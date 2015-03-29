package com.LotuZ.EventInscription;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.user.bl.User;

public class EventInscriptionUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EventInscriptionUI() {
		//User user = FacadeUser.login("jack", "jack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//contentPane.add(Bandeau.createBandeau(user, "Ma page"), BorderLayout.NORTH);
	}

}
