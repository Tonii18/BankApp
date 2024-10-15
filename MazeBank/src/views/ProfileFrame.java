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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundLabel;
import services.DBServices;
import javax.swing.JTextField;

public class ProfileFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private User user;
	private JTextField emailTF;
	private JTextField phoneTF;
	private JTextField dollarTF;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileFrame frame = new ProfileFrame();
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
	public ProfileFrame(User user) {
		this.user = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 680);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundLabel mailLabel = new RoundLabel("", 15, 15);
		mailLabel.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 24));
		mailLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
		mailLabel.setBackground(new Color(215, 215, 215));
		mailLabel.setBounds(23, 342, 440, 52);
		mailLabel.setIcon(new ImageIcon(getClass().getResource("/profileMail.png")));
		
		dollarTF = new JTextField();
		dollarTF.setFocusable(false);
		dollarTF.setHorizontalAlignment(SwingConstants.CENTER);
		dollarTF.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 24));
		dollarTF.setColumns(10);
		dollarTF.setBorder(null);
		dollarTF.setBackground(new Color(215, 215, 215));
		dollarTF.setBounds(83, 474, 358, 48);
		try {
			dollarTF.setText(String.valueOf(DBServices.getCurrentBalance(user)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(dollarTF);
		
		phoneTF = new JTextField();
		phoneTF.setFocusable(false);
		phoneTF.setHorizontalAlignment(SwingConstants.CENTER);
		phoneTF.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 24));
		phoneTF.setColumns(10);
		phoneTF.setBorder(null);
		phoneTF.setBackground(new Color(215, 215, 215));
		phoneTF.setBounds(83, 410, 358, 48);
		try {
			phoneTF.setText(String.valueOf(DBServices.getUser(user.getUsername()).getPhone()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(phoneTF);
		
		emailTF = new JTextField();
		emailTF.setFocusable(false);
		emailTF.setHorizontalAlignment(SwingConstants.CENTER);
		emailTF.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 24));
		emailTF.setBorder(null);
		emailTF.setBackground(new Color(215, 215, 215));
		emailTF.setBounds(83, 344, 358, 48);
		try {
			emailTF.setText(String.valueOf(DBServices.getUser(user.getUsername()).getEmail()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		contentPane.add(mailLabel);
		
		JLabel profilePic = new JLabel("");
		profilePic.setBounds(153, 70, 180, 180);
		profilePic.setIcon(new ImageIcon(getClass().getResource("/profilePic.png")));
		contentPane.add(profilePic);
		
		JLabel whiteEllipse = new JLabel("");
		whiteEllipse.setBounds(143, 58, 200, 200);
		whiteEllipse.setIcon(new ImageIcon(getClass().getResource("/profileElipse.png")));
		contentPane.add(whiteEllipse);
		
		RoundLabel background = new RoundLabel("", 15, 15);
		background.setBounds(-7, 0, 500, 160);
		background.setIcon(new ImageIcon(getClass().getResource("/profileBack.png")));
		contentPane.add(background);
		
		RoundButton close = new RoundButton("Cerrar", 10, 10);
		close.setFocusable(false);
		close.setForeground(new Color(255, 255, 255));
		close.setFont(new Font("Inter 24pt", Font.PLAIN, 20));
		close.setBorderPainted(false);
		close.setBorder(null);
		close.setBackground(new Color(0, 149, 255));
		close.setBounds(148, 583, 190, 40);
		contentPane.add(close);
		
		JLabel username = new JLabel("");
		username.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 24));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(88, 260, 310, 40);
		username.setText(user.getUsername());
		contentPane.add(username);
		
		RoundLabel phoneLabel = new RoundLabel("", 15, 15);
		phoneLabel.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 24));
		phoneLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
		phoneLabel.setBackground(new Color(215, 215, 215));
		phoneLabel.setBounds(23, 406, 440, 52);
		phoneLabel.setIcon(new ImageIcon(getClass().getResource("/profilePhone.png")));
		contentPane.add(phoneLabel);
		
		RoundLabel moneyLabel = new RoundLabel("", 15, 15);
		moneyLabel.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 24));
		moneyLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
		moneyLabel.setBackground(new Color(215, 215, 215));
		moneyLabel.setBounds(23, 470, 440, 52);
		moneyLabel.setIcon(new ImageIcon(getClass().getResource("/profileDollar.png")));
		contentPane.add(moneyLabel);
		
		
		
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setBackground(new Color(105, 193, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				close.setBackground(new Color(0, 149, 255));
			}
			
		});
		
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
	}
}
