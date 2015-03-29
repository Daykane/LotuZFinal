package com.LotuZ.accessory.ui;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class ViewAccessoryUI extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewAccessoryUI(Accessory accessory) throws SQLException, UserNotFoundException 
	{
		final Accessory accessorySel =accessory;
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
		contentPane.add(bandeau.createBandeau(user, "ACCESSORY MANAGEMENT"), BorderLayout.NORTH);
		
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
		JLabel lblSbTitle = new JLabel("Accessory View");
		lblSbTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSbTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblSbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBannerCenter.add(lblSbTitle, BorderLayout.CENTER);
		
		//Center Center
		JPanel accessoryPan = new JPanel();
		accessoryPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(accessoryPan, BorderLayout.CENTER);
		
		//name
		
			//label
		JLabel lblName =new JLabel("Name : ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		accessoryPan.add(lblName, gbc_lblName);

			//textfield
		final JTextField txtFName = new JTextField(accessorySel.getNameAccessory());
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		txtFName.setColumns(15);
		txtFName.setEditable(false);
		accessoryPan.add(txtFName, gbc_txtFName);

		
		
		//Description	
		
			//label
		JLabel lbldescription =new JLabel("Description : ");
		GridBagConstraints gbc_lbldescription = new GridBagConstraints();
		gbc_lbldescription.gridx = 0;
		gbc_lbldescription.gridy = 2;
		accessoryPan.add(lbldescription, gbc_lbldescription);
	
			//TextField
		JTextArea txtAdescription = new JTextArea(accessorySel.getDescriptionAccessory());
		GridBagConstraints gbc_txtAdescription= new GridBagConstraints();
		gbc_txtAdescription.gridx = 2;
		gbc_txtAdescription.gridy = 2;
		txtAdescription.setEditable(false);
		txtAdescription.setColumns(30);
		txtAdescription.setRows(3);
		accessoryPan.add(txtAdescription, gbc_txtAdescription);
		
		//Center South
		JPanel validationPan = new JPanel();
		validationPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(validationPan, BorderLayout.SOUTH);
			
			//Cancel
		JButton btnCancel =new JButton("Cancel");
		GridBagConstraints gbc_btnCancel= new GridBagConstraints();
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 3;
		validationPan.add(btnCancel, gbc_btnCancel);
		
			//Edit
		JButton btnEdit=new JButton("Edit");
		GridBagConstraints gbc_btnEdit= new GridBagConstraints();
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 3;
		validationPan.add(btnEdit, gbc_btnEdit);
		
		//Listeners
		
			
		ActionListener btnCancelListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				AccessoriesUI accessoriesUI = null;
				try {
					accessoriesUI = new AccessoriesUI();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				accessoriesUI.setLocationRelativeTo(null);
				accessoriesUI.setVisible(true);
				dispose();				
				
			}
		};
		btnCancel.addActionListener(btnCancelListeners);
		
		
		
			//btnEditListeners
			
		ActionListener btnEditListeners = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				EditAccessoryUI editAccessoryUI = null;
				try {
					editAccessoryUI = new EditAccessoryUI(accessorySel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				editAccessoryUI.setLocationRelativeTo(null);
				editAccessoryUI.setVisible(true);
				dispose();
			}
		};
		btnEdit.addActionListener(btnEditListeners);
		
	}
}
