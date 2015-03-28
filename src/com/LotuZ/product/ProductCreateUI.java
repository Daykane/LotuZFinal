package com.LotuZ.product;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.activity.UI.ActivityCreateUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JScrollBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductCreateUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TFProductName;
	private JTextField TFPrice;
	private JTextField TFQuantity;
	private JTextField TFCategory;
	private JTextField TFReduction;
	private final JLabel jlblStatus = new JLabel("Error dans un champ");

	static int count = 0;

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
		FacadeBL.init(jdbcKit);
		//FacadeUser.init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductCreateUI frame = new ProductCreateUI();
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
	public ProductCreateUI() throws SQLException, UserNotFoundException {
		FacadeUser.login("jack","jack");
		User user = UserLog.getUserLog();
		System.out.println("Mail page acceuil test : " + user.getMail());

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelBandeau = new JPanel();
		panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(panelBandeau, BorderLayout.NORTH);
		panelBandeau.setLayout(new BorderLayout(0, 0));


		JLabel lblTitle = new JLabel("CREATE A PRODUCT");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelBandeau.add(lblTitle, BorderLayout.CENTER);

		JLabel lblToto = new JLabel("LOGO");
		lblToto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblToto.setHorizontalAlignment(SwingConstants.LEFT);
		//panel.add(lblToto, BorderLayout.WEST);

		JLabel image = new JLabel(new ImageIcon("zen.jpg"));
		panelBandeau.add(image,BorderLayout.WEST);

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
				System.out.println("Clicked sur name = acces profil");
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

		JLabel lblIconeMail = new JLabel("icone mail");
		lblIconeMail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelOptions.add(lblIconeMail);

		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(null);

		JLabel lblNameProduct = new JLabel("Name Product:");
		lblNameProduct.addMouseListener(new MouseAdapter() {
		});
		lblNameProduct.setBounds(112, 85, 128, 14);
		panelCenter.add(lblNameProduct);

		TFProductName = new JTextField();
		TFProductName.setBounds(271, 79, 165, 27);
		panelCenter.add(TFProductName);
		TFProductName.setColumns(10);

		JLabel lblPrice = new JLabel("Price: (number)");
		lblPrice.setBounds(112, 141, 128, 14);
		panelCenter.add(lblPrice);

		TFPrice = new JTextField();
		TFPrice.setColumns(10);
		TFPrice.setBounds(271, 135, 165, 27);
		panelCenter.add(TFPrice);

		JLabel lblQuantity = new JLabel("Quantity: (number)");
		lblQuantity.setBounds(112, 203, 128, 14);
		panelCenter.add(lblQuantity);

		TFQuantity = new JTextField();
		TFQuantity.setColumns(10);
		TFQuantity.setBounds(271, 197, 165, 27);
		panelCenter.add(TFQuantity);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(112, 316, 129, 14);
		panelCenter.add(lblCategory);

		JLabel lblRduction = new JLabel("Reduction: (number)");
		lblRduction.setBounds(112, 260, 128, 14);
		panelCenter.add(lblRduction);

		TFCategory = new JTextField();
		TFCategory.setColumns(10);
		TFCategory.setBounds(271, 310, 165, 27);
		panelCenter.add(TFCategory);

		TFReduction = new JTextField();
		TFReduction.setColumns(10);
		TFReduction.setBounds(271, 254, 165, 27);
		panelCenter.add(TFReduction);

		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if( this.verifyTF() & this.verifyPrice() & this.verifyQuantity() & this.verifyReduction() )
				{
					try
					{
						System.out.println("ok");
						//FacadeBL.product(user.getIdMember,TFProductName.getText(),Integer.parseInt(TFPrice.getText()),Integer.parseInt(TFQuantity.getText()),Integer.parseInt(TFCategory.getText()),Integer.parseInt(TFReduction.getText()));

						FacadeBL.product(TFProductName.getText(),Integer.parseInt(TFPrice.getText()),Integer.parseInt(TFQuantity.getText()),Integer.parseInt(TFCategory.getText()),Integer.parseInt(TFReduction.getText()));
						System.out.println("ok");
						JOptionPane.showMessageDialog(null,"Product added","Product added",JOptionPane.INFORMATION_MESSAGE);
					}


					catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e1) 
					{
						e1.printStackTrace();
					} 
					catch (ClassNotFoundException e1) 
					{
						e1.printStackTrace();
					} catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			}
			
			private boolean verifyTF() {

				this.TFisempty(TFProductName);
				this.TFisempty(TFPrice);
				this.TFisempty(TFQuantity);
				this.TFisempty(TFCategory);
				this.TFisempty(TFReduction);

				if (count>0){
					return false;
				}
				else {
					return true;
				}
			}

			private void TFisempty(JTextField textfield){
				RemoveBorder(textfield);
				String text = textfield.getText();

					if(text.equals("")){
						RedBorder(textfield);
						count++;
					}
			}


			private void RedBorder(JTextField textfield){
				jlblStatus.setVisible(true);
				Border border = BorderFactory.createLineBorder(Color.RED, 2);
				textfield.setBorder(border);
			}

			private void RemoveBorder(JTextField textfield){
				jlblStatus.setVisible(false);
				Border border = BorderFactory.createLineBorder(Color.white, 2);
				textfield.setBorder(border);

			}

			private boolean verifyPrice(){
				if (!isNumeric(TFPrice.getText())){
					RedBorder(TFPrice);
					return false;
				};
				return true;
			}

			private boolean verifyQuantity(){
				if (!isNumeric(TFQuantity.getText())){
					RedBorder(TFQuantity);
					return false;
				};
				return true;
			}

			private boolean verifyReduction(){
				if (!isNumeric(TFReduction.getText())){
					RedBorder(TFReduction);
					return false;
				};
				return true;
			}

			private boolean isNumeric(String str)  
			{  
			  try  
			  {  
				  Integer.parseInt(str);  
			  }  
			  catch(Exception e)  
			  {  
			    return false;  
			  }  
			  return true;  
			}	
			
});
		btnOk.setBounds(131, 451, 89, 23);
		panelCenter.add(btnOk);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("cancel");
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(252, 451, 89, 23);
		panelCenter.add(btnCancel);
		lblConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Connexion ou deconnexion si la personne n'est pas connecté ou l'est");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblConnexion.setText("<html><u><font color = #1373cc >"+Connexion +" </u></font></html>");
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblConnexion.setText(Connexion);

			}

		});


	}
}
