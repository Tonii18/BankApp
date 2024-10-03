package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

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
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(107, 55, 425, 573);
		firstSide.add(loginPanel);
		
		JPanel secondSide = new JPanel();
		secondSide.setBackground(new Color(44, 144, 151));
		secondSide.setBounds(640, 0, 626, 683);
		contentPane.add(secondSide);
		
		
		
	}
}
