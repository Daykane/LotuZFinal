package com.LotuZ.login;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.LotuZ.PageAccueil;
import com.LotuZ.inscription.InscriptionUserUI;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.Homepage;
import com.LotuZ.user.HomepageUI;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class LoginUI extends JFrame {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TfMail;
	private JTextField Tfpassword;
	public static LoginUI frame;



	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(81, 66, 69, 14);
		contentPane.add(lblMail);

		TfMail = new JTextField();
		TfMail.setBounds(176, 63, 86, 20);
		contentPane.add(TfMail);
		TfMail.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 111, 69, 14);
		contentPane.add(lblPassword);

		Tfpassword = new JTextField();
		Tfpassword.setBounds(176, 108, 86, 20);
		contentPane.add(Tfpassword);
		Tfpassword.setColumns(10);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(176, 34, 46, 14);
		contentPane.add(lblLogin);

		JButton btnOk = new JButton("OK");




		btnOk.setBounds(93, 217, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PageAccueil pageaccueil;
				pageaccueil = new PageAccueil();
				pageaccueil.setVisible(true);
				pageaccueil.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		
		btnCancel.setBounds(241, 217, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InscriptionUserUI frame =  new InscriptionUserUI();				
				frame.setVisible(true);
			}
		});
		
		lblInscription.setBounds(143, 156, 69, 14);
		contentPane.add(lblInscription);

		btnOk.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent arg0) {
				try {
					FacadeUser.login(TfMail.getText(),Tfpassword.getText());

					User user = UserLog.getUserLog();

					
					if(user != null){
						Homepage homepage = new Homepage();
						homepage.setVisible(true);
						homepage.setLocationRelativeTo(null);
						dispose();
					}



				} 
				catch (UserNotFoundException e){
					JOptionPane.showMessageDialog(null,"Error user not found","Error user not found",JOptionPane.ERROR_MESSAGE);
				}
				catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});		
	}
}
