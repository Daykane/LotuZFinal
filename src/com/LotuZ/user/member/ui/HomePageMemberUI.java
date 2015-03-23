package com.LotuZ.user.member.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class HomePageMemberUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageMemberUI frame = new HomePageMemberUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePageMemberUI() {
		
		User user = UserLog.getUserLog();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAcceuilMember = new JLabel("Acceuil Member");
		panel.add(lblAcceuilMember);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblBienvenue = new JLabel("Bienvenue : ");
		lblBienvenue.setBounds(27, 79, 89, 14);
		panel_1.add(lblBienvenue);
		
		JLabel lblName = new JLabel(user.getLastName() +" "+ user.getLastName());
		lblName.setBounds(141, 79, 62, 14);
		panel_1.add(lblName);
		
	}
}
