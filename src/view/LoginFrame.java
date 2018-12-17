package view;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class LoginFrame extends JFrame{
	BufferedImage img = null;
	//main
	public static void main(String[] args) {
		new LoginFrame();
	}
	
	//생성자
	public LoginFrame() {
		setTitle("로그인 테스트");
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		//get image
		try {
			img = ImageIO.read(new File("img/login.png"));
		}catch(IOException e) {
			System.out.println("failed to load image");
			System.exit(0);
		}
		
		//layout
		
		//panel1
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1600, 900);
		
		//login
		
		//password
		
		//etc
		add(panel,BorderLayout.NORTH);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		public void paint(Graphics2D g) {
			g.drawImage(img,0,0,null);
		}
	}

}
