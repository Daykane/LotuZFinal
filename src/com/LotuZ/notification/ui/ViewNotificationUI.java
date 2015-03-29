package com.LotuZ.notification.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.login.LoginUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.notification.bl.Notification;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class ViewNotificationUI extends JFrame{
	
	private FacadeBL facadeBL;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Notification notification;
	String dateReceived;

	public ViewNotificationUI(Notification notif, String dateReceiveD, User user2) throws SQLException, UserNotFoundException 
	{
//		FacadeUser.login("jack","jack");
//		final User user = UserLog.getUserLog();
		final User user = user2;
		notification =notif;
		dateReceived =dateReceiveD;

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
		
		JPanel notifViewPan = new JPanel();
		notifViewPan.setLayout(new GridBagLayout());
		
			//object
		
			//date
			
			//label
		JLabel lblDateReceived=new JLabel("Date : ");
		GridBagConstraints gbc_lblDateReceived = new GridBagConstraints();
		gbc_lblDateReceived.gridx = 0;
		gbc_lblDateReceived.gridy = 0;
		notifViewPan.add(lblDateReceived, gbc_lblDateReceived);
	
			//textfield
		JTextField txtFDateReceived= new JTextField(dateReceived);
		GridBagConstraints gbc_txtFDateReceived = new GridBagConstraints();
		gbc_txtFDateReceived.gridx = 2;
		gbc_txtFDateReceived.gridy = 0;
		txtFDateReceived.setColumns(15);
		txtFDateReceived.setEditable(false);
		notifViewPan.add(txtFDateReceived, gbc_txtFDateReceived);
			
			//label
		JLabel lblObjectNotif =new JLabel("Object : ");
		GridBagConstraints gbc_lblObjectNotif = new GridBagConstraints();
		gbc_lblObjectNotif.gridx = 0;
		gbc_lblObjectNotif.gridy = 1;
		notifViewPan.add(lblObjectNotif, gbc_lblObjectNotif);
	
			//textfield
		JTextField txtFObjectNotif = new JTextField(notification.getObjetNotification());
		GridBagConstraints gbc_txtFObjectNotif = new GridBagConstraints();
		gbc_txtFObjectNotif.gridx = 2;
		gbc_txtFObjectNotif.gridy = 1;
		txtFObjectNotif.setColumns(30);
		txtFObjectNotif.setEditable(false);
		notifViewPan.add(txtFObjectNotif, gbc_txtFObjectNotif);
		
			//textNotification	
			
			//label
		JLabel lblDescription =new JLabel("Description : ");
		GridBagConstraints gbc_lbldescription = new GridBagConstraints();
		gbc_lbldescription.gridx = 0;
		gbc_lbldescription.gridy = 2;
		notifViewPan.add(lblDescription, gbc_lbldescription);
	
			//JTextArea
		JTextArea txtADescription = new JTextArea(notification.getTextNotification());
		GridBagConstraints gbc_txtADescription = new GridBagConstraints();
		gbc_txtADescription.gridx = 2;
		gbc_txtADescription.gridy = 2;
		txtADescription.setColumns(15);
		txtADescription.setRows(4);
		txtADescription.setEditable(false);
		notifViewPan.add(txtADescription, gbc_txtADescription);
		
			//Button Cancel
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel= new GridBagConstraints();
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 3;		
		btnCancel.setVisible(true);
		notifViewPan.add(btnCancel, gbc_btnCancel);
		
			//Button Remove
		final JButton btnRemoveNotif = new JButton("Remove");
		GridBagConstraints gbc_btnRemoveNotif= new GridBagConstraints();
		gbc_btnRemoveNotif.gridx = 2;
		gbc_btnRemoveNotif.gridy = 3;		
		btnRemoveNotif.setVisible(true);
		notifViewPan.add(btnRemoveNotif, gbc_btnRemoveNotif);
		
		//Listeners
	
		
			//btnViewCatListeners
		
	ActionListener btnCancelNotifListeners = new ActionListener() 
	{
		
		public void actionPerformed(ActionEvent e)
		{
				NotificationCenterUI notificationCenterUI = null;
				try {
					notificationCenterUI = new NotificationCenterUI(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (UserNotFoundException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				notificationCenterUI.setLocationRelativeTo(null);
				notificationCenterUI.setVisible(true);
				dispose();
				}
	};
	btnCancel.addActionListener(btnCancelNotifListeners);
	
		//btnRemoveCatListeners
		
	ActionListener btnRemoveNotifListeners = new ActionListener() 
	{
	
		public void actionPerformed(ActionEvent e) 
		{
				facadeBL.deleteNotificationInBox(notification.getIdNotification(),user.getIdMember());
				NotificationCenterUI notificationCenterUI = null;
				try {
					notificationCenterUI = new NotificationCenterUI(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (UserNotFoundException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				notificationCenterUI.setLocationRelativeTo(null);
				notificationCenterUI.setVisible(true);
				dispose();
		}
	};
	btnRemoveNotif.addActionListener(btnRemoveNotifListeners);
		
		
			//set ScrollPan
	JScrollPane scrollPpanelNotifCenter= new JScrollPane(notifViewPan);
	//	scrollPpanelCategory.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
	contentPane.add(scrollPpanelNotifCenter, BorderLayout.CENTER);
				//add  JScrollBar
	JScrollBar scrollBarEast = new JScrollBar();
	scrollPpanelNotifCenter.add(scrollBarEast);
	
		//South
		
	}
}