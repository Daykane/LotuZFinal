package interfaceDeBase;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.LotuZ.login.LoginUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.notification.ui.NotificationCenterUI;
import com.LotuZ.product.category.ui.CategoryUI;
import com.LotuZ.user.Homepage;
import com.LotuZ.user.UserDetailUI;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

public class Bandeau extends JFrame {
	public Bandeau() {
	}
	private static final long serialVersionUID = 1L;	
	private JFrame jframe;


public Component createBandeau(final User user,String name){
	JPanel panelBandeau = new JPanel();
	panelBandeau.setLayout(new BorderLayout(0, 0));
	
	panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
	
	JLabel lblTitle = new JLabel(name);
	lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	panelBandeau.add(lblTitle, BorderLayout.CENTER);

	JLabel image = new JLabel(new ImageIcon("zen.jpg"));
	panelBandeau.add(image,BorderLayout.WEST);
	image.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			UserDetailUI userDetail;
			try {
				Homepage homepage = new Homepage();
				homepage.setVisible(true);
				homepage.setLocationRelativeTo(null);
				getJframe().dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});
	
	JPanel panelOptions = new JPanel();
	panelBandeau.add(panelOptions, BorderLayout.EAST);
	panelOptions.setLayout(new GridLayout(0, 2, 0, 0));

	final JLabel lblnameUser = new JLabel("name");
	panelOptions.add(lblnameUser);
	if 	(user!=null){
		lblnameUser.setText(user.getLastName() +" "+ user.getFirstName());
	}
	else {
		lblnameUser.setVisible(false);
	}
	final String nameUser = lblnameUser.getText(); 
	lblnameUser.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			UserDetailUI userDetail;
			try {
				userDetail = new UserDetailUI(user.getMail());
				userDetail.setVisible(true);
				userDetail.setLocationRelativeTo(null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			lblnameUser.setText("<html><u><font color = #1373cc >"+nameUser +" </u></font></html>");
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			lblnameUser.setText(nameUser);
		}
	});
	lblnameUser.setHorizontalAlignment(SwingConstants.LEFT);

	final JLabel lblConnexion = new JLabel("connexion/deconnexion");
	lblConnexion.setHorizontalAlignment(SwingConstants.RIGHT);
	panelOptions.add(lblConnexion);
	if (user == null){
		lblConnexion.setText("connexion");
	}
	else {
		lblConnexion.setText("déconnexion");
	}
	final String Connexion = lblConnexion.getText();
	final JLabel lblBoutique = new JLabel("Boutique Access ");
	panelOptions.add(lblBoutique);
	final String Boutique = lblBoutique.getText();
	lblBoutique.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			CategoryUI categoryUI=null;
			try {
				categoryUI = new CategoryUI();
				categoryUI.setLocationRelativeTo(null);
				categoryUI.setVisible(true);
				getJframe().dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("Clicked sur acces boutique");
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			lblBoutique.setText("<html><u><font color = #1373cc >"+Boutique +" </u></font></html>");
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			lblBoutique.setText(Boutique);
		}
	});
	lblBoutique.setHorizontalAlignment(SwingConstants.LEFT);
	
	JLabel lblIconeMail = new JLabel(new ImageIcon("notif.png"));
	lblIconeMail.setHorizontalAlignment(SwingConstants.RIGHT);
	panelOptions.add(lblIconeMail);
	lblIconeMail.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (user == null){
				LoginUI loginUI = new LoginUI();
				loginUI.setVisible(true);
				loginUI.setLocationRelativeTo(null);
				getJframe().dispose();
			}
			else{
				NotificationCenterUI notifCenter;
				try {
					getJframe().dispose();
					notifCenter = new NotificationCenterUI(user);
					notifCenter.setVisible(true);
					notifCenter.setLocationRelativeTo(null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			lblConnexion.setText(Connexion);
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			lblConnexion.setText(Connexion);
		}
		
		
	});
	lblConnexion.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (user == null){
				LoginUI loginUI = new LoginUI();
				loginUI.setVisible(true);
				loginUI.setLocationRelativeTo(null);
				getJframe().dispose();
			}
			else{
				UserLog.logOff();
				Homepage loginUI;
				try {
					getJframe().dispose();
					loginUI = new Homepage();
					loginUI.setVisible(true);
					loginUI.setLocationRelativeTo(null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			lblConnexion.setText(Connexion);
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			lblConnexion.setText(Connexion);
		}
		
		
	});
	return panelBandeau;
}

/**
 * @return the jframe
 */
public JFrame getJframe() {
	return jframe;
}


/**
 * @param jframe the jframe to set
 */
public void setJframe(JFrame jframe) {
	this.jframe = jframe;
}}
