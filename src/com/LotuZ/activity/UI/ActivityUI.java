package com.LotuZ.activity.UI;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.sql.SQLException;
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

/**
 * @author Alexis
 */
public class ActivityUI extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ActivityUI() {

		User user = UserLog.getUserLog();
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
		contentPane.add(bandeau.createBandeau(user, "Ma page"), BorderLayout.NORTH);

		final JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel enTete = new JPanel();
		mainPanel.add(enTete, BorderLayout.NORTH);
		enTete.setLayout(new BoxLayout(enTete, BoxLayout.X_AXIS));

		JLabel labelEnTete = new JLabel("Liste des activit\u00E9s");
		labelEnTete.setHorizontalAlignment(SwingConstants.LEFT);
		labelEnTete.setVerticalAlignment(SwingConstants.BOTTOM);
		enTete.add(labelEnTete);

		// List
		final Activity[] list = this.generateList();

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JList listActivities = new JList(list);
		mainPanel.add(listActivities, BorderLayout.WEST);
		listActivities.setPreferredSize(new Dimension(450, 300));


		listActivities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					ActivityDetailsUI details;

					try {
						details = new ActivityDetailsUI(list[listActivities.getSelectedIndex()].getIdActivity());
						details.setVisible(true);
						details.setLocationRelativeTo(null);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UserNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
				FormFactory.DEFAULT_ROWSPEC,}));

		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int i = listActivities.getSelectedIndex();
					if ( i >= 0){
						System.out.println(list.length);
						JOptionPane.showConfirmDialog (null, "Are you sure to remove"+list[i].getName(),"Advert",dialogButton);
						if (dialogButton == JOptionPane.YES_OPTION){
							FacadeActivity.deleteActivity(list[i]);
							
							Activity[] list = generateList();
							listActivities.setListData(list);
							listActivities.revalidate();
							listActivities.repaint();
							
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivityCreateUI frame = new ActivityCreateUI();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Activity[] list = generateList();
				listActivities.setListData(list);
				listActivities.revalidate();
				listActivities.repaint();
			}
		});
		panelButton.add(btnRefresh, "1, 1");
		panelButton.add(btnAdd, "1, 10, fill, center");
		panelButton.add(btnRemove, "1, 12, fill, center");

		JPanel panel = new JPanel();
		mainPanel.add(panel, BorderLayout.SOUTH);

		//If not admin no add and remove button
		if ( admin == null){
			btnAdd.setVisible(false);
			btnRemove.setVisible(false);
		}
	}

	/**
	 * @return All Activities in an Array
	 */
	Activity[] generateList(){
		List<Activity> lAct = null; 	
		try {
			lAct = FacadeActivity.getAllActivities();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Activity[] liste = toActivityArray(lAct);		
		return liste;		
	}

	/**
	 * @param listActivity to convert
	 * @return listActivity in ArrayActivity
	 */
	Activity[] toActivityArray(List<Activity> list){
		Activity[] ret = new Activity[list.size()];
		for(int i = 0;i < ret.length;i++)
			ret[i] = list.get(i);
		return ret;
	}
}
