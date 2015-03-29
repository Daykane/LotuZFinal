package com.LotuZ.room.ui;

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
import com.LotuZ.accessory.ui.AccessoriesUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.ui.CreateCategoryUI;
import com.LotuZ.product.category.ui.ViewCategoryUI;
import com.LotuZ.room.bl.Room;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class RoomsUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	
	public RoomsUI() throws SQLException, UserNotFoundException {
		
	User user = UserLog.getUserLog();
	Bandeau bandeau = new Bandeau();
	bandeau.setJframe(this);


	setTitle("Zen Lounge");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300,800, 750, 600);
	contentPane = new JPanel();
	contentPane.setToolTipText("");
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	contentPane.add(bandeau.createBandeau(user, "ROOM MANAGEMENT"), BorderLayout.NORTH);
	
		//Center
	JPanel roomPan = new JPanel();
	roomPan.setLayout(new GridBagLayout());
	
	//JListe Room
	
	final ArrayList<Room> rooms = (ArrayList<Room>) FacadeBL.getAllRoom();
	final JList jListRooms= new JList(rooms.toArray());
	jListRooms.setCellRenderer(new DefaultListCellRenderer() 
	{ 
	@Override 
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
	{ 
		Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
		if (renderer instanceof JLabel && value instanceof Room) 
		{ 
			// Here value will be of the Type 'CD' 
			((JLabel) renderer).setText(((Room) value).getNameRoom()); 
			if (((Room) value).getTypeRoom()==0)
			{
				setIcon(new ImageIcon(""));
			}
			else
			{
				setIcon(new ImageIcon(""));
			}
		}	 
		return renderer; 
	} 
	}
	);				
	GridBagConstraints gbc_jListRooms= new GridBagConstraints();
	gbc_jListRooms.gridx = 0;
	gbc_jListRooms.gridy = 1;		
	jListRooms.setVisible(true);
	roomPan.add(jListRooms, gbc_jListRooms);
	
		//Button Add
	
	JButton btnAddRoom = new JButton("Add");
	GridBagConstraints gbc_btnAddRoom= new GridBagConstraints();
	gbc_btnAddRoom.gridx = 1;
	gbc_btnAddRoom.gridy = 1;		
	btnAddRoom.setVisible(true);
	roomPan.add(btnAddRoom, gbc_btnAddRoom);
	
		//Button View
	
	JButton btnViewRoom= new JButton("View");
	GridBagConstraints gbc_btnViewRoom= new GridBagConstraints();
	gbc_btnViewRoom.gridx = 1;
	gbc_btnViewRoom.gridy = 2;		
	btnViewRoom.setVisible(true);
	roomPan.add(btnViewRoom, gbc_btnViewRoom);
	
		//Button Remove
		
	final JButton btnRemoveRoom= new JButton("Remove");
	GridBagConstraints gbc_btnRemoveRoom= new GridBagConstraints();
	gbc_btnRemoveRoom.gridx = 1;
	gbc_btnRemoveRoom.gridy = 3;		
	btnRemoveRoom.setVisible(true);
	roomPan.add(btnRemoveRoom, gbc_btnRemoveRoom);
	
		//Button Accessories
		
	final JButton btnAccessories = new JButton("Accessories");
	GridBagConstraints gbc_btnAccessories= new GridBagConstraints();
	gbc_btnAccessories.gridx = 1;
	gbc_btnAccessories.gridy = 4;		
	btnAccessories.setVisible(true);
	roomPan.add(btnAccessories, gbc_btnAccessories);
		
	//Listeners
	
		//btnAddCatListeners
	
	ActionListener btnAddRoomListeners = new ActionListener() 
	{
	
		public void actionPerformed(ActionEvent e)
		{
			AddRoomUI add = null;
			try {
				add = new AddRoomUI();
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
	
	btnAddRoom.addActionListener(btnAddRoomListeners);
	
		//btnViewRoomListeners
	
	ActionListener btnViewListeners = new ActionListener() 
	{
	
	public void actionPerformed(ActionEvent e)
	{
		if (jListRooms.getSelectedValue()!=null)
		{
			ViewRoomUI viewRoomUI = null;
			try {
				viewRoomUI  = new ViewRoomUI(rooms.get(jListRooms.getSelectedIndex()));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			viewRoomUI.setLocationRelativeTo(null);
			viewRoomUI.setVisible(true);
			dispose();
		}		
	}
	};
	btnViewRoom.addActionListener(btnViewListeners);
	
	//btnRemoveCatListeners
	
	ActionListener btnRemoveRoomListeners = new ActionListener() 
	{
	
	public void actionPerformed(ActionEvent e) 
	{
		if (!jListRooms.getSelectedValue().equals(null))
		{
			FacadeBL.deleteRoom(rooms.get(jListRooms.getSelectedIndex()).getIdRoom());
			rooms.remove(jListRooms.getSelectedIndex());
			jListRooms.setListData(rooms.toArray());

		}
		if (rooms.isEmpty())
		{
			btnRemoveRoom.setVisible(false);			
		}
	}
	};
	btnRemoveRoom.addActionListener(btnRemoveRoomListeners);
	
		//btnAccessoriesListeners
		
	ActionListener btnAccessoriesListeners = new ActionListener() 
	{
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("iciiia");
		AccessoriesUI accessorieUI=null;
		try {
			accessorieUI = new AccessoriesUI();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		accessorieUI.setLocationRelativeTo(null);
		accessorieUI.setVisible(true);
		dispose();	
	}
	};
	btnAccessories.addActionListener(btnAccessoriesListeners);
	
	
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
