package com.LotuZ.product;

import interfaceDeBase.Bandeau;
import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserDetailUI;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.bl.ListActivityLeader;
import com.LotuZ.user.user.bl.User;

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListProductUI extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;

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
					ListProductUI frame = new ListProductUI();
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
	public ListProductUI() throws SQLException, UserNotFoundException {
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
		contentPane.add(bandeau.createBandeau(user, "Liste Produit"), BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Cr�ation de la list 

		ListCategoryProduct listCategoryProduct = FacadeBL.getCategories();
		List<Product> listProduct = FacadeBL.getAllProducts(12);

		List<Product> products = new ArrayList<Product>();
		for(int i = 0; i < listProduct.size(); i++)
		{
			products.add(listProduct.get(i)); 
		}

		System.out.println(products);


		list = new JList(new Vector<Product>(products));
		list.setVisibleRowCount(15);
		list.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Product) {
					// Here value will be of the Type 'CD'
					((JLabel) renderer).setText(((Product) value).getProductName());
				}
				return renderer;
			}
		});


		list.setBounds(44, 26, 251, 384);
		panel.add(list);

		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			private Product product;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selected[] = list.getSelectedIndices();
				for (int i = 0; i < selected.length; i++) {
					Product element = (Product) list.getModel()
							.getElementAt(selected[i]);
					System.out.println("  " + element.getProductName());
					this.product = (Product)element;
				}
				ProductUI pageProduct;

				try {
					pageProduct = new ProductUI(this.product.getCategory());
					pageProduct.setVisible(true);
					pageProduct.setLocationRelativeTo(null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		btnNewButton.setBounds(351, 162, 89, 23);
		panel.add(btnNewButton);
}	
}
