package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;
import services.DBServices;

public class Bizum extends JPanel {

	private static final long serialVersionUID = 1L;
	private RoundTextField amountMoney;
	
	private JButton addButton;
	
	private User user;
	private Home home;
	

	/**
	 * Create the panel.
	 */
	public Bizum(User user, Home home) {
		this.user = user;
		this.home = home;
		
		setBackground(new Color(227, 222, 222));
		setLayout(null);
        
        JLabel bizumLogo = new JLabel("");
        bizumLogo.setBounds(420, 36, 153, 153);
        bizumLogo.setIcon(new ImageIcon(getClass().getResource("/bizumLogo.png")));
        add(bizumLogo);
        
        amountMoney = new RoundTextField(10, 15, 15);
        amountMoney.setHorizontalAlignment(SwingConstants.CENTER);
        amountMoney.setForeground(new Color(154, 154, 154));
        amountMoney.setFont(new Font("Inter 28pt Black", Font.ITALIC, 45));
        amountMoney.setBounds(351, 217, 290, 60);
        add(amountMoney);
        amountMoney.setColumns(10);
        
        JPanel numPad = new JPanel();
        numPad.setBackground(new Color(227, 222, 222));
        numPad.setBounds(382, 308, 229, 168);
        add(numPad);
        numPad.setLayout(new GridLayout(3, 3, 10, 10));
        
        RoundButton submit = new RoundButton("ENVIAR", 10, 10);
        submit.setForeground(new Color(255, 255, 255));
        submit.setBackground(new Color(44, 144, 151));
        submit.setBorder(null);
        submit.setFont(new Font("Inter 24pt", Font.PLAIN, 20));
        submit.setBounds(426, 500, 140, 42);
        add(submit);
        
        RoundPanel addButtonPanel = new RoundPanel(10, 10);
        addButtonPanel.setBackground(Color.WHITE);
        addButtonPanel.setBounds(663, 217, 60, 60);
        add(addButtonPanel);
        addButtonPanel.setLayout(null);
        
        addButton = new JButton("");
        addButton.setBounds(5, 5, 50, 50);
        addButtonPanel.add(addButton);
        addButton.setBorderPainted(false);
        addButton.setBackground(Color.WHITE);
        addButton.setBorder(null);
        addButton.setIcon(new ImageIcon(getClass().getResource("/addContact.png")));
        
        addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactList c;
				try {
					c = new ContactList(user, Bizum.this);
					c.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
        	
        });
        
        submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DBServices.withdrawMoney(user, getAmountMoney());
					JOptionPane.showMessageDialog(null, "¡Bizum enviado correctamente!", "Enviar Bizum", JOptionPane.PLAIN_MESSAGE, getIcon("/comprobado.png", 40, 40));
					home.updateBalance();
					amountMoney.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        	
        });
        
        for(int i = 1; i <= 9; i++) {
        	RoundButton button = new RoundButton(String.valueOf(i), 10, 10);
        	button.setFont(new Font("Inter Black", Font.PLAIN, 40));
        	button.setForeground(new Color(154, 154 ,154));
        	button.setBackground(Color.WHITE);
        	button.setFocusable(false);
        	numPad.add(button);
        	
        	button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					RoundButton button = (RoundButton)e.getSource();
					amountMoney.setText(amountMoney.getText()+String.valueOf(button.getText()));
				}
        		
        	});
        	
        	button.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			            String currentText = amountMoney.getText();

			            if (currentText.length() == 1) {
			            	amountMoney.setText("0");  //Establecer en 0 si no hay mas numeros en el campo
			            } else if (currentText.length() > 1) {
			            	amountMoney.setText(currentText.substring(0, currentText.length() - 1));
			            }
			            e.consume(); // Prevent further processing of the event
			        }
				}
        	});
        	
        }
        
        

	}
	
	/*
	 * External Methods
	 */
	
	public double getAmountMoney() {
	    String text = amountMoney.getText().trim(); // Eliminar espacios en blanco alrededor del texto
	    if (text.isEmpty()) {
	        // Si el campo está vacío, devolvemos un valor por defecto, por ejemplo 0
	        return 0;
	    }

	    try {
	        return Double.valueOf(text);
	    } catch (NumberFormatException e) {
	        // Manejo de la excepción en caso de que no sea un número válido
	        JOptionPane.showMessageDialog(this, "Por favor, introduce una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
	        return 0; // Devolver 0 en caso de error
	    }
	}

	public Icon getIcon(String path, int w, int h) {
		return new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(w, h, 0));
	}
	
	
}
