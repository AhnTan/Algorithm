package pratice_server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {


	ClientThread client_thread;
	ServerThread server_thread;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		
		server_thread = new ServerThread();
		
		
		server_thread.start();
		
		try {
			Thread.sleep(3000);
			client_thread = new ClientThread();
			client_thread.start();
		}catch(Exception e) {}
		
		
	}
	
	
	class ServerThread extends Thread{
		Socket socket;
		ServerSocket serversocket;
		ObjectOutputStream outputstream;
		ObjectInputStream inputstream;
		@Override
		public void run() {
			int port = 8080;
			
			try {
				serversocket = new ServerSocket(port);
				socket = serversocket.accept();
				System.out.println("서버초기화 완료");
				inputstream = new ObjectInputStream(socket.getInputStream());
				System.out.println("1-0");
				outputstream = new ObjectOutputStream(socket.getOutputStream());
				
				System.out.println("1");
				
				/*Object input = inputstream.readObject();
					if (input.equals("send")) {
						System.out.println("1-1");
						String out = "check";
						outputstream.writeObject(out);
						outputstream.flush();

					}else {
						System.out.println("1-2");
						String out = "not_check";
						outputstream.writeObject(out);
						outputstream.flush();
					}
					System.out.println("2");*/
				
			} catch (Exception e) {
				System.out.println("에러에러");
				e.printStackTrace();
			}
			
		}
		
	}

	class ClientThread extends Thread{
		
		Socket connect_socket;
		ObjectInputStream client_input;
		ObjectOutputStream client_output;
		
		
		@Override
		public void run() {
			try {
				connect_socket = new Socket("localhost", 8080);
				System.out.println("클라이언트 : 서버접속 완료");
				client_input = new ObjectInputStream(connect_socket.getInputStream());
				System.out.println("3-0");
				client_output = new ObjectOutputStream(connect_socket.getOutputStream());
				System.out.println("3");
				
				/*String sender = "send";
				client_output.writeObject(sender);
				client_output.flush();
				System.out.println("4");
				Object receive = client_input.readObject();
				System.out.println("5");
				if(receive.equals("check")) {
					System.out.println("클라이언트: 서버에서 받은 데이터 " + receive.toString());
					
				}else if(receive.equals("not_check")){
					System.out.println("클라이언트: 서버에서 받은 non데이터 " + receive.toString());
				}*/
				
			} catch (Exception e) {
				System.out.println("클라이언트 에러");
				e.printStackTrace();
			}
		}
	}
}


