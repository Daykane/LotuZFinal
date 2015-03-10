package UI;


import java.awt.EventQueue;


import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Business.FacadeBL;
import Class.Activity;

public class ActivityUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FacadeBL facadeBL = new FacadeBL();

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityUI frame = new ActivityUI();
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
	public ActivityUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAfficherTableauDactivit = new JLabel("Afficher tableau d'activit\u00E9");
		lblAfficherTableauDactivit.setBounds(27, 34, 143, 14);
		contentPane.add(lblAfficherTableauDactivit);
		
		this.getActivities();
	}
	


	public List<Activity> getActivities() {
		return facadeBL.getActivities();
	}
}
