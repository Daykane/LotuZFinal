package com.LotuZ.payment;

import interfaceDeBase.Bandeau;
import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserDetailUI;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PaymentUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		// Info Connection
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";

		// Choose the kit
		JdbcKit jdbcKit = new JdbcKit(url,login,passwd);
		jdbcKit.openConnection(url, login, passwd);

		// Init the FacadeBL with the kit
		FacadeBL.init(jdbcKit);
		//FacadeUser.init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentUI frame = new PaymentUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public PaymentUI() throws SQLException, UserNotFoundException {
		FacadeUser.login("jack","jack");
		User user = UserLog.getUserLog();
		Bandeau bandeau = new Bandeau();

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(bandeau.createBandeau(user, "Paiement"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Card Number");
		lblNewLabel.setBounds(104, 50, 74, 14);
		panel.add(lblNewLabel);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(104, 87, 74, 14);
		panel.add(lblExpirationDate);
		
		JLabel lblCodeDeConfirmation = new JLabel("Code de confidentialit\u00E9");
		lblCodeDeConfirmation.setBounds(104, 126, 131, 14);
		panel.add(lblCodeDeConfirmation);
		
		textField = new JTextField();
		textField.setBounds(270, 47, 185, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(270, 84, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(270, 123, 86, 20);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(162, 270, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(295, 270, 89, 23);
		panel.add(btnCancel);

	}
}
