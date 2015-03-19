package com.LotuZ.user;


import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.LotuZ.inscription.InscriptionUserUI;
import com.LotuZ.login.LoginUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomepageUI extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static HomepageUI frame;

	/*
	/**
	 * Launch the application.
	//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HomepageUI();					
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
	public HomepageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JButton btnInscription = new JButton("Inscription");
		btnInscription.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				InscriptionUserUI inscriptionUserUI =  new InscriptionUserUI();
				InscriptionUserUI.frame = inscriptionUserUI;
				inscriptionUserUI.setVisible(true);
				frame.dispose();
			}
		});
		panel.add(btnInscription);
		
		JButton btnAuthentification = new JButton("Authentification");
		btnAuthentification.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				LoginUI loginUI =  new LoginUI();	
				LoginUI.frame = loginUI;
				loginUI.setVisible(true);
				frame.dispose();
				
				

			}
		});
		panel.add(btnAuthentification);
	}

}
