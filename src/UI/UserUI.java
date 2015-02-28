package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserUI extends JFrame {

	/**
	 * Init Attribute tot
	 */
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
	private JTextField TFPassword;
	private JTextField TFConfirmPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI frame = new UserUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTitle = new JPanel();
		FlowLayout fl_panelTitle = (FlowLayout) panelTitle.getLayout();
		fl_panelTitle.setVgap(12);
		fl_panelTitle.setHgap(15);
		contentPane.add(panelTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Inscription");
		panelTitle.add(lblTitle);
		
		/*
		 * Panel for Label
		 */
		JPanel panelLabel = new JPanel();
		contentPane.add(panelLabel, BorderLayout.WEST);
		GridBagLayout gbl_panelLabel = new GridBagLayout();
		gbl_panelLabel.columnWidths = new int[] {0};
		gbl_panelLabel.rowHeights = new int[]{25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 0};
		gbl_panelLabel.columnWeights = new double[]{1.0};
		gbl_panelLabel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		// Label empty garder la mise en page lors de la réduction fenetre
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 0;
		gbc_label.gridy = 10;
		panelLabel.add(label, gbc_label);
		
		/*
		 * Panel for TextField
		 */
		JPanel panelTF = new JPanel();
		contentPane.add(panelTF, BorderLayout.CENTER);
		GridBagLayout gbl_panelTF = new GridBagLayout();
		gbl_panelTF.columnWidths = new int[]{0, 0};
		gbl_panelTF.rowHeights = new int[]{25, 25, 0, 0, 0, 0, 0, 0, 25, 25, 0, 0};
		gbl_panelTF.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTF.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		TFPassword = new JTextField();
		GridBagConstraints gbc_TFPassword = new GridBagConstraints();
		gbc_TFPassword.insets = new Insets(0, 0, 5, 0);
		gbc_TFPassword.fill = GridBagConstraints.BOTH;
		gbc_TFPassword.gridx = 0;
		gbc_TFPassword.gridy = 8;
		panelTF.add(TFPassword, gbc_TFPassword);
		TFPassword.setColumns(10);
		
		TFConfirmPw = new JTextField();
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
		final JCheckBox chckbxMember = new JCheckBox("Become Member");
		GridBagConstraints gbc_chckbxMember = new GridBagConstraints();
		gbc_chckbxMember.anchor = GridBagConstraints.WEST;
		gbc_chckbxMember.gridx = 0;
		gbc_chckbxMember.gridy = 10;
		panelTF.add(chckbxMember, gbc_chckbxMember);
		
		JPanel panelButton = new JPanel();
		FlowLayout fl_panelButton = (FlowLayout) panelButton.getLayout();
		fl_panelButton.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelButton, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton("OK");
		btnOK.setHorizontalAlignment(SwingConstants.RIGHT);		
		panelButton.add(btnOK);		
		
		JButton btnCancel = new JButton("Cancel");		
		panelButton.add(btnCancel);
		
		/*
		 * Action button
		 */
		
		btnCancel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		btnOK.addMouseListener(new MouseAdapter() {		
			public void mouseClicked(MouseEvent arg0) {
				if ( chckbxMember.isSelected())
				{System.out.println("Check");}
				else { System.out.println("pas Check");}
			}
		});
	}
}
