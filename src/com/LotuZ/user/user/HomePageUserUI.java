package com.LotuZ.user.user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.LotuZ.activity.ActivityCreateUI;
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePageUserUI extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageUserUI frame = new HomePageUserUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public HomePageUserUI() {
		
		User user = UserLog.getUserLog();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcceuil = new JLabel("Acceuil User");
		lblAcceuil.setBounds(131, 11, 95, 14);
		contentPane.add(lblAcceuil);
		
		JLabel lblNewLabel = new JLabel("Bienvenue :");
		lblNewLabel.setBounds(69, 49, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel(user.getLastName() +" "+ user.getFirstName());
		lblName.setBounds(201, 49, 95, 14);
		contentPane.add(lblName);
		
		JButton btnGestionEvent = new JButton("Gestion Event");
		btnGestionEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivityCreateUI activityUI =  new ActivityCreateUI();				
				activityUI.setVisible(true);
			}
		});
		btnGestionEvent.setBounds(36, 153, 99, 23);
		contentPane.add(btnGestionEvent);
		
		
	}
}
