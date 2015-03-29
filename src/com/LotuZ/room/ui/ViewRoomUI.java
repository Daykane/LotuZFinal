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
		
		
			//btnEditListeners
			
		ActionListener btnEditListeners = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
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
		
	}

}
