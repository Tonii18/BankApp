package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import roundedComponents.RoundPanel;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel firstSide = new JPanel();
		firstSide.setBackground(new Color(61, 60, 60));
		firstSide.setBounds(0, 0, 640, 683);
		contentPane.add(firstSide);
		firstSide.setLayout(null);
		
		RoundPanel loginPanel = new RoundPanel(20, 20);
		loginPanel.setBounds(107, 55, 425, 573);
		firstSide.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel loginTitle = new JLabel("<html>Login into your<br>account</html>");
		loginTitle.setHorizontalAlignment(SwingConstants.LEFT);
		loginTitle.setFont(new Font("Inter 28pt Black", Font.PLAIN, 33));
		loginTitle.setBounds(81, 59, 263, 87);
		loginPanel.add(loginTitle);
		
		JPanel secondSide = new JPanel();
		secondSide.setBackground(new Color(44, 144, 151));
		secondSide.setBounds(640, 0, 626, 683);
		contentPane.add(secondSide);
		secondSide.setLayout(null);
		
		JLabel title = new JLabel("Welcome Back");
		title.setFont(new Font("Inter 28pt Black", Font.PLAIN, 50));
		title.setForeground(new Color(255, 255, 255));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(116, 98, 393, 44);
		secondSide.add(title);
		
		JLabel logo = new JLabel("");
		logo.setBounds(238, 204, 150, 150);
		secondSide.add(logo);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		
		JLabel vector = new JLabel("");
		vector.setBounds(41, 392, 457, 269);
		secondSide.add(vector);
		vector.setIcon(new ImageIcon(getClass().getResource("/vector.png")));
		
	}
}
