// Java Chatting Server

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame {
	private JPanel contentPane;
	private JTextField textField; // 사용할 PORT번호 입력
	private JButton Start; // 서버를 실행시킨 버튼
	JTextArea textArea; // 클라이언트 및 서버 메시지 출력

	private ServerSocket socket; //서버소켓
	private Socket soc; // 연결소켓 
	private int Port = 30000; // 포트번호
	private Vector vc = new Vector(); // 연결된 사용자를 저장할 벡터
	
	private HashMap<String, String> users = new HashMap<String, String>();

	public static void main(String[] args)
	{	
			Server frame = new Server();
			frame.setVisible(true);			
	}

	public Server() {
		init();
		users.put("alice","1234");
		users.put("bob", "12345");

	}

	private void init() { // GUI를 구성하는 메소드		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane js = new JScrollPane();				

		textArea = new JTextArea();
		textArea.setColumns(20);
		textArea.setRows(5);
		js.setBounds(0, 0, 264, 254);
		contentPane.add(js);
		js.setViewportView(textArea);

		textField = new JTextField();
		textField.setText(Integer.toString(Port)); // 포트번호 미리 입력
		textField.setEnabled(false); // 더이상 포트번호 수정못 하게 막는다
		textField.setBounds(98, 264, 154, 37);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Port Number");
		lblNewLabel.setBounds(12, 264, 98, 37);
		contentPane.add(lblNewLabel);
		Start = new JButton("서버 실행");
		
		Myaction action = new Myaction();
		Start.addActionListener(action); // 내부클래스로 액션 리스너를 상속받은 클래스로
		textField.addActionListener(action);
		Start.setBounds(0, 325, 264, 37);
		contentPane.add(Start);
		textArea.setEditable(false); // textArea를 사용자가 수정 못하게끔 막는다.	
	}
	
	class Myaction implements ActionListener // 내부클래스로 액션 이벤트 처리 클래스
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			// 액션 이벤트가 sendBtn일때 또는 textField 에세 Enter key 치면
			if (e.getSource() == Start || e.getSource() == textField) 
			{
				if (textField.getText().equals("") || textField.getText().length()==0)// textField에 값이 들어있지 않을때
				{
					textField.setText("포트번호를 입력해주세요");
					textField.requestFocus(); // 포커스를 다시 textField에 넣어준다
				} 			
				else 
				{
					try
					{
						//Port = Integer.parseInt(textField.getText()); // 숫자로 입력하지 않으면 에러 발생 포트를 열수 없다.		
						server_start(); // 사용자가 제대로된 포트번호를 넣었을때 서버 실행을위헤 메소드 호출			
					}
					catch(Exception er)
					{
						//사용자가 숫자로 입력하지 않았을시에는 재입력을 요구한다
						textField.setText("숫자로 입력해주세요");
						textField.requestFocus(); // 포커스를 다시 textField에 넣어준다
					}	
				}// else 문 끝
			}

		}

	}
	private void server_start() {
		try {
			socket = new ServerSocket(Port); // 서버가 포트 여는부분
			Start.setText("서버실행중");
			Start.setEnabled(false); // 서버를 더이상 실행시키지 못 하게 막는다
			textField.setEnabled(false); // 더이상 포트번호 수정못 하게 막는다
			
			if(socket!=null) // socket 이 정상적으로 열렸을때
			{
				Connection();
			}
			
		} catch (IOException e) {
			textArea.append("소켓이 이미 사용중입니다...\n");

		}

	}

	private void Connection() {
		Thread th = new Thread(new Runnable() { // 사용자 접속을 받을 스레드
			@Override
			public void run() {
				while (true) { // 사용자 접속을 계속해서 받기 위해 while문
					try {
						textArea.append("사용자 접속 대기중...\n");
						soc = socket.accept(); // accept가 일어나기 전까지는 무한 대기중
						
						
						
						
						//id, pw 확인
						if(check(soc)) {
							textArea.append("사용자 접속!!\n");
							UserInfo user = new UserInfo(soc, vc); // 연결된 소켓 정보는 금방 사라지므로, user 클래스 형태로 객체 생성
		                                // 매개변수로 현재 연결된 소켓과, 벡터를 담아둔다
							vc.add(user); // 해당 벡터에 사용자 객체를 추가
							user.start(); // 만든 객체의 스레드 실행
						}
						
					} catch (IOException e) {
						textArea.append("!!!! accept 에러 발생... !!!!\n");
					} 
				}
			}
		});
		th.start();
	}
	
	
	public boolean check(Socket soc) {
		String msg="";
		DataInputStream in;
		DataOutputStream out;
		try {
			in = new DataInputStream(soc.getInputStream());
			out = new DataOutputStream(soc.getOutputStream());
			
			// id+"/"+pw
			byte[] b = new byte[128];
			in.read(b);
			msg = new String(b);
			msg = msg.trim();
			
			// 
			String s[] = msg.split("/");
			String temp_id = s[0];			// id
			String temp_pw = s[1];			// pw
			
			
			// id와 pw과 일치하는것이 있을경우, 클라이언트쪽으로 ok 값을 보내줌.
			Iterator<String> it = users.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				if(key.equals(temp_id)) {		// 해쉬맵에 저장되있는 아이디(key)값을 돌리면서 입력받은 temp_id값과 일치하는것이 있는지 확인
					if(users.get(temp_id).equals(temp_pw)) {
						String str = "ok";
						byte[] bb;
						bb = str.getBytes();
						out.write(bb); //.writeUTF(str)
						return true;
					}
					else {						// id는 같지만, 비밀번호만 틀렸을 경우
						String str = "nok";
						byte[] bb;
						bb = str.getBytes();
						out.write(bb); //.writeUTF(str)
						return false;
					}
				}
			}
			// id 자체가 틀렸을 경우
			String str = "nok";
			byte[] bb;
			bb = str.getBytes();
			out.write(bb); //.writeUTF(str)
		} catch (Exception e) {}
		
		
		return false;
	}

	class UserInfo extends Thread {
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket user_socket;
		private Vector user_vc;
		private String Nickname = "";

		public UserInfo(Socket soc, Vector vc) // 생성자메소드
		{
			// 매개변수로 넘어온 자료 저장
			this.user_socket = soc;
			this.user_vc = vc;
			User_network();
		}
		public void User_network() {
			try {
				is = user_socket.getInputStream();
				dis = new DataInputStream(is);
				os = user_socket.getOutputStream();
				dos = new DataOutputStream(os);
				//Nickname = dis.readUTF(); // 사용자의 닉네임 받는부분
				byte[] b=new byte[128];
				dis.read(b);
				String Nickname = new String(b);
				Nickname = Nickname.trim();
				textArea.append("ID " + Nickname + " 접속\n");
				textArea.setCaretPosition(textArea.getText().length());		
				send_Message(Nickname + "님 환영합니다."); // 연결된 사용자에게 정상접속을 알림
			} catch (Exception e) {
				textArea.append("스트림 셋팅 에러\n");
				textArea.setCaretPosition(textArea.getText().length());
			}
		}

		public void InMessage(String str) {
			//textArea.append("사용자로부터 들어온 메세지 : " + str+"\n");
			textArea.append(str + "\n");
			textArea.setCaretPosition(textArea.getText().length());
			// 사용자 메세지 처리
			broad_cast(str);
		}

		public void broad_cast(String str) {
			for (int i = 0; i < user_vc.size(); i++) {
				UserInfo imsi = (UserInfo) user_vc.elementAt(i);
				imsi.send_Message(str);
			}
		}

		public void send_Message(String str) {
			try {
				//dos.writeUTF(str);
				byte[] bb;
				String s = String.format("%-32s", str);
				bb = s.getBytes();
				dos.write(bb,0,32); //.writeUTF(str);
			} 
			catch (IOException e) {
				textArea.append("메시지 송신 에러 발생\n");	
				textArea.setCaretPosition(textArea.getText().length());
			}
		}

		public void run() // 스레드 정의
		{

			while (true) {
				try {
					
					// 사용자에게 받는 메세지
					byte[] b = new byte[128];
					dis.read(b);
					String msg = new String(b);
					msg = msg.trim();
					//String msg = dis.readUTF();
					InMessage(msg);
					
				} 
				catch (IOException e) 
				{
					
					try {
						dos.close();
						dis.close();
						user_socket.close();
						vc.removeElement( this ); // 에러가난 현재 객체를 벡터에서 지운다
						textArea.append(vc.size() +" : 현재 벡터에 담겨진 사용자 수\n");
						textArea.append("사용자 접속 끊어짐 자원 반납\n");
						textArea.setCaretPosition(textArea.getText().length());
						
						break;
					
					} catch (Exception ee) {
					
					}// catch문 끝
				}// 바깥 catch문끝

			}
			
			
			
		}// run메소드 끝

	} // 내부 userinfo클래스끝

}
