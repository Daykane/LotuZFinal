package com.LotuZ.payment;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.ui.CategoryUI;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public PaymentUI() throws SQLException, UserNotFoundException {
		User user = UserLog.getUserLog();
		Bandeau bandeau = new Bandeau();
		bandeau.setJframe(this);

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
		
		//label Card Number
		JLabel lblNewLabel = new JLabel("Card Number");
		lblNewLabel.setBounds(89, 50, 131, 14);
		panel.add(lblNewLabel);
		
		//label Expiration Date
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(89, 87, 101, 14);
		panel.add(lblExpirationDate);
		
		//label CodeDeConfirmation
		JLabel lblCodeDeConfirmation = new JLabel("Code de confidentialit\u00E9");
		lblCodeDeConfirmation.setBounds(87, 126, 142, 14);
		panel.add(lblCodeDeConfirmation);
		
		//textfield card number
		textField = new JTextField();
		textField.setBounds(270, 47, 185, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		//textfield Expiration date
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(270, 84, 86, 20);
		panel.add(textField_1);
		
		//textfield Code de confirmation
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(270, 123, 86, 20);
		panel.add(textField_2);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//a message to inform that the payment is submit
				JOptionPane.showMessageDialog(null,"Payment submit","Payment submit",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(162, 270, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CategoryUI category = new CategoryUI();
					category.setVisible(true);
					category.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancel.setBounds(295, 270, 89, 23);
		panel.add(btnCancel);

	}
}
