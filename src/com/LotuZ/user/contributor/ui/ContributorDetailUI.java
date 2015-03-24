//package com.LotuZ.user.contributor.ui;
//
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.SQLException;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.SwingConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.TitledBorder;
//
//import com.LotuZ.FacadeBL;
//import com.LotuZ.inscription.InscriptionUserUI;
//import com.LotuZ.login.UserNotFoundException;
//import com.LotuZ.user.UserLog;
//import com.LotuZ.user.contributor.bl.Contributor;
//import com.LotuZ.user.user.bl.User;
//
//import javax.swing.JTextField;
//import javax.swing.JButton;
//
//public class ContributorDetailUI extends JFrame{
//
//	private FacadeBL facadeBL;
//	
//	public static ContributorDetailUI frame;
//	
//	
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTextField LastName;
//	private JTextField FirstName;
//	private JTextField AdressMail;
//	private JTextField StreetName;
//	private JTextField PhoneNumber;
//	private JTextField HouseNumber;
//	private JTextField City;
//	private JTextField PostCode;
//
//
//	/**
//	 * Create the application.
//	 * @throws UserNotFoundException 
//	 * @throws SQLException 
//	 */
//	public ContributorDetailUI(String idContributor) throws SQLException, UserNotFoundException {
//		initialize(idContributor);
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 * @throws UserNotFoundException 
//	 * @throws SQLException 
//	 */
//	private void initialize(String idContributor) throws SQLException, UserNotFoundException {
//		
//		final Contributor contributor = FacadeBL.getContributor(idContributor);
//		
//		
//		User user = UserLog.getUserLog();
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
//		JLabel lblTitle = new JLabel("Responsable d'Activité");
//		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		panelBandeau.add(lblTitle, BorderLayout.CENTER);
//
//		JLabel lblToto = new JLabel("LOGO");
//		lblToto.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblToto.setHorizontalAlignment(SwingConstants.LEFT);
//		
//
//		JLabel image = new JLabel(new ImageIcon("zen.jpg"));
//		panelBandeau.add(image,BorderLayout.WEST);
//
//		JPanel panelOptions = new JPanel();
//		panelBandeau.add(panelOptions, BorderLayout.EAST);
//		panelOptions.setLayout(new GridLayout(3, 1, 0, 0));
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
//		lblConnexion.setHorizontalAlignment(SwingConstants.LEFT);
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
//		JPanel panel = new JPanel();
//		contentPane.add(panel, BorderLayout.CENTER);
//		panel.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Last Name");
//		lblNewLabel.setBounds(233, 60, 73, 14);
//		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
//		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
//		panel.add(lblNewLabel);
//		
//		LastName = new JTextField();
//		LastName.setBounds(326, 57, 160, 20);
//		panel.add(LastName);
//		LastName.setColumns(10);
//		LastName.setText(contributor.getLastName());
//		
//		FirstName = new JTextField();
//		FirstName.setBounds(326, 100, 160, 20);
//		panel.add(FirstName);
//		FirstName.setColumns(10);
//		FirstName.setText(contributor.getFirstName());
//		
//		JLabel lblNewLabel_1 = new JLabel("First Name");
//		lblNewLabel_1.setBounds(233, 100, 83, 20);
//		panel.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("Adress Mail");
//		lblNewLabel_2.setBounds(233, 140, 73, 14);
//		panel.add(lblNewLabel_2);
//		
//		AdressMail = new JTextField();
//		AdressMail.setBounds(326, 137, 160, 20);
//		panel.add(AdressMail);
//		AdressMail.setColumns(10);
//		AdressMail.setText(contributor.getMail());
//		
//		JLabel lblNewLabel_3 = new JLabel("Phone Number");
//		lblNewLabel_3.setBounds(233, 220, 73, 14);
//		panel.add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_4 = new JLabel("Street Name");
//		lblNewLabel_4.setBounds(233, 180, 73, 14);
//		panel.add(lblNewLabel_4);
//		
//		JLabel lblNewLabel_5 = new JLabel("House Number");
//		lblNewLabel_5.setBounds(233, 260, 73, 14);
//		panel.add(lblNewLabel_5);
//		
//		JLabel lblNewLabel_6 = new JLabel("City");
//		lblNewLabel_6.setBounds(233, 300, 73, 14);
//		panel.add(lblNewLabel_6);
//		
//		JLabel lblNewLabel_7 = new JLabel("Post Code");
//		lblNewLabel_7.setBounds(233, 340, 73, 14);
//		panel.add(lblNewLabel_7);
//		
//		StreetName = new JTextField();
//		StreetName.setBounds(326, 177, 160, 20);
//		panel.add(StreetName);
//		StreetName.setColumns(10);
//		StreetName.setText(contributor.getStreetName());
//		
//		PhoneNumber = new JTextField();
//		PhoneNumber.setBounds(326, 217, 160, 20);
//		panel.add(PhoneNumber);
//		PhoneNumber.setColumns(10);
//		PhoneNumber.setText(contributor.getPhone());
//		
//		HouseNumber = new JTextField();
//		HouseNumber.setBounds(326, 257, 160, 20);
//		panel.add(HouseNumber);
//		HouseNumber.setColumns(10);
//		HouseNumber.setText(contributor.getNumHouse());
//		
//		System.out.println("mail : "+contributor.getMail());
//		City = new JTextField();
//		City.setBounds(326, 297, 160, 20);
//		panel.add(City);
//		City.setColumns(10);
//		City.setText(contributor.getCity());
//		
//		PostCode = new JTextField();
//		PostCode.setBounds(326, 337, 160, 20);
//		panel.add(PostCode);
//		PostCode.setColumns(10);
//		PostCode.setText(contributor.getPostCode());
//		
//		JButton btnEdit = new JButton("Edit");
//		btnEdit.setBounds(190, 428, 89, 23);
//		btnEdit.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent arg0) {
//				try {
//					contributor.setLastName(LastName.getText());
//					contributor.setFirstName(FirstName.getText());
//					contributor.setMail(AdressMail.getText());
//					contributor.setStreetName(StreetName.getText());
//					contributor.setPhone(PhoneNumber.getText());
//					contributor.setNumHouse(HouseNumber.getText());
//					contributor.setCity(City.getText());
//					contributor.setPostCode(PostCode.getText());
//					FacadeBL.updateContributor(contributor);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				JOptionPane.showMessageDialog(null,"Edition effectuée","Edition effectuée",JOptionPane.INFORMATION_MESSAGE);
//			}
//		});
//		panel.add(btnEdit);
//		
//		JButton btnCancel = new JButton("Cancel");
//		btnCancel.setBounds(427, 428, 89, 23);
//		panel.add(btnCancel);
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
//}
