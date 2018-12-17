package chat_client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame implements ActionListener{
	private JTextArea jta = new JTextArea(40,25);
	private JTextField jtf = new JTextField(25);
	private ClientBackground clientBackground = new ClientBackground(); 
	
	public ClientGui() {
		
		add(jta,BorderLayout.CENTER);
		add(jtf,BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("Client Side");
		
		clientBackground.setGui(this);
		clientBackground.connect();
	}
	
	public static void main(String[] args) {
		new ClientGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = jtf.getText()+"\n";
		jta.append(msg);
		System.out.print(msg);
		jtf.setText("");
		
	}
}
