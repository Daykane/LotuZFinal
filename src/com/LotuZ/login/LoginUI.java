package com.LotuZ.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.HomepageUI;
import com.LotuZ.user.user.HomePageUserUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JCheckBox;

public class LoginUI extends JFrame {
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TfMail;
	private JTextField Tfpassword;
	public static LoginUI frame;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(93, 66, 57, 14);
		contentPane.add(lblMail);
		
		TfMail = new JTextField();
		TfMail.setBounds(176, 63, 86, 20);
		contentPane.add(TfMail);
		TfMail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(93, 111, 57, 14);
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
				HomepageUI homepageUI = new HomepageUI();
				HomepageUI.frame = homepageUI;
				homepageUI.setVisible(true);
				frame.dispose();
			}
		});
		btnCancel.setBounds(241, 217, 89, 23);
		contentPane.add(btnCancel);
		
		final JCheckBox chckbxMember = new JCheckBox("Member");
		
		chckbxMember.setBounds(23, 164, 97, 23);
		contentPane.add(chckbxMember);
		
		final JCheckBox chckbxSpeaker = new JCheckBox("Speaker");
		chckbxSpeaker.setBounds(122, 164, 97, 23);
		contentPane.add(chckbxSpeaker);
		
		final JCheckBox chckbxRespo = new JCheckBox("Respo");
		chckbxRespo.setBounds(222, 164, 86, 23);
		contentPane.add(chckbxRespo);
		
		final JCheckBox chckbxAdministrateur = new JCheckBox("Administrateur");
		chckbxAdministrateur.setBounds(310, 164, 118, 23);
		contentPane.add(chckbxAdministrateur);
		
		chckbxSpeaker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxSpeaker.isSelected()){
					chckbxMember.setSelected(false);
					chckbxAdministrateur.setSelected(false);
					chckbxRespo.setSelected(false);
				}
			}
		});
		
		
		
		chckbxRespo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxRespo.isSelected()){
					chckbxMember.setSelected(false);
					chckbxAdministrateur.setSelected(false);
					chckbxSpeaker.setSelected(false);
				}
			}
		});
		
		
		
		chckbxAdministrateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxAdministrateur.isSelected()){
					chckbxMember.setSelected(false);
					chckbxRespo.setSelected(false);
					chckbxSpeaker.setSelected(false);
				}
			}
		});
		
		
		
		chckbxMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxMember.isSelected()){
					chckbxAdministrateur.setSelected(false);
					chckbxRespo.setSelected(false);
					chckbxSpeaker.setSelected(false);
				}
			}
		});
		
		btnOk.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent arg0) {
				try {
					if (chckbxAdministrateur.isSelected()){
						
					}
					if (chckbxMember.isSelected()){
						
					}
					if (chckbxSpeaker.isSelected()){
						
					}
					if (chckbxRespo.isSelected()){
						
					}
					else{
					FacadeUser.login(TfMail.getText(),Tfpassword.getText());
					HomePageUserUI frame =  new HomePageUserUI();				
					frame.setVisible(true);
					
					}
				} 
				catch (UserNotFoundException e){
					JOptionPane.showMessageDialog(null,"Error user not found","Error user not found",JOptionPane.ERROR_MESSAGE);
				}
				catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Error Mail/Password","Mail ou password inexistant",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});		
	}
}
