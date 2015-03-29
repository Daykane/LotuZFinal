package com.LotuZ.room.ui;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.ui.CategoryUI;
import com.LotuZ.product.category.ui.CreateCategoryUI;
import com.LotuZ.product.category.ui.ViewCategoryUI;
import com.LotuZ.room.bl.Room;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class ViewRoomUI extends JFrame
{

	private FacadeBL facadeBL;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int PARTICIPANTMIN = 5;
	private static final int PARTCIPANTMAX = 50;
	private static final int PARTICIPANTSTANDARD = 15;
	private static final int SURFACESTANDDARD = 25;
	private static final int SURFACEMIN = 15;
	private static final int SURFACEMAX = 50;
	private JPanel contentPane;

	public ViewRoomUI(Room room) throws SQLException, UserNotFoundException 
	{
		final Room roomSel =room;
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
		contentPane.add(bandeau.createBandeau(user, "ROOM MANAGEMENT"), BorderLayout.NORTH);
		
		//Center
		//Center North
		//Set Center contentPane
		JPanel contentPaneCenter = new JPanel();
		contentPaneCenter.setToolTipText("");
		contentPaneCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneCenter.setLayout(new BorderLayout(0, 0));
		contentPane.add(contentPaneCenter, BorderLayout.CENTER);
		
		//Set top banner in center pane
		JPanel panelBannerCenter = new JPanel();
		panelBannerCenter.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPaneCenter.add(panelBannerCenter, BorderLayout.NORTH);
		panelBannerCenter.setLayout(new BorderLayout(0, 0));
		
		//Set top banner Title
		JLabel lblSbTitle = new JLabel("Room View");
		lblSbTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSbTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblSbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBannerCenter.add(lblSbTitle, BorderLayout.CENTER);
		
		//Center Center
		JPanel roomPan = new JPanel();
		roomPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(roomPan, BorderLayout.CENTER);
		
		//name
		
			//label
		JLabel lblName =new JLabel("Name : ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		roomPan.add(lblName, gbc_lblName);

			//textfield
		final JTextField txtFName = new JTextField(roomSel.getNameRoom());
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		txtFName.setColumns(15);
		txtFName.setEditable(false);
		roomPan.add(txtFName, gbc_txtFName);

		
		
		//Surface	
		
			//label
		JLabel lblSurface =new JLabel("Surface : ");
		GridBagConstraints gbc_lblSurface = new GridBagConstraints();
		gbc_lblSurface.gridx = 0;
		gbc_lblSurface.gridy = 2;
		roomPan.add(lblSurface, gbc_lblSurface);
	
			//TextField
		JTextField txtFSurface = new JTextField(String.valueOf(roomSel.getSurfaceRoom()));
		GridBagConstraints gbc_txtFSurface= new GridBagConstraints();
		gbc_txtFSurface.gridx = 2;
		gbc_txtFSurface.gridy = 2;
		txtFSurface.setEditable(false);
		roomPan.add(txtFSurface, gbc_txtFSurface);
		
		//Type room
		
			//label
		JLabel lblTypeRoom =new JLabel("Type : ");
		GridBagConstraints gbc_lblTypeRoom= new GridBagConstraints();
		gbc_lblTypeRoom.gridx = 0;
		gbc_lblTypeRoom.gridy = 3;
		roomPan.add(lblTypeRoom, gbc_lblTypeRoom);
		
			//TextField
		JTextField txtFTypeRoom=null;
		if (roomSel.getTypeRoom()==0)
		{
			txtFTypeRoom = new JTextField("Salle de cours");
		}
		if (roomSel.getTypeRoom()==1)
		{
			txtFTypeRoom = new JTextField("Cabinet");
		}
		GridBagConstraints gbc_txtFTypeRoom= new GridBagConstraints();
		gbc_txtFTypeRoom.gridx = 2;
		gbc_txtFTypeRoom.gridy = 3;
		txtFTypeRoom.setEditable(false);
		roomPan.add(txtFTypeRoom, gbc_txtFTypeRoom);
			
		
		//nbMaxparticipant
		if (roomSel.getTypeRoom()==0)
		{
				//label
			final JLabel lblnbMaxParticipant =new JLabel("nbMaxParticipant : ");
			GridBagConstraints gbc_lblnbMaxParticipant= new GridBagConstraints();
			gbc_lblnbMaxParticipant.gridx = 0;
			gbc_lblnbMaxParticipant.gridy = 4;
			roomPan.add(lblnbMaxParticipant, gbc_lblnbMaxParticipant);
			lblnbMaxParticipant.setVisible(true);
			
				//JSpinner
			System.out.println(roomSel.getNbMaxParticipant());
			JTextField txtFnbMaxParticipant = new JTextField(String.valueOf(roomSel.getNbMaxParticipant()));
			GridBagConstraints gbc_txtFnbMaxParticipant= new GridBagConstraints();
			gbc_txtFnbMaxParticipant.gridx = 2;
			gbc_txtFnbMaxParticipant.gridy = 4;
			txtFnbMaxParticipant.setEditable(false);
			roomPan.add(txtFnbMaxParticipant, gbc_txtFnbMaxParticipant);
		}
		
			//Accessories
			
			//label
		JLabel lblAccesoires =new JLabel("Accesoires : ");
		GridBagConstraints gbc_lblAccesoires= new GridBagConstraints();
		gbc_lblAccesoires.gridx = 0;
		gbc_lblAccesoires.gridy = 6;
		roomPan.add(lblAccesoires, gbc_lblAccesoires);
		
			//JListe
		
		final ArrayList<Accessory> accessoriesSel = roomSel.getListAccessory();
		final JList jListAccessoriesSel = new JList(accessoriesSel.toArray());
		jListAccessoriesSel.setCellRenderer(new DefaultListCellRenderer() 
		{ 
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
		GridBagConstraints gbc_jListAccesoriesSel = new GridBagConstraints();
		gbc_jListAccesoriesSel.gridx = 2;
		gbc_jListAccesoriesSel.gridy = 6;	
		roomPan.add(jListAccessoriesSel , gbc_jListAccesoriesSel);
		
//			//ComboBox
//		
//		final ArrayList<Accessory> accessories = FacadeBL.getAllAccessory();
//		final JComboBox cBoxAccessories = new JComboBox(accessories.toArray());
//		cBoxAccessories.setRenderer(new DefaultListCellRenderer() 
//		{ 
//		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
//		{ 
//			Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
//			if (renderer instanceof JLabel && value instanceof Accessory) 
//			{ 
//				// Here value will be of the Type 'CD' 
//				((JLabel) renderer).setText(((Accessory) value).getNameAccessory()); 
//			}
//			return renderer; 
//		}
//		}
//		);
//		GridBagConstraints gbc_cBoxAccessories = new GridBagConstraints();
//		gbc_cBoxAccessories.gridx = 3;
//		gbc_cBoxAccessories.gridy = 6;	
//		roomPan.add(cBoxAccessories , gbc_cBoxAccessories);
//		
//			//AddAccesories
//		final JButton btnAddAccesories =new JButton("AddAccesories");
//		GridBagConstraints gbc_btnAddAccesories= new GridBagConstraints();
//		gbc_btnAddAccesories.gridx = 3;
//		gbc_btnAddAccesories.gridy = 7;
//		roomPan.add(btnAddAccesories, gbc_btnAddAccesories);
//		
//			//RemvoveAccesories
//		final JButton btnRemoveAccesories=new JButton("Remove");
//		GridBagConstraints gbc_btnRemoveAccesories= new GridBagConstraints();
//		gbc_btnRemoveAccesories.gridx = 3;
//		gbc_btnRemoveAccesories.gridy = 8;
//		roomPan.add(btnRemoveAccesories, gbc_btnRemoveAccesories);
		
		//Center South
		JPanel validationPan = new JPanel();
		validationPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(validationPan, BorderLayout.SOUTH);
			
			//Cancel
		JButton btnCancel =new JButton("Cancel");
		GridBagConstraints gbc_btnCancel= new GridBagConstraints();
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 5;
		validationPan.add(btnCancel, gbc_btnCancel);
		
			//Submit
		JButton btnEdit=new JButton("Edit");
		GridBagConstraints gbc_btnEdit= new GridBagConstraints();
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 5;
		validationPan.add(btnEdit, gbc_btnEdit);
		
		//Listeners
		
//				//cBoxTypeRoom Listeners
//		ActionListener cBoxTypeRoomListeners = new ActionListener ()
//		{
//		
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				if (cBoxTypeRoom.getSelectedItem().equals("Salle de cours"))
//				{
//					lblnbMaxParticipant.setVisible(true);
//					spnrNbMaxParticipant.setVisible(true);
//				}
//				if (cBoxTypeRoom.getSelectedItem().equals("Cabinet"))
//				{
//					lblnbMaxParticipant.setVisible(false);
//					spnrNbMaxParticipant.setVisible(false);
//				}
//			}
//			
//		}
//		;
//		cBoxTypeRoom.addActionListener(cBoxTypeRoomListeners);
		
			//btnCancelListeners
			
		ActionListener btnCancelListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				RoomsUI roomsUI = null;
				try {
					roomsUI = new RoomsUI();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				roomsUI.setLocationRelativeTo(null);
				roomsUI.setVisible(true);
				dispose();				
				
			}
		};
		btnCancel.addActionListener(btnCancelListeners);
		
//			//btnAddAccesories
//		
//		ActionListener btnAddAccesoriesListeners = new ActionListener() 
//		{
//			
//			public void actionPerformed(ActionEvent e)
//			{
//				if (cBoxAccessories.getSelectedObjects()!=null)
//				{
//					//Ajout dans la liste des accesoires sélectionné
//					accessoriesSel.add(accessories.get(cBoxAccessories.getSelectedIndex()));
//					jListAccessoriesSel.setListData(accessoriesSel.toArray());
//					
//					//Suppression dans la liste des accesoires disponible
//					accessories.remove(cBoxAccessories.getSelectedIndex());
//					cBoxAccessories.removeItem(cBoxAccessories.getSelectedItem());
//					
//					btnRemoveAccesories.setVisible(true);
//
//				}
//				if (accessories.isEmpty())
//				{
//					cBoxAccessories.setVisible(false);
//					btnAddAccesories.setVisible(false);
//				}
//			}
//		};
//		btnAddAccesories.addActionListener(btnAddAccesoriesListeners);
		
			//btnRemoveAccesories
		
//		ActionListener btnRemoveAccesoriesListeners = new ActionListener() 
//		{
//			
//			public void actionPerformed(ActionEvent e)
//			{
//				if (jListAccessoriesSel.getSelectedValue()!=null)
//				{
//					//Ajout dans la liste des accesoires disponible
//					accessories.add(accessoriesSel.get(jListAccessoriesSel.getSelectedIndex()));
//					cBoxAccessories.addItem(accessoriesSel.get(jListAccessoriesSel.getSelectedIndex()));
//					
//					//Suppression dans la liste des accesoires selectionné
//					accessoriesSel.remove(jListAccessoriesSel.getSelectedIndex());
//					jListAccessoriesSel.setListData(accessoriesSel.toArray());
//					
//					cBoxAccessories.setVisible(true);
//					btnAddAccesories.setVisible(true);
//					
//
//				}
//				if (accessoriesSel.isEmpty())
//				{
//					btnRemoveAccesories.setVisible(false);
//				}
//			}
//		};
//		btnRemoveAccesories.addActionListener(btnRemoveAccesoriesListeners);
		
			//btnEditListeners
			
		ActionListener btnEditListeners = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
//				if (cBoxTypeRoom.getSelectedItem().equals("Salle de cours"))
//				{	
//					int surface = (Integer) spnrSurface.getValue();
//					int nbMaxParticipant = (Integer) spnrNbMaxParticipant.getValue();
//					facadeBL.createRoom(txtFName.getText(), surface , 0, nbMaxParticipant, accessoriesSel); //Code salle de cours = 0
//					System.out.println("coucou");
//					Room r = facadeBL.getRoom(txtFName.getText());
//					System.out.println("id:"+r.getIdRoom()+"   name"+r.getNameRoom());
//				}
//				if (cBoxTypeRoom.getSelectedItem().equals("Cabinet"))
//				{
//					int surface = (Integer) spnrSurface.getValue();
//					facadeBL.createRoom(txtFName.getText(), surface, 1, accessoriesSel); //Code cabinet = 1
//					Room r = facadeBL.getRoom(txtFName.getText());
//				}
				EditRoomUI editRoomUI = null;
				try {
					editRoomUI = new EditRoomUI(roomSel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				editRoomUI.setLocationRelativeTo(null);
				editRoomUI.setVisible(true);
				dispose();
			}
		};
		btnEdit.addActionListener(btnEditListeners);
		
//			//set ScrollPan
//		JScrollPane scrollPpanelCategory = new JScrollPane(roomPan);
//		//scrollPpanelCategory.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
//		contentPane.add(scrollPpanelCategory, BorderLayout.CENTER);
//					//add  JScrollBar
//		JScrollBar scrollBarEast = new JScrollBar();
//		scrollPpanelCategory.add(scrollBarEast);
//		
//			//South
	}

}
