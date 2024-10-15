package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.User;
import roundedComponents.RoundPanel;
import services.DBServices;

public class Transfer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton setMoneyButton;
	private JButton getMoneyButton;
	
	private User user;
	private Home homepanel;

	/**
	 * Create the panel.
	 */
	public Transfer(User user, Home homepanel) {
		this.user = user;
		this.homepanel = homepanel;
		
		setBackground(new Color(227, 222, 222));
		setLayout(null);
		
		RoundPanel setMoneyPanel = new RoundPanel(25, 25);
		setMoneyPanel.setBackground(new Color(255, 255, 255));
		setMoneyPanel.setBounds(168, 193, 244, 172);
		add(setMoneyPanel);
		setMoneyPanel.setLayout(null);
		
		setMoneyButton = new JButton("Ingresar dinero");
		setMoneyButton.setBackground(new Color(255, 255, 255));
		setMoneyButton.setFocusable(false);
		setMoneyButton.setBorder(null);
		setMoneyButton.setForeground(new Color(44, 144, 151));
		setMoneyButton.setFont(new Font("Inter 18pt Light", Font.PLAIN, 20));
		setMoneyButton.setBounds(4, 3, 235, 165);
		setMoneyButton.setIcon(new ImageIcon(getClass().getResource("/Arrow-up.png")));
		setMoneyButton.setHorizontalTextPosition(SwingConstants.CENTER);  // Texto centrado horizontalmente
		setMoneyButton.setVerticalTextPosition(SwingConstants.BOTTOM);    // Texto debajo del icono
		setMoneyButton.setIconTextGap(10);  // Espacio entre el icono y el texto
		setMoneyPanel.add(setMoneyButton);

		
		RoundPanel getMoneyPanel = new RoundPanel(25, 25);
		getMoneyPanel.setBackground(new Color(255, 255, 255));
		getMoneyPanel.setBounds(580, 193, 244, 172);
		add(getMoneyPanel);
		getMoneyPanel.setLayout(null);
		
		getMoneyButton = new JButton("Retirar dinero");
		getMoneyButton.setBackground(Color.WHITE);
		getMoneyButton.setFocusable(false);
		getMoneyButton.setBorderPainted(false);
		getMoneyButton.setBorder(null);
		getMoneyButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		getMoneyButton.setIconTextGap(10);
		getMoneyButton.setIcon(new ImageIcon(Transfer.class.getResource("/Arrow up-1.png")));
		getMoneyButton.setHorizontalTextPosition(SwingConstants.CENTER);
		getMoneyButton.setForeground(new Color(44, 144, 151));
		getMoneyButton.setFont(new Font("Inter 18pt Light", Font.PLAIN, 20));
		getMoneyButton.setBounds(4, 3, 235, 165);
		getMoneyPanel.add(getMoneyButton);
		
		getMoneyButton.addActionListener(new buttons());
		setMoneyButton.addActionListener(new buttons());

	}
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			
			if(button == getMoneyButton) {
				getMoney(user);
			}else if(button == setMoneyButton) {
				setMoney(user);
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void getMoney(User user) {
        String money = (String) JOptionPane.showInputDialog(null, "Introduce la cantidad a retirar", "Retiro de dinero", 
        		JOptionPane.PLAIN_MESSAGE, getIcon("/Arrow down-left.png", 40, 40), null, null);
        
        if (money != null) {
            try {
                Double amountRetired = Double.valueOf(money);
                if (DBServices.getCurrentBalance(user) > amountRetired) { // Verificar que hay suficiente saldo
                    user.setMoney(user.getMoney() - amountRetired);
                    // Actualizar en la base de datos
                    if (DBServices.withdrawMoney(user, amountRetired)) {
                        JOptionPane.showMessageDialog(null, "Retiro exitoso.");
                        homepanel.updateBalance();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar el saldo en la base de datos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un valor válido.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
            }
        }
    }
	
	public void setMoney(User user) {
        String money = (String) JOptionPane.showInputDialog(null, "Introduce la cantidad a ingresar", "Ingreso de dinero", 
        		JOptionPane.PLAIN_MESSAGE, getIcon("/Arrow up-right.png", 40, 40), null, null);
        
        if (money != null) {
            try {
                Double amountEntered = Double.valueOf(money);
                user.setMoney(user.getMoney() + amountEntered);
                // Actualizar en la base de datos
                if (DBServices.depositMoney(user, amountEntered)) {
                    JOptionPane.showMessageDialog(null, "Ingreso exitoso.");
                    homepanel.updateBalance();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el saldo en la base de datos.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un valor válido.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
            }
        }
    }
	
	public Icon getIcon(String path, int w, int h) {
		return new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(w, h, 0));
	}
	
}
