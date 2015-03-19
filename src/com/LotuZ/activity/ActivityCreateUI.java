package com.LotuZ.activity;


import java.awt.EventQueue;


import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.user.UserJDBC;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ActivityCreateUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//FacadeBL facadeBL = new FacadeBL();

	private JPanel contentPane;


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
				FacadeBL.init(jdbcKit);
				jdbcKit.createUserLog("toto le respo","toto","mail","0626290616","ici","2bis","montp","123456","1",0,1);
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityCreateUI frame = new ActivityCreateUI();
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
	public ActivityCreateUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateActivity = new JLabel("Create Activity");
		lblCreateActivity.setBounds(137, 11, 143, 14);
		contentPane.add(lblCreateActivity);
		
		JButton btnTestCreate = new JButton("test load");
		btnTestCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Activity acti = null;
				try {
					//acti = FacadeBL.readActivity("test Acti");
					acti = FacadeBL.readActivity(3);
					
					
					FacadeBL.updateActivity(acti,"new name","new short desc","new loooong descr","new mail respo");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(acti.getName());
			}
		});
		btnTestCreate.setBounds(99, 171, 132, 23);
		contentPane.add(btnTestCreate);
	}
}
