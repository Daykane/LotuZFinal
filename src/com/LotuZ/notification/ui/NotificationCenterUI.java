package com.LotuZ.notification.ui;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.LoginUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.notification.bl.Notification;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;


public class NotificationCenterUI extends JFrame
{

	private FacadeBL facadeBL;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) 
//	{
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
//		//FacadeUser.init();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NotificationCenterUI frame = new NotificationCenterUI(null);
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
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	
	public NotificationCenterUI(User userMember) throws SQLException, UserNotFoundException 
	{
		FacadeUser.login("jack","jack");
		final User user = UserLog.getUserLog();

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		//North
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelBandeau = new JPanel();
		panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(panelBandeau, BorderLayout.NORTH);
		panelBandeau.setLayout(new BorderLayout(0, 0));


		JLabel lblTitle = new JLabel("Notification Center");
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
			lblConnexion.setText("d�connexion");
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
		lblConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(UserLog.getUserLog() == null){
					LoginUI loginUI =  new LoginUI();	
					LoginUI.frame = loginUI;
					loginUI.setVisible(true);
				}
				else{
					System.out.println("Faire une d�connexion");
				}
				//System.out.println("Connexion ou deconnexion si la personne n'est pas connect� ou l'est");
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
		
			//Center
		JPanel notifCenterPan = new JPanel();
		notifCenterPan.setLayout(new GridBagLayout());
	
		//JListe Category
		System.out.println("Coucou");
		System.out.println(user.getIdMember());
		final ArrayList<BoxLetter> boxLetter = (ArrayList<BoxLetter>) FacadeBL.getAllNotificationInBox(user.getIdMember());
		final ArrayList<Notification> notifications = new ArrayList<Notification>();
		for (int i=0;i<boxLetter.size();i++)
		{
			System.out.println("Coucouoooo");
			notifications.add(FacadeBL.getNotification(boxLetter.get(i).getIdNotification()));
			System.out.println("Coucouaaa");
		}	
		final JList jListNotifications = new JList(notifications.toArray());
		jListNotifications.setCellRenderer(new DefaultListCellRenderer() 
		{ 
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
		{ 
			Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
			if (renderer instanceof JLabel && value instanceof Notification) 
			{ 
				//While à ameliorer
				int i =0;
				int f =0;
				while (i<boxLetter.size() & f==0 )
				{
					if (boxLetter.get(i).getIdNotification() == ((Notification) value).getIdNotification())
					{
						f=1;
						i--; //-1 pour obtenir l'index
					}
					i++;
				}
				//Fin While
				// Here value will be of the Type 'CD' 
				((JLabel) renderer).setText(((Notification) value).getObjetNotification()+" at "+boxLetter.get(i).getDateReceived());

				((Notification) value).getObjetNotification();
				if (boxLetter.get(i).getReadNotification()==0)
				{
					setIcon(new ImageIcon("notif.png"));
				}
				else
				{
					setIcon(new ImageIcon("notifOpen.png"));
				}
			}	 
			return renderer; 
		} 
		}
		);	
		GridBagConstraints gbc_jListNotifications= new GridBagConstraints();
		gbc_jListNotifications.gridx = 0;
		gbc_jListNotifications.gridy = 1;		
		jListNotifications.setVisible(true);
		notifCenterPan.add(jListNotifications, gbc_jListNotifications);
			
			//Button View
		System.out.println("le pingpu");
		JButton btnViewNotif = new JButton("View");
		GridBagConstraints gbc_btnViewNotif= new GridBagConstraints();
		gbc_btnViewNotif.gridx = 1;
		gbc_btnViewNotif.gridy = 2;		
		btnViewNotif.setVisible(true);
		notifCenterPan.add(btnViewNotif, gbc_btnViewNotif);
		
			//Button Remove
		System.out.println("la pingpu");
		final JButton btnRemoveNotif = new JButton("Remove");
		GridBagConstraints gbc_btnRemoveNotif= new GridBagConstraints();
		gbc_btnRemoveNotif.gridx = 1;
		gbc_btnRemoveNotif.gridy = 3;		
		btnRemoveNotif.setVisible(true);
		notifCenterPan.add(btnRemoveNotif, gbc_btnRemoveNotif);
		
		//Listeners
	
		
			//btnViewCatListeners
		
	ActionListener btnViewNotifListeners = new ActionListener() 
	{
		
		public void actionPerformed(ActionEvent e)
		{
			if (jListNotifications.getSelectedValue()!=null)
			{
				ViewNotificationUI viewNotificationUI = null;
				try {
					viewNotificationUI = new ViewNotificationUI(notifications.get(jListNotifications.getSelectedIndex()),boxLetter.get(jListNotifications.getSelectedIndex()).getDateReceived(),user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("idBox:"+boxLetter.get(jListNotifications.getSelectedIndex()).getIdBoxLetter()+"  id notif:"+boxLetter.get(jListNotifications.getSelectedIndex()).getIdNotification()+"  idMember:"+boxLetter.get(jListNotifications.getSelectedIndex()).getIdMember());
				FacadeBL.updateBoxLetter(boxLetter.get(jListNotifications.getSelectedIndex()).getIdBoxLetter(), boxLetter.get(jListNotifications.getSelectedIndex()).getIdNotification(), boxLetter.get(jListNotifications.getSelectedIndex()).getIdMember(), 1);
				viewNotificationUI.setLocationRelativeTo(null);
				viewNotificationUI.setVisible(true);
				dispose();
			}
			
			
		}
	};
	btnViewNotif.addActionListener(btnViewNotifListeners);
	
		//btnRemoveCatListeners
		
	ActionListener btnRemoveNotifListeners = new ActionListener() 
	{
	
		public void actionPerformed(ActionEvent e) 
		{
			if (!jListNotifications.getSelectedValue().equals(null))
			{				
				facadeBL.deleteNotificationInBox(notifications.get(jListNotifications.getSelectedIndex()).getIdNotification(),user.getIdMember());
				boxLetter.remove(jListNotifications.getSelectedIndex());
				notifications.remove(jListNotifications.getSelectedIndex());
				jListNotifications.setListData(notifications.toArray());
			}
			if (notifications.isEmpty())
			{
				btnRemoveNotif.setVisible(false);			
			}
		}
	};
	btnRemoveNotif.addActionListener(btnRemoveNotifListeners);
		
		
				//set ScrollPan
		JScrollPane scrollPpanelNotifCenter= new JScrollPane(notifCenterPan);
	//	scrollPpanelCategory.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(scrollPpanelNotifCenter, BorderLayout.CENTER);
					//add  JScrollBar
		JScrollBar scrollBarEast = new JScrollBar();
		scrollPpanelNotifCenter.add(scrollBarEast);
		
			//South
	}
}
