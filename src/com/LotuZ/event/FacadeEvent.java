package com.LotuZ.event;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionManager;



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
			int price, String startingTime, String finishingTime, java.util.Date date,
			String description, int idRepetition, int idActivity, int idContrib, int idRoom) throws SQLException {
		eventManager.createEvent(name, nbParticipant,price,
			startingTime, finishingTime, date,description,
			idRepetition, idActivity, idContrib, idRoom);
		
	}

	public static Event getEvent(int idEvent) throws SQLException {
		return eventManager.getEvent(idEvent);
	}

	public static  Event instanceEvent(String name, int nbParticipant,
			int price, String startingTime, String finishingTime, Date date,
			String description, int idRepetition, int idActivity,
			int idContrib, int idRoom) {
		return eventManager.instanceEvent(name, nbParticipant,price,
				startingTime, finishingTime, date,description,
				idRepetition, idActivity, idContrib, idRoom);
	}

	public static void updateEvent(Event oldEvent, Event newEvent) throws SQLException {
		eventManager.updateEvent(oldEvent,newEvent);
		
	}

	public static void deleteEvent(int idEvent) throws SQLException {
		eventManager.deleteEvent(idEvent);
		
	}

	public static List<Event> getEventsActivity(int idActivity) throws SQLException {
		return eventManager.getEventsActivity(idActivity);
	}
	
	public static List<Event> getEventsContributor(int idContributor) throws SQLException {
		return eventManager.getEventsContributor(idContributor);
	}

	public static void createEvent2(String name, int nbParticipant, int price,
			String startingTime, String finishingTime, java.util.Date date,
			String description, int idRepetition, int idActivity,
			int idContrib, int idRoom) throws SQLException {
		eventManager.createEvent(name, nbParticipant,price,
				startingTime, finishingTime, date,description,
				idRepetition, idActivity, idContrib, idRoom);
		
	}

	public static void updateEvent(Event oldEvent, String name, int nbParticipant,
			int price, String startingTime, String finishingTime,
			java.util.Date date, String description, int idRepetition,
			int idActivity, int idContrib, int idRoom) throws SQLException {
		eventManager.updateEvent(oldEvent, name, nbParticipant,
			 price, startingTime, finishingTime,
			 date, description, idRepetition,
			 idActivity, idContrib, idRoom);
		
	}

}
