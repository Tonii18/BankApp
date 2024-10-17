package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import models.Contact;
import models.User;
import roundedComponents.RoundButton;
import services.DBServices;

public class ContactList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private RoundButton addContact;
	private JScrollPane scrollPane;

	private User user;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ContactList frame = new ContactList();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ContactList(User user) throws SQLException {
		this.user = user;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Crear el panel que contendrá la lista de contactos
        JPanel contactPanelList = new JPanel();
        contactPanelList.setBackground(new Color(238, 238, 238));
        // Cambiamos a BoxLayout para alinear los contactos en una columna
        contactPanelList.setLayout(new BoxLayout(contactPanelList, BoxLayout.Y_AXIS));

        // Crear el JScrollPane y agregar el panel de contactos dentro de él
        scrollPane = new JScrollPane(contactPanelList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(16, 10, 414, 521);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(scrollPane);

		List<Contact> contactos = DBServices.getUserContacts(DBServices.obtenerUserIdPorNombre(user.getUsername()));

		for (Contact contacto : contactos) {
		    // Crear un panel para cada contacto
		    JPanel contactPanel = new JPanel();
		    contactPanel.setLayout(new BorderLayout());
		    contactPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		    // Definir la etiqueta con la información del contacto
		    JLabel contactLabel = new JLabel(
		            contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getTelefono());
		    contactPanel.add(contactLabel, BorderLayout.CENTER);

		    // Establecer un tamaño fijo para el panel
		    contactPanel.setPreferredSize(new Dimension(400, 80)); 
		    contactPanel.setMinimumSize(new Dimension(400, 80));  // Tamaño mínimo
		    contactPanel.setMaximumSize(new Dimension(400, 80));  // Tamaño máximo

		    // Añadir el panel de contacto al panel principal que usa BoxLayout
		    contactPanelList.add(contactPanel);

		    // Añadir un espacio rígido entre los contactos para evitar colisiones visuales
		    contactPanelList.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio vertical de 10 píxeles
		}

		addContact = new RoundButton("Agregar un nuevo contacto", 10, 10);
		addContact.setBorder(null);
		addContact.setForeground(new Color(255, 255, 255));
		addContact.setBackground(new Color(44, 144, 151));
		addContact.setFont(new Font("Inter 24pt", Font.BOLD, 18));
		addContact.setBounds(16, 554, 414, 44);
		contentPane.add(addContact);

		addContact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddContact a = new AddContact(user);
				a.setVisible(true);
				dispose();
			}

		});

		addContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				addContact.setBackground(new Color(40, 197, 208));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				addContact.setBackground(new Color(44, 144, 151));
			}

		});

	}
}
