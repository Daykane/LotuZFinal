package com.LotuZ.user;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.EventInscription.FacadeEventInscription;
import com.LotuZ.event.Event;
import com.LotuZ.event.UI.DetailsEventUI;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.user.bl.User;





import java.awt.FlowLayout;


import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

public class PlanningUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Event> list;


	/**
	 * Create the frame.
	 * @throws UserNotFoundException 
	 * @throws SQLException 
	 */
	public PlanningUI() throws SQLException {
		
		User user = UserLog.getUserLog();

		List<Event> listEvent = FacadeEventInscription.getUserEvent(user);
	
		
		Bandeau bandeau = new Bandeau();
		bandeau.setJframe(this);

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
		
		
	    list = new JList<Event>(new Vector<Event>(listEvent));
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

		list.addMouseListener(new MouseAdapter() {
			private Event event;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int selected[] = list.getSelectedIndices();

				      for (int i = 0; i < selected.length; i++) {
				        Event events = (Event) list.getModel().getElementAt(selected[i]);
				        this.event = (Event)events;
				      }
					DetailsEventUI detailsEvent = null;
					detailsEvent = new DetailsEventUI(this.event);
					detailsEvent.setVisible(true);
					detailsEvent.setLocationRelativeTo(null);

				}
			}
		});

	}
	
	


}
