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
	private JTextField textField; // ����� PORT��ȣ �Է�
	private JButton Start; // ������ �����Ų ��ư
	JTextArea textArea; // Ŭ���̾�Ʈ �� ���� �޽��� ���

	private ServerSocket socket; //��������
	private Socket soc; // ������� 
	private int Port = 30000; // ��Ʈ��ȣ
	private Vector vc = new Vector(); // ����� ����ڸ� ������ ����
	
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

	private void init() { // GUI�� �����ϴ� �޼ҵ�		
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
		textField.setText(Integer.toString(Port)); // ��Ʈ��ȣ �̸� �Է�
		textField.setEnabled(false); // ���̻� ��Ʈ��ȣ ������ �ϰ� ���´�
		textField.setBounds(98, 264, 154, 37);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Port Number");
		lblNewLabel.setBounds(12, 264, 98, 37);
		contentPane.add(lblNewLabel);
		Start = new JButton("���� ����");
		
		Myaction action = new Myaction();
		Start.addActionListener(action); // ����Ŭ������ �׼� �����ʸ� ��ӹ��� Ŭ������
		textField.addActionListener(action);
		Start.setBounds(0, 325, 264, 37);
		contentPane.add(Start);
		textArea.setEditable(false); // textArea�� ����ڰ� ���� ���ϰԲ� ���´�.	
	}
	
	class Myaction implements ActionListener // ����Ŭ������ �׼� �̺�Ʈ ó�� Ŭ����
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			// �׼� �̺�Ʈ�� sendBtn�϶� �Ǵ� textField ���� Enter key ġ��
			if (e.getSource() == Start || e.getSource() == textField) 
			{
				if (textField.getText().equals("") || textField.getText().length()==0)// textField�� ���� ������� ������
				{
					textField.setText("��Ʈ��ȣ�� �Է����ּ���");
					textField.requestFocus(); // ��Ŀ���� �ٽ� textField�� �־��ش�
				} 			
				else 
				{
					try
					{
						//Port = Integer.parseInt(textField.getText()); // ���ڷ� �Է����� ������ ���� �߻� ��Ʈ�� ���� ����.		
						server_start(); // ����ڰ� ����ε� ��Ʈ��ȣ�� �־����� ���� ���������� �޼ҵ� ȣ��			
					}
					catch(Exception er)
					{
						//����ڰ� ���ڷ� �Է����� �ʾ����ÿ��� ���Է��� �䱸�Ѵ�
						textField.setText("���ڷ� �Է����ּ���");
						textField.requestFocus(); // ��Ŀ���� �ٽ� textField�� �־��ش�
					}	
				}// else �� ��
			}

		}

	}
	private void server_start() {
		try {
			socket = new ServerSocket(Port); // ������ ��Ʈ ���ºκ�
			Start.setText("����������");
			Start.setEnabled(false); // ������ ���̻� �����Ű�� �� �ϰ� ���´�
			textField.setEnabled(false); // ���̻� ��Ʈ��ȣ ������ �ϰ� ���´�
			
			if(socket!=null) // socket �� ���������� ��������
			{
				Connection();
			}
			
		} catch (IOException e) {
			textArea.append("������ �̹� ������Դϴ�...\n");

		}

	}

	private void Connection() {
		Thread th = new Thread(new Runnable() { // ����� ������ ���� ������
			@Override
			public void run() {
				while (true) { // ����� ������ ����ؼ� �ޱ� ���� while��
					try {
						textArea.append("����� ���� �����...\n");
						soc = socket.accept(); // accept�� �Ͼ�� �������� ���� �����
						
						
						
						
						//id, pw Ȯ��
						if(check(soc)) {
							textArea.append("����� ����!!\n");
							UserInfo user = new UserInfo(soc, vc); // ����� ���� ������ �ݹ� ������Ƿ�, user Ŭ���� ���·� ��ü ����
		                                // �Ű������� ���� ����� ���ϰ�, ���͸� ��Ƶд�
							vc.add(user); // �ش� ���Ϳ� ����� ��ü�� �߰�
							user.start(); // ���� ��ü�� ������ ����
						}
						
					} catch (IOException e) {
						textArea.append("!!!! accept ���� �߻�... !!!!\n");
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
			
			
			// id�� pw�� ��ġ�ϴ°��� �������, Ŭ���̾�Ʈ������ ok ���� ������.
			Iterator<String> it = users.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				if(key.equals(temp_id)) {		// �ؽ��ʿ� ������ִ� ���̵�(key)���� �����鼭 �Է¹��� temp_id���� ��ġ�ϴ°��� �ִ��� Ȯ��
					if(users.get(temp_id).equals(temp_pw)) {
						String str = "ok";
						byte[] bb;
						bb = str.getBytes();
						out.write(bb); //.writeUTF(str)
						return true;
					}
					else {						// id�� ������, ��й�ȣ�� Ʋ���� ���
						String str = "nok";
						byte[] bb;
						bb = str.getBytes();
						out.write(bb); //.writeUTF(str)
						return false;
					}
				}
			}
			// id ��ü�� Ʋ���� ���
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

		public UserInfo(Socket soc, Vector vc) // �����ڸ޼ҵ�
		{
			// �Ű������� �Ѿ�� �ڷ� ����
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
				//Nickname = dis.readUTF(); // ������� �г��� �޴ºκ�
				byte[] b=new byte[128];
				dis.read(b);
				String Nickname = new String(b);
				Nickname = Nickname.trim();
				textArea.append("ID " + Nickname + " ����\n");
				textArea.setCaretPosition(textArea.getText().length());		
				send_Message(Nickname + "�� ȯ���մϴ�."); // ����� ����ڿ��� ���������� �˸�
			} catch (Exception e) {
				textArea.append("��Ʈ�� ���� ����\n");
				textArea.setCaretPosition(textArea.getText().length());
			}
		}

		public void InMessage(String str) {
			//textArea.append("����ڷκ��� ���� �޼��� : " + str+"\n");
			textArea.append(str + "\n");
			textArea.setCaretPosition(textArea.getText().length());
			// ����� �޼��� ó��
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
				textArea.append("�޽��� �۽� ���� �߻�\n");	
				textArea.setCaretPosition(textArea.getText().length());
			}
		}

		public void run() // ������ ����
		{

			while (true) {
				try {
					
					// ����ڿ��� �޴� �޼���
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
						vc.removeElement( this ); // �������� ���� ��ü�� ���Ϳ��� �����
						textArea.append(vc.size() +" : ���� ���Ϳ� ����� ����� ��\n");
						textArea.append("����� ���� ������ �ڿ� �ݳ�\n");
						textArea.setCaretPosition(textArea.getText().length());
						
						break;
					
					} catch (Exception ee) {
					
					}// catch�� ��
				}// �ٱ� catch����

			}
			
			
			
		}// run�޼ҵ� ��

	} // ���� userinfoŬ������

}