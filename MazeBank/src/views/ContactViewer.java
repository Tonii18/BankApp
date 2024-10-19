package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import models.User;
import roundedComponents.RoundPanel;

public class ContactViewer extends RoundPanel {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the panel.
	 */
	public ContactViewer(int r, int r2, String nombre, String apellido, String telefono) {
		super(r, r2);
		setBackground(new Color(217, 217, 217));
		setBorder(new LineBorder(new Color(117, 117, 117)));
		setLayout(null);
		setCustomBorderColor(new Color(117, 117, 117));
		
		JLabel picLabel = new JLabel("");
		picLabel.setBounds(15, 20, 50, 50);
		picLabel.setIcon(new ImageIcon(getClass().getResource("/profileSmall.png")));
		add(picLabel);
		
		JLabel completeName = new JLabel("New label");
		completeName.setForeground(new Color(91, 91, 91));
		completeName.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 16));
		completeName.setBorder(new EmptyBorder(0, 5, 0, 0));
		completeName.setBounds(80, 20, 250, 20);
		completeName.setText(nombre+" "+apellido);
		add(completeName);
		
		JLabel phone = new JLabel("New label");
		phone.setForeground(new Color(91, 91, 91));
		phone.setFont(new Font("Inter 24pt Medium", Font.ITALIC, 16));
		phone.setBorder(new EmptyBorder(0, 5, 0, 0));
		phone.setBounds(80, 50, 250, 20);
		phone.setText(telefono);
		add(phone);

	}
}
