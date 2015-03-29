package com.LotuZ.product.category.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class EditCategoryUI extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FacadeBL facadeBl;
	CategoryProduct categorySelected;
	

	/**
	 * Launch the application.
	 */



	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public EditCategoryUI(CategoryProduct categorySel) throws SQLException, UserNotFoundException 
	{
		categorySelected = FacadeBL.getCategory(categorySel.getIdCategoryProduct());
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
		JLabel lblSbTitle = new JLabel("Edit Category");
		lblSbTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSbTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblSbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBannerCenter.add(lblSbTitle, BorderLayout.CENTER);
		
		//Center Center
		final JPanel categoryPan = new JPanel();
		categoryPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(categoryPan, BorderLayout.CENTER);
		
		
		//name
		
			//label
		JLabel lblName =new JLabel("Name : ");
		lblName.setVisible(true);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		categoryPan.add(lblName, gbc_lblName);

			//textfield
		final JTextField txtFName = new JTextField(categorySelected.getNameCategory());
		txtFName.setVisible(true);
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		txtFName.setColumns(15);
		txtFName.setEditable(true);
		categoryPan.add(txtFName, gbc_txtFName);

		
		
		//description	
		
			//label
		JLabel lblDescription =new JLabel("Description : ");
		lblDescription.setVisible(true);
		lblDescription.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_lbldescription = new GridBagConstraints();
		gbc_lbldescription.gridx = 0;
		gbc_lbldescription.gridy = 2;
		categoryPan.add(lblDescription, gbc_lbldescription);
	
			//textfield
		final JTextArea txtADescription = new JTextArea(categorySelected.getDecriptionCategory());
		txtADescription.setVisible(true);
		GridBagConstraints gbc_txtADescription = new GridBagConstraints();
		gbc_txtADescription.gridx = 2;
		gbc_txtADescription.gridy = 2;
		txtADescription.setColumns(15);
		txtADescription.setRows(5);
		txtADescription.setEditable(true);
		categoryPan.add(txtADescription, gbc_txtADescription);
		
			//levelCategory
			
			//label
		JLabel lblLevelCategory =new JLabel("Level : ");
		lblLevelCategory.setVisible(true);
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
		cBoxLevelCategory.setVisible(true);
		cBoxLevelCategory.setSelectedItem(categorySelected.getLevelCategory());
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
		
			//JComboBoxFCat
		final ArrayList<CategoryProduct> categories = (ArrayList<CategoryProduct>) FacadeBL.getCategories().getListCategoryProduct();
		categories.remove(categorySelected); //Suppression de la categorie selectionne dans la liste des categoris a afficher
		final ArrayList<String> categoriesNames = new ArrayList<String>();
		for (int i=0;i<categories.size();i++)
		{
			categoriesNames.add(categories.get(i).getNameCategory());
		}
		GridBagConstraints gbc_cBoxChooseFCat = new GridBagConstraints();
		gbc_cBoxChooseFCat.gridx = 2;
		gbc_cBoxChooseFCat.gridy = 4;		
		final JComboBox cBoxFCat = new JComboBox(categoriesNames.toArray());
		cBoxFCat.setVisible(false);
		categoryPan.add(cBoxFCat, gbc_cBoxChooseFCat);
		
		//subCategory
			
			//label
		final JLabel lblSubCategory =new JLabel("Sub Category : ");
		GridBagConstraints gbc_lblSubCategory= new GridBagConstraints();
		gbc_lblSubCategory.gridx = 0;
		gbc_lblSubCategory.gridy = 4;
		categoryPan.add(lblSubCategory, gbc_lblSubCategory);
		lblSubCategory.setVisible(false);
		contentPaneCenter.add(categoryPan, BorderLayout.CENTER);
		
			//Liste
		final ArrayList<CategoryProduct> subCategoriesOfSelCat = (ArrayList<CategoryProduct>) FacadeBL.getSubCategories(categorySelected.getIdCategoryProduct()).getListCategoryProduct();
		final ArrayList<String> subCategoriesOfSelCatNames = new ArrayList<String>();
		for (int i=0;i<subCategoriesOfSelCat.size();i++)
		{
			subCategoriesOfSelCatNames.add(subCategoriesOfSelCat.get(i).getNameCategory());
		}
		final JList jlistSubCategoryOfSelCat = new JList(subCategoriesOfSelCatNames.toArray());
		final GridBagConstraints gbc_listSubCategory= new GridBagConstraints();
		gbc_listSubCategory.gridx = 2;
		gbc_listSubCategory.gridy = 4;
		jlistSubCategoryOfSelCat.setVisible(false);
		categoryPan.add(jlistSubCategoryOfSelCat, gbc_listSubCategory);
		
			//ButtonRemoveSubCat
		final JButton btnRemoveSubCat = new JButton("Remove");
		GridBagConstraints gbc_btnRemoveSubCat= new GridBagConstraints();
		gbc_btnRemoveSubCat.gridx = 3;
		gbc_btnRemoveSubCat.gridy = 4;
		btnRemoveSubCat.setVisible(false);
		categoryPan.add(btnRemoveSubCat, gbc_btnRemoveSubCat);
		
			//JComboBoxSubCat
		final ArrayList<CategoryProduct> subCategories = (ArrayList<CategoryProduct>) FacadeBL.getSubCategories().getListCategoryProduct();
		for (int i=0;i<subCategoriesOfSelCat.size();i++)
		{
			for (int j=0; j<subCategories.size();j++)
			{
				if (subCategories.get(j).getIdCategoryProduct() == subCategoriesOfSelCat.get(i).getIdCategoryProduct())
				{
					subCategories.remove(subCategories.get(j));
				}
			}

		}
		final ArrayList<String> subCategoriesNames = new ArrayList<String>();
		for (int i=0;i<subCategories.size();i++)
		{
			subCategoriesNames.add(subCategories.get(i).getNameCategory());
		}
		GridBagConstraints gbc_cBoxAddSubCat = new GridBagConstraints();
		gbc_cBoxAddSubCat.gridx = 2;
		gbc_cBoxAddSubCat.gridy = 5;		
		final JComboBox cBoxSubCat = new JComboBox(subCategoriesNames.toArray());
		cBoxSubCat.setVisible(false);
		categoryPan.add(cBoxSubCat, gbc_cBoxAddSubCat);
		
			//ButtonAddSubCat
		final JButton btnAddSubCat = new JButton("Add");
		GridBagConstraints gbc_btnAddSubCat= new GridBagConstraints();
		gbc_btnAddSubCat.gridx = 3;
		gbc_btnAddSubCat.gridy = 5;
		btnAddSubCat.setVisible(false);
		categoryPan.add(btnAddSubCat, gbc_btnAddSubCat);
		
		if (cBoxLevelCategory.getSelectedItem().equals("Sub Category"))
		{
			//FatherCat Visible
			lblfatherCategory.setVisible(true);
			cBoxFCat.setVisible(true);
			
			//SubCat Invisible
			lblSubCategory.setVisible(false);
			jlistSubCategoryOfSelCat.setVisible(false);
			btnRemoveSubCat.setVisible(false);
			cBoxSubCat.setVisible(false);
			btnAddSubCat.setVisible(false);
			
		}
		if (cBoxLevelCategory.getSelectedItem().equals("Category"))
		{

			//FatherCat Invisible
			lblfatherCategory.setVisible(false);
			cBoxFCat.setVisible(false);
			//SubCat Visible
			lblSubCategory.setVisible(true);
			jlistSubCategoryOfSelCat.setVisible(true);
			btnRemoveSubCat.setVisible(true);
			cBoxSubCat.setVisible(true);
			btnAddSubCat.setVisible(true);
		}
		if (subCategories.isEmpty())
		{
			btnAddSubCat.setVisible(false);
			cBoxSubCat.setVisible(false);
		}
		if (subCategoriesOfSelCat.isEmpty())
		{
			jlistSubCategoryOfSelCat.setVisible(false);
			btnRemoveSubCat.setVisible(false);
		}
		
		//Listeners
		
				//cBoxLevelCategoryListeners
		ActionListener cBoxLevelCategoryListeners = new ActionListener ()
		{
		
			public void actionPerformed(ActionEvent arg0) 
			{
				if (cBoxLevelCategory.getSelectedItem().equals("Sub Category"))
				{
					//FatherCat Visible
					lblfatherCategory.setVisible(true);
					cBoxFCat.setVisible(true);
					
					//SubCat Invisible
					lblSubCategory.setVisible(false);
					jlistSubCategoryOfSelCat.setVisible(false);
					btnRemoveSubCat.setVisible(false);
					cBoxSubCat.setVisible(false);
					btnAddSubCat.setVisible(false);
					
				}
				if (cBoxLevelCategory.getSelectedItem().equals("Category"))
				{

					//FatherCat Invisible
					lblfatherCategory.setVisible(false);
					cBoxFCat.setVisible(false);
					//SubCat Visible
					lblSubCategory.setVisible(true);
					jlistSubCategoryOfSelCat.setVisible(true);
					btnRemoveSubCat.setVisible(true);
					cBoxSubCat.setVisible(true);
					btnAddSubCat.setVisible(true);
				}
			}
		};
		cBoxLevelCategory.addActionListener(cBoxLevelCategoryListeners);
		
				//Remove subCategory Listeners
		ActionListener btnRemoveSubCategoryListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				if (!jlistSubCategoryOfSelCat.getSelectedValue().equals(null))
				{
					//Ajout de l'élement sélectionné à la liste des sous category possible
					//categories.add((String) jlistSubCategory.getSelectedValue());
					cBoxSubCat.addItem((String) jlistSubCategoryOfSelCat.getSelectedValue());
					subCategories.add(subCategoriesOfSelCat.get(jlistSubCategoryOfSelCat.getSelectedIndex()));
					subCategoriesNames.add((String) jlistSubCategoryOfSelCat.getSelectedValue());
					
					//Suppression de l'élement sélection de la liste des sous category
					subCategoriesOfSelCatNames.remove(jlistSubCategoryOfSelCat.getSelectedValue());
					subCategoriesOfSelCat.remove(subCategoriesOfSelCat.get(jlistSubCategoryOfSelCat.getSelectedIndex()));
					jlistSubCategoryOfSelCat.setListData(subCategoriesOfSelCatNames.toArray());
					
					//Visibilite des boutons
					btnAddSubCat.setVisible(true);
					cBoxSubCat.setVisible(true);
				}
				if (subCategoriesOfSelCat.isEmpty())
				{
					jlistSubCategoryOfSelCat.setVisible(false);
					btnRemoveSubCat.setVisible(false);		
				}	
				
			}
		};
		btnRemoveSubCat.addActionListener(btnRemoveSubCategoryListeners);
		
				//Add subCategory Listeners
		ActionListener btnAddSubCategoryListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				if(!cBoxSubCat.getSelectedItem().equals(null))
				{
				//Ajout de l'élement sélectionné à la liste des sous category possible
				subCategoriesOfSelCatNames.add((String) cBoxSubCat.getSelectedItem()); //Ajout à la liste des noms des sous categories associe a la category
				subCategoriesOfSelCat.add(subCategories.get(cBoxSubCat.getSelectedIndex())); //Ajout à la liste des sous categories associe a la category
				jlistSubCategoryOfSelCat.setListData(subCategoriesOfSelCatNames.toArray());
				
				//Suppression de l'élement sélection de la liste des sous category
				subCategories.remove(subCategories.get(cBoxSubCat.getSelectedIndex())); // Mise a jour de la liste des sous categories
				subCategoriesNames.remove(subCategories.get(cBoxSubCat.getSelectedIndex())); // Mise a jour de la liste des noms des sous categories
				cBoxSubCat.removeItem((String) cBoxSubCat.getSelectedItem());
				//cBoxSubCat.revalidate();
				//Visibilite des boutton
				jlistSubCategoryOfSelCat.setVisible(true);
				btnRemoveSubCat.setVisible(true);
				}
				if(subCategories.isEmpty())
				{
					cBoxSubCat.setVisible(false);
					btnAddSubCat.setVisible(false);	
				}
						
				
			}
		};
		btnAddSubCat.addActionListener(btnAddSubCategoryListeners);
		
		//Center South
		JPanel validationPan = new JPanel();
		validationPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(validationPan, BorderLayout.SOUTH);
			
			//Cancel
		JButton btnCancel =new JButton("Cancel");
		GridBagConstraints gbc_btnCancel= new GridBagConstraints();
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 6;
		categoryPan.add(btnCancel, gbc_btnCancel);
		
			//Submit
		JButton btnSubmit=new JButton("Submit");
		GridBagConstraints gbc_btnSubmit= new GridBagConstraints();
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 6;
		categoryPan.add(btnSubmit, gbc_btnSubmit);
		
		//btnCancelListeners
		
		ActionListener btnCancelListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				CategoryUI CategoryUI;
				try {
					CategoryUI = new CategoryUI();
					CategoryUI.setVisible(true);
					CategoryUI.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		};
		btnCancel.addActionListener(btnCancelListeners);
		
		//btnSubmitListeners
		
		ActionListener btnSubmitListeners = new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				//Mise a jour des données
				if (cBoxLevelCategory.getSelectedItem().equals("Category"))
				{
					try 
					{
						CategoryProduct CaSelToUpdate = FacadeBL.getCategory((categorySelected.getIdCategoryProduct()));
						CaSelToUpdate.update((categorySelected.getIdCategoryProduct()), txtFName.getText(), txtADescription.getText(), 0, -1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i=0; i<subCategoriesOfSelCat.size();i++)
					{
						CategoryProduct subCatOfSelCatToUpdate = FacadeBL.getCategory(subCategoriesOfSelCat.get(i).getIdCategoryProduct());
						try {
							subCatOfSelCatToUpdate.update(subCategoriesOfSelCat.get(i).getIdCategoryProduct(), subCategoriesOfSelCat.get(i).getNameCategory(), subCategoriesOfSelCat.get(i).getDecriptionCategory(), 1, categorySelected.getIdCategoryProduct());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					for (int i=0; i<subCategories.size();i++)
					{
						CategoryProduct subCatToUpdate = FacadeBL.getCategory(subCategories.get(i).getIdCategoryProduct());
						if (subCategories.get(i).getFactherCategory() == categorySelected.getIdCategoryProduct())
						{
							try {
								subCatToUpdate.update(subCategories.get(i).getIdCategoryProduct(), subCategories.get(i).getNameCategory(), subCategories.get(i).getDecriptionCategory(), 1, 0);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
				if (cBoxLevelCategory.getSelectedItem().equals("Sub Category"))
				{
					CategoryProduct CaSelToUpdate = FacadeBL.getCategory(categorySelected.getIdCategoryProduct());
					try {
						CaSelToUpdate.update((categorySelected.getIdCategoryProduct()), txtFName.getText(), txtADescription.getText(), 1, categories.get(cBoxFCat.getSelectedIndex()).getIdCategoryProduct());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				//Retour à la page CategoryUI
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