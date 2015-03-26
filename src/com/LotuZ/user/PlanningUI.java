package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.user.bl.User;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.FlowLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Component;

public class PlanningUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		FacadeEvent.init(jdbcKit);

		FacadeBL.init(jdbcKit);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningUI frame = new PlanningUI();
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
	public PlanningUI() throws SQLException, UserNotFoundException {
		FacadeUser.login("jack","jack");
		User user = UserLog.getUserLog();
		Bandeau bandeau = new Bandeau();
		List<Event> events =  FacadeEvent.getEventsActivity(15);
		//System.out.println("Mail page acceuil test : " + user.getMail());

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(bandeau.createBandeau(user, "Ma page"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		contentPane.add(panel, BorderLayout.CENTER);
        
        table = new JTable();
        table.setSize(new Dimension(80, 80));
        table.setPreferredSize(new Dimension(600, 300));
        table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setBounds(200, 600, 800, 300);
        table.getTableHeader().setVisible(true);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"New column", "New column", "New column", "New column", "New column", "New column", "New column"
        	}
        ));
 
        
        panel.add(table, BorderLayout.CENTER);
        table.getTableHeader().setBounds(800, 600, 1000, 300);
        table.getTableHeader().setVisible(true);


	}
	
	


}
