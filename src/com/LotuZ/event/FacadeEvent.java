package com.LotuZ.event;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.activity.ActivityManager;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionManager;
import com.LotuZ.inscription.InscriptionManager;
import com.LotuZ.login.LoginManager;
import com.LotuZ.user.activityLeader.bl.ActivityLeaderManager;


public class FacadeEvent {
	
	private static EventManager eventManager;
	private static RepetitionManager repetitionManager;
	
	public static void init(PersistKit kit){
		eventManager = new EventManager(kit);
		repetitionManager = new RepetitionManager(kit);
	}

	public static void createRepetition(String name) throws ClassNotFoundException, SQLException {
		repetitionManager.createRepetition(name);
		
	}

	public static Repetition getRepetition(String name) throws SQLException {		
		return repetitionManager.getRepetition(name);
	}

	public static Repetition getRepetition(int idRep) throws SQLException {
		return repetitionManager.getRepetition(idRep);
	}

	public static void updateRepetition(Repetition rep, String name) throws ClassNotFoundException, SQLException {
		repetitionManager.updateRepetition(rep,name);
	}

	public static void deleteRepetition(int idRep) throws ClassNotFoundException, SQLException {
		repetitionManager.deleteRepetition(idRep);		
	}

	public static List<Repetition> getAllRepetition() throws SQLException {
		return repetitionManager.getAllRepetion();
	}

	public static void createEvent(String name, int nbParticipant,
			int price, String startingTime, String finishingTime, Date date,
			int idRepetition, int idActivity, String idContrib, int idRoom) {
		eventManager.createEvent(name, nbParticipant,price,
			startingTime, finishingTime, date,
			idRepetition, idActivity, idContrib, idRoom);
		
	}

}
