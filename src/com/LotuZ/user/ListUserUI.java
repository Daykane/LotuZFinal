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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.PageAccueil;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
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


public class ListUserUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;
	private User user;



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
		FacadeUser.init(jdbcKit);
		FacadeBL.init(jdbcKit);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUserUI frame = new ListUserUI();
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
	public ListUserUI() throws SQLException, UserNotFoundException {
		
		FacadeUser.login("jack","jack");
		// Initialisation et Recherche du User connecté 
		final User user = UserLog.getUserLog();
		final Member member = UserLog.getMemberLog();
		Administrator admin = UserLog.getAdminLog();
		ActivityLeader activityLeader = UserLog.getRespoLog();
		Contributor contributor = UserLog.getContribLog();
		
	
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
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 50));
		
		// Création de la list 
		
		ListUser listActivityLeader = FacadeUser.getLeaders();
		List<User> listUser = listActivityLeader.getListUser();

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
                    ((JLabel) renderer).setText(((User) value).getLastName());
                }
                return renderer;
            }
        });

		panel.add(list);
		list.setPreferredSize(new Dimension(500, 300));

		list.setVisibleRowCount(10);
		
		JButton btnEdit = new JButton("Edit");
		panel.add(btnEdit);
		btnEdit.addMouseListener(new MouseAdapter()  {
			private User user;

			public void mouseClicked(MouseEvent arg0){
			      int selected[] = list.getSelectedIndices();
			      System.out.println("Selected Elements:  ");

			      for (int i = 0; i < selected.length; i++) {
			        User element = (User) list.getModel()
			            .getElementAt(selected[i]);
			        System.out.println("  " + element.getLastName());
			        this.user = (User)element;
			      }
					UserDetailUI pageAcceuil;
					
					try {
						pageAcceuil = new UserDetailUI(this.user);
						pageAcceuil.setVisible(true);
						pageAcceuil.setLocationRelativeTo(null);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UserNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			    }
		});
		
		
		
	}
}