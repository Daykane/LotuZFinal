package com.LotuZ.room.ui;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.notification.bl.Notification;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.ui.CategoryUI;
import com.LotuZ.room.bl.Room;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

/**
 * @author Loïc
 *
 */

public class AddRoomUI extends JFrame
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


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	
	public AddRoomUI() throws SQLException, UserNotFoundException 
	{
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
		JLabel lblSbTitle = new JLabel("Room Creation");
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
		final JTextField txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		txtFName.setColumns(15);
		roomPan.add(txtFName, gbc_txtFName);

		
		
		//Surface	
		
			//label
		JLabel lblSurface =new JLabel("Surface : ");
		GridBagConstraints gbc_lblSurface = new GridBagConstraints();
		gbc_lblSurface.gridx = 0;
		gbc_lblSurface.gridy = 2;
		roomPan.add(lblSurface, gbc_lblSurface);
	
			//JSpinner
		SpinnerModel sufaceSpinerModel = new SpinnerNumberModel(SURFACESTANDDARD,SURFACEMIN,SURFACEMAX,1);
		final JSpinner spnrSurface = new JSpinner(sufaceSpinerModel);
		GridBagConstraints gbc_spnrSurface= new GridBagConstraints();
		gbc_spnrSurface.gridx = 2;
		gbc_spnrSurface.gridy = 2;
		roomPan.add(spnrSurface, gbc_spnrSurface);
		
		//Type room
		
			//label
		JLabel lblTypeRoom =new JLabel("Type : ");
		GridBagConstraints gbc_lblTypeRoom= new GridBagConstraints();
		gbc_lblTypeRoom.gridx = 0;
		gbc_lblTypeRoom.gridy = 3;
		roomPan.add(lblTypeRoom, gbc_lblTypeRoom);
		
			//ComboBox
		
		Object[] elements = new Object[]{"Salle de cours", "Cabinet"};
		GridBagConstraints gbc_cBoxTypeRoom = new GridBagConstraints();
		gbc_cBoxTypeRoom.gridx = 2;
		gbc_cBoxTypeRoom.gridy = 3;		
		final JComboBox cBoxTypeRoom = new JComboBox(elements);
		
		roomPan.add(cBoxTypeRoom , gbc_cBoxTypeRoom);
			
		
		//nbMaxparticipant
		
			//label
		final JLabel lblnbMaxParticipant =new JLabel("nbMaxParticipant : ");
		GridBagConstraints gbc_lblnbMaxParticipant= new GridBagConstraints();
		gbc_lblnbMaxParticipant.gridx = 0;
		gbc_lblnbMaxParticipant.gridy = 4;
		roomPan.add(lblnbMaxParticipant, gbc_lblnbMaxParticipant);
		lblnbMaxParticipant.setVisible(false);
		
			//JSpinner
		SpinnerModel nbMaxParticipantSpinerModel = new SpinnerNumberModel(PARTICIPANTSTANDARD,PARTICIPANTMIN,PARTCIPANTMAX,1);
		final JSpinner spnrNbMaxParticipant = new JSpinner(nbMaxParticipantSpinerModel);
		GridBagConstraints gbc_spnrNbMaxParticipant= new GridBagConstraints();
		gbc_spnrNbMaxParticipant.gridx = 2;
		gbc_spnrNbMaxParticipant.gridy = 4;
		roomPan.add(spnrNbMaxParticipant, gbc_spnrNbMaxParticipant);
		
		
			//Accesories
			
			//label
		JLabel lblAccesoires =new JLabel("Accesoires : ");
		GridBagConstraints gbc_lblAccesoires= new GridBagConstraints();
		gbc_lblAccesoires.gridx = 0;
		gbc_lblAccesoires.gridy = 6;
		roomPan.add(lblAccesoires, gbc_lblAccesoires);
		
			//JListe
		
		final ArrayList<Accessory> accessoriesSel = new ArrayList<Accessory>();
		final JList jListAccessoriesSel = new JList();
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
		
			//ComboBox
		
		final ArrayList<Accessory> accessories = FacadeBL.getAllAccessory();
		final JComboBox cBoxAccessories = new JComboBox(accessories.toArray());
		cBoxAccessories.setRenderer(new DefaultListCellRenderer() 
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
		GridBagConstraints gbc_cBoxAccessories = new GridBagConstraints();
		gbc_cBoxAccessories.gridx = 3;
		gbc_cBoxAccessories.gridy = 6;	
		roomPan.add(cBoxAccessories , gbc_cBoxAccessories);
		
			//AddAccesories
		final JButton btnAddAccesories =new JButton("AddAccesories");
		GridBagConstraints gbc_btnAddAccesories= new GridBagConstraints();
		gbc_btnAddAccesories.gridx = 3;
		gbc_btnAddAccesories.gridy = 7;
		roomPan.add(btnAddAccesories, gbc_btnAddAccesories);
		
			//RemvoveAccesories
		final JButton btnRemoveAccesories=new JButton("Remove");
		GridBagConstraints gbc_btnRemoveAccesories= new GridBagConstraints();
		gbc_btnRemoveAccesories.gridx = 3;
		gbc_btnRemoveAccesories.gridy = 8;
		roomPan.add(btnRemoveAccesories, gbc_btnRemoveAccesories);
		
		//Center South
		JPanel validationPan = new JPanel();
		validationPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(validationPan, BorderLayout.SOUTH);
			
			//Cancel
		JButton btnCancel =new JButton("Cancel");
		GridBagConstraints gbc_btnCancel= new GridBagConstraints();
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 9;
		validationPan.add(btnCancel, gbc_btnCancel);
		
			//Submit
		JButton btnSubmit=new JButton("Submit");
		GridBagConstraints gbc_btnSubmit= new GridBagConstraints();
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 9;
		validationPan.add(btnSubmit, gbc_btnSubmit);
		
		//Listeners
		
				//cBoxTypeRoom Listeners
		ActionListener cBoxTypeRoomListeners = new ActionListener ()
		{
		
			public void actionPerformed(ActionEvent arg0) 
			{
				if (cBoxTypeRoom.getSelectedItem().equals("Salle de cours"))
				{
					lblnbMaxParticipant.setVisible(true);
					spnrNbMaxParticipant.setVisible(true);
				}
				if (cBoxTypeRoom.getSelectedItem().equals("Cabinet"))
				{
					lblnbMaxParticipant.setVisible(false);
					spnrNbMaxParticipant.setVisible(false);
				}
			}
			
		}
		;
		cBoxTypeRoom.addActionListener(cBoxTypeRoomListeners);
		
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
		
			//btnAddAccesories
		
		ActionListener btnAddAccesoriesListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if (cBoxAccessories.getSelectedObjects()!=null)
				{
					//Ajout dans la liste des accesoires sélectionné
					accessoriesSel.add(accessories.get(cBoxAccessories.getSelectedIndex()));
					jListAccessoriesSel.setListData(accessoriesSel.toArray());
					
					//Suppression dans la liste des accesoires disponible
					accessories.remove(cBoxAccessories.getSelectedIndex());
					cBoxAccessories.removeItem(cBoxAccessories.getSelectedItem());
					
					btnRemoveAccesories.setVisible(true);

				}
				if (accessories.isEmpty())
				{
					cBoxAccessories.setVisible(false);
					btnAddAccesories.setVisible(false);
				}
			}
		};
		btnAddAccesories.addActionListener(btnAddAccesoriesListeners);
		
			//btnRemoveAccesories
		
		ActionListener btnRemoveAccesoriesListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				if (jListAccessoriesSel.getSelectedValue()!=null)
				{
					//Ajout dans la liste des accesoires disponible
					accessories.add(accessoriesSel.get(jListAccessoriesSel.getSelectedIndex()));
					cBoxAccessories.addItem(accessoriesSel.get(jListAccessoriesSel.getSelectedIndex()));
					
					//Suppression dans la liste des accesoires selectionné
					accessoriesSel.remove(jListAccessoriesSel.getSelectedIndex());
					jListAccessoriesSel.setListData(accessoriesSel.toArray());
					
					cBoxAccessories.setVisible(true);
					btnAddAccesories.setVisible(true);
					

				}
				if (accessoriesSel.isEmpty())
				{
					btnRemoveAccesories.setVisible(false);
				}
			}
		};
		btnRemoveAccesories.addActionListener(btnRemoveAccesoriesListeners);
		
			//btnSubmitListeners
			
		ActionListener btnSubmitListeners = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (cBoxTypeRoom.getSelectedItem().equals("Salle de cours"))
				{	
					int surface = (Integer) spnrSurface.getValue();
					int nbMaxParticipant = (Integer) spnrNbMaxParticipant.getValue();
					//facadeBL.createRoom(txtFName.getText(), surface , 0, nbMaxParticipant, accessoriesSel); //Code salle de cours = 0
				}
				else if (cBoxTypeRoom.getSelectedItem().equals("Cabinet"))
				{
					System.out.println("yrert");
					int surface = (Integer) spnrSurface.getValue();
					System.out.println("yrertooo");
					facadeBL.createRoom(txtFName.getText(), surface , 0, accessoriesSel); //Code cabinet = 1
				}
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
		btnSubmit.addActionListener(btnSubmitListeners);

	}

}
