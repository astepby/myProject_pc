package chat_client;

import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	Socket socket;
	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("Connected to Server.");
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();
	}
}
