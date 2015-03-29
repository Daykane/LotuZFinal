package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.EventInscription.FacadeEventInscription;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.user.bl.User;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.FlowLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Component;

import javax.swing.JList;

public class PlanningUI extends JFrame {

	private JPanel contentPane;
	private JList<Event> list;


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public PlanningUI() throws SQLException, UserNotFoundException {
		FacadeUser.login("jack","jack");
		
		User user = UserLog.getUserLog();

		List<Event> listEvent = FacadeEventInscription.getUserEvent(user);
	
		
		Bandeau bandeau = new Bandeau();

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(bandeau.createBandeau(user, "Ma page"), BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(20);
		contentPane.add(panel, BorderLayout.CENTER);
		


		// On remplit la liste 
		List<Event> events = new ArrayList<Event>();
	    for(int i = 0; i < listEvent.size(); i++)
	    {
	    	events.add(listEvent.get(i)); 
	    }
		
	    list = new JList<Event>(new Vector<Event>(events));
        list.setVisibleRowCount(10);
        list.setCellRenderer(new DefaultListCellRenderer() {
 
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Event) {
                    ((JLabel) renderer).setText(((Event) value).getName()+" de "+((Event) value).getHeureDeb()+" à "+((Event) value).getHeureFin()+" le "+((Event) value).getDate());
                }
                return renderer;
            }
        });

		panel.add(list);
		list.setPreferredSize(new Dimension(400, 400));

		list.setVisibleRowCount(10);
		

	}
	
	


}
