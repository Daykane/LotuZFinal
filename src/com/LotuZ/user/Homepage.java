package com.LotuZ.user;
import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;




import com.LotuZ.FacadeBL;
import com.LotuZ.activity.UI.ActivityUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.User;

import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;








import javax.swing.JButton;


public class Homepage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public Homepage() throws SQLException, UserNotFoundException {
		
		User user = UserLog.getUserLog();
		Administrator admin = UserLog.getAdminLog();
		ActivityLeader activityLeader = UserLog.getRespoLog();

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

		contentPane.add(bandeau.createBandeau(user, "Accueil"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(300);
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
		
		JButton btnGestionDesActivitees = new JButton("Gestion des activit\u00E9es");
		btnGestionDesActivitees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivityUI activityUI = new ActivityUI();
				activityUI.setVisible(true);
				activityUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btnGestionDesActivitees);
		
		JButton btnGestionDesEvents = new JButton("Mes activit\u00E9es");
		btnGestionDesEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PlanningUI planning;
				try {
					planning = new PlanningUI();
					planning.setVisible(true);
					planning.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		panel.add(btnGestionDesEvents);
		
		JButton btnSinscrireUn = new JButton("S'inscrire a un evenement");
		btnSinscrireUn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BoxLetter boxLetter = FacadeBL.getBoxLetter(UserLog.getMemberLog().getIdMember());

				try {
					boxLetter.sendNotification(14, UserLog.getMemberLog().getIdMember());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		
		panel.add(btnSinscrireUn);
		
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
		
		// Test des droits de l'utilisateur connect� 
		if (admin != null)
		{
			btnGestionDesResponsables.setVisible(true);
			btnGestionDesMembres.setVisible(true);
			btnGestionDesIntervenants.setVisible(true);
			btnGestionDesUtilisateurs.setVisible(true);
			btnGestionDesEvents.setVisible(true);
			
		}
		else if (admin == null && activityLeader != null)
		{
			btnGestionDesResponsables.setVisible(false);
			btnGestionDesMembres.setVisible(false);
			btnGestionDesIntervenants.setVisible(true);
			btnGestionDesUtilisateurs.setVisible(false);
			btnGestionDesEvents.setVisible(true);
		}
		else 
		{
			btnGestionDesResponsables.setVisible(false);
			btnGestionDesMembres.setVisible(false);
			btnGestionDesIntervenants.setVisible(false);
			btnGestionDesEvents.setVisible(false);
			btnGestionDesUtilisateurs.setVisible(false);
		}
	}

}
