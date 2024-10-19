package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;
import services.DBServices;

public class AddContact extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private RoundButton add;
	private JLabel profileLabel;
	private RoundTextField nameField;
	private RoundTextField surnameField;
	private RoundTextField phoneField;
	
	private User user;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContact frame = new AddContact();
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
	public AddContact(User user) {
		this.user = user;
		
		setTitle("Añade un contacto a tu agenda");
		ImageIcon icon = new ImageIcon(getClass().getResource("/bankPNG.png"));
		setIconImage(icon.getImage());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundPanel panel = new RoundPanel(10, 10);
		panel.setBackground(new Color(238, 238, 238));
		panel.setCustomBorderColor(new Color(186, 186, 186));
		panel.setBounds(16, 10, 414, 521);
		contentPane.add(panel);
		panel.setLayout(null);
		
		profileLabel = new JLabel("");
		profileLabel.setBounds(142, 36, 130, 130);
		profileLabel.setIcon(new ImageIcon(getClass().getResource("/profile.png")));
		panel.add(profileLabel);
		
		nameField = new RoundTextField(10, 10, 10);
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setForeground(new Color(91, 91, 91));
		nameField.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 20));
		nameField.setBorder(null);
		nameField.setBackground(new Color(217, 217, 217));
		nameField.setBounds(84, 217, 245, 38);
		panel.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new RoundTextField(10, 10, 10);
		surnameField.setHorizontalAlignment(SwingConstants.CENTER);
		surnameField.setForeground(new Color(91, 91, 91));
		surnameField.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 20));
		surnameField.setColumns(10);
		surnameField.setBorder(null);
		surnameField.setBackground(new Color(217, 217, 217));
		surnameField.setBounds(84, 278, 245, 38);
		panel.add(surnameField);
		
		phoneField = new RoundTextField(10, 10, 10);
		phoneField.setHorizontalAlignment(SwingConstants.CENTER);
		phoneField.setForeground(new Color(91, 91, 91));
		phoneField.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 20));
		phoneField.setColumns(10);
		phoneField.setBorder(null);
		phoneField.setBackground(new Color(217, 217, 217));
		phoneField.setBounds(84, 383, 245, 38);
		panel.add(phoneField);
		
		JLabel picLabel = new JLabel("");
		picLabel.setBounds(20, 215, 40, 40);
		picLabel.setIcon(new ImageIcon(getClass().getResource("/person.png")));
		panel.add(picLabel);
		
		JLabel phoneLabel = new JLabel("");
		phoneLabel.setIcon(new ImageIcon(AddContact.class.getResource("/phone2.png")));
		phoneLabel.setBounds(25, 381, 40, 40);
		panel.add(phoneLabel);
		
		add = new RoundButton("Guardar mi contacto", 10, 10);
		add.setBorder(null);
		add.setBackground(new Color(44, 144, 151));
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Inter 24pt", Font.BOLD, 18));
		add.setBounds(16, 554, 414, 44);
		contentPane.add(add);
		
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				add.setBackground(new Color(40, 197, 208));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				add.setBackground(new Color(44, 144, 151));
			}
			
		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveContact();
			}
			
		});
		
	}
	
	/*
	 * External methods
	 */
	
	public void saveContact() {
		String username = nameField.getText();
		String surname = surnameField.getText();
		String phone = phoneField.getText();
		
		int userID = DBServices.obtenerUserIdPorNombre(user.getUsername());
		
		if(!username.isEmpty() && !surname.isEmpty() && !phone.isEmpty()) {
			if(DBServices.insertarContacto(userID, username, surname, phone)) {
				JOptionPane.showMessageDialog(null, "Contacto añadido con exito");
				dispose();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos");
		}
	}
	
}
