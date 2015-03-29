package com.LotuZ.event.UI;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author Alexis
 *
 */
public class EditEventUI extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TfName;
	private JTextField textDate;
	private JTextField tfPrice;


	/**
	 * Create the frame.
	 */
	public EditEventUI(final Event event) {
		User user = UserLog.getUserLog();

		System.out.println("Mail page acceuil test : " + user.getMail());

		setTitle("Zen Lounge");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,800, 750, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(new Bandeau().createBandeau(user, "Edit Event"), BorderLayout.NORTH);
		
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
		
		JLabel lblActivite = new JLabel("Activit\u00E9e : ");
		panelMain.add(lblActivite, "2, 4, right, default");
		
		final Activity[] listAct = this.generateListActi(user.getMail());
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox BoxActivity = new JComboBox(listAct);		
		panelMain.add(BoxActivity, "4, 4, left, default");
		
		JLabel lblHeureDbut = new JLabel("Heure D\u00E9but : ");
		panelMain.add(lblHeureDbut, "2, 6, right, default");
		
		JPanel panel = new JPanel();
		panelMain.add(panel, "4, 6, fill, fill");
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		SpinnerModel modelHeureDeb = new SpinnerNumberModel(01, 00, 12, 1);
		final JSpinner spinnerHeureDeb = new JSpinner(modelHeureDeb);
		panel.add(spinnerHeureDeb);
		
		JLabel lblHeureLabel = new JLabel("h");
		panel.add(lblHeureLabel);
		
		SpinnerModel modelMinDeb = new SpinnerNumberModel(01, 00, 59, 1);
		final JSpinner spinnerMinuteDeb = new JSpinner(modelMinDeb);
		panel.add(spinnerMinuteDeb);
		
		JLabel lblMin = new JLabel("min");
		panel.add(lblMin);
		
		JLabel lblHeureDeFin = new JLabel("Heure de Fin : ");
		panelMain.add(lblHeureDeFin, "2, 8, right, default");
		
		JPanel panel_1 = new JPanel();
		panelMain.add(panel_1, "4, 8, left, fill");
		
		SpinnerModel modelHeureFin = new SpinnerNumberModel(01, 00, 12, 1);
		final JSpinner spinnerHeureFin = new JSpinner(modelHeureFin);
		panel_1.add(spinnerHeureFin);
		
		JLabel lblheure = new JLabel("h");
		panel_1.add(lblheure);
		
		SpinnerModel modelMinFin = new SpinnerNumberModel(01, 00, 59, 1);
		final JSpinner spinnerMinuteFin = new JSpinner(modelMinFin);
		panel_1.add(spinnerMinuteFin);
		
		JLabel lblMinute = new JLabel("min");
		panel_1.add(lblMinute);
		
		JLabel lblDate = new JLabel("Date : ");
		panelMain.add(lblDate, "2, 10, right, default");
		
		textDate = new JTextField();
		textDate.setText("YYYY-MM-dd");
		panelMain.add(textDate, "4, 10, left, default");
		textDate.setColumns(10);
		
		
		JLabel lblRepetition = new JLabel("Repetition : ");
		panelMain.add(lblRepetition, "2, 12, right, default");
		
		/*
		 * Repetition in the comboBox
		 */
		final Repetition[] list = this.generateListRepet();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox choiceRep = new JComboBox(list);		
		panelMain.add(choiceRep, "4, 12, left, default");
		
		JLabel lblNombreParticipant = new JLabel("Nombre participant : ");
		panelMain.add(lblNombreParticipant, "2, 14");
		
		final JSpinner spinnerNbParticipant = new JSpinner();
		panelMain.add(spinnerNbParticipant, "4, 14, left, default");
		
		JLabel lblSalle = new JLabel("Salle : ");
		panelMain.add(lblSalle, "2, 16, right, default");
		
		//TODO get list room
		String mail;
		Choice choiceRoom = new Choice();
		panelMain.add(choiceRoom, "4, 16, left, default");
		
		JLabel lblContributor = new JLabel("Contributor : ");
		panelMain.add(lblContributor, "2, 18, right, default");
		
		/*
		 * Contributor in comboBox
		 */
		List<User> listUser;
		ListUser u = null;
		try {
			u = FacadeUser.getContributors();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		listUser = u.getListUser();
		User[] arrayContrib;
		arrayContrib = toUserArray(listUser);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox choiceContrib = new JComboBox(arrayContrib);
		panelMain.add(choiceContrib, "4, 18, left, default");
		
		JLabel lblPrice = new JLabel("Price : ");
		panelMain.add(lblPrice, "2, 20, right, default");
		
		tfPrice = new JTextField();
		panelMain.add(tfPrice, "4, 20, left, default");
		tfPrice.setColumns(10);
		
		JLabel lblDescr = new JLabel("Description : ");
		panelMain.add(lblDescr, "2, 22, right, default");
		
		final JTextArea tfDescr = new JTextArea();
		panelMain.add(tfDescr, "4, 22, fill, fill");
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (control()){
					String name = TfName.getText();
					int nbParticipant = (Integer) spinnerNbParticipant.getValue();
					int heureDeb = (Integer) spinnerHeureDeb.getValue();
					int minDeb = (Integer) spinnerMinuteDeb.getValue();
					int heureFin = (Integer) spinnerHeureFin.getValue();
					int minFin = (Integer) spinnerMinuteDeb.getValue();
					String startingTime = heureDeb+"h"+minDeb+"min";
					String finishingTime = heureFin+"h"+minFin+"min";
					String description = tfDescr.getText();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");					
					String dateInString = textDate.getText();
					java.util.Date date = null;
					try {
						date = formatter.parse(dateInString);
					} catch (ParseException e) {
						System.out.println("format date error");
					}
					int idRepetition = list[choiceRep.getSelectedIndex()].getIdRepetition();
					int idActivity = listAct[BoxActivity.getSelectedIndex()].getIdActivity();
					
					int idContrib = 0;
					//TODO get list Romm;
					int idRoom = 0;
					
					int price = 0;
					try{
					price = Integer.parseInt(tfPrice.getText());
					}
					catch (java.lang.NumberFormatException e){
						System.out.println("Error int string null");
					}
					try {
						FacadeEvent.updateEvent(event,name, nbParticipant, price, startingTime, finishingTime, date, description, idRepetition, idActivity, idContrib, idRoom);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}


		});
		panel_2.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panel_2.add(btnCancel);
	}
	
	

	private boolean control() {
		// TODO Auto-generated method stub
		return true;
	}
	
	Repetition[] generateListRepet(){
		List<Repetition> lrepet = null; 	
		try {
			lrepet = FacadeEvent.getAllRepetition();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Repetition[] liste = toRepetitionArray(lrepet);		
		return liste;		
	}
	
	Repetition[] toRepetitionArray(List<Repetition> lrepet){
		Repetition[] ret = new Repetition[lrepet.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = lrepet.get(i);
		  return ret;
		}
	
	private Activity[] generateListActi(String idRespo) {
		List<Activity> lact = null; 	
		try {
			Administrator admin = UserLog.getAdminLog();
			if (admin != null){
				lact = FacadeActivity.getAllActivities();
			}
			else{
				lact = FacadeActivity.getActivityOfLeader(idRespo);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Activity[] liste = toActivityArray(lact);		
		return liste;
	}
	
	Activity[] toActivityArray(List<Activity> lrepet){
		Activity[] ret = new Activity[lrepet.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = lrepet.get(i);
		  return ret;
		}
	
	User[] toUserArray(List<User> lrepet){
		User[] ret = new User[lrepet.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = lrepet.get(i);
		  return ret;
		}
	}


