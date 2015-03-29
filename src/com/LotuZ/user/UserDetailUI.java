package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.event.Event;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.admin.ui.HomepageAdmin;
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
	private JLabel lblLastName;
	private JLabel lblDateCotisation;
	private JLabel lblCotisation;
	private JTextField textField;
	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public UserDetailUI(String mail) throws SQLException, UserNotFoundException {
		

		final User user = FacadeUser.getUser(mail);
		final Member member = FacadeUser.getMember(mail);
		final Contributor contributor = FacadeUser.getContributor(mail);
		final ActivityLeader leader = FacadeUser.getActivityLeader(mail);
		
		System.out.println(" user : "+user+" mail :"+mail);
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
		contentPane.add(bandeau.createBandeau(UserLog.getUserLog(), "Détail Utilisateur"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		// Création des labels 
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(233, 30, 73, 14);
		lblLastName.setVerticalAlignment(SwingConstants.TOP);
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblLastName);
		
		JLabel lblDateCotisation = new JLabel("Date Cotisation");
		lblDateCotisation.setBounds(233, 395, 83, 14);
		panel.add(lblDateCotisation);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(233, 70, 83, 20);
		panel.add(lblFirstName);
		
		JLabel lblAdressMail = new JLabel("Adress Mail");
		lblAdressMail.setBounds(233, 110, 73, 14);
		panel.add(lblAdressMail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(233, 190, 73, 14);
		panel.add(lblPhoneNumber);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setBounds(233, 150, 73, 14);
		panel.add(lblStreetName);
		
		JLabel lblHouseNumber = new JLabel("House Number");
		lblHouseNumber.setBounds(233, 230, 73, 14);
		panel.add(lblHouseNumber);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(233, 270, 73, 14);
		panel.add(lblCity);
		
		JLabel lblPostCode = new JLabel("Post Code");
		lblPostCode.setBounds(233, 310, 73, 14);
		panel.add(lblPostCode);
		
		JLabel lblCotisation = new JLabel("Cotisation");
		lblCotisation.setBounds(233, 352, 73, 14);
		panel.add(lblCotisation);
		
		JLabel lblActivity = new JLabel("Activity");
		lblActivity.setBounds(233, 441, 46, 14);
		panel.add(lblActivity);
		
		// Création des textField
		
		AdressMail = new JTextField();
		AdressMail.setBounds(326, 107, 160, 20);
		panel.add(AdressMail);
		AdressMail.setColumns(10);
		
		LastName = new JTextField();
		LastName.setBounds(326, 27, 160, 20);
		panel.add(LastName);
		LastName.setColumns(10);

		FirstName = new JTextField();
		FirstName.setBounds(326, 70, 160, 20);
		panel.add(FirstName);
		FirstName.setColumns(10);		

		StreetName = new JTextField();
		StreetName.setBounds(326, 147, 160, 20);
		panel.add(StreetName);
		StreetName.setColumns(10);

		PhoneNumber = new JTextField();
		PhoneNumber.setBounds(326, 187, 160, 20);
		panel.add(PhoneNumber);
		PhoneNumber.setColumns(10);

		HouseNumber = new JTextField();
		HouseNumber.setBounds(326, 227, 160, 20);
		panel.add(HouseNumber);
		HouseNumber.setColumns(10);

		City = new JTextField();
		City.setBounds(326, 267, 160, 20);
		panel.add(City);
		City.setColumns(10);

		PostCode = new JTextField();
		PostCode.setBounds(326, 307, 160, 20);
		panel.add(PostCode);
		PostCode.setColumns(10);

		Cotisation = new JTextField();
		Cotisation.setBounds(326, 349, 160, 20);
		panel.add(Cotisation);
		Cotisation.setColumns(10);

		DateCotisation = new JTextField();
		DateCotisation.setBounds(326, 392, 160, 20);
		panel.add(DateCotisation);
		DateCotisation.setColumns(10);
		
		NameActivity = new JTextField();
		NameActivity.setBounds(326, 438, 160, 20);
		panel.add(NameActivity);
		NameActivity.setColumns(10);

		if (member == null)
		{
			DateCotisation.setVisible(false);
			Cotisation.setVisible(false);
			lblCotisation.setVisible(false);
			lblDateCotisation.setVisible(false);
		}
		if (leader == null)
		{
			NameActivity.setVisible(false);
			lblActivity.setVisible(false);
		}
		editableTextField(false);

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
					editableTextField(true);
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
					editableTextField(false);

					if (member!=null)
					{
						member.setCotisation(Double.parseDouble(Cotisation.getText()));
						member.setDateCotisation(DateCotisation.getText());
					}
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
		btnEdit.setBounds(537, 150, 89, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteUserUI deleteUser;
				try {
					deleteUser = new DeleteUserUI(user.getMail());
					deleteUser.setVisible(true);
					deleteUser.setLocationRelativeTo(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnDelete.setBounds(537, 226, 89, 23);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomepageAdmin homepage;
				
				try {
					homepage = new HomepageAdmin();
					homepage.setVisible(true);
					homepage.setLocationRelativeTo(null);
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
		btnCancel.setBounds(537, 301, 89, 23);
		panel.add(btnCancel);
		



	}
	
	private void editableTextField(Boolean show) {
		if (show)
		{
			LastName.setEditable(true);
			FirstName.setEditable(true);
			StreetName.setEditable(true);
			AdressMail.setEditable(false);
			PhoneNumber.setEditable(true);
			HouseNumber.setEditable(true);
			City.setEditable(true);
			PostCode.setEditable(true);
			Cotisation.setEditable(true);
			DateCotisation.setEditable(true);
			NameActivity.setEditable(false);
		}
		else
		{
			LastName.setEditable(false);
			FirstName.setEditable(false);
			StreetName.setEditable(false);
			AdressMail.setEditable(false);
			PhoneNumber.setEditable(false);
			HouseNumber.setEditable(false);
			City.setEditable(false);
			PostCode.setEditable(false);
			Cotisation.setEditable(false);
			DateCotisation.setEditable(false);	
			NameActivity.setEditable(false);

		}
	}
}
