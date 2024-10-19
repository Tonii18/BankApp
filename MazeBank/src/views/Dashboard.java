package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundLabel;
import roundedComponents.RoundPanel;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField moneyField;
	private User user;
	private JTextField usernameField;
	private RoundButton homeButton;
	private RoundButton bizumButton;
	private RoundButton transferButton;
	private RoundButton logoutButton;
	
	private JPanel centralPanel;
	private Bizum bizumPanel;
	private Transfer transferPanel;
	private RoundPanel panel;
	
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User testUser = new User("JohnDoe47", "john@example.com", "password123", "123456789");
	                testUser.setMoney(1423.45F); // Saldo de prueba para el usuario
	                
	                // Crear y mostrar el dashboard usando este usuario de prueba
					Dashboard frame = new Dashboard(testUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Dashboard(User user) {
		this.user = user;
		
		setTitle("Menu principal");
		ImageIcon icon = new ImageIcon(getClass().getResource("/bankPNG.png"));
		setIconImage(icon.getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sideBar = new JPanel();
		sideBar.setBounds(0, 0, 274, 720);
		sideBar.setBackground(new Color(69, 69, 69));
		contentPane.add(sideBar);
		sideBar.setLayout(null);
		
		RoundLabel profilePic = new RoundLabel("", 150, 150);
		profilePic.setBounds(72, 50, 129, 129);
		profilePic.setIcon(new ImageIcon(getClass().getResource("/profile.png")));
		sideBar.add(profilePic);
		
		RoundPanel menu = new RoundPanel(20, 20);
		menu.setBackground(new Color(44, 44, 44));
		menu.setBounds(16, 246, 242, 421);
		sideBar.add(menu);
		menu.setLayout(null);
		
		homeButton = new RoundButton("INICIO", 10 ,10);
		homeButton.setFocusable(false);
		homeButton.setForeground(Color.WHITE);
		homeButton.setBorder(null);
		homeButton.setBackground(new Color(91, 91, 91));
		homeButton.setFont(new Font("Inter 24pt", Font.BOLD | Font.ITALIC, 20));
		homeButton.setBounds(19, 38, 203, 50);
		menu.add(homeButton);
		
		bizumButton = new RoundButton("", 10, 10);
		bizumButton.setText("BIZUM");
		bizumButton.setForeground(Color.WHITE);
		bizumButton.setFont(new Font("Inter 24pt", Font.BOLD | Font.ITALIC, 20));
		bizumButton.setFocusable(false);
		bizumButton.setBorder(null);
		bizumButton.setBackground(new Color(91, 91, 91));
		bizumButton.setBounds(19, 101, 203, 50);
		menu.add(bizumButton);
		
		transferButton = new RoundButton("", 10, 10);
		transferButton.setText("TRANSFERIR");
		transferButton.setForeground(Color.WHITE);
		transferButton.setFont(new Font("Inter 24pt", Font.BOLD | Font.ITALIC, 20));
		transferButton.setFocusable(false);
		transferButton.setBorder(null);
		transferButton.setBackground(new Color(91, 91, 91));
		transferButton.setBounds(19, 164, 203, 50);
		menu.add(transferButton);
		
		logoutButton = new RoundButton("", 10, 10);
		logoutButton.setText("SALIR");
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Inter 24pt", Font.BOLD | Font.ITALIC, 20));
		logoutButton.setFocusable(false);
		logoutButton.setBorder(null);
		logoutButton.setBackground(new Color(255, 37, 76));
		logoutButton.setBounds(19, 344, 203, 50);
		menu.add(logoutButton);

		usernameField = new JTextField();
		usernameField.setFocusable(false);
		usernameField.setEditable(false);
		usernameField.setBorder(null);
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setFont(new Font("Inter 24pt Black", Font.PLAIN, 23));
		usernameField.setForeground(Color.WHITE);
		usernameField.setBackground(new Color(69, 69, 69));
		usernameField.setBounds(16, 189, 242, 40);
		usernameField.setText(user.getUsername());
		sideBar.add(usernameField);
		usernameField.setColumns(10);
		
		JPanel navBar = new JPanel();
		navBar.setBounds(273, 0, 1008, 126);
		navBar.setBackground(new Color(44, 144, 151));
		contentPane.add(navBar);
		navBar.setLayout(null);
		
		JLabel seeProfileLabel = new JLabel("Ver perfil");
		seeProfileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seeProfileLabel.setForeground(Color.WHITE);
		seeProfileLabel.setFont(new Font("Inter 24pt Black", Font.BOLD, 30));
		seeProfileLabel.setBounds(697, 44, 182, 38);
		navBar.add(seeProfileLabel);
		
		JButton profileMenu = new JButton("");
		profileMenu.setBackground(new Color(44, 144, 151));
		profileMenu.setOpaque(false);
		profileMenu.setBorderPainted(false);
		profileMenu.setBorder(null);
		profileMenu.setIcon(new ImageIcon(getClass().getResource("/seeProfile.png")));
		profileMenu.setBounds(889, 16, 93, 93);
		navBar.add(profileMenu);
		
		profileMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfileFrame p = new ProfileFrame(user);
				p.setVisible(true);
			}
			
		});
		
		//Creacion de los paneles variables

		centralPanel = new JPanel();
		centralPanel.setBackground(new Color(227, 222, 222));
		centralPanel.setBounds(274, 126, 993, 558);
		contentPane.add(centralPanel);
		
		//Creacion del CardLayout
		cardLayout = new CardLayout();
		//Se establece el cardLayout al panel central
		centralPanel.setLayout(cardLayout);
		//Se añaden los 3 paneles al 'centralPanel'
		
		// *** Crear primero el panel Home ***
	    Home homePanel = new Home(user);  // Crear instancia de Home

	    // *** Pasar la referencia de Home al constructor de Transfer ***
	    Transfer transferPanel = new Transfer(user, homePanel);  // Pasar Home a Transfer

	    // Crear instancia de Bizum (si es necesario)
	    Bizum bizumPanel = new Bizum(user, homePanel);

	    // Añadir los paneles al CardLayout del centralPanel
	    
	    centralPanel.add(homePanel, "Home");
	    centralPanel.add(transferPanel, "Transfer");
	    centralPanel.add(bizumPanel, "Bizum");
	    
		//Se llama a los distintos paneles desde los botones
		homeButton.addActionListener(e -> cardLayout.show(centralPanel, "Home"));
	    transferButton.addActionListener(e -> cardLayout.show(centralPanel, "Transfer"));
	    bizumButton.addActionListener(e -> cardLayout.show(centralPanel, "Bizum"));
		
		//EventsListeners
		
		homeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				homeButton.setBackground(new Color(159, 156, 156));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				homeButton.setBackground(new Color(91, 91, 91));
			}
			
		});
		
		bizumButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bizumButton.setBackground(new Color(159, 156, 156));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bizumButton.setBackground(new Color(91, 91, 91));
			}
			
		});
		
		transferButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				transferButton.setBackground(new Color(159, 156, 156));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				transferButton.setBackground(new Color(91, 91, 91));
			}
			
		});
		
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutButton.setBackground(new Color(255, 85, 116));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				logoutButton.setBackground(new Color(255, 37, 76));
			}
			
		});
		
		logoutButton.addActionListener(new buttons());
		
		/*bizumButton.addActionListener(new buttons());
		homeButton.addActionListener(new buttons());
		transferButton.addActionListener(new buttons());*/
		
	}
	
	
	/*
	 * Private class
	 */
	
	private class buttons implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JButton button = (JButton) e.getSource();
	        
	        if(button == logoutButton) {
	        	Object opciones[] = {"Si", "No"};
	        	int option = JOptionPane.showOptionDialog(null, "¿Seguro que deseas cerrar sesion?", "Cierre de sesion", 
	        			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, getIcon("/cerrar-sesion.png", 40, 40), opciones, opciones[0]);
	        	if(option == 0) {
	        		Login l = new Login();
	        		l.setVisible(true);
	        		dispose();
	        	}
	        }
	        
	    }
	}
	
	/*
	 * External methods
	 */
	
	public Icon getIcon(String path, int w, int h) {
		return new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(w, h, 0));
	}
	
}
