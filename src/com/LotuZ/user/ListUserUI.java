package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.PageAccueil;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.admin.ui.HomepageAdmin;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.member.data.MemberJDBC;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;
import com.LotuZ.user.UserLog;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ListUserUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;
	private User user;
	private JButton btnCancel;



	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public ListUserUI(int idRole) throws SQLException, UserNotFoundException {
		

	
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
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 50));
		
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


		List<User> users = new ArrayList<User>();
	    for(int i = 0; i < listUser.size(); i++)
	    {
	    	users.add(listUser.get(i)); 
	    }
		
	    list = new JList(new Vector<User>(users));
        list.setVisibleRowCount(10);
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof User) {
                    // Here value will be of the Type 'CD'
                    ((JLabel) renderer).setText(((User) value).getLastName()+((User) value).getFirstName());
                }
                return renderer;
            }
        });

		panel.add(list);
		list.setPreferredSize(new Dimension(500, 300));

		list.setVisibleRowCount(10);
		
		JButton btnEdit = new JButton("Edit");
		panel.add(btnEdit);
		
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
		btnEdit.addMouseListener(new MouseAdapter()  {
			private User user;

			public void mouseClicked(MouseEvent arg0){
			      int selected[] = list.getSelectedIndices();

			      for (int i = 0; i < selected.length; i++) {
			        User element = (User) list.getModel()
			            .getElementAt(selected[i]);
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
		
		
		
	}
}