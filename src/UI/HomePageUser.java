package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class HomePageUser extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageUser frame = new HomePageUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePageUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcceuil = new JLabel("Acceuil");
		lblAcceuil.setBounds(170, 11, 46, 14);
		contentPane.add(lblAcceuil);
		
		JLabel lblBonjourUser = new JLabel("Bonjour User :");
		lblBonjourUser.setBounds(74, 81, 79, 14);
		contentPane.add(lblBonjourUser);
		
		JLabel lblName = new JLabel("New label");
		lblName.setBounds(152, 81, 135, 14);
		contentPane.add(lblName);
	}
}
