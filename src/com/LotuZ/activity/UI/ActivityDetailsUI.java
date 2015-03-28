package com.LotuZ.activity.UI;
import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.activity.Activity;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;


public class ActivityDetailsUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfRespo;
	private JTextField tfShortDescr;
	static String editText = "Edit";

	/**
	 * Launch the application.
	 */
/*
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
		//FacadeUser.init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityDetailsUI frame = new ActivityDetailsUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public ActivityDetailsUI(int idAct) throws SQLException, UserNotFoundException {
		
		// Déclaration du monde
		//FacadeUser.login("jack","jack");
		final Activity activity = FacadeActivity.getActivity(idAct);
		User user = UserLog.getUserLog();
		//
		
		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelBandeau = new JPanel();
		panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(new Bandeau().createBandeau(user,"Details Activity"), BorderLayout.NORTH);
		panelBandeau.setLayout(new BorderLayout(0, 0));


		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblName = new JLabel("Name : ");
		panel.add(lblName, "4, 2, right, default");
		
		tfName = new JTextField(activity.getName());
		tfName.setEditable(false);
		panel.add(tfName, "6, 2, fill, default");
		tfName.setColumns(10);
		
		JLabel lblCreated = new JLabel("Created : ");
		panel.add(lblCreated, "10, 2");
		
		JLabel lblDateCreated = new JLabel(activity.getCreateDate());
		panel.add(lblDateCreated, "12, 2");
		
		JLabel lblRespo = new JLabel("Responsible : ");
		panel.add(lblRespo, "4, 6, right, default");
		
		//TODO get le name et pas l'id du respo
		tfRespo = new JTextField(activity.getIdRespo());
		tfRespo.setEditable(false);
		panel.add(tfRespo, "6, 6, fill, top");
		tfRespo.setColumns(10);
		
		JLabel lblUpdated = new JLabel("Updated : ");
		panel.add(lblUpdated, "10, 6");
		
		JLabel lblDateUpdated = new JLabel(activity.getMajDate());
		panel.add(lblDateUpdated, "12, 6");
		
		JLabel lblShortDescr = new JLabel("Short description : ");
		panel.add(lblShortDescr, "4, 10, right, default");
		
		tfShortDescr = new JTextField(activity.getShortDescr());
		tfShortDescr.setEditable(false);
		panel.add(tfShortDescr, "6, 10, fill, default");
		tfShortDescr.setColumns(10);
		
		JLabel lblLongDescr = new JLabel("Long description : ");
		panel.add(lblLongDescr, "4, 14, right, default");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "6, 14, fill, fill");
		
		final JTextArea tfLongDescr = new JTextArea(activity.getLongDescr());
		tfLongDescr.setEditable(false);
		scrollPane.setViewportView(tfLongDescr);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelButton = new JPanel();
		panel_1.add(panelButton, BorderLayout.SOUTH);
		
		final JButton btnEdit = new JButton(editText);
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnEdit.getText().equals("Edit")){
					btnEdit.setText("Validate");
					tfName.setEditable(true);
					tfShortDescr.setEditable(true);
					tfLongDescr.setEditable(true);
				}
				else if(btnEdit.getText().equals("Validate")){
					btnEdit.setText("Edit");
					try {
						FacadeBL.updateActivity(activity, tfName.getText(), tfShortDescr.getText(), tfLongDescr.getText(), tfRespo.getText());
						tfName.setEditable(false);
						tfShortDescr.setEditable(false);
						tfLongDescr.setEditable(false);
						// TODO alert boite
						System.out.println("Activity updaté");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		panelButton.add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnEdit.getText().equals("Validate")){
					tfName.setText(activity.getName());
					tfShortDescr.setText(activity.getShortDescr());
					tfLongDescr.setText(activity.getLongDescr());
					tfName.setEditable(false);
					tfShortDescr.setEditable(false);
					tfLongDescr.setEditable(false);
					btnEdit.setText("Edit");
				}
				else{
					//TODO
					System.out.println("Retour vers la page précédente");
				}
			}
		});
		panelButton.add(btnCancel);
		
	}

}
