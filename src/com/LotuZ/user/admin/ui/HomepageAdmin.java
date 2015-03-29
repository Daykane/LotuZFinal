package com.LotuZ.user.admin.ui;
import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;



import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.ListUserUI;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.User;

import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;


public class HomepageAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		FacadeUser.init(jdbcKit);
		FacadeEvent.init(jdbcKit);
		//FacadeUser.init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageAdmin frame = new HomepageAdmin();
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
	public HomepageAdmin() throws SQLException, UserNotFoundException {
		
		FacadeUser.login("jack","jack");

		User user = UserLog.getUserLog();
		Administrator admin = UserLog.getAdminLog();
		ActivityLeader activityLeader = UserLog.getRespoLog();

		Bandeau bandeau = new Bandeau();

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(bandeau.createBandeau(user, "Accueil"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(60);
		flowLayout.setHgap(220);
		contentPane.add(panel, BorderLayout.CENTER);

		
		JButton btnGestionDesMembres = new JButton("Gestion des Membres");
		btnGestionDesMembres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListUserUI listUser;
				try {
					listUser = new ListUserUI(1);
					listUser.setVisible(true);
					listUser.setLocationRelativeTo(null);
					dispose();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		panel.add(btnGestionDesMembres);
		
		JButton btnGestionDesIntervenants = new JButton("Gestion des Intervenants");
		btnGestionDesIntervenants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListUserUI listUser;
				try {
					listUser = new ListUserUI(2);
					listUser.setVisible(true);
					listUser.setLocationRelativeTo(null);
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
		panel.add(btnGestionDesIntervenants);
		

		JButton btnGestionDesUtilisateurs = new JButton("Gestion des utilisateurs");
		btnGestionDesUtilisateurs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListUserUI listUser;
				try {
					listUser = new ListUserUI(4);
					listUser.setVisible(true);
					listUser.setLocationRelativeTo(null);
					dispose();

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (UserNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		panel.add(btnGestionDesUtilisateurs);
		
		
		JButton btnGestionDesResponsables = new JButton("Gestion des Responsables d'Activit\u00E9s");
		panel.add(btnGestionDesResponsables);
		
		btnGestionDesResponsables.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ListUserUI listUser;
				try {
					listUser = new ListUserUI(3);
					listUser.setVisible(true);
					listUser.setLocationRelativeTo(null);
					dispose();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		// Test des droits de l'utilisateur connecté 
		if (admin != null)
		{
			btnGestionDesResponsables.setVisible(true);
			btnGestionDesMembres.setVisible(true);
			btnGestionDesIntervenants.setVisible(true);
		}
		else if (admin == null && activityLeader != null)
		{
			btnGestionDesResponsables.setVisible(false);
			btnGestionDesMembres.setVisible(false);
			btnGestionDesIntervenants.setVisible(true);
		}
		else 
		{
			btnGestionDesResponsables.setVisible(false);
			btnGestionDesMembres.setVisible(false);
			btnGestionDesIntervenants.setVisible(false);
		}
	}

}
