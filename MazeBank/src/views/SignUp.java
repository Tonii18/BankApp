package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundLabel;
import services.DBServices;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private RoundButton create;
	private JTextField emailField;
	private JLabel title;
	private JTextField userField;
	private JTextField phoneField;
	private JPasswordField passwordField;
	private JButton back;
	
	private User user;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		back = new JButton("");
		back.setBackground(new Color(0, 0, 0));
		back.setBorderPainted(false);
		back.setOpaque(false);
		back.setBorder(null);
		back.setBounds(10, 623, 50, 50);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow_back.png")));
		contentPane.add(back);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Inter 24pt", Font.PLAIN, 18));
		passwordField.setBorder(null);
		passwordField.setBounds(751, 378, 346, 39);
		contentPane.add(passwordField);
		
		phoneField = new JTextField("");
		phoneField.setFont(new Font("Inter 24pt", Font.PLAIN, 18));
		phoneField.setColumns(10);
		phoneField.setBorder(null);
		phoneField.setBounds(751, 452, 346, 39);
		contentPane.add(phoneField);
		
		userField = new JTextField("");
		userField.setFont(new Font("Inter 24pt", Font.PLAIN, 18));
		userField.setColumns(10);
		userField.setBorder(null);
		userField.setBounds(751, 306, 346, 39);
		contentPane.add(userField);
		
		emailField = new JTextField("");
		emailField.setBorder(null);
		emailField.setFont(new Font("Inter 24pt", Font.PLAIN, 18));
		emailField.setBounds(751, 233, 346, 39);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel phoneIcon = new JLabel("");
		phoneIcon.setIcon(new ImageIcon(SignUp.class.getResource("/Phone.png")));
		phoneIcon.setBounds(710, 461, 23, 23);
		contentPane.add(phoneIcon);
		
		JLabel passwordIcon = new JLabel("");
		passwordIcon.setIcon(new ImageIcon(SignUp.class.getResource("/Lock.png")));
		passwordIcon.setBounds(710, 385, 23, 23);
		contentPane.add(passwordIcon);
		
		JLabel userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(SignUp.class.getResource("/User.png")));
		userIcon.setBounds(710, 316, 23, 23);
		contentPane.add(userIcon);
		
		JLabel mailIcon = new JLabel("");
		mailIcon.setBounds(710, 241, 23, 23);
		mailIcon.setIcon(new ImageIcon(getClass().getResource("/Mail.png")));
		contentPane.add(mailIcon);
		
		create = new RoundButton("Create Account", 15, 15);
		create.setBorder(null);
		create.setBackground(new Color(11, 224, 171));
		create.setForeground(Color.WHITE);
		create.setFont(new Font("Inter 18pt", Font.PLAIN, 15));
		create.setBounds(700, 561, 403, 45);
		contentPane.add(create);
		
		RoundLabel phoneLabel = new RoundLabel("", 15, 15);
		phoneLabel.setBackground(Color.WHITE);
		phoneLabel.setBounds(700, 451, 403, 44);
		contentPane.add(phoneLabel);
		
		RoundLabel passwordLabel = new RoundLabel("", 15, 15);
		passwordLabel.setBackground(Color.WHITE);
		passwordLabel.setBounds(700, 376, 403, 44);
		contentPane.add(passwordLabel);
		
		RoundLabel usernameLabel = new RoundLabel("", 15, 15);
		usernameLabel.setBackground(Color.WHITE);
		usernameLabel.setBounds(700, 306, 403, 44);
		contentPane.add(usernameLabel);
		
		RoundLabel emailLabel = new RoundLabel("", 15, 15);
		emailLabel.setBackground(new Color(255, 255, 255));
		emailLabel.setBounds(700, 231, 403, 44);
		contentPane.add(emailLabel);
		
		JLabel creatingLabel = new JLabel("<html>Create your Maze <br> Account</html>");
		creatingLabel.setFont(new Font("Inter 24pt Black", Font.PLAIN, 35));
		creatingLabel.setForeground(Color.WHITE);
		creatingLabel.setBounds(700, 80, 332, 102);
		contentPane.add(creatingLabel);
		
		JLabel inputsLabel = new JLabel("");
		inputsLabel.setBounds(567, 19, 668, 645);
		inputsLabel.setBackground(null);
		inputsLabel.setIcon(new ImageIcon(getClass().getResource("/panel.png")));
		contentPane.add(inputsLabel);
		
		JLabel logo = new JLabel("");
		logo.setBounds(215, 328, 150, 150);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		contentPane.add(logo);
		
		title = new JLabel("<html><div style='text-align: center;'>Welcome to Maze<br>Bank</div></html>");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Inter 24pt Black", Font.PLAIN, 48));
		title.setBounds(62, 139, 457, 124);
		contentPane.add(title);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setBounds(-7, -18, 1280, 720);
		backgroundImage.setIcon(new ImageIcon(getClass().getResource("/fade.png")));
		contentPane.add(backgroundImage);
		
		/*
		 * EventsListeners
		 */
		
		
		create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				create.setBackground(new Color(40, 186, 150));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				create.setBackground(new Color(11, 224, 171));
			}
			
		});
		
		back.addActionListener(new components());
		create.addActionListener(new components());
		
		emailField.addActionListener(new components());
		userField.addActionListener(new components());
		passwordField.addActionListener(new components());
		phoneField.addActionListener(new components());
		
	}
	
	/*
	 * Private class with buttons methods
	 */
	
	private class components implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = (Object)e.getSource();
			
			if(source instanceof JTextField) {
				JTextField textfield = (JTextField)e.getSource();
				
				if(textfield == emailField) {
					userField.requestFocusInWindow();
				}else if(textfield == userField) {
					passwordField.requestFocusInWindow();
				}else if(textfield == passwordField) {
					phoneField.requestFocusInWindow();
				}else if(textfield == phoneField) {
					create.doClick();
				}
			}else if(source instanceof JButton) {
				JButton button = (JButton)e.getSource();
				
				if(button == back) {
					Login l = new Login();
					l.setVisible(true);
					dispose();
				}else if(button == create) {
					try {
						Dashboard d = new Dashboard(createUser());
						d.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public User createUser() throws SQLException {
		
		String username = userField.getText();
		String password = passwordField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		
		User u = new User(username, email, password, phone);
		DBServices.createAccount(u);
		
		JOptionPane.showMessageDialog(null, "Has creado tu cuenta correctamente", "Creacion de cuenta",  JOptionPane.PLAIN_MESSAGE, getIcon("/comprobado.png", 40, 40));
		
		return u;
	}
	
	public Icon getIcon(String path, int w, int h) {
		return new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(w, h, 0));
	}
	
}
