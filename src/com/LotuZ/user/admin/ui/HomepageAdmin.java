//package com.LotuZ.user.admin.ui;
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import java.awt.FlowLayout;
//
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
//
//import com.LotuZ.FacadeBL;
//import com.LotuZ.JdbcKit;
//import com.LotuZ.inscription.InscriptionUserUI;
//import com.LotuZ.login.UserNotFoundException;
//import com.LotuZ.user.FacadeUser;
//import com.LotuZ.user.UserLog;
//import com.LotuZ.user.activityLeader.ui.ActivityLeaderDetailUI;
//import com.LotuZ.user.activityLeader.ui.ActivityLeaderUI;
//import com.LotuZ.user.user.bl.User;
//
//import java.awt.Font;
//import java.sql.SQLException;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//
//import javax.swing.BoxLayout;
//
//import java.awt.GridLayout;
//
//import javax.swing.border.TitledBorder;
//import javax.swing.JButton;
//
//
//public class HomepageAdmin extends JFrame {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JFrame ActivityLeaderUI;
//
//	/**
//	 * Launch the application.
//	 */
//
//	public static void main(String[] args) {
//		// Info Connection
//		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
//		String login = "ROLL";
//		String passwd = "rolldevelopment";
//
//		// Choose the kit
//		JdbcKit jdbcKit = new JdbcKit(url,login,passwd);
//		jdbcKit.openConnection(url, login, passwd);
//
//		// Init the FacadeBL with the kit
//		FacadeBL.init(jdbcKit);
//		//FacadeUser.init();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomepageAdmin frame = new HomepageAdmin();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//
//	/**
//	 * Create the frame.
//	 * @throws UserNotFoundException 
//	 * @throws SQLException 
//	 */
//	public HomepageAdmin() throws SQLException, UserNotFoundException {
//		FacadeUser.login("jack","jack");
//		User user = UserLog.getUserLog();
//		
//		ActivityLeaderUI gestionRespo;
//		gestionRespo = new ActivityLeaderUI();
//		//ActivityLeaderUI.frame = gestionRespo;
//
//		setTitle("Zen Lounge");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(300,800, 750, 600);
//		contentPane = new JPanel();
//		contentPane.setToolTipText("");
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new BorderLayout(0, 0));
//
//		JPanel panelBandeau = new JPanel();
//		panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
//		contentPane.add(panelBandeau, BorderLayout.NORTH);
//		panelBandeau.setLayout(new BorderLayout(0, 0));
//
//
//		JLabel lblTitle = new JLabel("NOM DE TA PAGE");
//		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		panelBandeau.add(lblTitle, BorderLayout.CENTER);
//
//		JLabel lblToto = new JLabel("LOGO");
//		lblToto.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblToto.setHorizontalAlignment(SwingConstants.LEFT);
//		//panel.add(lblToto, BorderLayout.WEST);
//
//		JLabel image = new JLabel(new ImageIcon("zen.jpg"));
//		panelBandeau.add(image,BorderLayout.WEST);
//
//		JPanel panelOptions = new JPanel();
//		panelBandeau.add(panelOptions, BorderLayout.EAST);
//		panelOptions.setLayout(new GridLayout(0, 2, 0, 0));
//
//		final JLabel lblnameUser = new JLabel("name");
//		panelOptions.add(lblnameUser);
//		if 	(user!=null){
//			lblnameUser.setText(user.getLastName() +" "+ user.getFirstName());
//		}
//		else {
//			lblnameUser.setVisible(false);
//		}
//		final String nameUser = lblnameUser.getText(); 
//		lblnameUser.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println("Clicked sur name = acces profil");
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				lblnameUser.setText("<html><u><font color = #1373cc >"+nameUser +" </u></font></html>");
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				lblnameUser.setText(nameUser);
//			}
//		});
//		lblnameUser.setHorizontalAlignment(SwingConstants.LEFT);
//
//		final JLabel lblConnexion = new JLabel("connexion/deconnexion");
//		lblConnexion.setHorizontalAlignment(SwingConstants.RIGHT);
//		panelOptions.add(lblConnexion);
//		if (user == null){
//			lblConnexion.setText("connexion");
//		}
//		else {
//			lblConnexion.setText("déconnexion");
//		}
//		final String Connexion = lblConnexion.getText();
//		final JLabel lblBoutique = new JLabel("Boutique Access ");
//		panelOptions.add(lblBoutique);
//		final String Boutique = lblBoutique.getText();
//		lblBoutique.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println("Clicked sur acces boutique");
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				lblBoutique.setText("<html><u><font color = #1373cc >"+Boutique +" </u></font></html>");
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				lblBoutique.setText(Boutique);
//			}
//		});
//		lblBoutique.setHorizontalAlignment(SwingConstants.LEFT);
//		
//		JLabel lblIconeMail = new JLabel("icone mail");
//		lblIconeMail.setHorizontalAlignment(SwingConstants.RIGHT);
//		panelOptions.add(lblIconeMail);
//		
//		JPanel panel = new JPanel();
//		contentPane.add(panel, BorderLayout.CENTER);
//		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));
//		
//		JButton btnGestionDesMembres = new JButton("Gestion des Membres");
//		panel.add(btnGestionDesMembres);
//		
//		JButton btnGestionDesIntervenants = new JButton("Gestion des Intervenants");
//		panel.add(btnGestionDesIntervenants);
//		
//		JButton btnGestionDesResponsables = new JButton("Gestion des Responsables d'Activit\u00E9s");
//		panel.add(btnGestionDesResponsables);
//		
//		
//		btnGestionDesResponsables.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//					//gestionRespo.setVisible(true);
//					setVisible(false);
//			}
//		});
//		
//		
//		lblConnexion.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println("Connexion ou deconnexion si la personne n'est pas connecté ou l'est");
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				lblConnexion.setText("<html><u><font color = #1373cc >"+Connexion +" </u></font></html>");
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				lblConnexion.setText(Connexion);
//			}
//		});
//	}
//
//}
