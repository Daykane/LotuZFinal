package com.LotuZ.user.activityLeader;

import interfaceDeBase.PageAccueiltest;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;


public class ActivityLeaderUI extends JFrame{

	private JFrame frame;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityLeaderUI frame = new ActivityLeaderUI();
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
	public ActivityLeaderUI() {
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


		JLabel lblTitle = new JLabel("NOM DE TA PAGE");
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
		
		
		String[] ar = {"one", "two", "three"};

		JList list = new JList(ar);
		list.setBounds(51, 53, 366, 343);
		panel.add(list);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(492, 135, 89, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(492, 215, 89, 23);
		panel.add(btnDelete);
		
		

		
		
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
