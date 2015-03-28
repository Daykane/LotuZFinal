package com.LotuZ.activity.UI;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.activity.Activity;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ActivityCreateUI2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfShortDesc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";
		
		// Choose the kit
		JdbcKit jdbcKit = new JdbcKit(url,login,passwd);
		jdbcKit.openConnection(url, login, passwd);
		
		// Init the FacadeBL with the kit
		FacadeBL.init(jdbcKit);
		FacadeActivity.init(jdbcKit);
		//jdbcKit.createUserLog("toto le respo","toto","mail","0626290616","ici","2bis","montp","123456","1",0,1);
		
	}
	/**
	 * Create the frame.
	 */
	public ActivityCreateUI2() {
		User user = UserLog.getUserLog();
	
		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(new Bandeau().createBandeau(user, "Ma page"), BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_top = new JPanel();
		panel_1.add(panel_top, BorderLayout.NORTH);
		
		JLabel lblCreateActivity = new JLabel("Create Activity");
		panel_top.add(lblCreateActivity);
		
		JPanel panel_Center = new JPanel();
		panel_1.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.PREF_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(150dlu;min):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				RowSpec.decode("max(3dlu;default)"),
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("Name : ");
		panel_Center.add(lblNewLabel, "1, 2, right, default");
		
		tfName = new JTextField();
		panel_Center.add(tfName, "3, 2, fill, default");
		tfName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Short description : ");
		panel_Center.add(lblNewLabel_1, "1, 4, right, default");
		
		tfShortDesc = new JTextField();
		panel_Center.add(tfShortDesc, "3, 4, fill, default");
		tfShortDesc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Long description : ");
		panel_Center.add(lblNewLabel_2, "1, 7, right, default");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Center.add(scrollPane, "3, 7, fill, fill");
		
		final JTextArea tfLongDesc = new JTextArea();
		tfLongDesc.setTabSize(7);
		scrollPane.setViewportView(tfLongDesc);
		
		JPanel panel_Bottom = new JPanel();
		panel_1.add(panel_Bottom, BorderLayout.SOUTH);
		panel_Bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					//FacadeBL.createActivity(tfName.getText(), tfShortDesc.getText(), tfLongDesc.getText());
					Activity act = FacadeActivity.getActivity(14);
					FacadeActivity.deleteActivity(act);
					

					//act = FacadeActivity.getActivity(14);
					//System.out.println(act.getName());
					
				} catch (com.mysql.jdbc.MysqlDataTruncation e){
					//TODO
					System.out.println("Boite alert, text trop long");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Bottom.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Retour à la page Acceuil respo");
			}
		});
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Bottom.add(btnCancel);
	}
}
