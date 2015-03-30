package com.LotuZ.product;



import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale.Category;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.product.category.ui.CategoryUI;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

import javax.swing.JComboBox;

public class ProductCreateUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFProductName;
	private JTextField TFPrice;
	private JTextField TFQuantity;
	private JTextField TFReduction;
	private final JLabel jlblStatus = new JLabel("Error dans un champ");

	static int count = 0;

	
	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public ProductCreateUI() throws SQLException, UserNotFoundException {

		//creation du bandeau

		User user = UserLog.getUserLog();
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
		contentPane.add(bandeau.createBandeau(user, "Add Product"), BorderLayout.NORTH);

		//panel central
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(null);

		// label NameProduct
		JLabel lblNameProduct = new JLabel("Name Product:");
		lblNameProduct.addMouseListener(new MouseAdapter() {
		});
		lblNameProduct.setBounds(112, 85, 128, 14);
		panelCenter.add(lblNameProduct);

		//textfield ProductName
		TFProductName = new JTextField();
		TFProductName.setBounds(271, 79, 165, 27);
		panelCenter.add(TFProductName);
		TFProductName.setColumns(10);

		//label Price
		JLabel lblPrice = new JLabel("Price: (number in €)");
		lblPrice.setBounds(112, 141, 128, 14);
		panelCenter.add(lblPrice);

		//textfield Price
		TFPrice = new JTextField();
		TFPrice.setColumns(10);
		TFPrice.setBounds(271, 135, 165, 27);
		panelCenter.add(TFPrice);

		//label quantity
		JLabel lblQuantity = new JLabel("Quantity: (number)");
		lblQuantity.setBounds(112, 203, 128, 14);
		panelCenter.add(lblQuantity);

		//textfield quatity
		TFQuantity = new JTextField();
		TFQuantity.setColumns(10);
		TFQuantity.setBounds(271, 197, 165, 27);
		panelCenter.add(TFQuantity);
		final ArrayList<CategoryProduct> categories = (ArrayList<CategoryProduct>) FacadeBL.getAllCategories().getListCategoryProduct();
		final ArrayList<String> categoriesNames = new ArrayList<String>();
		final JComboBox comboBox = new JComboBox(categories.toArray());
		comboBox.setRenderer(new DefaultListCellRenderer() 
		{ 
		@Override 
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
		{ 
			Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
			if (renderer instanceof JLabel && value instanceof CategoryProduct) 
			{ 
				// Here value will be of the Type 'CD' 
				((JLabel) renderer).setText(((CategoryProduct) value).getNameCategory()+" "+((CategoryProduct) value).getDecriptionCategory()); 
			}	 
			return renderer; 
		} 
		}
		);
		comboBox.setBounds(271, 313, 165, 20);
		panelCenter.add(comboBox);

		//label category
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(112, 316, 129, 14);
		panelCenter.add(lblCategory);

		//lavel reduction
		JLabel lblReduction = new JLabel("Reduction: (number in %)");
		lblReduction.setBounds(112, 260, 149, 14);
		panelCenter.add(lblReduction);

		//textfield reduction
		TFReduction = new JTextField();
		TFReduction.setColumns(10);
		TFReduction.setBounds(271, 254, 165, 27);
		panelCenter.add(TFReduction);

		//button ADD
		JButton btnADD = new JButton("ADD");
		btnADD.addMouseListener(new MouseAdapter() {

			// when we click on the button
			@Override
			public void mouseClicked(MouseEvent e) {

				// verification of the fields
				if( this.verifyTF() & this.verifyPrice() & this.verifyQuantity() & this.verifyReduction() )
				{
					try
					{
						//the product is added
						Date creationDate = new Date();
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						FacadeBL.product(TFProductName.getText(),Integer.parseInt(TFPrice.getText()),Integer.parseInt(TFQuantity.getText()),categories.get(comboBox.getSelectedIndex()).getIdCategoryProduct(),Integer.parseInt(TFReduction.getText()), dateFormat.format(creationDate));

						//a message to inform that the product is added
						JOptionPane.showMessageDialog(null,"Product added","Product added",JOptionPane.INFORMATION_MESSAGE);
					}
					catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e1) 
					{
						e1.printStackTrace();
					} 
					catch (ClassNotFoundException e1) 
					{
						e1.printStackTrace();
					} catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			}

			/**
			 * to verify that all textfields or not empty
			 * @return
			 */
			private boolean verifyTF() {

				this.TFisempty(TFProductName);
				this.TFisempty(TFPrice);
				this.TFisempty(TFQuantity);
				this.TFisempty(TFReduction);

				if (count>0){
					return false;
				}
				else {
					return true;
				}
			}


			/**
			 * to verify that a textfield is not empty
			 * @param textfield
			 */
			private void TFisempty(JTextField textfield){
				RemoveBorder(textfield);
				String text = textfield.getText();

				if(text.equals("")){
					RedBorder(textfield);
					count++;
				}
			}


			/**
			 * change the border of a textfield in red if it is not well filled
			 * @param textfield
			 */
			private void RedBorder(JTextField textfield){
				jlblStatus.setVisible(true);
				Border border = BorderFactory.createLineBorder(Color.RED, 2);
				textfield.setBorder(border);
			}



			/**
			 * change the border of a textfield in white
			 * @param textfield
			 */
			private void RemoveBorder(JTextField textfield){
				jlblStatus.setVisible(false);
				Border border = BorderFactory.createLineBorder(Color.white, 2);
				textfield.setBorder(border);

			}

			/**
			 * verify if a price is written with numbers
			 * @return
			 */
			private boolean verifyPrice(){
				if (!isNumeric(TFPrice.getText())){
					RedBorder(TFPrice);
					return false;
				};
				return true;
			}

			/**
			 * verify if a quantity is written with numbers
			 * @return
			 */
			private boolean verifyQuantity(){
				if (!isNumeric(TFQuantity.getText())){
					RedBorder(TFQuantity);
					return false;
				};
				return true;
			}


			/**
			 * verify if a reduction is written with numbers
			 * @return
			 */
			private boolean verifyReduction(){
				if (!isNumeric(TFReduction.getText())){
					RedBorder(TFReduction);
					return false;
				};
				return true;
			}


			/**
			 * verify if a string is written with numbers
			 * @param str
			 * @return
			 */
			private boolean isNumeric(String str)  
			{  
				try  
				{  
					Integer.parseInt(str);  
				}  
				catch(Exception e)  
				{  
					return false;  
				}  
				return true;  
			}	

		});
		//the button ADD is added to the center panel
		btnADD.setBounds(190, 451, 89, 23);
		panelCenter.add(btnADD);

		//button CANCEL
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			CategoryUI categoryUI = null;

			//when we click on the button CANCEL
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO renvoyer vers la liste des catégory
				try {
					categoryUI = new CategoryUI();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				categoryUI.setVisible(true);
				categoryUI.setLocationRelativeTo(null);		
				dispose();
			}
		});

		//the button CANCEL is added to the center panel
		btnCancel.setBounds(315, 451, 89, 23);
		panelCenter.add(btnCancel);
		
		


	}


}
