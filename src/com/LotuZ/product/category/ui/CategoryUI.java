package com.LotuZ.product.category.ui;

import interfaceDeBase.Bandeau;
import interfaceDeBase.PageAccueiltest;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.DefaultListCellRenderer;
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
import com.LotuZ.user.FacadeUser;
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
	
	public CategoryUI() throws SQLException, UserNotFoundException 
	{
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
		contentPane.add(bandeau.createBandeau(user, "CATEGORY MANAGEMENT"), BorderLayout.NORTH);
			//Center
		JPanel categoryPan = new JPanel();
		categoryPan.setLayout(new GridBagLayout());

		//JListe Category
		final ArrayList<CategoryProduct> categories = (ArrayList<CategoryProduct>) FacadeBL.getAllCategories().getListCategoryProduct();
		final ArrayList<String> categoriesNames = new ArrayList<String>();
//		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//			Component renderer =  super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus)
//		    setText(entry.getTitle());
//		    setIcon(entry.getImage());
//		    if (isSelected) {
//		      setBackground(HIGHLIGHT_COLOR);
//		      setForeground(Color.white);
//		    } else {
//		      setBackground(Color.white);
//		      setForeground(Color.black);
//		    }
//		    return this;
//		  }	
		
//		 Création de la list ListActivityLeader listActivityLeader = FacadeBL.getActivityLeaders(); 
//		List<User> listUser = listActivityLeader.getListActivityLeader(); 
//		List<User> users = new ArrayList<User>(); 
//		for(int i = 0; i < listUser.size(); i++) { users.add(listUser.get(i)); } 
//		list = new JList(new Vector<User>(users)); 
//		list.setVisibleRowCount(10); 
//		list.setCellRenderer(new DefaultListCellRenderer() 
//		{ 
//		@Override 
//		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
//		{ 
//			Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
//			if (renderer instanceof JLabel && value instanceof User) 
//			{ 
//				// Here value will be of the Type 'CD' 
//				((JLabel) renderer).setText(((User) value).getLastName()+" "+((User) value).getFirstName()); 
//				} return renderer; 
//				} 
//		});
//		}
//		}
		
		for (int i=0;i<categories.size();i++)
		{
			categoriesNames.add(categories.get(i).getNameCategory());
		}
		
		
		final JList jListCategories = new JList(categories.toArray());
		jListCategories.setCellRenderer(new DefaultListCellRenderer() 
		{ 
		@Override 
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
		{ 
			Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
			if (renderer instanceof JLabel && value instanceof CategoryProduct) 
			{ 
				// Here value will be of the Type 'CD' 
				((JLabel) renderer).setText(((CategoryProduct) value).getNameCategory()+" "+((CategoryProduct) value).getDecriptionCategory()); 
				if (((CategoryProduct) value).getLevelCategory()==0)
				{
					setIcon(new ImageIcon("notif.png"));
				}
				else
				{
					setIcon(new ImageIcon("notifOpen.png"));
				}
			}	 
			return renderer; 
		} 
		}
		);
		
		
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
			if (jListCategories.getSelectedValue()!=null)
			{
				ViewCategoryUI ViewCategoryUI = null;
				try {
					ViewCategoryUI = new ViewCategoryUI(categories.get(jListCategories.getSelectedIndex()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ViewCategoryUI.setLocationRelativeTo(null);
				ViewCategoryUI.setVisible(true);
				dispose();
			}
			
			
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
				System.out.println(jListCategories.getSelectedIndex()+"-----"+jListCategories.getSelectedValue());
				System.out.println(categoriesNames.get(jListCategories.getSelectedIndex())+"-----"+jListCategories.getSelectedValue());
				FacadeBL.deleteCategory(categories.get(jListCategories.getSelectedIndex()).getIdCategoryProduct());
				for(int i=0;i<categories.size();i++)
				{
					if (categories.get(i).getFactherCategory() == categories.get(jListCategories.getSelectedIndex()).getIdCategoryProduct())
					{
						CategoryProduct subCatOfRemoveCatToUpdate = FacadeBL.getCategory(categories.get(i).getIdCategoryProduct());
						try {
							subCatOfRemoveCatToUpdate.update(categories.get(i).getIdCategoryProduct(), categories.get(i).getNameCategory(), categories.get(i).getDecriptionCategory(), categories.get(i).getLevelCategory(), 0); //0 --> pere inconnu
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				categories.remove(jListCategories.getSelectedIndex());
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