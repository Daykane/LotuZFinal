package com.LotuZ.product;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.payment.PaymentUI;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;



import javax.swing.JLabel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



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
	private int idCat;

	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public ProductUI(int idProduct, int idCategory) throws SQLException, UserNotFoundException {
		//creation du bandeau 
		idCat = idCategory;
		final Product product = FacadeBL.loadProduct(idProduct);
		
		User user1 = UserLog.getUserLog();
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
		contentPane.add(bandeau.createBandeau(user1, "Consultation d'un produit"), BorderLayout.NORTH);
		
		//central panel
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//label product name
		JLabel lblNewLabel = new JLabel("Product Name:");
		lblNewLabel.setBounds(112, 84, 121, 14);
		panel.add(lblNewLabel);
		
		//textfield product name
		tfNameProduct = new JTextField(product.getProductName());
		tfNameProduct.setBounds(264, 81, 86, 20);
		panel.add(tfNameProduct);
		tfNameProduct.setColumns(10);
		
		//label price
		JLabel lblNewLabel_1 = new JLabel("Price (number in €):");
		lblNewLabel_1.setBounds(112, 121, 121, 14);
		panel.add(lblNewLabel_1);
		
		//textfield price
		tfPrice = new JTextField(Integer.toString(product.getPrice()));
		tfPrice.setColumns(10);
		tfPrice.setBounds(264, 118, 86, 20);
		panel.add(tfPrice);
		
		//label quantity
		JLabel lblQuantity = new JLabel("Quantity (number):");
		lblQuantity.setBounds(112, 162, 121, 14);
		panel.add(lblQuantity);
		
		//textfield quantity
		tfQuantity = new JTextField(Integer.toString(product.getQuantity()));
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(264, 159, 86, 20);
		panel.add(tfQuantity);
		
		//label reduction
		JLabel lblReduction = new JLabel("Reduction (number in %):");
		lblReduction.setBounds(112, 204, 142, 14);
		panel.add(lblReduction);
		
		//textfield reduction
		tfReduction = new JTextField(Integer.toString(product.getReduction()));
		tfReduction.setColumns(10);
		tfReduction.setBounds(264, 201, 86, 20);
		panel.add(tfReduction);
		
		//label id category
		lblCategoryid = new JLabel("Category(id):");
		lblCategoryid.setBounds(112, 244, 121, 14);
		panel.add(lblCategoryid);
		
		//textfield id category
		tfCategory = new JTextField(Integer.toString(product.getCategory()));
		tfCategory.setColumns(10);
		tfCategory.setBounds(264, 241, 86, 20);
		panel.add(tfCategory);
		
		//button EDIT
		
		final JButton btnEdit = new JButton("Edit");
		
		tfNameProduct.setEditable(false);
		tfPrice.setEditable(false);
		tfQuantity.setEditable(false);
		tfReduction.setEditable(false);
		tfCategory.setEditable(false);
		btnEdit.addMouseListener(new MouseAdapter() {
			
			//when we click on EDIT
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
						Date updateDate = new Date();
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						FacadeBL.UpdateProduct(product, tfNameProduct.getText(),Integer.parseInt(tfCategory.getText()),Integer.parseInt(tfQuantity.getText()),Integer.parseInt(tfPrice.getText()),Integer.parseInt(tfReduction.getText()),dateFormat.format(updateDate));
						
						tfNameProduct.setEditable(false);
						tfPrice.setEditable(false);
						tfQuantity.setEditable(false);
						tfReduction.setEditable(false);
						tfCategory.setEditable(false);
						//a message to inform that the product is edited
						JOptionPane.showMessageDialog(null,"Product edited","Product edited",JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException e) {
						e.printStackTrace();
					}				
			}
		}
		});
		
		// button EDIT added to the panel center
		btnEdit.setBounds(212, 361, 89, 23);
		panel.add(btnEdit);
		
		//button CANCEL
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			
			//when we click on CANCEL
			@Override
			public void mouseClicked(MouseEvent e) {
				ListProductUI pageListProductUI = null;
					try {
						pageListProductUI = new ListProductUI(idCat);
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (UserNotFoundException e1) {
						e1.printStackTrace();
					}
					pageListProductUI.setVisible(true);
					pageListProductUI.setLocationRelativeTo(null);		
					dispose();
			}
	
		});
		
		//button  CANCEL added to the central panel
		btnCancel.setBounds(312, 361, 89, 23);
		panel.add(btnCancel);
		
		//panel creationDate
		JLabel lblNewLabel_2 = new JLabel("Created:");
		lblNewLabel_2.setBounds(390, 61, 60, 14);
		panel.add(lblNewLabel_2);
		
		//panel updateDate
		JLabel lblUpdated = new JLabel("Updated:");
		lblUpdated.setBounds(390, 96, 60, 14);
		panel.add(lblUpdated);

		//label creationDate
		JLabel lblNewLabel_4 = new JLabel(product.getCreationDate().toString());
		lblNewLabel_4.setBounds(460, 61, 90, 14);
		panel.add(lblNewLabel_4);
		
		//label updateDate
		JLabel lblNewLabel_5 = new JLabel(product.getUpdateDate().toString());
		lblNewLabel_5.setBounds(460, 96, 96, 14);
		panel.add(lblNewLabel_5);
		
		//button DELETE
		
		JButton btnNewButton = 
				new JButton("Delete");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			//when we click on DELETE
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					FacadeBL.deleteProduct(product.getId());
					//a message to inform that the product is deleted
					JOptionPane.showMessageDialog(null,"Product deleted","Product deleted",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		//button DELETE added to the central panel
		btnNewButton.setBounds(112, 361, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaymentUI paymentUI = null;
				try {
					paymentUI = new PaymentUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					e1.printStackTrace();
				}
				paymentUI.setVisible(true);
				paymentUI.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnBuy.setBounds(411, 361, 89, 23);
		panel.add(btnBuy);

	}
}
