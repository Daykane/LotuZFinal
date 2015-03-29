package com.LotuZ.event.UI;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.activity.UI.ActivityDetailsUI;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class DetailsEventUI extends JFrame {

	private JPanel contentPane;
	private JTextField TfName;
	private Calendar cal;
	private JTextField tfPrice;
	private JTextField BoxActivity;
	private JTextField TfActivity;
	private JTextField TfHeureDeb;
	private JTextField TfheureFin;
	private JTextField TfDate;
	private JTextField TfRep;
	private JTextField TfNbrPart;
	private JTextField TfSalle;
	private JTextField TfContrib;

	/**
	 * Create the frame.
	 * @param event 
	 */
	public DetailsEventUI(final Event event) {
		User user = UserLog.getUserLog();
		ActivityLeader respo = UserLog.getRespoLog();
		Administrator admin = UserLog.getAdminLog();

		System.out.println("Mail page acceuil test : " + user.getMail());

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//JPanel panelBandeau = new JPanel();
		//panelBandeau.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		contentPane.add(new Bandeau().createBandeau(user, "Gestion Event"), BorderLayout.NORTH);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(17dlu;pref)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
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
				RowSpec.decode("max(35dlu;min)"),}));

		JLabel lblName = new JLabel("Name : ");
		panelMain.add(lblName, "2, 2, right, default");

		TfName = new JTextField();
		panelMain.add(TfName, "4, 2, left, default");
		TfName.setColumns(10);
		TfName.setText(event.getName());

		JLabel lblActivite = new JLabel("Activit\u00E9e : ");
		panelMain.add(lblActivite, "2, 4, right, default");

		//BoxActivity.setColumns(10);
		Activity activity = null;
		try {
			activity = FacadeActivity.getActivity(event.getIdActivity());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		TfActivity = new JTextField(activity.getName());
		panelMain.add(TfActivity, "4, 4, left, default");
		TfActivity.setColumns(10);


		JLabel lblHeureDbut = new JLabel("Heure D\u00E9but : ");
		panelMain.add(lblHeureDbut, "2, 6, right, default");


		TfHeureDeb = new JTextField(event.getHeureDeb());
		panelMain.add(TfHeureDeb, "4, 6, left, default");
		TfHeureDeb.setColumns(10);

		JLabel lblHeureDeFin = new JLabel("Heure de Fin : ");
		panelMain.add(lblHeureDeFin, "2, 8, right, default");

		SpinnerModel modelHeureFin = new SpinnerNumberModel(01, 00, 12, 1);

		SpinnerModel modelMinFin = new SpinnerNumberModel(01, 00, 59, 1);

		TfheureFin = new JTextField(event.getHeureFin());
		panelMain.add(TfheureFin, "4, 8, left, fill");
		TfheureFin.setColumns(10);

		JLabel lblDate = new JLabel("Date : ");
		panelMain.add(lblDate, "2, 10, right, default");

		TfDate = new JTextField(event.getDate().toString());
		panelMain.add(TfDate, "4, 10, left, default");
		TfDate.setColumns(10);


		JLabel lblRepetition = new JLabel("Repetition : ");
		panelMain.add(lblRepetition, "2, 12, right, default");

		Repetition repet = null;
		try {
			repet = FacadeEvent.getRepetition(event.getRepetition());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (repet != null){
			TfRep = new JTextField(repet.getName());
		}
		else{
			TfRep = new JTextField();
		}
		panelMain.add(TfRep, "4, 12, left, top");
		TfRep.setColumns(10);

		JLabel lblNombreParticipant = new JLabel("Nombre participant : ");
		panelMain.add(lblNombreParticipant, "2, 14, right, default");

		TfNbrPart = new JTextField(Double.toString(event.getNbParticipant()));
		panelMain.add(TfNbrPart, "4, 14, left, default");
		TfNbrPart.setColumns(10);

		JLabel lblSalle = new JLabel("Salle : ");
		panelMain.add(lblSalle, "2, 16, right, default");

		TfSalle = new JTextField();
		panelMain.add(TfSalle, "4, 16, left, default");
		TfSalle.setColumns(10);


		JLabel lblContributor = new JLabel("Contributor : ");
		panelMain.add(lblContributor, "2, 18, right, default");

		//TODO le nom du contributor
		TfContrib = new JTextField();
		panelMain.add(TfContrib, "4, 18, left, default");
		TfContrib.setColumns(10);

		JLabel lblPrice = new JLabel("Price : ");
		panelMain.add(lblPrice, "2, 20, right, default");

		tfPrice = new JTextField(Double.toString(event.getPrice()));
		panelMain.add(tfPrice, "4, 20, left, default");
		tfPrice.setColumns(10);

		JLabel lblDescr = new JLabel("Description : ");
		panelMain.add(lblDescr, "2, 22, right, default");

		final JTextArea tfDescr = new JTextArea(event.getDescription());
		panelMain.add(tfDescr, "4, 22, fill, fill");

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EditEventUI details;
				details = new EditEventUI(event);
				details.setVisible(true);
				details.setLocationRelativeTo(null);
			}
		});
		panel_2.add(btnEdit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panel_2.add(btnCancel);
		
		btnEdit.setVisible(false);
		if( admin != null ){
			btnEdit.setVisible(true);
		}
		else if(respo !=null && respo.getIdLeader()!= activity.getIdRespo() ){
			btnEdit.setVisible(true);
		}
	}

}


