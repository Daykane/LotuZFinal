package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.SwingConstants;

import java.awt.Font;




import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;


public class UserUI extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLastName;
	private JTextField textFieldFirstName;
	private JTextField textFieldMail;
	private JTextField textFieldPhone;
	private JTextField textFieldStreetName;
	private JTextField textFieldNumHouse;
	private JTextField textFieldCity;
	private JTextField textFieldPostCode;
	private final Action action = new OkButton();
	private final Action action_1 = new CancelButton();
	private JTextField textField;
	private JTextField textField_1;
	
	final JFrame parent = new JFrame();


	static UserUI frame = new UserUI();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UserUI frame = new UserUI();
					 //frame.pack();
					 frame.setResizable(false);
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
	public UserUI() {
		setAutoRequestFocus(false);
		
		setTitle("LotuZ");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 323, 357);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JPanel panel = new JPanel();
	contentPane.add(panel, BorderLayout.NORTH);
	
	JLabel lblInscription = new JLabel("Inscription");
	lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 14));
	panel.add(lblInscription);
	
	JPanel panel_1 = new JPanel();
	contentPane.add(panel_1, BorderLayout.CENTER);
	panel_1.setLayout(new GridLayout(10, 1, 0, 0));
	
	JPanel panel_2 = new JPanel();
	panel_1.add(panel_2);
	panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
	JLabel lblLastName = new JLabel("Last name : ");
	lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
	
	panel_2.add(lblLastName);
	
	textFieldLastName = new JTextField();
	panel_2.add(textFieldLastName);
	textFieldLastName.setColumns(10);
	
	JPanel panel_3 = new JPanel();
	panel_1.add(panel_3);
	
	JLabel lblFirstName = new JLabel("First name : ");
	lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
	panel_3.add(lblFirstName);
	
	textFieldFirstName = new JTextField();
	panel_3.add(textFieldFirstName);
	textFieldFirstName.setColumns(10);
	
	JPanel panel_4 = new JPanel();
	panel_1.add(panel_4);
	
	JLabel lblMail = new JLabel("Adress mail : ");
	lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
	panel_4.add(lblMail);
	
	textFieldMail = new JTextField();
	panel_4.add(textFieldMail);
	textFieldMail.setColumns(10);
	
	JPanel panel_5 = new JPanel();
	
	panel_1.add(panel_5);
	
	JLabel lblPhone = new JLabel("Phone number : ");
	lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
	panel_5.add(lblPhone);
	
	textFieldPhone = new JTextField();
	panel_5.add(textFieldPhone);
	textFieldPhone.setColumns(10);
	
	JPanel panel_6 = new JPanel();
	panel_1.add(panel_6);
	
	JLabel lblStreetName = new JLabel("Street name : ");
	panel_6.add(lblStreetName);
	
	textFieldStreetName = new JTextField();
	panel_6.add(textFieldStreetName);
	textFieldStreetName.setColumns(10);
	
	JPanel panel_7 = new JPanel();
	panel_1.add(panel_7);
	
	JLabel lblNumHouse = new JLabel("House number : ");
	panel_7.add(lblNumHouse);
	
	textFieldNumHouse = new JTextField();
	panel_7.add(textFieldNumHouse);
	textFieldNumHouse.setColumns(10);
	
	JPanel panel_9 = new JPanel();
	panel_1.add(panel_9);
	
	JLabel lblCity = new JLabel("City : ");
	panel_9.add(lblCity);
	
	textFieldCity = new JTextField();
	panel_9.add(textFieldCity);
	textFieldCity.setColumns(10);
	
	JPanel panel_10 = new JPanel();
	panel_1.add(panel_10);
	
	JLabel lblPostCode = new JLabel("Post code : ");
	panel_10.add(lblPostCode);
	
	textFieldPostCode = new JTextField();
	panel_10.add(textFieldPostCode);
	textFieldPostCode.setColumns(10);
	
	JPanel panel_11 = new JPanel();
	panel_1.add(panel_11);
	
	JLabel lblPassword = new JLabel("Password : ");
	panel_11.add(lblPassword);
	
	textField = new JTextField();
	panel_11.add(textField);
	textField.setColumns(10);
	
	JPanel panel_12 = new JPanel();
	panel_1.add(panel_12);
	
	JLabel lblConfPassword = new JLabel("Confirm password : ");
	panel_12.add(lblConfPassword);
	
	textField_1 = new JTextField();
	panel_12.add(textField_1);
	textField_1.setColumns(10);
	
	JPanel panel_8 = new JPanel();
	contentPane.add(panel_8, BorderLayout.SOUTH);
	panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
	JButton btnOk = new JButton("Ok");
	btnOk.setAction(action);
	panel_8.add(btnOk);
	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.setAction(action_1);
	panel_8.add(btnCancel);
	
}

	private class OkButton extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public OkButton() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Commit description");
		}
		public void actionPerformed(ActionEvent e) {
			System.out.println(textFieldLastName.getText());
			System.out.println(textFieldFirstName.getText());
			System.out.println(textFieldMail.getText());
			System.out.println(textFieldPhone.getText());
			System.out.println(textFieldStreetName.getText());
			System.out.println(textFieldNumHouse.getText());
			System.out.println(textFieldCity.getText());
			System.out.println(textFieldPostCode.getText());
			
		}
	}
	private class CancelButton extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public CancelButton() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Cancel inscription");
		}
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Inscription cancel!", "Inscription cancel!", JOptionPane.CANCEL_OPTION);
			//test de rajout de commentaire
		}
	}
}
