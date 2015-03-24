package com.LotuZ.product.category.ui;

import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

/**
 * @author Loïc
 *
 */

public class CategoryUI extends JFrame {

	private FacadeBL facadeBL;
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
					CategoryUI frame = new CategoryUI();
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
	public CategoryUI() throws SQLException, UserNotFoundException {
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
		JPanel categoryPan = new JPanel();
		categoryPan.setLayout(new GridBagLayout());

		//JListe Category
		ArrayList<CategoryProduct> categories = (ArrayList<CategoryProduct>) FacadeBL.getCategories().getListCategoryProduct();
		final ArrayList<String> categoriesNames = new ArrayList<String>();
		for (int i=0;i<categories.size();i++)
		{
			categoriesNames.add(categories.get(i).getNameCategory());
		}
		
		
		final JList jListCategories = new JList(categoriesNames.toArray());
		
		GridBagConstraints gbc_jListCategories= new GridBagConstraints();
		gbc_jListCategories.gridx = 0;
		gbc_jListCategories.gridy = 1;		
		jListCategories.setVisible(true);
		categoryPan.add(jListCategories, gbc_jListCategories);
		
			//Button Add
		
		JButton btnAddCat = new JButton("Add");
		GridBagConstraints gbc_btnAddCat= new GridBagConstraints();
		gbc_btnAddCat.gridx = 1;
		gbc_btnAddCat.gridy = 1;		
		btnAddCat.setVisible(true);
		categoryPan.add(btnAddCat, gbc_btnAddCat);
		
			//Button View
		
		JButton btnViewCat = new JButton("View");
		GridBagConstraints gbc_btnViewCat= new GridBagConstraints();
		gbc_btnViewCat.gridx = 1;
		gbc_btnViewCat.gridy = 2;		
		btnViewCat.setVisible(true);
		categoryPan.add(btnViewCat, gbc_btnViewCat);
		
			//Button Remove
		
		final JButton btnRemoveCat = new JButton("Remove");
		GridBagConstraints gbc_btnRemoveCat= new GridBagConstraints();
		gbc_btnRemoveCat.gridx = 1;
		gbc_btnRemoveCat.gridy = 3;		
		btnRemoveCat.setVisible(true);
		categoryPan.add(btnRemoveCat, gbc_btnRemoveCat);
		
		//Listeners
		
			//btnAddCatListeners
		
	ActionListener btnAddCatListeners = new ActionListener() 
	{
		
		public void actionPerformed(ActionEvent e)
		{
			CreateCategoryUI add = null;
			try {
				add = new CreateCategoryUI();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			add.setVisible(true);
			dispose();
			
			
		}
	};
	
		btnAddCat.addActionListener(btnAddCatListeners);
		
			//btnViewCatListeners
		
	ActionListener btnAddViewListeners = new ActionListener() 
	{
		
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Coucou");
			ViewCategoryUI ViewCategoryUI = null;
			try {
				ViewCategoryUI = new ViewCategoryUI();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ViewCategoryUI.setVisible(true);
			dispose();
			
			
		}
	};
	btnViewCat.addActionListener(btnAddViewListeners);
	
		//btnRemoveCatListeners
		
	ActionListener btnRemoveCatListeners = new ActionListener() 
	{
	
		public void actionPerformed(ActionEvent e) 
		{
			if (!jListCategories.getSelectedValue().equals(null))
			{		
				//Suppression de l'élement sélection de la liste des sous category
				categoriesNames.remove(jListCategories.getSelectedValue());
				jListCategories.setListData(categoriesNames.toArray());
			}
			if (categoriesNames.isEmpty())
			{
				btnRemoveCat.setVisible(false);			
			}
		}
	};
	btnRemoveCat.addActionListener(btnRemoveCatListeners);
		
		
		

		

				//set ScrollPan
		JScrollPane scrollPpanelCategory = new JScrollPane(categoryPan);
//		scrollPpanelCategory.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(scrollPpanelCategory, BorderLayout.CENTER);
					//add  JScrollBar
		JScrollBar scrollBarEast = new JScrollBar();
		scrollPpanelCategory.add(scrollBarEast);
		
			//South
	}


}
