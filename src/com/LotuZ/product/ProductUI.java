package com.LotuZ.product;

import interfaceDeBase.Bandeau;
import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.activity.Activity;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

import javax.swing.ImageIcon;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ProductUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNameProduct;
	private JTextField tfPrice;
	private JTextField tfQuantity;
	private JTextField tfReduction;
	private JLabel lblCategoryid;
	private JTextField tfCategory;

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
					ProductUI frame = new ProductUI();
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
	public ProductUI() throws SQLException, UserNotFoundException {
		
		
		FacadeUser.login("jack","jack");
		final Product product = FacadeBL.loadProduct(18564);
		User user1 = UserLog.getUserLog();
		Bandeau bandeau = new Bandeau();

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(bandeau.createBandeau(user1, "Consultation d'un produit"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Name:");
		lblNewLabel.setBounds(144, 84, 90, 14);
		panel.add(lblNewLabel);
		
		tfNameProduct = new JTextField(product.getProductName());
		//tfNameProduct.setText(product.getProductName());
		tfNameProduct.setBounds(243, 81, 86, 20);
		panel.add(tfNameProduct);
		tfNameProduct.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Price (\u20AC):");
		lblNewLabel_1.setBounds(144, 121, 52, 14);
		panel.add(lblNewLabel_1);
		
		tfPrice = new JTextField(Integer.toString(product.getPrice()));
		tfPrice.setColumns(10);
		tfPrice.setBounds(243, 118, 86, 20);
		panel.add(tfPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(144, 162, 52, 14);
		panel.add(lblQuantity);
		
		tfQuantity = new JTextField(Integer.toString(product.getQuantity()));
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(243, 159, 86, 20);
		panel.add(tfQuantity);
		
		JLabel lblReduction = new JLabel("Reduction (%):");
		lblReduction.setBounds(144, 204, 86, 14);
		panel.add(lblReduction);
		
		tfReduction = new JTextField(Integer.toString(product.getReduction()));
		tfReduction.setColumns(10);
		tfReduction.setBounds(243, 201, 86, 20);
		panel.add(tfReduction);
		
		lblCategoryid = new JLabel("Category(id):");
		lblCategoryid.setBounds(144, 244, 86, 14);
		panel.add(lblCategoryid);
		
		tfCategory = new JTextField(Integer.toString(product.getCategory()));
		tfCategory.setColumns(10);
		tfCategory.setBounds(240, 241, 86, 20);
		panel.add(tfCategory);
		
		final JButton btnEdit = new JButton("Edit");
		
		tfNameProduct.setEditable(false);
		tfPrice.setEditable(false);
		tfQuantity.setEditable(false);
		tfReduction.setEditable(false);
		tfCategory.setEditable(false);
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (btnEdit.getText().equals("Edit")){
					btnEdit.setText("Validate");
					tfNameProduct.setEditable(true);
					tfPrice.setEditable(true);
					tfQuantity.setEditable(true);
					tfReduction.setEditable(true);
					tfCategory.setEditable(true);
				}
				else if(btnEdit.getText().equals("Validate")){
					btnEdit.setText("Edit");
					try {
						FacadeBL.UploadProduct(product, tfNameProduct.getText(),product.getCategory(),product.getQuantity(),product.getPrice(),product.getReduction());
						tfNameProduct.setEditable(false);
						tfPrice.setEditable(false);
						tfQuantity.setEditable(false);
						tfReduction.setEditable(false);
						tfCategory.setEditable(false);
						// TODO alert boite
						System.out.println("Activity updaté");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
			}
		}
		});
		
		btnEdit.setBounds(155, 361, 89, 23);
		panel.add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("retour vers page précédente");
				
			}
		});
		btnCancel.setBounds(291, 361, 89, 23);
		panel.add(btnCancel);
		
		JLabel label = new JLabel("");
		label.setBounds(390, 84, 46, 14);
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Created:");
		lblNewLabel_2.setBounds(390, 61, 60, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblUpdated = new JLabel("Updated:");
		lblUpdated.setBounds(390, 96, 60, 14);
		panel.add(lblUpdated);

		JLabel lblNewLabel_4 = new JLabel(product.getCreationDate().toString());
		lblNewLabel_4.setBounds(460, 61, 90, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(product.getUpdateDate().toString());
		lblNewLabel_5.setBounds(460, 96, 96, 14);
		panel.add(lblNewLabel_5);

	}
}
