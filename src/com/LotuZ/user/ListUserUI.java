package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




import com.LotuZ.inscription.InscriptionUserUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.admin.ui.HomepageAdmin;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;




import java.awt.Component;
import java.awt.Dimension;


public class ListUserUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<User> list;
	private JButton btnCancel;
	private JButton btnInscription;



	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public ListUserUI(int idRole) throws SQLException, UserNotFoundException {
		
		User user = UserLog.getUserLog();

		// Initialisation du bandeau et création de la Frame
		contentPane = new JPanel();
		Bandeau bandeau = new Bandeau();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Zen Lounge");
		setBounds(300,800, 750, 600);

		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(bandeau.createBandeau(user, "Détail Utilisateur"), BorderLayout.NORTH);
		
		// Création contenu de la frame
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 50));
		
		
		
		/*
		 * Création du contenu de la List 
		 */
		
		
		// Création de la list 
		List<User> listUser = null;
		if (idRole == 1)
		{
			ListUser listMembers = FacadeUser.getMembers();
			listUser = listMembers.getListUser();
		}
		else if (idRole == 2)
		{
			ListUser listContributors = FacadeUser.getContributors();
			listUser = listContributors.getListUser();
		}
		else if (idRole == 3)
		{
			ListUser listLeaders = FacadeUser.getLeaders();
			listUser = listLeaders.getListUser();
		}
		else if (idRole == 4)
		{
			ListUser listUsers = FacadeUser.getUsers();
			listUser = listUsers.getListUser();
		}


	    list = new JList<User>(new Vector<User>(listUser));
        list.setVisibleRowCount(10);
        list.setCellRenderer(new DefaultListCellRenderer() {
 
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof User) {
                    ((JLabel) renderer).setText(((User) value).getLastName()+" "+((User) value).getFirstName());
                }
                return renderer;
            }
        });

		panel.add(list);
		list.setPreferredSize(new Dimension(500, 300));

		list.setVisibleRowCount(10);
		
		
		
		/*
		 * Gestion des boutons 
		 */
		

		
		btnInscription = new JButton("Registration");
		btnInscription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InscriptionUI inscription;

				try {
					inscription = new InscriptionUI();
					inscription.setVisible(true);
					inscription.setLocationRelativeTo(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				dispose();
			}
		});
		panel.add(btnInscription);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomepageAdmin homepage;
				try {
					homepage = new HomepageAdmin();
					homepage.setVisible(true);
					homepage.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UserNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnCancel);
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter()  {
			private User user;

			public void mouseClicked(MouseEvent arg0){
			      int selected[] = list.getSelectedIndices();

			      for (int i = 0; i < selected.length; i++) {
			        User element = (User) list.getModel().getElementAt(selected[i]);
			        this.user = (User)element;
			      }
			      if (user != null)
			      {
					UserDetailUI pageAcceuil = null;
					
					try {
						pageAcceuil = new UserDetailUI(this.user.getMail());
						pageAcceuil.setVisible(true);
						pageAcceuil.setLocationRelativeTo(null);
						dispose();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UserNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      }
			      else 
			      {
						JOptionPane.showMessageDialog(null,"Please, select a user","Please, select a user",JOptionPane.ERROR_MESSAGE);

			      }
			    }
		});
		panel.add(btnEdit);

		
		
		
	}
}