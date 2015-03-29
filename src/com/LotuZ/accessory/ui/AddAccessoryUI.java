package com.LotuZ.accessory.ui;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
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
import com.LotuZ.room.ui.RoomsUI;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class AddAccessoryUI extends JFrame {
	private FacadeBL facadeBL;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	
	public AddAccessoryUI() throws SQLException, UserNotFoundException 
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
		JLabel lblSbTitle = new JLabel("Accessory Creation");
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

		
		
		//Description
		
			//label
		JLabel lblSurface =new JLabel("Description : ");
		GridBagConstraints gbc_lblSurface = new GridBagConstraints();
		gbc_lblSurface.gridx = 0;
		gbc_lblSurface.gridy = 2;
		roomPan.add(lblSurface, gbc_lblSurface);
	
			//JTextArea
		final JTextArea txtADesscription = new JTextArea();
		GridBagConstraints gbc_txtADesscription= new GridBagConstraints();
		gbc_txtADesscription.gridx = 2;
		gbc_txtADesscription.gridy = 2;
		txtADesscription.setColumns(15);
		txtADesscription.setRows(3);
		roomPan.add(txtADesscription, gbc_txtADesscription);
		
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
		
		
			//btnCancelListeners
			
		ActionListener btnCancelListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				AccessoriesUI accessoriesUI=null; 
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
		
		
		
			//btnSubmitListeners
			
		ActionListener btnSubmitListeners = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				FacadeBL.createAccessory(txtFName.getText(), txtADesscription.getText());
				AccessoriesUI accessoriesUI=null; 
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
		btnSubmit.addActionListener(btnSubmitListeners);

	}

}
