package com.LotuZ.product.category.ui;

import java.awt.BorderLayout;
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

/**
 * @author Loïc
 *
 */

public class ViewCategoryUI extends JFrame {

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
					ViewCategoryUI frame = new ViewCategoryUI();
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
	public ViewCategoryUI() throws SQLException, UserNotFoundException {
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
		JLabel lblSbTitle = new JLabel("View Category");
		lblSbTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSbTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblSbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBannerCenter.add(lblSbTitle, BorderLayout.CENTER);
		
		//Center Center
		JPanel categoryPan = new JPanel();
		categoryPan.setLayout(new GridBagLayout());
		contentPaneCenter.add(categoryPan, BorderLayout.CENTER);
		
			//Edit
		
		JButton btnEditCat =new JButton();
		btnEditCat.setIcon(new ImageIcon("edit.png"));
		btnEditCat.setBorder(null);
		GridBagConstraints gbc_btnEditCat = new GridBagConstraints();
		gbc_btnEditCat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditCat.gridx = 3;
		gbc_btnEditCat.gridy = 0;
		categoryPan.add(btnEditCat, gbc_btnEditCat);
		
		//name
		
			//label
		JLabel lblName =new JLabel("Name : ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		categoryPan.add(lblName, gbc_lblName);

			//textfield
		JTextField txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.gridx = 2;
		gbc_txtFName.gridy = 1;
		txtFName.setColumns(15);
		txtFName.setEditable(false);
		categoryPan.add(txtFName, gbc_txtFName);

		
		
		//description	
		
			//label
		JLabel lblDescription =new JLabel("Description : ");
		GridBagConstraints gbc_lbldescription = new GridBagConstraints();
		gbc_lbldescription.gridx = 0;
		gbc_lbldescription.gridy = 2;
		categoryPan.add(lblDescription, gbc_lbldescription);
	
			//JTextArea
		JTextArea txtADescription = new JTextArea();
		GridBagConstraints gbc_txtADescription = new GridBagConstraints();
		gbc_txtADescription.gridx = 2;
		gbc_txtADescription.gridy = 2;
		txtADescription.setColumns(15);
		txtADescription.setRows(4);
		txtADescription.setEditable(false);
		categoryPan.add(txtADescription, gbc_txtADescription);
		
		//levelCategory
		
			//label
		JLabel lblLevelCategory =new JLabel("Level : ");
		GridBagConstraints gbc_lblLevelCategory = new GridBagConstraints();
		gbc_lblLevelCategory.gridx = 0;
		gbc_lblLevelCategory.gridy = 3;
		categoryPan.add(lblLevelCategory, gbc_lblLevelCategory);
		
		
			//textfield
		JTextField txtFLevelCategory = new JTextField("");
		GridBagConstraints gbc_txtFLevelCategory = new GridBagConstraints();
		gbc_txtFLevelCategory.gridx = 2;
		gbc_txtFLevelCategory.gridy = 3;
		txtFLevelCategory.setColumns(15);
		txtFLevelCategory.setEditable(false);
		txtFLevelCategory.setSize(15, 15);
		categoryPan.add(txtFLevelCategory, gbc_txtFLevelCategory);
			
		
		//fatherCategory
		
			//label
		final JLabel lblfatherCategory =new JLabel("Category : ");
		GridBagConstraints gbc_lblfatherCategory= new GridBagConstraints();
		gbc_lblfatherCategory.gridx = 0;
		gbc_lblfatherCategory.gridy = 4;
		categoryPan.add(lblfatherCategory, gbc_lblfatherCategory);
		lblfatherCategory.setVisible(false);
		contentPaneCenter.add(categoryPan, BorderLayout.CENTER);
		
			//textfield
		JTextField txtFFatherCategory = new JTextField();
		GridBagConstraints gbc_txtFFatherCategory = new GridBagConstraints();
		gbc_txtFFatherCategory.gridx = 2;
		gbc_txtFFatherCategory.gridy = 4;
		txtFFatherCategory.setColumns(15);
		txtFFatherCategory.setEditable(false);
		txtFFatherCategory.setSize(15, 15);
		txtFFatherCategory.setVisible(false);
		categoryPan.add(txtFFatherCategory, gbc_txtFFatherCategory);
		
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
		
		if (txtFLevelCategory.getText().equals("Sub Category"))
		{
			System.out.println("Coucou");
			txtFFatherCategory.setVisible(true);
			lblfatherCategory.setVisible(true);
		}
		else if (txtFLevelCategory.getText().equals("Category"))
		{
			System.out.println("Kikoo");
			jlistSubCategory.setVisible(true);
			lblSubCategory.setVisible(true);
		}
			
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
		JButton btnOk=new JButton("Ok");
		GridBagConstraints gbc_btnOk= new GridBagConstraints();
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 5;
		categoryPan.add(btnOk, gbc_btnOk);

	}
}
