package com.LotuZ.accessory.ui;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.room.bl.Room;
import com.LotuZ.room.ui.AddRoomUI;
import com.LotuZ.room.ui.RoomsUI;
import com.LotuZ.room.ui.ViewRoomUI;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class AccessoriesUI extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		//FacadeUser.init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoriesUI frame = new AccessoriesUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AccessoriesUI() throws SQLException, UserNotFoundException {
		
	FacadeUser.login("jack","jack");
	User user = UserLog.getUserLog();
	Bandeau bandeau = new Bandeau();
	System.out.println("Mail page acceuil test : " + user.getMail());

	setTitle("Zen Lounge");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300,800, 750, 600);
	contentPane = new JPanel();
	contentPane.setToolTipText("");
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	contentPane.add(bandeau.createBandeau(user, "ACCESSORIES MANAGEMENT"), BorderLayout.NORTH);
	
		//Center
	JPanel roomPan = new JPanel();
	roomPan.setLayout(new GridBagLayout());
	
	//JListe Room
	
	final ArrayList<Accessory> accessories = (ArrayList<Accessory>) FacadeBL.getAllAccessory();
	final JList jListAccessories= new JList(accessories.toArray());
	jListAccessories.setCellRenderer(new DefaultListCellRenderer() 
	{ 
	@Override 
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
	{ 
		Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
		if (renderer instanceof JLabel && value instanceof Accessory) 
		{ 
			// Here value will be of the Type 'CD' 
			((JLabel) renderer).setText(((Accessory) value).getNameAccessory()); 
		}	 
		return renderer; 
	} 
	}
	);				
	GridBagConstraints gbc_jListAccessories= new GridBagConstraints();
	gbc_jListAccessories.gridx = 0;
	gbc_jListAccessories.gridy = 1;		
	jListAccessories.setVisible(true);
	roomPan.add(jListAccessories, gbc_jListAccessories);
	
		//Button Add
	
	JButton btnAdd = new JButton("Add");
	GridBagConstraints gbc_btnAdd= new GridBagConstraints();
	gbc_btnAdd.gridx = 1;
	gbc_btnAdd.gridy = 1;		
	btnAdd.setVisible(true);
	roomPan.add(btnAdd, gbc_btnAdd);
	
		//Button View
	
	JButton btnView= new JButton("View");
	GridBagConstraints gbc_btnView= new GridBagConstraints();
	gbc_btnView.gridx = 1;
	gbc_btnView.gridy = 2;		
	btnView.setVisible(true);
	roomPan.add(btnView, gbc_btnView);
	
		//Button Remove
		
	final JButton btnRemove= new JButton("Remove");
	GridBagConstraints gbc_btnRemove= new GridBagConstraints();
	gbc_btnRemove.gridx = 1;
	gbc_btnRemove.gridy = 3;		
	btnRemove.setVisible(true);
	roomPan.add(btnRemove, gbc_btnRemove);
	
		
	//Listeners
	
		//btnAddCatListeners
	
	ActionListener btnAddListeners = new ActionListener() 
	{
	
		public void actionPerformed(ActionEvent e)
		{
			AddAccessoryUI add = null;
			try {
				add = new AddAccessoryUI();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			add.setLocationRelativeTo(null);
			add.setVisible(true);
			dispose();
					
		}
	};
	
	btnAdd.addActionListener(btnAddListeners);
	
		//btnViewRoomListeners
	
	ActionListener btnViewListeners = new ActionListener() 
	{
	
	public void actionPerformed(ActionEvent e)
	{
		if (jListAccessories.getSelectedValue()!=null)
		{
			ViewAccessoryUI viewAccessoryUI = null;
			viewAccessoryUI  = new ViewAccessoryUI(accessories.get(jListAccessories.getSelectedIndex()));
			viewAccessoryUI.setLocationRelativeTo(null);
			viewAccessoryUI.setVisible(true);
			dispose();
		}		
	}
	};
	btnView.addActionListener(btnViewListeners);
	
	//btnRemoveCatListeners
	
	ActionListener btnRemoveRoomListeners = new ActionListener() 
	{
	
	public void actionPerformed(ActionEvent e) 
	{
		if (!jListAccessories.getSelectedValue().equals(null))
		{
			FacadeBL.deleteAccessory((accessories.get(jListAccessories.getSelectedIndex()).getIdAccesorry()));
			accessories.remove(jListAccessories.getSelectedIndex());
			jListAccessories.setListData(accessories.toArray());

		}
		if (accessories.isEmpty())
		{
			btnRemove.setVisible(false);			
		}
	}
	};
	btnRemove.addActionListener(btnRemoveRoomListeners);
	
	
			//set ScrollPan
	JScrollPane scrollPpanelCategory = new JScrollPane(roomPan);
	//scrollPpanelCategory.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
	contentPane.add(scrollPpanelCategory, BorderLayout.CENTER);
				//add  JScrollBar
	JScrollBar scrollBarEast = new JScrollBar();
	scrollPpanelCategory.add(scrollBarEast);
	
		//South
	}
}
