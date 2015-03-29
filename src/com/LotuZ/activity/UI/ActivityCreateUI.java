package com.LotuZ.activity.UI;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
/**
 * @author Alexis
 */

public class ActivityCreateUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfShortDesc;

	
	/**
	 * Create the frame.
	 */
	public ActivityCreateUI() {
		User user = UserLog.getUserLog();
	
		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(new Bandeau().createBandeau(user, "Ma page"), BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_EnTete = new JPanel();
		panel_1.add(panel_EnTete, BorderLayout.NORTH);
		
		JLabel lblCreateActivity = new JLabel("Create Activity");
		panel_EnTete.add(lblCreateActivity);
		
		JPanel panelMain = new JPanel();
		panel_1.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.PREF_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(150dlu;min):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("10dlu"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.MIN_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				RowSpec.decode("max(73dlu;pref)"),}));
		
		JLabel lblName = new JLabel("Name : ");
		panelMain.add(lblName, "1, 2, right, default");
		
		tfName = new JTextField();
		panelMain.add(tfName, "3, 2, fill, default");
		tfName.setColumns(10);
		
		JLabel lblShortDescr = new JLabel("Short description : ");
		panelMain.add(lblShortDescr, "1, 4, right, default");
		
		tfShortDesc = new JTextField();
		panelMain.add(tfShortDesc, "3, 4, fill, default");
		tfShortDesc.setColumns(10);
		
		// Fill the choice box
		
		final List<User> listUser;
		ListUser u = null;
		try {
			u = FacadeUser.getLeaders();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		listUser = u.getListUser();
		final User[] arrayLeader;
		arrayLeader = toUserArray(listUser);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox choiceRespo = new JComboBox(arrayLeader);
		panelMain.add(choiceRespo, "3, 7, left, default");
		
		JLabel lblLongDescr = new JLabel("Long description : ");
		panelMain.add(lblLongDescr, "1, 9, right, default");
		
		JScrollPane scrollPane = new JScrollPane();
		panelMain.add(scrollPane, "3, 9, fill, fill");
		
		final JTextArea tfLongDesc = new JTextArea();
		tfLongDesc.setTabSize(7);
		scrollPane.setViewportView(tfLongDesc);
		
		JLabel lblRespo = new JLabel("Leader : ");
		panelMain.add(lblRespo, "1, 7, right, default");
		
		JPanel panel_Button = new JPanel();
		panel_1.add(panel_Button, BorderLayout.SOUTH);
		panel_Button.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					String idRespo = arrayLeader[choiceRespo.getSelectedIndex()].getMail();
					
					FacadeBL.createActivity(tfName.getText(),idRespo, tfShortDesc.getText(), tfLongDesc.getText());
					JOptionPane.showMessageDialog(null,"creation sucess","Creation",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (com.mysql.jdbc.MysqlDataTruncation e){
					//TODO
					System.out.println("Boite alert, text trop long");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch(java.lang.ArrayIndexOutOfBoundsException e){
					//TODO
					System.out.println("Il n'y a pas de respo selectionné");
				}
			}
		});
		btnConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnCancel);
	}
	
	
	/**
	 * Parse the List User in Array USer
	 * @param listUser
	 */
	User[] toUserArray(List<User> listUser){
		User[] ret = new User[listUser.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = listUser.get(i);
		  return ret;
	}
}
