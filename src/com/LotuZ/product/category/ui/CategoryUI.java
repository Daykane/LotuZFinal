package com.LotuZ.product.category.ui;

import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

/**
 * @author Loïc
 *
 */

public class CategoryUI extends JFrame {

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
	    JButton form[][] = new JButton[24][2];
	    String counts[] = { "", "view","delete"};
	    String categories[] = { "Household", "Office", "Extended Family",
	        "Company (US)", "Company (World)", "Team", "Will",
	        "Birthday Card List", "High School", "Country", "Continent",
	        "Planet","Household", "Office", "Extended Family",
	        "Company (US)", "Company (World)", "Team", "Will",
	        "Birthday Card List", "High School", "Country", "Continent",
	        "Planet" };
		JPanel categoryPan = new JPanel();
		categoryPan.setSize(600, 400);
		categoryPan.setLayout(new GridLayout(25, 3, 10, 0));
		for (int row = 0; row < 25; row++) {
		      ButtonGroup bg = new ButtonGroup();
		      for (int col = 0; col < 3; col++) {
		        if (row == 0) {
		        	categoryPan.add(new JLabel(counts[col]));
		        } else {
		          if (col == 0) {
		        	  categoryPan.add(new JLabel(categories[row - 1]));
		          } else {
		            form[row - 1][col - 1] = new JButton();
		            
		            bg.add(form[row - 1][col - 1]);
		            categoryPan.add(form[row - 1][col - 1]);
		          }
		        }
		      }
		    }
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
