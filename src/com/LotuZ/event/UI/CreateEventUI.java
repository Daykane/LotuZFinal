package com.LotuZ.event.UI;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.event.FacadeEvent;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.JSpinner;

import java.awt.Choice;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateEventUI extends JFrame {

	private JPanel contentPane;
	private JTextField TfName;
	private Calendar cal;
	private JTextField textDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEventUI frame = new CreateEventUI();
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
	public CreateEventUI() {
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name : ");
		panelMain.add(lblName, "2, 2, right, default");
		
		TfName = new JTextField();
		panelMain.add(TfName, "4, 2, left, default");
		TfName.setColumns(10);
		
		JLabel lblHeureDbut = new JLabel("Heure D\u00E9but : ");
		panelMain.add(lblHeureDbut, "2, 4, right, default");
		
		JPanel panel = new JPanel();
		panelMain.add(panel, "4, 4, fill, fill");
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
		panelMain.add(lblHeureDeFin, "2, 6, right, default");
		
		JPanel panel_1 = new JPanel();
		panelMain.add(panel_1, "4, 6, left, fill");
		
		SpinnerModel modelHeureFin = new SpinnerNumberModel(01, 00, 12, 1);
		final JSpinner spinnerHeureFin = new JSpinner(modelHeureFin);
		panel_1.add(spinnerHeureFin);
		
		JLabel lblheure = new JLabel("h");
		panel_1.add(lblheure);
		
		SpinnerModel modelMinFin = new SpinnerNumberModel(01, 00, 59, 1);
		final JSpinner spinnerMinuteFin = new JSpinner(modelMinFin);
		panel_1.add(spinnerMinuteFin);
		//spinnerMinuteFin
		
		JLabel lblMinute = new JLabel("min");
		panel_1.add(lblMinute);
		
		JLabel lblDate = new JLabel("Date : ");
		panelMain.add(lblDate, "2, 8, right, default");
		
		textDate = new JTextField();
		textDate.setText("YYYY-MM-dd");
		panelMain.add(textDate, "4, 8, left, default");
		textDate.setColumns(10);
		
		
		JLabel lblRepetition = new JLabel("Repetition : ");
		panelMain.add(lblRepetition, "2, 10, right, default");
		
		Choice choice = new Choice();
		panelMain.add(choice, "4, 10, left, default");
		
		JLabel lblNombreParticipant = new JLabel("Nombre participant : ");
		panelMain.add(lblNombreParticipant, "2, 12");
		
		final JSpinner spinnerNbParticipant = new JSpinner();
		panelMain.add(spinnerNbParticipant, "4, 12, left, default");
		
		JLabel lblSalle = new JLabel("Salle : ");
		panelMain.add(lblSalle, "2, 14, right, default");
		
		Choice choice_1 = new Choice();
		panelMain.add(choice_1, "4, 14, left, default");
		
		JLabel lblDescr = new JLabel("Description : ");
		panelMain.add(lblDescr, "2, 16, right, default");
		
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
					System.out.println(startingTime);
					System.out.println(finishingTime);
					//FacadeEvent.createEvent(name, nbParticipant, price, startingTime, finishingTime, date, description, idRepetition, idActivity, idContrib, idRoom);
					
				}
			}


		});
		panel_2.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		panel_2.add(btnCancel);
	}
	
	private boolean control() {
		// TODO Auto-generated method stub
		return true;
	}
}
