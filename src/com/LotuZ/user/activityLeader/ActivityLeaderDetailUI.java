package com.LotuZ.user.activityLeader;

import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class ActivityLeaderDetailUI extends JFrame{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityLeaderDetailUI frame = new ActivityLeaderDetailUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ActivityLeaderDetailUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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


		JLabel lblTitle = new JLabel("Responsable d'Activité");
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
		final JLabel lblBoutique = new JLabel("Boutique Access ");
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setBounds(233, 60, 73, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(326, 57, 160, 20);
		panel.add(textField);
		textField.setColumns(10);
		//textField.setText("Richard");
		
		textField_1 = new JTextField();
		textField_1.setBounds(326, 100, 160, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(233, 100, 83, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adress Mail");
		lblNewLabel_2.setBounds(233, 140, 73, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(326, 137, 160, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(233, 220, 73, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Street Name");
		lblNewLabel_4.setBounds(233, 180, 73, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("House Number");
		lblNewLabel_5.setBounds(233, 260, 73, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setBounds(233, 300, 73, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Post Code");
		lblNewLabel_7.setBounds(233, 340, 73, 14);
		panel.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(326, 177, 160, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(326, 217, 160, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(326, 257, 160, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(326, 297, 160, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(326, 337, 160, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(190, 428, 89, 23);
		panel.add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(427, 428, 89, 23);
		panel.add(btnCancel);
		lblConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
