// Client.Java Java Chatting Client 의 Nicknam, IP, Port 번호 입력하고 접속하는 부분

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField tf_ID; // ID를 입력받을곳
	private JTextField tf_PW; // ID를 입력받을곳
	private JTextField tf_IP; // IP를 입력받을곳
	private JTextField tf_PORT; //PORT를 입력받을곳

	String _ip= "127.0.0.1";
	int _port= 30008;
	
	public Client() // 생성자
	{
		init();
		start();
	}

	public void init() // 화면 구성
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(53, 57, 90, 34);
		contentPane.add(lblNewLabel);

		tf_ID = new JTextField();
		tf_ID.setBounds(92, 64, 150, 21);
		contentPane.add(tf_ID);
		tf_ID.setColumns(10);
		
		
		JLabel lblNewLabelpw = new JLabel("PW");
		lblNewLabelpw.setBounds(53, 87, 90, 34);
		contentPane.add(lblNewLabelpw);

		tf_PW = new JTextField();
		tf_PW.setBounds(92, 94, 150, 21);
		contentPane.add(tf_PW);
		tf_PW.setColumns(10);
		

		JLabel lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(12, 141, 90, 34);
		contentPane.add(lblServerIp);

		tf_IP = new JTextField();
		tf_IP.setText(_ip);
		tf_IP.setEnabled(false);
		tf_IP.setColumns(10);
		tf_IP.setBounds(92, 148, 150, 21);
		contentPane.add(tf_IP);

		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(36, 178, 90, 34);
		contentPane.add(lblPort);

		tf_PORT = new JTextField();
		tf_PORT.setText(Integer.toString(_port));
		tf_PORT.setEnabled(false);
		tf_PORT.setColumns(10);
		tf_PORT.setBounds(92, 185, 150, 21);
		contentPane.add(tf_PORT);
		
		JButton btnNewButton = new JButton("접    속");
		btnNewButton.setBounds(36, 266, 206, 52);
		contentPane.add(btnNewButton);
		
		ConnectAction action = new ConnectAction();
		btnNewButton.addActionListener(action);
		tf_PORT.addActionListener(action);			
	}
	class ConnectAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {			
			String _id = tf_ID.getText().trim(); // 공백이 있지 모르니 공백 제거 trim() 사용
			String _PW = tf_PW.getText().trim(); // 공백이 있지 모르니 공백 제거 trim() 사용
			
			
			try {
				Socket socket = new Socket(_ip, _port);
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				
				String str = _id + "/" + _PW;
				byte[] bb;
				bb = str.getBytes();
				out.write(bb); //.writeUTF(str)
				
				
				// 서버쪽에서 ok 인지, nok인지 받는 부분
				byte[] b = new byte[128];
				in.read(b);
				String msg = new String(b);
				msg = msg.trim();
				
				// 서버에서 id와 pw가 맞다고 확인된다면, 다음 채팅화면 실행
				if(msg.equals("ok")) {
					MainView view = new MainView(socket, _id,_ip,_port);
					setVisible(false);	
				}else if(msg.equals("nok")) {
					tf_ID.setText("아이디를 확인해주세요");
					tf_PW.setText("비밀번호를 확인하세요");
				}
				
			} 
			catch (Exception e) {
			}
			
			
								
		}
	}
	
	public void start() // 이벤트 처리
	{
	}

}
