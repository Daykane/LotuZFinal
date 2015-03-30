package com.LotuZ.EventInscription;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.DataBaseException;
import com.LotuZ.FacadeBL;
import com.LotuZ.activity.Activity;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.event.UI.DetailsEventUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.user.Homepage;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JButton;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

/**
 * @author Alexis
 */
public class InscriptionEventUI extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public InscriptionEventUI() {

		final User user = UserLog.getUserLog();
		Administrator admin = UserLog.getAdminLog();
		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		Bandeau bandeau = new Bandeau();
		bandeau.setJframe(this);
		contentPane.add(bandeau.createBandeau(user, "Inscription Event"), BorderLayout.NORTH);

		final JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel enTete = new JPanel();
		mainPanel.add(enTete, BorderLayout.NORTH);
		enTete.setLayout(new BoxLayout(enTete, BoxLayout.X_AXIS));

		JLabel labelEnTete = new JLabel("Liste des events");
		labelEnTete.setHorizontalAlignment(SwingConstants.LEFT);
		labelEnTete.setVerticalAlignment(SwingConstants.BOTTOM);
		enTete.add(labelEnTete);

		// List
		final Event[] list = this.generateList();

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JList listEvent = new JList(list);
		mainPanel.add(listEvent, BorderLayout.WEST);
		listEvent.setPreferredSize(new Dimension(450, 300));


		listEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					DetailsEventUI details;
					if (listEvent.getSelectedIndex() >= 0){
					details = new DetailsEventUI(list[listEvent.getSelectedIndex()]);
					details.setVisible(true);
					details.setLocationRelativeTo(null);


					}
				}
			}
		});






		// Button pannel and Button
		JPanel panelButton = new JPanel();
		mainPanel.add(panelButton, BorderLayout.CENTER);
		panelButton.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("98px"),
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
				RowSpec.decode("23px"),
				RowSpec.decode("23px"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = listEvent.getSelectedIndex();
				if ( i >= 0){
					try {
						FacadeEventInscription.addUserInEvent(user, list[listEvent.getSelectedIndex()]);
					}catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
						JOptionPane.showMessageDialog(null,"Alrady register","already register",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BoxLetter boxLetter = FacadeBL.getBoxLetter(UserLog.getMemberLog().getIdMember());
					try {
						boxLetter.sendNotification(14, UserLog.getMemberLog().getIdMember());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		

		

		panelButton.add(btnAdd, "1, 10, fill, center");
	

		JPanel panel = new JPanel();
		mainPanel.add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnHome = new JButton("Back home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Homepage homepage;
				try {
					homepage = new Homepage();
					homepage.setVisible(true);
					homepage.setLocationRelativeTo(null);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnHome);

		//If not admin no add and remove button
		if ( user == null){
			btnAdd.setVisible(false);
		}
	}

	/**
	 * @return All Activities in an Array
	 */
	Event[] generateList(){
		List<Activity> lAct = null; 	
		List<Event> lEvent = new ArrayList<Event>();
		try {
			lAct = FacadeActivity.getAllActivities();
			for(Activity act : lAct){

				try {
					List<Event> listEventActivity = (FacadeEvent.getEventsActivity(act.getIdActivity()));
					for( Event ev : listEventActivity ){
						lEvent.add(ev);
					}
					
				} 
				catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Error base","Error base",JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Event[] liste = toEventArray(lEvent);		
		return liste;		
	}

	/**
	 * @param listActivity to convert
	 * @return listActivity in ArrayActivity
	 */
	Event[] toEventArray(List<Event> list){
		Event[] ret = new Event[list.size()];
		for(int i = 0;i < ret.length;i++)
			ret[i] = list.get(i);
		return ret;
	}
}
