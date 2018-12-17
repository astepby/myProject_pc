package chat_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



public class ClientBackground {
	Socket socket;
	
	DataInputStream in;
	DataOutputStream out;
	
	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("Connected to Server.");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF("This is client.");
			System.out.println("msg sent.");
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();
	}
}
