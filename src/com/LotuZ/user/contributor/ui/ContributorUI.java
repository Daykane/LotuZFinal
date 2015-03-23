package com.LotuZ.user.contributor.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.inscription.InscriptionUserUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.contributor.bl.ListContributor;
import com.LotuZ.user.user.bl.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.Color;


public class ContributorUI extends JFrame{

	private static final long serialVersionUID = 1L;
	public static ContributorUI frame;
	private JPanel contentPane;
	private JList list;



	/**
	 * Create the application.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public ContributorUI() throws SQLException, UserNotFoundException {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException, UserNotFoundException {
		
		// Demande de l'identité de l'utilisateur logué 
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
		panel.setToolTipText("");
		panel.setForeground(new Color(153, 204, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 60));	
		

		List<String> tabOfLeader = getList();
		list = new JList(tabOfLeader.toArray());
		panel.add(list);
		list.setPreferredSize(new Dimension(500, 300));

		
		list.getSelectedValue();

		JButton btnEdit = new JButton("Edit");
		panel.add(btnEdit);
		
		btnEdit.addMouseListener(new MouseAdapter()  {
			public void mouseClicked(MouseEvent arg0){
				try {
				int index = list.getSelectedIndex();
				System.out.println("Index Selected: " + index);
				String s = (String) list.getSelectedValue();
				System.out.println("Value Selected: " + s);
				String idContributor = s;
				ContributorDetailUI detailContributorUI = null;
				detailContributorUI = new ContributorDetailUI(idContributor);
				ContributorDetailUI.frame = detailContributorUI;
				ContributorDetailUI.frame.setAlwaysOnTop(true);
				detailContributorUI.setVisible(true);
				frame.dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		
		
		JButton btnDelete = new JButton("Delete");
		panel.add(btnDelete);
		
		btnDelete.addMouseListener(new MouseAdapter()  {
			public void mouseClicked(MouseEvent arg0){
				try {
				int index = list.getSelectedIndex();
				System.out.println("Index Selected: " + index);
				String s = (String) list.getSelectedValue();
				System.out.println("Value Selected: " + s);
				String idContributor = s;
				ContributorDetailUI detailContributorUI = null;
				detailContributorUI = new ContributorDetailUI(idContributor);
				ContributorDetailUI.frame = detailContributorUI;
				ContributorDetailUI.frame.setAlwaysOnTop(true);
				detailContributorUI.setVisible(true);
				frame.dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		
			
		
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
	
	private List<String> getList() throws SQLException, UserNotFoundException {
		
		ListContributor listContributor = FacadeBL.getContributors();
		List<User> listUser = listContributor.getListContributor();
		List<String> tabOfLeader = new ArrayList<String>();
		
	    for(int i = 0; i < listUser.size(); i++)
	    {
	    	User user = listUser.get(0);
	    	String nomPrenom = listUser.get(i).getFirstName()+" - "+listUser.get(i).getLastName();
	    	tabOfLeader.add(i,nomPrenom);
	    }

	return tabOfLeader;
	}
}
