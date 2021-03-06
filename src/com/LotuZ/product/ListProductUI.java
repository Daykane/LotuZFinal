package com.LotuZ.product;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Component;
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
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.ui.CategoryUI;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
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
	@SuppressWarnings("rawtypes")
	private JList list;
	private int idCat;

	


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public ListProductUI(int idCategory) throws SQLException, UserNotFoundException {
		idCat = idCategory;
		// creation of the "bandeau"

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
		contentPane.add(bandeau.createBandeau(user, "Liste Produit"), BorderLayout.NORTH);

		//panel central
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		//creation of the list

		List<Product> listProduct = FacadeBL.loadAllProducts(idCategory);
		List<Product> products = new ArrayList<Product>();
		for(int i = 0; i < listProduct.size(); i++)
		{
			products.add(listProduct.get(i)); 
		}

		list = new JList(new Vector<Product>(products));
		list.setVisibleRowCount(15);
		list.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Product) {
					((JLabel) renderer).setText(((Product) value).getProductName());
				}
				return renderer;
			}
		});

		list.setBounds(44, 26, 251, 384);
		panel.add(list);

		// creation of the button VIEW

		JButton btnNewButton = new JButton("View");
		btnNewButton.addMouseListener(new MouseAdapter() {
			private Product product;

			// when we clik on the button VIEW
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
					pageProduct = new ProductUI(this.product.getId(), idCat);
					pageProduct.setVisible(true);
					pageProduct.setLocationRelativeTo(null);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}
				dispose();

			}
		});
		
		btnNewButton.setBounds(351, 162, 89, 23);
		panel.add(btnNewButton);
		
		//creation of the button Cancel

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			
			// when we click on the button Cancel
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CategoryUI categoryUI = null;
				try {
					categoryUI = new CategoryUI();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				categoryUI.setVisible(true);
				categoryUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCancel.setBounds(351, 223, 89, 23);
		panel.add(btnCancel);
	}		
}
