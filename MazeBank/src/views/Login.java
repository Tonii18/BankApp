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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import services.DBServices;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private RoundButton loginButton;
	private RoundButton signupButton;

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
		setTitle("Inicia sesion");
		ImageIcon icon = new ImageIcon(getClass().getResource("/bankPNG.png"));
		setIconImage(icon.getImage());
		
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
		loginTitle.setBounds(81, 55, 263, 87);
		loginPanel.add(loginTitle);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setBounds(81, 190, 110, 35);
		loginPanel.add(usernameLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(null);
		separator.setBackground(new Color(44, 144, 151));
		separator.setBounds(81, 263, 263, 9);
		loginPanel.add(separator);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(new Color(240, 240, 240));
		textField.setFont(new Font("Inter 18pt", Font.PLAIN, 15));
		textField.setBounds(81, 226, 263, 35);
		loginPanel.add(textField);
		textField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLabel.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		passwordLabel.setBounds(81, 318, 110, 35);
		loginPanel.add(passwordLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(null);
		separator_1.setBackground(new Color(44, 144, 151));
		separator_1.setBounds(81, 391, 263, 9);
		loginPanel.add(separator_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Inter 18pt", Font.PLAIN, 15));
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(240, 240, 240));
		passwordField.setBounds(81, 353, 263, 35);
		loginPanel.add(passwordField);
		
		loginButton = new RoundButton("Log In", 15, 15);
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBorder(null);
		loginButton.setBackground(new Color(44, 144, 151));
		loginButton.setFont(new Font("Inter 18pt", Font.PLAIN, 15));
		loginButton.setBounds(81, 450, 263, 42);
		loginPanel.add(loginButton);
		
		signupButton = new RoundButton("Log In", 15, 15);
		signupButton.setText("Create Account");
		signupButton.setForeground(new Color(0, 0, 0));
		signupButton.setFont(new Font("Inter 18pt", Font.PLAIN, 15));
		signupButton.setBackground(new Color(240, 240, 240));
		signupButton.setBounds(81, 507, 263, 42);
		signupButton.setCustomBorderColor(new Color(44, 144, 151));
		loginPanel.add(signupButton);
		
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
		
		/*
		 * EventsListeners
		 */
		
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setBackground(new Color(66, 209, 219));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setBackground(new Color(44, 144, 151));
			}
			
		});
		
		signupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupButton.setBackground(new Color(250, 250, 250));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signupButton.setBackground(new Color(240, 240, 240));
			}
			
		});
		
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordField.requestFocusInWindow();
			}
			
		});
		
		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginButton.doClick();
			}
			
		});
		
		loginButton.addActionListener(new buttons());
		signupButton.addActionListener(new buttons());
		
		
		
	}
	
	/*
	 * Private classes with buttons methods
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			
			if(button == loginButton) {
				try {
					if(loginUser()) {
						Dashboard d = new Dashboard(new User(textField.getText(), passwordField.getText()));
						d.setVisible(true);
						dispose();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(button == signupButton) {
				new SignUp().setVisible(true);
				dispose();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public boolean loginUser() throws SQLException {
		String username = textField.getText();
		String password = passwordField.getText();
		
		User u = new User(username, password);
		if(DBServices.loginUser(u)) {
			JOptionPane.showMessageDialog(null, "Has iniciado sesion correctamente", "Iniciar sesion en Maze Bank", JOptionPane.PLAIN_MESSAGE, getIcon("/comprobado.png", 40, 40));
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos, vuelvelo a intentar", "Sesion denegada", JOptionPane.PLAIN_MESSAGE, getIcon("/boton-eliminar.png", 40, 40));
			limpiar();
		}
		return false;
		
	}
	
	public void limpiar() {
		textField.setText("");
		passwordField.setText("");
	}
	
	public Icon getIcon(String path, int w, int h) {
		return new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(w, h, 0));
	}
	
	
}
