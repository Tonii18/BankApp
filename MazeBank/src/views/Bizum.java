package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;

public class Bizum extends JPanel {

	private static final long serialVersionUID = 1L;
	private RoundTextField amountMoney;
	
	private JButton addButton;

	/**
	 * Create the panel.
	 */
	public Bizum() {
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
        
        submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sendBizum();
				} catch (InterruptedException e1) {
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
	
	public void sendBizum() throws InterruptedException {
		String contacto = JOptionPane.showInputDialog(null, "Escribe el contacto al que le quieres hacer el bizum: ");
		Thread.sleep(2000);
		JOptionPane.showMessageDialog(null, "Bizum mandado con exito a "+contacto);
		amountMoney.setText("");
	}
	
}
