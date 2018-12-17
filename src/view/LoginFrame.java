package view;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sun.misc.PerformanceLogger;



public class LoginFrame extends JFrame{
	private BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt;
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
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1600, 900);
		layeredPane.setLayout(null);
		
		
		//panel1
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 1600, 900);
		
		
		//login field
		loginTextField = new JTextField(15);
		loginTextField.setBounds(731, 404, 200, 30);
		loginTextField.setOpaque(false);
		loginTextField.setForeground(Color.green);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(loginTextField);
		
		//password field
		passwordField = new JPasswordField(200);
		passwordField.setBounds(731, 528, 200, 30);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);
		
		//login btn
		bt = new JButton(new ImageIcon("img/btLogin_hud.png"));
		bt.setBounds(755,689,104,48);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setContentAreaFilled(false);
		layeredPane.add(bt);
		
		
		//etc
		//add(panel);  //add(panel,BorderLayout.NORTH);
		layeredPane.add(panel);
		add(layeredPane);
		
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}

}
