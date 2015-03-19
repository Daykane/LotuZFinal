package com.LotuZ;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.LotuZ.login.LoginUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.awt.GridLayout;

import javax.swing.border.TitledBorder;


public class PageAccueil extends JFrame {

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
	public PageAccueil() throws SQLException, UserNotFoundException {
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

		JPanel panelBandeau = new JPanel();
		panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(panelBandeau, BorderLayout.NORTH);
		panelBandeau.setLayout(new BorderLayout(0, 0));


		JLabel lblTitle = new JLabel("Accueil");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBandeau.add(lblTitle, BorderLayout.CENTER);

		JLabel lblToto = new JLabel("LOGO");
		lblToto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblToto.setHorizontalAlignment(SwingConstants.LEFT);
		//panel.add(lblToto, BorderLayout.WEST);

		JLabel image = new JLabel(new ImageIcon("zen.jpg"));
		panelBandeau.add(image,BorderLayout.WEST);

		JPanel panelOptions = new JPanel();
		panelBandeau.add(panelOptions, BorderLayout.EAST);
		panelOptions.setLayout(new GridLayout(3, 1, 0, 0));

		final JLabel lblnameUser = new JLabel("name");
		panelOptions.add(lblnameUser);
		if 	(user!=null){
			lblnameUser.setText(user.getLastName() +" "+ user.getFirstName());
		}
		else {
			lblnameUser.setVisible(false);
		}
		final String nameUser = lblnameUser.getText(); 
		lblnameUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Clicked sur name = acces profil");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblnameUser.setText("<html><u><font color = #1373cc >"+nameUser +" </u></font></html>");
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblnameUser.setText(nameUser);
			}
		});
		lblnameUser.setHorizontalAlignment(SwingConstants.LEFT);

		final JLabel lblConnexion = new JLabel("connexion/deconnexion");
		lblConnexion.setHorizontalAlignment(SwingConstants.LEFT);
		panelOptions.add(lblConnexion);
		if (user == null){
			lblConnexion.setText("connexion");
		}
		else {
			lblConnexion.setText("déconnexion");
		}
		final String Connexion = lblConnexion.getText();
		final JLabel lblBoutique = new JLabel("Boutique Access");
		panelOptions.add(lblBoutique);
		final String Boutique = lblBoutique.getText();
		lblBoutique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Clicked sur acces boutique");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblBoutique.setText("<html><u><font color = #1373cc >"+Boutique +" </u></font></html>");
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblBoutique.setText(Boutique);
			}
		});
		lblBoutique.setHorizontalAlignment(SwingConstants.LEFT);
		lblConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(UserLog.getUserLog() == null){
					LoginUI loginUI =  new LoginUI();	
					LoginUI.frame = loginUI;
					loginUI.setVisible(true);
				}
				else{
					System.out.println("Faire une déconnexion");
				}
				System.out.println("Connexion ou deconnexion si la personne n'est pas connecté ou l'est");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblConnexion.setText("<html><u><font color = #1373cc >"+Connexion +" </u></font></html>");
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblConnexion.setText(Connexion);
			}
		});
	}

}
