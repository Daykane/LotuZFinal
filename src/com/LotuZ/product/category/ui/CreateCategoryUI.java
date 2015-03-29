package com.LotuZ.product.category.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.data.CatgeoryJdbc;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

/**
 * @author Loïc
 *
 */

public class CreateCategoryUI extends JFrame {

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
	public CreateCategoryUI() throws SQLException, UserNotFoundException {
		setLocationRelativeTo(null);
		User user = UserLog.getUserLog();
		
		//Create Window
		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		
		//North
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
			//Set top banner
		JPanel panelBanner = new JPanel();
		panelBanner.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(panelBanner, BorderLayout.NORTH);
		panelBanner.setLayout(new BorderLayout(0, 0));

				//Set top banner Title
		JLabel lblTitle = new JLabel("CATEGORY MANAGEMENT");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBanner.add(lblTitle, BorderLayout.CENTER);

				//Set top banner Logo
		JLabel lblToto = new JLabel("LOGO");
		lblToto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblToto.setHorizontalAlignment(SwingConstants.LEFT);
//		panel.add(lblToto, BorderLayout.WEST);


		JLabel image = new JLabel(new ImageIcon("zen.jpg"));
		panelBanner.add(image,BorderLayout.WEST);

				//Set top banner Options
		JPanel panelOptions = new JPanel();
		panelBanner.add(panelOptions, BorderLayout.EAST);
		panelOptions.setLayout(new GridLayout(3, 1, 0, 0));

				//Set top banner option parameter initalisation
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
		JLabel lblSbTitle = new JLabel("Category Creation");
		lblSbTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSbTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblSbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBannerCenter.add(lblSbTitle, BorderLayout.CENTER);
		
		//Center Center
		JPanel categoryPan = new JPanel();
		categoryPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(categoryPan, BorderLayout.CENTER);
		
		//name
		
			//label
		JLabel lblName =new JLabel("Name : ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		categoryPan.add(lblName, gbc_lblName);

			//textfield
		final JTextField txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		txtFName.setColumns(15);
		categoryPan.add(txtFName, gbc_txtFName);

		
		
		//description	
		
			//label
		JLabel lblDescription =new JLabel("Description : ");
		GridBagConstraints gbc_lbldescription = new GridBagConstraints();
		gbc_lbldescription.gridx = 0;
		gbc_lbldescription.gridy = 2;
		categoryPan.add(lblDescription, gbc_lbldescription);
	
			//JTextArea
		final JTextArea txtADescription = new JTextArea();
		GridBagConstraints gbc_txtADescription = new GridBagConstraints();
		gbc_txtADescription.gridx = 2;
		gbc_txtADescription.gridy = 2;
		txtADescription.setColumns(15);
		txtADescription.setRows(4);
		categoryPan.add(txtADescription, gbc_txtADescription);
		
		//levelCategory
		
			//label
		JLabel lblLevelCategory =new JLabel("Level : ");
		GridBagConstraints gbc_lblLevelCategory = new GridBagConstraints();
		gbc_lblLevelCategory.gridx = 0;
		gbc_lblLevelCategory.gridy = 3;
		categoryPan.add(lblLevelCategory, gbc_lblLevelCategory);
		
			//ComboBox
		
		Object[] elements = new Object[]{"Category", "Sub Category"};
		GridBagConstraints gbc_cBoxLevelCategory = new GridBagConstraints();
		gbc_cBoxLevelCategory.gridx = 2;
		gbc_cBoxLevelCategory.gridy = 3;		
		final JComboBox cBoxLevelCategory = new JComboBox(elements);
		
		categoryPan.add(cBoxLevelCategory, gbc_cBoxLevelCategory);
			
		
		//fatherCategory
		
			//label
		final JLabel lblfatherCategory =new JLabel("Category : ");
		GridBagConstraints gbc_lblfatherCategory= new GridBagConstraints();
		gbc_lblfatherCategory.gridx = 0;
		gbc_lblfatherCategory.gridy = 4;
		categoryPan.add(lblfatherCategory, gbc_lblfatherCategory);
		lblfatherCategory.setVisible(false);
		contentPaneCenter.add(categoryPan, BorderLayout.CENTER);
		
			//Liste
		
		final ArrayList<CategoryProduct> categories = (ArrayList<CategoryProduct>) FacadeBL.getCategories().getListCategoryProduct();
		final ArrayList<String> categoriesNames = new ArrayList<String>();
		for (int i=0;i<categories.size();i++)
		{
			categoriesNames.add(categories.get(i).getNameCategory());
		}
		final JList listFatherCategory = new JList(categoriesNames.toArray());
		GridBagConstraints gbc_listFatherCategory= new GridBagConstraints();
		gbc_listFatherCategory.gridx = 2;
		gbc_listFatherCategory.gridy = 4;
		listFatherCategory.setVisible(false);
		categoryPan.add(listFatherCategory, gbc_listFatherCategory);
		
		//Center South
		JPanel validationPan = new JPanel();
		validationPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(validationPan, BorderLayout.SOUTH);
			
			//Cancel
		JButton btnCancel =new JButton("Cancel");
		GridBagConstraints gbc_btnCancel= new GridBagConstraints();
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 5;
		categoryPan.add(btnCancel, gbc_btnCancel);
		
			//Submit
		JButton btnSubmit=new JButton("Submit");
		GridBagConstraints gbc_btnSubmit= new GridBagConstraints();
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 5;
		categoryPan.add(btnSubmit, gbc_btnSubmit);
		
		//Listeners
		
				//ComboBox Listeners
		ActionListener cBoxLevelCategoryListeners = new ActionListener ()
		{
		
			public void actionPerformed(ActionEvent arg0) 
			{
				if (cBoxLevelCategory.getSelectedItem().equals("Sub Category"))
				{
					lblfatherCategory.setVisible(true);
					listFatherCategory.setVisible(true);
				}
				if (cBoxLevelCategory.getSelectedItem().equals("Category"))
				{
					lblfatherCategory.setVisible(false);
					listFatherCategory.setVisible(false);
				}
			}
			
		}
		;
		cBoxLevelCategory.addActionListener(cBoxLevelCategoryListeners);
		
			//btnCancelListeners
			
		ActionListener btnCancelListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				CategoryUI CategoryUI = null;
				try {
					CategoryUI = new CategoryUI();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CategoryUI.setVisible(true);
				dispose();
				
				
			}
		};
		btnCancel.addActionListener(btnCancelListeners);
		
			//btnSubmitListeners
			
		ActionListener btnSubmitListeners = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (cBoxLevelCategory.getSelectedItem().equals("Sub Category"))
				{				
					//int idCatGen = facadeBL.generateId();
					facadeBL.createCategory(txtFName.getText(), txtADescription.getText(), 1, categories.get(listFatherCategory.getSelectedIndex()).getIdCategoryProduct());
				}
				if (cBoxLevelCategory.getSelectedItem().equals("Category"))
				{
					//int idCatGen = facadeBL.generateId();
					facadeBL.createCategory(txtFName.getText(), txtADescription.getText(), 0, -1);
				}
				CategoryUI CategoryUI = null;
				try {
					CategoryUI = new CategoryUI();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CategoryUI.setVisible(true);
				CategoryUI.setLocationRelativeTo(null);
				dispose();
				
				
			}
		};
		btnSubmit.addActionListener(btnSubmitListeners);


	}

}