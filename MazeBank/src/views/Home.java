package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.User;
import roundedComponents.RoundPanel;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;
	private User user;
	private JTextField moneyField;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Home(User user) {
		setFocusable(false);
		this.user = user;
		
		setBackground(new Color(227, 222, 222));
		setLayout(null);
		
		RoundPanel showMoneyPanel = new RoundPanel(15, 15);
		showMoneyPanel.setBounds(36, 33, 921, 246);
		showMoneyPanel.setCustomBorderColor(new Color(44, 144, 151));
		add(showMoneyPanel);
		showMoneyPanel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(44, 144, 151));
		separator.setBounds(1, 50, 919, 2);
		showMoneyPanel.add(separator);
		
		JLabel myMoney = new JLabel("Mi saldo");
		myMoney.setHorizontalAlignment(SwingConstants.LEFT);
		myMoney.setForeground(new Color(44, 144, 151));
		myMoney.setFont(new Font("Inter 24pt", Font.BOLD | Font.ITALIC, 35));
		myMoney.setBounds(20, 8, 197, 37);
		showMoneyPanel.add(myMoney);
		
		JLabel creditCard = new JLabel("");
		creditCard.setBounds(20, 75, 219, 165);
		creditCard.setIcon(new ImageIcon(getClass().getResource("/card.png")));
		showMoneyPanel.add(creditCard);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(new Color(154, 154, 154));
		textField.setFont(new Font("Inter 28pt Black", Font.PLAIN, 90));
		textField.setText(String.valueOf(user.getMoney()));
		textField.setBounds(261, 75, 638, 145);
		showMoneyPanel.add(textField);
		textField.setColumns(10);
		
		
		

	}

}
