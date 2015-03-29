package com.LotuZ.activity.UI;
import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;

import com.LotuZ.DataBaseException;
import com.LotuZ.FacadeBL;
import com.LotuZ.activity.Activity;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.event.UI.CreateEventUI;
import com.LotuZ.event.UI.DetailsEventUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.User;

import java.sql.SQLException;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;





import java.awt.GridLayout;

import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTextField;


import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;

/**
 * @author Alexis
 */

public class ActivityDetailsUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfRespo;
	private JTextField tfShortDescr;
	static String editText = "Edit";


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public ActivityDetailsUI(final int idAct) throws DataBaseException, UserNotFoundException {
		
		// Déclaration du monde
		//FacadeUser.login("jack","jack");
		final Activity activity = FacadeActivity.getActivity(idAct);
		User user = UserLog.getUserLog();
		ActivityLeader respo = UserLog.getRespoLog();
		Administrator admin = UserLog.getAdminLog();
		//
		
		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelBandeau = new JPanel();
		panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		Bandeau bandeau = new Bandeau();
		bandeau.setJframe(this);
		contentPane.add(bandeau.createBandeau(user,"Details Activity"), BorderLayout.NORTH);
		panelBandeau.setLayout(new BorderLayout(0, 0));


		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.PREF_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(61dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name : ");
		panel.add(lblName, "4, 2, right, default");
		
		tfName = new JTextField(activity.getName());
		tfName.setEditable(false);
		panel.add(tfName, "6, 2, fill, default");
		tfName.setColumns(10);
		
		JLabel lblCreated = new JLabel("Created : ");
		panel.add(lblCreated, "10, 2");
		
		JLabel lblDateCreated = new JLabel(activity.getCreateDate());
		panel.add(lblDateCreated, "12, 2");
		
		JLabel lblRespo = new JLabel("Responsible : ");
		panel.add(lblRespo, "4, 6, right, default");
		
		//TODO get le name et pas l'id du respo
		tfRespo = new JTextField(activity.getIdRespo());
		tfRespo.setEditable(false);
		panel.add(tfRespo, "6, 6, fill, top");
		tfRespo.setColumns(10);
		
		JLabel lblUpdated = new JLabel("Updated : ");
		panel.add(lblUpdated, "10, 6");
		
		JLabel lblDateUpdated = new JLabel(activity.getMajDate());
		panel.add(lblDateUpdated, "12, 6");
		
		JLabel lblShortDescr = new JLabel("Short description : ");
		panel.add(lblShortDescr, "4, 10, right, default");
		
		tfShortDescr = new JTextField(activity.getShortDescr());
		tfShortDescr.setEditable(false);
		panel.add(tfShortDescr, "6, 10, fill, default");
		tfShortDescr.setColumns(10);
		
		JLabel lblLongDescr = new JLabel("Long description : ");
		panel.add(lblLongDescr, "4, 14, right, default");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "6, 14, fill, fill");
		
		final JTextArea tfLongDescr = new JTextArea(activity.getLongDescr());
		tfLongDescr.setEditable(false);
		scrollPane.setViewportView(tfLongDescr);
		
		JLabel lblListEvents = new JLabel("list events");
		panel.add(lblListEvents, "4, 16");
		
		//List gestion		
		final Event[] list = this.generateList(idAct);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JList listEvents = new JList(list);
		listEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					DetailsEventUI details;
					try{
					details = new DetailsEventUI(list[listEvents.getSelectedIndex()]);
					details.setVisible(true);
					details.setLocationRelativeTo(null);
					}
					catch(java.lang.ArrayIndexOutOfBoundsException ex){
					 System.out.println("Error indice Jlist");
					}
					
			}
			}
		});
		panel.add(listEvents, "4, 18, 5, 1, fill, fill");
		
		JButton btnAddEvent = new JButton("Add Event");
		
		panel.add(btnAddEvent, "10, 18, default, center");
		btnAddEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO
				CreateEventUI frame = new CreateEventUI();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				System.out.println("create a event");
			}
		});
		
		JButton btnRemoveEvent = new JButton("Remove");
		panel.add(btnRemoveEvent, "12, 18");
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Event[] list = generateList(idAct);
				listEvents.setListData(list);
				listEvents.revalidate();
				listEvents.repaint();
			}
		});
		panel.add(btnRefresh, "14, 18");
		btnRemoveEvent.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (listEvents.getSelectedIndex() == -1){
					
				}
				else{
				try {
					FacadeEvent.deleteEvent(list[listEvents.getSelectedIndex()].getIdEvent());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Event[] list = generateList(idAct);
				listEvents.setListData(list);
				listEvents.revalidate();
				listEvents.repaint();
				}
			}
		});
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelButton = new JPanel();
		panel_1.add(panelButton, BorderLayout.SOUTH);
		
		final JButton btnEdit = new JButton(editText);
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnEdit.getText().equals("Edit")){
					btnEdit.setText("Validate");
					tfName.setEditable(true);
					tfShortDescr.setEditable(true);
					tfLongDescr.setEditable(true);
				}
				else if(btnEdit.getText().equals("Validate")){
					btnEdit.setText("Edit");
					try {
						FacadeBL.updateActivity(activity, tfName.getText(), tfShortDescr.getText(), tfLongDescr.getText(), tfRespo.getText());
						tfName.setEditable(false);
						tfShortDescr.setEditable(false);
						tfLongDescr.setEditable(false);
						JOptionPane.showMessageDialog(null,"update sucess","Update",JOptionPane.INFORMATION_MESSAGE);
					} catch (DataBaseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		panelButton.add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnEdit.getText().equals("Validate")){
					tfName.setText(activity.getName());
					tfShortDescr.setText(activity.getShortDescr());
					tfLongDescr.setText(activity.getLongDescr());
					tfName.setEditable(false);
					tfShortDescr.setEditable(false);
					tfLongDescr.setEditable(false);
					btnEdit.setText("Edit");
				}
				else{
					//TODO
					dispose();
				}
			}
		});
		panelButton.add(btnCancel);
		
		btnAddEvent.setVisible(false);
		btnRemoveEvent.setVisible(false);
		btnEdit.setVisible(false);
		if( admin != null ){
			btnAddEvent.setVisible(true);
			btnRemoveEvent.setVisible(true);
			btnEdit.setVisible(true);
		}
		else if(respo !=null && respo.getIdLeader()!= activity.getIdRespo() ){
			btnAddEvent.setVisible(true);
			btnRemoveEvent.setVisible(true);
			btnEdit.setVisible(true);
		}

	}
	/**
	 * @param idActivity : identifer of Activity
	 * @return Activity's Events
	 */
	Event[] generateList(int idActivity){
		List<Event> lEvent = null; 	
		try {
			lEvent = FacadeEvent.getEventsActivity(idActivity);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Event[] liste = toActivityArray(lEvent);		
		return liste;		
	}
	
	/**
	 * Parse ListEvent in ArrayEvent
	 * @param lEvent : List Event to convert
	 */
	Event[] toActivityArray(List<Event> lEvent){
		  Event[] ret = new Event[lEvent.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = lEvent.get(i);
		  return ret;
		}

}
