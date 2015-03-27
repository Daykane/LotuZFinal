//package com.LotuZ.notification.ui;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//import javax.swing.SwingConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.TitledBorder;
//
//import com.LotuZ.FacadeBL;
//import com.LotuZ.JdbcKit;
//import com.LotuZ.login.LoginUI;
//import com.LotuZ.login.UserNotFoundException;
//import com.LotuZ.notification.bl.BoxLetter;
//import com.LotuZ.notification.bl.Notification;
//import com.LotuZ.product.category.bl.CategoryProduct;
//import com.LotuZ.product.category.ui.CreateCategoryUI;
//import com.LotuZ.product.category.ui.ViewCategoryUI;
//import com.LotuZ.user.FacadeUser;
//import com.LotuZ.user.UserLog;
//import com.LotuZ.user.user.bl.User;
//
//
//public class NotificationCenterUI extends JFrame
//{
//
//	private FacadeBL facadeBL;
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//
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
//					NotificationCenterUI frame = new NotificationCenterUI();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	/**
//	 * Create the frame.
//	 * @throws UserNotFoundException 
//	 * @throws SQLException 
//	 */
//	
////	public Component getListCellRendererComponent(JList list, Object value,
////		      int index, boolean isSelected, boolean cellHasFocus) {
////		    BookEntry entry = (BookEntry) value;
////		    setText(entry.getTitle());
////		    setIcon(entry.getImage());
////		    if (isSelected) {
////		      setBackground(Color.blue);
////		      setForeground(Color.white);
////		    } else {
////		      setBackground(Color.white);
////		      setForeground(Color.black);
////		    }
////		    return this;
////		  }
////		}
//
//	public NotificationCenterUI() throws SQLException, UserNotFoundException 
//	{
//		FacadeUser.login("jack","jack");
//		User user = UserLog.getUserLog();
//
//		setTitle("Zen Lounge");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(300,800, 750, 600);
//		//North
//		contentPane = new JPanel();
//		contentPane.setToolTipText("");
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new BorderLayout(0, 0));
//
//		JPanel panelBandeau = new JPanel();
//		panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
//		contentPane.add(panelBandeau, BorderLayout.NORTH);
//		panelBandeau.setLayout(new BorderLayout(0, 0));
//
//
//		JLabel lblTitle = new JLabel("Notification Center");
//		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//		panelBandeau.add(lblTitle, BorderLayout.CENTER);
//
//		JLabel lblToto = new JLabel("LOGO");
//		lblToto.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblToto.setHorizontalAlignment(SwingConstants.LEFT);
//		//panel.add(lblToto, BorderLayout.WEST);
//
//		JLabel image = new JLabel(new ImageIcon("zen.jpg"));
//		panelBandeau.add(image,BorderLayout.WEST);
//
//		JPanel panelOptions = new JPanel();
//		panelBandeau.add(panelOptions, BorderLayout.EAST);
//		panelOptions.setLayout(new GridLayout(3, 1, 0, 0));
//
//		final JLabel lblnameUser = new JLabel("name");
//		panelOptions.add(lblnameUser);
//		if 	(user!=null){
//			lblnameUser.setText(user.getLastName() +" "+ user.getFirstName());
//		}
//		else {
//			lblnameUser.setVisible(false);
//		}
//		final String nameUser = lblnameUser.getText(); 
//		lblnameUser.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println("Clicked sur name = acces profil");
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				lblnameUser.setText("<html><u><font color = #1373cc >"+nameUser +" </u></font></html>");
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				lblnameUser.setText(nameUser);
//			}
//		});
//		lblnameUser.setHorizontalAlignment(SwingConstants.LEFT);
//
//		final JLabel lblConnexion = new JLabel("connexion/deconnexion");
//		lblConnexion.setHorizontalAlignment(SwingConstants.LEFT);
//		panelOptions.add(lblConnexion);
//		if (user == null){
//			lblConnexion.setText("connexion");
//		}
//		else {
//			lblConnexion.setText("d�connexion");
//		}
//		final String Connexion = lblConnexion.getText();
//		final JLabel lblBoutique = new JLabel("Boutique Access ");
//		panelOptions.add(lblBoutique);
//		final String Boutique = lblBoutique.getText();
//		lblBoutique.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				System.out.println("Clicked sur acces boutique");
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				lblBoutique.setText("<html><u><font color = #1373cc >"+Boutique +" </u></font></html>");
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				lblBoutique.setText(Boutique);
//			}
//		});
//		lblBoutique.setHorizontalAlignment(SwingConstants.LEFT);
//		lblConnexion.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				if(UserLog.getUserLog() == null){
//					LoginUI loginUI =  new LoginUI();	
//					LoginUI.frame = loginUI;
//					loginUI.setVisible(true);
//				}
//				else{
//					System.out.println("Faire une d�connexion");
//				}
//				//System.out.println("Connexion ou deconnexion si la personne n'est pas connect� ou l'est");
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				lblConnexion.setText("<html><u><font color = #1373cc >"+Connexion +" </u></font></html>");
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				lblConnexion.setText(Connexion);
//			}
//		});
//		
//			//Center
//		JPanel categoryPan = new JPanel();
//		categoryPan.setLayout(new GridBagLayout());
//	
//		//JListe Category
//		final ArrayList<BoxLetter> boxLetter = (ArrayList<BoxLetter>) FacadeBL.getAllNotificationInBox(user.getIdMember());
//		final ArrayList<Notification> notifications = new ArrayList<Notification>();
//		for (int i=0;i<boxLetter.size();i++)
//		{
//			notifications.add(FacadeBL.getNotification(boxLetter.get(i).getIdNotification()));
//		}	
//		final JList jListNotifications = new JList(notifications.toArray());
//		
//		GridBagConstraints gbc_jListNotifications= new GridBagConstraints();
//		gbc_jListNotifications.gridx = 0;
//		gbc_jListNotifications.gridy = 1;		
//		jListNotifications.setVisible(true);
//		categoryPan.add(jListNotifications, gbc_jListNotifications);
//			
//			//Button View
//		
//		JButton btnViewNotif = new JButton("View");
//		GridBagConstraints gbc_btnViewNotif= new GridBagConstraints();
//		gbc_btnViewNotif.gridx = 1;
//		gbc_btnViewNotif.gridy = 2;		
//		btnViewNotif.setVisible(true);
//		categoryPan.add(btnViewNotif, gbc_btnViewNotif);
//		
//			//Button Remove
//		
//		final JButton btnRemoveNotif = new JButton("Remove");
//		GridBagConstraints gbc_btnRemoveNotif= new GridBagConstraints();
//		gbc_btnRemoveNotif.gridx = 1;
//		gbc_btnRemoveNotif.gridy = 3;		
//		btnRemoveNotif.setVisible(true);
//		categoryPan.add(btnRemoveNotif, gbc_btnRemoveNotif);
//		
//		//Listeners
//	
//		
//			//btnViewCatListeners
//		
//	ActionListener btnViewNotifListeners = new ActionListener() 
//	{
//		
//		public void actionPerformed(ActionEvent e)
//		{
//			if (jListNotifications.getSelectedValue()!=null)
//			{
//				ViewCategoryUI ViewNotificationUI = null;
//				try {
//					ViewNotificationUI = new ViewNotificationUI(jListNotifications.getSelectedValue());
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (UserNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				ViewNotificationUI.setLocationRelativeTo(null);
//				ViewNotificationUI.setVisible(true);
//				dispose();
//			}
//			
//			
//		}
//	};
//	btnViewNotif.addActionListener(btnViewNotifListeners);
//	
//		//btnRemoveCatListeners
//		
//	ActionListener btnRemoveNotifListeners = new ActionListener() 
//	{
//	
//		public void actionPerformed(ActionEvent e) 
//		{
//			if (!jListNotifications.getSelectedValue().equals(null))
//			{		
//				boxLetter.remove(jListNotifications.getSelectedIndex());
//				notifications.remove(jListNotifications.getSelectedIndex());
//				jListNotifications.setListData(notifications.toArray());
//				
//				facadeBL.deleteNotificationInBox(jListNotifications.getSelectedValue().getIdNotification(), user.getIdMember());
//			}
//			if (notifications.isEmpty())
//			{
//				btnRemoveNotif.setVisible(false);			
//			}
//		}
//	};
//	btnRemoveNotif.addActionListener(btnRemoveNotifListeners);
//		
//		
////				//set ScrollPan
////		JScrollPane scrollPpanelCategory = new JScrollPane(categoryPan);
////	//	scrollPpanelCategory.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
////		contentPane.add(scrollPpanelCategory, BorderLayout.CENTER);
////					//add  JScrollBar
////		JScrollBar scrollBarEast = new JScrollBar();
////		scrollPpanelCategory.add(scrollBarEast);
//		
//			//South
//	}
//	
//}
//
