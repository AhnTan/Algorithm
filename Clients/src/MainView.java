// MainView.java : Java Chatting Client �� �ٽɺκ�
// read keyboard --> write to network (Thread �� ó��)
// read network --> write to textArea

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MainView extends JFrame {
	private JPanel contentPane;
	private JTextField textField; // ���� �޼��� ���°�
	private String id;
	private String ip;
	private int port;
	private Canvas canvas;
	JScrollPane scrollPane;
	JButton sendBtn; // ���۹�ư
	JTextArea textArea; // ���ŵ� �޼����� ��Ÿ�� ����
	JTextPane myTextArea;
	private Socket socket; // �������
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	int count = 0;

	public MainView(Socket soc, String id, String ip, int port)// ������
	{
		this.socket = soc;
		this.id = id;
		this.ip = ip;
		this.port = port;
		init();
		start();
		textArea.append("�Ű� ������ �Ѿ�� �� : " + id + " " + ip + " " + port + "\n");
		network();
	}

	public void network() {
		if (socket != null) // socket�� null���� �ƴҶ� ��! ����Ǿ�����
		{
			Connection(); // ���� �޼ҵ带 ȣ��
		}
	}

	public void Connection() { // ���� ���� �޼ҵ� ����κ�
		
		
		
		try { // ��Ʈ�� ����
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
		} catch (IOException e) {
			textArea.append("��Ʈ�� ���� ����!!\n");
		}
		send_Message(id); // ���������� ����Ǹ� ���� id�� ����
		Thread th = new Thread(new Runnable() { // �����带 ������ �����κ��� �޼����� ����
			@SuppressWarnings("null")
			@Override
			public void run() {
				while (true) {
					try {
						
						byte[] b = new byte[128];
						dis.read(b);
						String msg = new String(b);
						msg = msg.trim();
						
						String split[] = msg.split(" ");
						
						
						if (split[0].equals("[" + id + "]")) {
							// System.out.println(scrollPane.getMaximumSize());
							System.out.println(scrollPane.getWidth());
							System.out.println(msg.length());
							System.out.println("col : " + textArea.getColumns());
							System.out.println("row : " + textArea.getRows());

							int size = 80 - msg.length(); // int size = contentPane.getWidth() -
							msg.length();
							for (int i = 0; i < size; i++) {
								textArea.append(" ");
							}
							textArea.append(msg + "\n");
							textArea.setCaretPosition(textArea.getText().length());
						} else {
							textArea.append(msg + "\n");
							textArea.setCaretPosition(textArea.getText().length());
							System.out.println("123456789");
						}


					/*	if (split[0].equals("[" + id + "]")) {
							StyledDocument doc = myTextArea.getStyledDocument();
							SimpleAttributeSet attribs = new SimpleAttributeSet();
							StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_RIGHT);
							myTextArea.setParagraphAttributes(attribs, false);
							doc.insertString(doc.getLength(), msg + "\n", attribs);
							myTextArea.setCaretPosition(myTextArea.getText().length());
						}else {
							textArea.append(msg + "\n");
							textArea.setCaretPosition(textArea.getText().length());
							System.out.println("123456789");
						}*/
					
						/*textArea.append(msg + "\n");
						textArea.setCaretPosition(textArea.getText().length());
						textArea.setAlignmentX(RIGHT_ALIGNMENT);
*/					
						
						// �����϶�
					
					/*	
						StyledDocument doc = myTextArea.getStyledDocument();
						SimpleAttributeSet attribs = new SimpleAttributeSet();
						StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_RIGHT);
						myTextArea.setParagraphAttributes(attribs, false);
						doc.insertString(doc.getLength(), msg+"\n", attribs);
						myTextArea.setCaretPosition(myTextArea.getText().length());*/
						
					
					} catch (IOException e) {
						textArea.append("�޼��� ���� ����!!\n");
						
						// ������ ���� ��ſ� ������ ������ ��� ������ �ݴ´�
						try {
							os.close();
							is.close();
							dos.close();
							dis.close();
							socket.close();
							break; // ���� �߻��ϸ� while�� ����
						} catch (IOException e1) {

						} 
					}catch(Exception e2) {}

				} // while�� ��
			}// run�޼ҵ� ��
		});
		th.start();
	}

	public void send_Message(String str) { // ������ �޼����� ������ �޼ҵ�
		try {
			byte[] bb;
			bb = str.getBytes();
			dos.write(bb); //.writeUTF(str);
		} catch (IOException e) {
			textArea.append("�޼��� �۽� ����!!\n");
		}
	}

	public void init() { // ȭ�鱸�� �޼ҵ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 272, 302);
		contentPane.add(scrollPane);
		textArea = new JTextArea();
		myTextArea = new JTextPane();
		scrollPane.setViewportView(textArea);
	
		//scrollPane.setViewportView(myTextArea);
		//textArea.setForeground(new Color(255,0,0));
		textArea.setDisabledTextColor(new Color(0,0,0));
		myTextArea.setDisabledTextColor(new Color(0,0,0));
		textField = new JTextField();
		textField.setBounds(0, 312, 155, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		sendBtn = new JButton("��   ��");
		sendBtn.setBounds(161, 312, 111, 42);
		contentPane.add(sendBtn);
		textArea.setEnabled(false); // ����ڰ� �������ϰ� ���´�
		myTextArea.setEnabled(false);
		setVisible(true);
	}

	public void start() { // �׼��̺�Ʈ ���� �޼ҵ�
		Myaction action = new Myaction();
		sendBtn.addActionListener(action); // ����Ŭ������ �׼� �����ʸ� ��ӹ��� Ŭ������
		textField.addActionListener(action);
	}

	class Myaction implements ActionListener // ����Ŭ������ �׼� �̺�Ʈ ó�� Ŭ����
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// �׼� �̺�Ʈ�� sendBtn�϶� �Ǵ� textField ���� Enter key ġ��
			if (e.getSource() == sendBtn || e.getSource() == textField) 
			{
				String msg = null;
				msg = String.format("[%s] %s\n", id, textField.getText());
				send_Message(msg);
				textField.setText(""); // �޼����� ������ ���� �޼��� ����â�� ����.
				textField.requestFocus(); // �޼����� ������ Ŀ���� �ٽ� �ؽ�Ʈ �ʵ�� ��ġ��Ų��				
			}
		}
	}
}