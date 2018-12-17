package chat_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	private ServerGui serverGui;
	
	
	
	public final void setGui(ServerGui serverGui) {
		this.serverGui = serverGui;
	}

	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("대기중...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress()+" connected.");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			String msg = in.readUTF();
			System.out.println("[Client] "+msg);
			serverGui.hello();
			serverGui.appendMsg(msg);
			
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}
}
