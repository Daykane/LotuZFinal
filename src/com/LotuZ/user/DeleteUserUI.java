package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;







import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.User;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Ludo
 *
 */
public class DeleteUserUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;



	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public DeleteUserUI(String mail) throws SQLException, UserNotFoundException {
		
		
		final User user = FacadeUser.getUser(mail);
		final Member member = FacadeUser.getMember(mail);
		final Contributor contributor = FacadeUser.getContributor(mail);
		final ActivityLeader leader = FacadeUser.getActivityLeader(mail);
		
		
		Administrator adminLog = UserLog.getAdminLog();

		

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

		contentPane.add(bandeau.createBandeau(user, "Ma page"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(500);
		flowLayout.setVgap(40);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnDeleteActivityLeader = new JButton("Delete Activity Leader");
		btnDeleteActivityLeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					FacadeUser.deleteLeader(leader.getIdLeader());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Leader deleted","Leader deleted",JOptionPane.ERROR_MESSAGE);

			}
		});
		panel.add(btnDeleteActivityLeader);
		
		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					FacadeUser.deleteUser(user);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"User deleted","User deleted",JOptionPane.ERROR_MESSAGE);

			}
		});
		panel.add(btnDeleteUser);
		
		JButton btnDeleteMember = new JButton("Delete Member");
		btnDeleteMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					FacadeUser.deleteMember(member.getIdMember());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Member deleted","Member deleted",JOptionPane.ERROR_MESSAGE);

			}
		});
		panel.add(btnDeleteMember);
		
		JButton btnDeleteContributor = new JButton("Delete Contributor");
		btnDeleteContributor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					FacadeUser.deleteContributor(contributor.getIdContributor());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Contributor deleted","Contributor deleted",JOptionPane.ERROR_MESSAGE);

			}
		});
		panel.add(btnDeleteContributor);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Homepage homepage;
				try {
					homepage = new Homepage();
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
		
		btnDeleteActivityLeader.setVisible(false);
		btnDeleteContributor.setVisible(false);
		btnDeleteMember.setVisible(false);
		
		if (contributor != null)
		{
			btnDeleteContributor.setVisible(true);
		}
		if (member != null)
		{
			btnDeleteMember.setVisible(true);
		}
		if (leader != null)
		{
			btnDeleteActivityLeader.setVisible(true);
		}
	}

}
