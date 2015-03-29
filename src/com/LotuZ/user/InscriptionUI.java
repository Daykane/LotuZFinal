package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.admin.ui.HomepageAdmin;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.UserLog;

//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;






import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Dimension;




import com.LotuZ.user.DeleteUserUI;



/**
 * @author Ludo
 *
 */
public class InscriptionUI extends JFrame {
	
	
	/**
	 * Init Attribute 
	 **/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField TFLastName;
	private JTextField TFFirstName;
	private JTextField TFAdress;
	private JTextField TFPhone;
	private JTextField TFStreet;
	private JTextField TFHouse;
	private JTextField TFCity;
	private JTextField TFPostCode;
	private JTextField TFCotisation;
	private JTextField TFDateCotisation;
	
	private JPasswordField TFPassword;
	private JPasswordField TFConfirmPw;	
	private final JLabel jlblStatus = new JLabel("Error dans un champ");
	
	static int count = 0;
	
	public static InscriptionUI frame;

	
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
//		FacadeUser.init();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					User user =UserLog.getUserLog();
//					UserDetailUI frame = new UserDetailUI(user.getMail());
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	public InscriptionUI() throws SQLException, UserNotFoundException  {
		
		setPreferredSize(new Dimension(750, 600));
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		
		Bandeau bandeau = new Bandeau();
		contentPane.add(bandeau.createBandeau(UserLog.getUserLog(), "Détail Utilisateur"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		

		/*
		 * Panel for Label
		 */
		JPanel panelLabel = new JPanel();
		contentPane.add(panelLabel, BorderLayout.WEST);
		GridBagLayout gbl_panelLabel = new GridBagLayout();
		gbl_panelLabel.columnWidths = new int[] {0};
		gbl_panelLabel.rowHeights = new int[]{25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25};
		gbl_panelLabel.columnWeights = new double[]{1.0};
		gbl_panelLabel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelLabel.setLayout(gbl_panelLabel);
		
		/*
		 * List Label
		 */
		JLabel lblLastName = new JLabel("Last Name : ");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.insets = new Insets(0, 5, 5, 0);
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 0;
		panelLabel.add(lblLastName, gbc_lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name : ");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 5, 5, 0);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 1;
		panelLabel.add(lblFirstName, gbc_lblFirstName);
		
		JLabel lblAdressMail = new JLabel("Adress mail : ");
		GridBagConstraints gbc_lblAdressMail = new GridBagConstraints();
		gbc_lblAdressMail.anchor = GridBagConstraints.EAST;
		gbc_lblAdressMail.insets = new Insets(0, 0, 5, 0);
		gbc_lblAdressMail.gridx = 0;
		gbc_lblAdressMail.gridy = 2;
		panelLabel.add(lblAdressMail, gbc_lblAdressMail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number : ");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 0);
		gbc_lblPhoneNumber.gridx = 0;
		gbc_lblPhoneNumber.gridy = 3;
		panelLabel.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		JLabel lblStreetName = new JLabel("Street Name : ");
		GridBagConstraints gbc_lblStreetName = new GridBagConstraints();
		gbc_lblStreetName.anchor = GridBagConstraints.EAST;
		gbc_lblStreetName.insets = new Insets(0, 0, 5, 0);
		gbc_lblStreetName.gridx = 0;
		gbc_lblStreetName.gridy = 4;
		panelLabel.add(lblStreetName, gbc_lblStreetName);
		
		JLabel lblHouseNumber = new JLabel("House Number : ");
		GridBagConstraints gbc_lblHouseNumber = new GridBagConstraints();
		gbc_lblHouseNumber.anchor = GridBagConstraints.EAST;
		gbc_lblHouseNumber.insets = new Insets(0, 0, 5, 0);
		gbc_lblHouseNumber.gridx = 0;
		gbc_lblHouseNumber.gridy = 5;
		panelLabel.add(lblHouseNumber, gbc_lblHouseNumber);
		
		JLabel lblCity = new JLabel("City : ");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 0);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 6;
		panelLabel.add(lblCity, gbc_lblCity);
		
		JLabel lblPostCode = new JLabel("Post code : ");
		GridBagConstraints gbc_lblPostCode = new GridBagConstraints();
		gbc_lblPostCode.anchor = GridBagConstraints.EAST;
		gbc_lblPostCode.insets = new Insets(0, 0, 5, 0);
		gbc_lblPostCode.gridx = 0;
		gbc_lblPostCode.gridy = 7;
		panelLabel.add(lblPostCode, gbc_lblPostCode);
		
		JLabel lblPassword = new JLabel("Password : ");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 8;
		panelLabel.add(lblPassword, gbc_lblPassword);
		
		JLabel lblConfirmPw = new JLabel("Confirm Password : ");
		GridBagConstraints gbc_lblConfirmPw = new GridBagConstraints();
		gbc_lblConfirmPw.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmPw.insets = new Insets(0, 0, 5, 0);
		gbc_lblConfirmPw.gridx = 0;
		gbc_lblConfirmPw.gridy = 9;
		panelLabel.add(lblConfirmPw, gbc_lblConfirmPw);
		
		// Label empty garder la mise en page lors de la rï¿½duction fenetre
		JLabel lblCotisation = new JLabel("Cotisation :");
		GridBagConstraints gbc_lblCotisation = new GridBagConstraints();
		gbc_lblCotisation.anchor = GridBagConstraints.EAST;
		gbc_lblCotisation.insets = new Insets(0, 0, 5, 0);
		gbc_lblCotisation.gridx = 0;
		gbc_lblCotisation.gridy = 10;
		panelLabel.add(lblCotisation, gbc_lblCotisation);
		
		JLabel lblDateCotisation = new JLabel("Date Cotisation :");
		GridBagConstraints gbc_lblDateCotisation = new GridBagConstraints();
		gbc_lblDateCotisation.anchor = GridBagConstraints.EAST;
		gbc_lblDateCotisation.insets = new Insets(0, 0, 5, 0);
		gbc_lblDateCotisation.gridx = 0;
		gbc_lblDateCotisation.gridy = 11;
		panelLabel.add(lblDateCotisation, gbc_lblDateCotisation);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 12;
		panelLabel.add(label_1, gbc_label_1);
		
		/*
		 * Panel for TextField
		 */
		JPanel panelTF = new JPanel();
		panelTF.setPreferredSize(new Dimension(8, 8));
		contentPane.add(panelTF, BorderLayout.CENTER);
		GridBagLayout gbl_panelTF = new GridBagLayout();
		gbl_panelTF.columnWidths = new int[]{0, 0};
		gbl_panelTF.rowHeights = new int[]{25, 25, 0, 0, 0, 0, 0, 0, 25, 25, 0, 0, 0, 0, 0};
		gbl_panelTF.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTF.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTF.setLayout(gbl_panelTF);
		
		/*
		 * List TextFiel
		 */
		TFLastName = new JTextField();
		GridBagConstraints gbc_TFLastName = new GridBagConstraints();
		gbc_TFLastName.insets = new Insets(0, 0, 5, 0);
		gbc_TFLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFLastName.gridx = 0;
		gbc_TFLastName.gridy = 0;
		panelTF.add(TFLastName, gbc_TFLastName);
		TFLastName.setColumns(10);
		
		TFFirstName = new JTextField();
		GridBagConstraints gbc_TFFirstName = new GridBagConstraints();
		gbc_TFFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_TFFirstName.fill = GridBagConstraints.BOTH;
		gbc_TFFirstName.gridx = 0;
		gbc_TFFirstName.gridy = 1;
		panelTF.add(TFFirstName, gbc_TFFirstName);
		TFFirstName.setColumns(10);
		
		TFAdress = new JTextField();
		GridBagConstraints gbc_TFAdress = new GridBagConstraints();
		gbc_TFAdress.insets = new Insets(0, 0, 5, 0);
		gbc_TFAdress.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFAdress.gridx = 0;
		gbc_TFAdress.gridy = 2;
		panelTF.add(TFAdress, gbc_TFAdress);
		TFAdress.setColumns(10);
		
		TFPhone = new JTextField();
		GridBagConstraints gbc_TFPhone = new GridBagConstraints();
		gbc_TFPhone.insets = new Insets(0, 0, 5, 0);
		gbc_TFPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFPhone.gridx = 0;
		gbc_TFPhone.gridy = 3;
		panelTF.add(TFPhone, gbc_TFPhone);
		TFPhone.setColumns(10);
		
		TFStreet = new JTextField();
		GridBagConstraints gbc_TFStreet = new GridBagConstraints();
		gbc_TFStreet.insets = new Insets(0, 0, 5, 0);
		gbc_TFStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFStreet.gridx = 0;
		gbc_TFStreet.gridy = 4;
		panelTF.add(TFStreet, gbc_TFStreet);
		TFStreet.setColumns(10);
		gbc_TFStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFStreet.gridx = 0;
		gbc_TFStreet.gridy = 4;
		gbc_TFStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFStreet.gridx = 0;
		gbc_TFStreet.gridy = 5;
		
		TFHouse = new JTextField();
		GridBagConstraints gbc_TFHouse = new GridBagConstraints();
		gbc_TFHouse.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFHouse.insets = new Insets(0, 0, 5, 0);
		gbc_TFHouse.gridx = 0;
		gbc_TFHouse.gridy = 5;
		panelTF.add(TFHouse, gbc_TFHouse);
		TFHouse.setColumns(10);
		
		TFCity = new JTextField();
		GridBagConstraints gbc_TFCity = new GridBagConstraints();
		gbc_TFCity.insets = new Insets(0, 0, 5, 0);
		gbc_TFCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFCity.gridx = 0;
		gbc_TFCity.gridy = 6;
		panelTF.add(TFCity, gbc_TFCity);
		TFCity.setColumns(10);
		
		TFPostCode = new JTextField();
		GridBagConstraints gbc_TFPostCode = new GridBagConstraints();
		gbc_TFPostCode.insets = new Insets(0, 0, 5, 0);
		gbc_TFPostCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFPostCode.gridx = 0;
		gbc_TFPostCode.gridy = 7;
		panelTF.add(TFPostCode, gbc_TFPostCode);
		TFPostCode.setColumns(10);
		
		TFPassword = new JPasswordField();
		GridBagConstraints gbc_TFPassword = new GridBagConstraints();
		gbc_TFPassword.insets = new Insets(0, 0, 5, 0);
		gbc_TFPassword.fill = GridBagConstraints.BOTH;
		gbc_TFPassword.gridx = 0;
		gbc_TFPassword.gridy = 8;
		panelTF.add(TFPassword, gbc_TFPassword);
		TFPassword.setColumns(10);
		
		TFConfirmPw = new JPasswordField();
		GridBagConstraints gbc_TFConfirmPw = new GridBagConstraints();
		gbc_TFConfirmPw.insets = new Insets(0, 0, 5, 0);
		gbc_TFConfirmPw.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFConfirmPw.gridx = 0;
		gbc_TFConfirmPw.gridy = 9;
		panelTF.add(TFConfirmPw, gbc_TFConfirmPw);
		TFConfirmPw.setColumns(10);
		
		
		/*
		 * CheckBox + Buttons
		 */
		
		TFCotisation = new JTextField();
		GridBagConstraints gbc_txtTfcotisation = new GridBagConstraints();
		gbc_txtTfcotisation.insets = new Insets(0, 0, 5, 0);
		gbc_txtTfcotisation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTfcotisation.gridx = 0;
		gbc_txtTfcotisation.gridy = 10;
		panelTF.add(TFCotisation, gbc_txtTfcotisation);
		TFCotisation.setColumns(10);
		
		TFDateCotisation = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 11;
		panelTF.add(TFDateCotisation, gbc_textField);
		TFDateCotisation.setColumns(10);
		
		final JCheckBox chckbxMember = new JCheckBox("Become Member");
		GridBagConstraints gbc_chckbxMember = new GridBagConstraints();
		gbc_chckbxMember.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxMember.gridx = 0;
		gbc_chckbxMember.gridy = 12;
		panelTF.add(chckbxMember, gbc_chckbxMember);
		
		JCheckBox chckbxBecomeContributor = new JCheckBox("Become Contributor");
		GridBagConstraints gbc_chckbxBecomeContributor = new GridBagConstraints();
		gbc_chckbxBecomeContributor.gridx = 0;
		gbc_chckbxBecomeContributor.gridy = 13;
		panelTF.add(chckbxBecomeContributor, gbc_chckbxBecomeContributor);
		
		JPanel panelButton = new JPanel();
		FlowLayout fl_panelButton = (FlowLayout) panelButton.getLayout();
		fl_panelButton.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelButton, BorderLayout.SOUTH);
		
		
		panelButton.add(jlblStatus, BorderLayout.SOUTH);
        jlblStatus.setForeground(Color.RED);
        jlblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
        

		jlblStatus.setHorizontalAlignment(SwingConstants.RIGHT);		
		panelButton.add(jlblStatus);
		jlblStatus.setVisible(false);
		
		if (chckbxMember.isSelected()==true)
		{
			TFDateCotisation.setVisible(false);
			TFCotisation.setVisible(false);
			lblCotisation.setVisible(false);
			lblDateCotisation.setVisible(false);
		}

		editableTextField(true);


				
				// Bouton Cancel
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
				
				JButton btnRegister = new JButton("Register");
				btnRegister.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(this.verifyTF() & verifyNumeric() & this.verifyPwd()){
							
							try {
								
								
								
								FacadeBL.inscription(TFLastName.getText(),TFFirstName.getText(),TFAdress.getText(),TFPhone.getText(),TFStreet.getText(),TFHouse.getText(),TFCity.getText(),TFPostCode.getText(),TFPassword.getText());
								if (chckbxMember.isSelected()){
									//TODO faire lien vers page payement
									Date today;
									String output;
									SimpleDateFormat formatter;

									formatter = new SimpleDateFormat("yyyy-MM-dd");
									today = new Date();
									output = formatter.format(today);
									Double cotisation = 10.10;
									System.out.println(output);
									//FacadeBL.inscriptionMember(cotisation,TFAdress.getText());
								}
								JOptionPane.showMessageDialog(null,"Inscription rï¿½ussie","Inscription rï¿½ussie",JOptionPane.INFORMATION_MESSAGE);
							} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
								e.printStackTrace();
								//JOptionPane.showMessageDialog(null,"Mail identique","Mail identique",JOptionPane.ERROR_MESSAGE);
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}

					}
				

				
			
		private boolean verifyTF() {
		
			this.tFisemplty(TFLastName);
			this.tFisemplty(TFFirstName);
			this.tFisemplty(TFAdress);
			this.tFisemplty(TFPhone);
			this.tFisemplty(TFStreet);
			this.tFisemplty(TFHouse);
			this.tFisemplty(TFCity);
			this.tFisemplty(TFPostCode);
			this.tFisemplty(TFPassword);
			this.tFisemplty(TFConfirmPw);
		
			if (count>0){
				return false;
			}
			else {
				return true;
			}
			}
	
		private boolean verifyNumeric() {
			return verifyPhone() & verifyPostCode();
		}
	
		private void tFisemplty(JTextField textfield){
			RemoveBorder(textfield);
			String text = textfield.getText();
		
			if(text.equals("")){
				RedBorder(textfield);
				count++;
			}
		}
	
		@SuppressWarnings("deprecation")
		private boolean verifyPwd() {
			if (!TFPassword.getText().equals( TFConfirmPw.getText())){
				RedBorder(TFConfirmPw);
				return false;
			}
			else{
				return true;
			}
		}
	
		private boolean verifyPhone(){
			if (!isNumeric(TFPhone.getText()) || TFPhone.getText().length()!=10 ){
				RedBorder(TFPhone);
				return false;
			};
			return true;
		}
	
		private boolean verifyPostCode(){
			if (!isNumeric(TFPostCode.getText()) ){
				RedBorder(TFPostCode);
				return false;
			};
			return true;
		}
	
	
		private void RedBorder(JTextField textfield){
			jlblStatus.setVisible(true);
			Border border = BorderFactory.createLineBorder(Color.RED, 2);
			textfield.setBorder(border);
		}
	
		private void RemoveBorder(JTextField textfield){
			jlblStatus.setVisible(false);
			Border border = BorderFactory.createLineBorder(Color.white, 2);
			textfield.setBorder(border);
		
		}
	
		private boolean isNumeric(String str)  
		{  
			try  
			{  
				Integer.parseInt(str);  
			}  
			catch(Exception e)  
			{  
				return false;  
			}  
			return true;  
		}
	});
				
				panelButton.add(btnRegister);
				btnCancel.setBounds(537, 301, 89, 23);
				panelButton.add(btnCancel);
	}


	/**
	 * to let to edit the textField
	 * @param show
	 */
	private void editableTextField(Boolean show) {
		if (show)
		{
			TFLastName.setEditable(true);
			TFFirstName.setEditable(true);
			TFStreet.setEditable(true);
			TFAdress.setEditable(false);
			TFPassword.setEditable(false);
			TFConfirmPw.setEditable(false);
			TFPhone.setEditable(true);
			TFHouse.setEditable(true);
			TFCity.setEditable(true);
			TFPostCode.setEditable(true);
			TFCotisation.setEditable(true);
			TFDateCotisation.setEditable(true);
		}
		else
		{
			TFLastName.setEditable(false);
			TFFirstName.setEditable(false);
			TFStreet.setEditable(false);
			TFAdress.setEditable(false);
			TFPhone.setEditable(false);
			TFPassword.setEditable(false);
			TFConfirmPw.setEditable(false);
			TFHouse.setEditable(false);
			TFCity.setEditable(false);
			TFPostCode.setEditable(false);
			TFCotisation.setEditable(false);
			TFDateCotisation.setEditable(false);	
			
		}
	}
}
