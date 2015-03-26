package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.member.data.MemberJDBC;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;
import com.LotuZ.user.UserLog;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class UserDetailUI extends JFrame {

	private JPanel contentPane;

	private JTextField LastName;
	private JTextField FirstName;
	private JTextField AdressMail;
	private JTextField StreetName;
	private JTextField PhoneNumber;
	private JTextField HouseNumber;
	private JTextField City;
	private JTextField PostCode;
	private JTextField Cotisation;
	private JTextField DateCotisation;
	private JTextField NameActivity;

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
		FacadeUser.init(jdbcKit);
		FacadeBL.init(jdbcKit);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user = new UserJDBC();
					UserDetailUI frame = new UserDetailUI(user);
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
	public UserDetailUI(final User user2) throws SQLException, UserNotFoundException {
		
		FacadeUser.login("jack","jack");
		// Initialisation et Recherche du User connecté 
		final User user = UserLog.getUserLog();
		final Member member = UserLog.getMemberLog();
		Administrator admin = UserLog.getAdminLog();
		ActivityLeader activityLeader = UserLog.getRespoLog();
		Contributor contributor = UserLog.getContribLog();
		
	
		// Initialisation du bandeau et création de la Frame
		contentPane = new JPanel();
		Bandeau bandeau = new Bandeau();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Zen Lounge");
		setBounds(300,800, 750, 600);

		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(bandeau.createBandeau(user, "Détail Utilisateur"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		// Création des labels 
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setBounds(233, 30, 73, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		JLabel lblDateCotisation = new JLabel("Date Cotisation");
		lblDateCotisation.setBounds(233, 395, 83, 14);
		panel.add(lblDateCotisation);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(233, 70, 83, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adress Mail");
		lblNewLabel_2.setBounds(233, 110, 73, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(233, 190, 73, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Street Name");
		lblNewLabel_4.setBounds(233, 150, 73, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("House Number");
		lblNewLabel_5.setBounds(233, 230, 73, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setBounds(233, 270, 73, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Post Code");
		lblNewLabel_7.setBounds(233, 310, 73, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblCotisation = new JLabel("Cotisation");
		lblCotisation.setBounds(233, 352, 73, 14);
		panel.add(lblCotisation);
		
		// Création des textField
		
		AdressMail = new JTextField();
		AdressMail.setBounds(326, 107, 160, 20);
		panel.add(AdressMail);
		AdressMail.setColumns(10);
		AdressMail.setEditable(false);
		
		LastName = new JTextField();
		LastName.setBounds(326, 27, 160, 20);
		panel.add(LastName);
		LastName.setColumns(10);
		LastName.setEditable(false);

		FirstName = new JTextField();
		FirstName.setBounds(326, 70, 160, 20);
		panel.add(FirstName);
		FirstName.setColumns(10);		
		FirstName.setEditable(false);

		StreetName = new JTextField();
		StreetName.setBounds(326, 147, 160, 20);
		panel.add(StreetName);
		StreetName.setColumns(10);
		StreetName.setEditable(false);

		PhoneNumber = new JTextField();
		PhoneNumber.setBounds(326, 187, 160, 20);
		panel.add(PhoneNumber);
		PhoneNumber.setColumns(10);
		PhoneNumber.setEditable(false);

		HouseNumber = new JTextField();
		HouseNumber.setBounds(326, 227, 160, 20);
		panel.add(HouseNumber);
		HouseNumber.setColumns(10);
		HouseNumber.setEditable(false);

		City = new JTextField();
		City.setBounds(326, 267, 160, 20);
		panel.add(City);
		City.setColumns(10);
		City.setEditable(false);

		PostCode = new JTextField();
		PostCode.setBounds(326, 307, 160, 20);
		panel.add(PostCode);
		PostCode.setColumns(10);
		PostCode.setEditable(false);

		Cotisation = new JTextField();
		Cotisation.setBounds(326, 349, 160, 20);
		panel.add(Cotisation);
		Cotisation.setColumns(10);
		Cotisation.setEditable(false);

		DateCotisation = new JTextField();
		DateCotisation.setBounds(326, 392, 160, 20);
		panel.add(DateCotisation);
		DateCotisation.setColumns(10);
		DateCotisation.setEditable(false);

		FirstName.setText(user.getFirstName());
		LastName.setText(user.getLastName());
		AdressMail.setText(user.getMail());
		StreetName.setText(user.getStreetName());
		PhoneNumber.setText(user.getPhone());
		HouseNumber.setText(user.getPhone());
		City.setText(user.getCity());
		PostCode.setText(user.getPostCode());
		if (member != null){
			Cotisation.setText((member.getCotisation()).toString());
			DateCotisation.setText(member.getDateCotisation());
		}
		// Gestion des événements Bouton 

		final JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnEdit.getText().equals("Edit")){
					btnEdit.setText("Validate");
					LastName.setEditable(true);
					FirstName.setEditable(true);
					StreetName.setEditable(true);
					PhoneNumber.setEditable(true);
					HouseNumber.setEditable(true);
					City.setEditable(true);
					PostCode.setEditable(true);
					Cotisation.setEditable(true);
					DateCotisation.setEditable(true);
				}
				else if(btnEdit.getText().equals("Validate")){
					btnEdit.setText("Edit");
					user.setLastName(LastName.getText());
					user.setFirstName(FirstName.getText());
					user.setMail(AdressMail.getText());
					user.setStreetName(StreetName.getText());
					user.setPhone(PhoneNumber.getText());
					user.setNumHouse(HouseNumber.getText());
					user.setCity(City.getText());
					user.setPostCode(PostCode.getText());
					member.setCotisation(Double.parseDouble(Cotisation.getText()));
					member.setDateCotisation(DateCotisation.getText());

					try {
						FacadeUser.updateUser(user);
						FacadeUser.updateMember(member);

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UserNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}});
		btnEdit.setBounds(338, 434, 89, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try {
						if (member != null){
							FacadeUser.deleteMember(member);
						}
						System.out.println(" le user : "+user);
						FacadeUser.deleteUser(user);
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UserNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnDelete.setBounds(162, 434, 89, 23);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCancel.setBounds(509, 434, 89, 23);
		panel.add(btnCancel);


	}
}
