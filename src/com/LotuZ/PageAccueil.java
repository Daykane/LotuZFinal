package com.LotuZ;
import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

import java.sql.SQLException;





public class PageAccueil extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public PageAccueil() {
		//FacadeUser.login("jack","jack");
		User user = UserLog.getUserLog();

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		Bandeau bandeau = new Bandeau();
		bandeau.setJframe(this);
		contentPane.add(bandeau.createBandeau(user,"Page Acceuil"), BorderLayout.NORTH);
	
	}

}
