package com.LotuZ.event.UI;

import interfaceDeBase.Bandeau;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.LotuZ.DataBaseException;
import com.LotuZ.FacadeBL;
import com.LotuZ.activity.Activity;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.room.bl.Room;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.user.bl.ListUser;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;

/**
 * @author Alexis
 *
 */
public class CreateEventUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TfName;
	private JTextField textDate;
	private JTextField tfPrice;


	/**
	 * Create the frame.
	 */
	public CreateEventUI() {
		User user = UserLog.getUserLog();


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
		contentPane.add(bandeau.createBandeau(user, "Gestion Event"), BorderLayout.NORTH);

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
				FormFactory.PREF_ROWSPEC,
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
		ArrayList<Room> rooms =FacadeBL.getAllRoom();		
		JComboBox cBoxRoom = new JComboBox(rooms.toArray());
		cBoxRoom.setRenderer(new DefaultListCellRenderer() {
 
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Room) {
                    ((JLabel) renderer).setText(((Room) value).getNameRoom()+" "+((Room) value).getSurfaceRoom());
                }
                return renderer;
            }
        });
		panelMain.add(cBoxRoom, "4, 16, left, default");

		JLabel lblContributor = new JLabel("Contributor : ");
		panelMain.add(lblContributor, "2, 18, right, default");
		
		
		JPanel panelContributor = new JPanel();
		panelMain.add(panelContributor, "4, 18, left, fill");
		panelContributor.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		final User[] arrayContrib;
		arrayContrib = toUserArray(listUser);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox choiceContrib = new JComboBox(arrayContrib);
		panelContributor.add(choiceContrib);		
		
		final JCheckBox chckbxContrib = new JCheckBox("No contributor");
		panelContributor.add(chckbxContrib);

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
		
		final BoxLetter boxLetter = FacadeBL.getBoxLetter(UserLog.getUserLog().getIdMember());
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
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


						date = formatter.parse(dateInString);


						int idRepetition = 0;
						int idActivity = 0;
						int idContrib = 0;
						if (choiceRep.getSelectedIndex() != -1){
							idRepetition = list[choiceRep.getSelectedIndex()].getIdRepetition();
						}
						if(BoxActivity.getSelectedIndex() != -1){
							idActivity = listAct[BoxActivity.getSelectedIndex()].getIdActivity();
						}
						if (choiceContrib.getSelectedIndex() != 1){
							idContrib = arrayContrib[choiceContrib.getSelectedIndex()].getIdContributor();
						}
						if (chckbxContrib.isSelected()){
							idContrib = 0;
						}

						int idRoom = 0;

						int price = 0;
						price = Integer.parseInt(tfPrice.getText());
						

						FacadeEvent.createEvent2(name, nbParticipant, price, startingTime, finishingTime, date, description, idRepetition, idActivity, idContrib, idRoom);
						JOptionPane.showMessageDialog(null,"Event add in system","Sucess",JOptionPane.INFORMATION_MESSAGE);
						
						boxLetter.sendNotification(14, UserLog.getUserLog().getIdMember());
						dispose();
					}
					}catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Error with the database","Faild creation",JOptionPane.WARNING_MESSAGE);					}
					catch (java.lang.NumberFormatException e){
						JOptionPane.showMessageDialog(null,"prix format invalid","Faild creation",JOptionPane.WARNING_MESSAGE);
					} 
					catch (ParseException e) {
					JOptionPane.showMessageDialog(null,"dateformat invalid","Faild creation",JOptionPane.WARNING_MESSAGE);

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



		/**
		 * always true so useless for the moment
		 * @return true if param control is okay
		 */
		private boolean control() {
			// TODO Auto-generated method stub
			return true;
		}

		/**
		 * @return Array with all repetitions
		 */
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

		/**
		 * Convert ListRepetition in ArrayRepetition
		 * @param lrepet : List Repetition
		 */
		Repetition[] toRepetitionArray(List<Repetition> lrepet){
			Repetition[] ret = new Repetition[lrepet.size()];
			for(int i = 0;i < ret.length;i++)
				ret[i] = lrepet.get(i);
			return ret;
		}

		/**
		 * Activites que l'utilisateur peut manager
		 * @return Array with Activies
		 */
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
			} catch (DataBaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			final Activity[] liste = toActivityArray(lact);		
			return liste;
		}

		/**
		 * Convert ListActivity into ArrayActivity
		 * @param lact : List Activity
		 * @return
		 */
		Activity[] toActivityArray(List<Activity> lact){
			Activity[] act = new Activity[lact.size()];
			for(int i = 0;i < act.length;i++)
				act[i] = lact.get(i);
			return act;
		}

		/**
		 * Convert ListUser into ArrayUser
		 * @param luser : List USer
		 * @return
		 */
		User[] toUserArray(List<User> luser){
			User[] user = new User[luser.size()];
			for(int i = 0;i < user.length;i++)
				user[i] = luser.get(i);
			return user;
		}
	}
