package com.LotuZ.product.category.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

public class EditCategoryUI extends JFrame
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
					EditCategoryUI frame = new EditCategoryUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public EditCategoryUI() throws SQLException, UserNotFoundException {
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
				System.out.println("Connexion ou deconnexion si la personne n'est pas connect� ou l'est");
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
		JPanel categoryPan = new JPanel();
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
		JTextField txtFName = new JTextField();
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
		JTextArea txtADescription = new JTextArea();
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
		Object[] Fcategories = new Object[]{ "Toto","Tata","Titi","Tutu"};
		GridBagConstraints gbc_cBoxChooseFCat = new GridBagConstraints();
		gbc_cBoxChooseFCat.gridx = 2;
		gbc_cBoxChooseFCat.gridy = 4;		
		final JComboBox cBoxFCat = new JComboBox(Fcategories);
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
		String[] listSubCategory = {"one", "two", "three", "four"};
		final JList jlistSubCategory = new JList(listSubCategory);
		GridBagConstraints gbc_listSubCategory= new GridBagConstraints();
		gbc_listSubCategory.gridx = 2;
		gbc_listSubCategory.gridy = 4;
		jlistSubCategory.setVisible(false);
		categoryPan.add(jlistSubCategory, gbc_listSubCategory);
		
			//ButtonRemoveSubCat
		final JButton btnRemoveSubCat = new JButton("Remove");
		GridBagConstraints gbc_btnRemoveSubCat= new GridBagConstraints();
		gbc_btnRemoveSubCat.gridx = 3;
		gbc_btnRemoveSubCat.gridy = 4;
		btnRemoveSubCat.setVisible(false);
		categoryPan.add(btnRemoveSubCat, gbc_btnRemoveSubCat);
		
			//JComboBoxSubCat
		Object[] categories = new Object[]{ "Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet","Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet" };
		GridBagConstraints gbc_cBoxAddSubCat = new GridBagConstraints();
		gbc_cBoxAddSubCat.gridx = 2;
		gbc_cBoxAddSubCat.gridy = 5;		
		final JComboBox cBoxSubCat = new JComboBox(categories);
		cBoxSubCat.setVisible(false);
		categoryPan.add(cBoxSubCat, gbc_cBoxAddSubCat);
		
			//ButtonAddSubCat
		final JButton btnAddSubCat = new JButton("Add");
		GridBagConstraints gbc_btnAddSubCat= new GridBagConstraints();
		gbc_btnAddSubCat.gridx = 3;
		gbc_btnAddSubCat.gridy = 5;
		btnAddSubCat.setVisible(false);
		categoryPan.add(btnAddSubCat, gbc_btnAddSubCat);
		
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
					jlistSubCategory.setVisible(false);
					btnRemoveSubCat.setVisible(false);
					cBoxSubCat.setVisible(false);
					btnAddSubCat.setVisible(false);
					
				}
				if (cBoxLevelCategory.getSelectedItem().equals("Category"))
				{
					System.out.println("Coucou Loïc");
					//FatherCat Invisible
					lblfatherCategory.setVisible(false);
					cBoxFCat.setVisible(false);
					//SubCat Visible
					lblSubCategory.setVisible(true);
					jlistSubCategory.setVisible(true);
					btnRemoveSubCat.setVisible(true);
					cBoxSubCat.setVisible(true);
					btnAddSubCat.setVisible(true);
				}
			}
		};
		cBoxLevelCategory.addActionListener(cBoxLevelCategoryListeners);
		
				//Remove subCategory Listeners
		
				//Add subCategory Listeners
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

	}


}
