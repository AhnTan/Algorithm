// Client.Java Java Chatting Client �� Nicknam, IP, Port ��ȣ �Է��ϰ� �����ϴ� �κ�

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
	private JTextField tf_ID; // ID�� �Է¹�����
	private JTextField tf_PW; // ID�� �Է¹�����
	private JTextField tf_IP; // IP�� �Է¹�����
	private JTextField tf_PORT; //PORT�� �Է¹�����

	String _ip= "127.0.0.1";
	int _port= 30008;
	
	public Client() // ������
	{
		init();
		start();
	}

	public void init() // ȭ�� ����
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
		
		JButton btnNewButton = new JButton("��    ��");
		btnNewButton.setBounds(36, 266, 206, 52);
		contentPane.add(btnNewButton);
		
		ConnectAction action = new ConnectAction();
		btnNewButton.addActionListener(action);
		tf_PORT.addActionListener(action);			
	}
	class ConnectAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {			
			String _id = tf_ID.getText().trim(); // ������ ���� �𸣴� ���� ���� trim() ���
			String _PW = tf_PW.getText().trim(); // ������ ���� �𸣴� ���� ���� trim() ���
			
			
			try {
				Socket socket = new Socket(_ip, _port);
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				
				String str = _id + "/" + _PW;
				byte[] bb;
				bb = str.getBytes();
				out.write(bb); //.writeUTF(str)
				
				
				// �����ʿ��� ok ����, nok���� �޴� �κ�
				byte[] b = new byte[128];
				in.read(b);
				String msg = new String(b);
				msg = msg.trim();
				
				// �������� id�� pw�� �´ٰ� Ȯ�εȴٸ�, ���� ä��ȭ�� ����
				if(msg.equals("ok")) {
					MainView view = new MainView(socket, _id,_ip,_port);
					setVisible(false);	
				}else if(msg.equals("nok")) {
					tf_ID.setText("���̵� Ȯ�����ּ���");
					tf_PW.setText("��й�ȣ�� Ȯ���ϼ���");
				}
				
			} 
			catch (Exception e) {
			}
			
			
								
		}
	}
	
	public void start() // �̺�Ʈ ó��
	{
	}

}
