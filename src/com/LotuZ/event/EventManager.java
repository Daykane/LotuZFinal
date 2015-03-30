package com.LotuZ.event;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.LotuZ.PersistKit;


public class EventManager {
	
	private PersistKit pkit;

	public EventManager(PersistKit kit) {
		this.pkit=kit;
	}

	public void createEvent(String name, int nbParticipant,
			int price, String startingTime, String finishingTime, java.util.Date date,
			String description, int idRepetition, int idActivity, int idContrib, int idRoom) throws SQLException {
		Event event = pkit.createEvent();
		event.setDate(date);
		event.setName(name);
		event.setHeureDeb(startingTime);
		event.setHeureFin(finishingTime);
		event.setRoom(idRoom);
		event.setRepetition(idRepetition);
		event.setIdContributor(idContrib);
		event.setIdActivity(idActivity);
		event.setNbParticipant(nbParticipant);
		event.setDescription(description);
		event.setPrice(price);
		event.save();
		
		
	}

	public Event getEvent(int idEvent) throws SQLException {
		Event event = pkit.createEvent();
		event = event.load(idEvent);
		return event;
	}

	public Event instanceEvent(String name, int nbParticipant, int price,
			String startingTime, String finishingTime, Date date,
			String description, int idRepetition, int idActivity,
			int idContrib, int idRoom) {
		Event event = pkit.createEvent();
		event.setDate(date);
		event.setName(name);
		event.setHeureDeb(startingTime);
		event.setHeureFin(finishingTime);
		event.setRoom(idRoom);
		event.setRepetition(idRepetition);
		event.setIdContributor(idContrib);
		event.setIdActivity(idActivity);
		event.setNbParticipant(nbParticipant);
		event.setDescription(description);
		event.setPrice(price);
		return event;
		
	}

	public void updateEvent(Event oldEvent, Event newEvent) throws SQLException {
		Event event = pkit.createEvent();
		event.setIdEvent(oldEvent.getIdEvent());
		event.setDate(newEvent.getDate());
		event.setName(newEvent.getName());
		event.setHeureDeb(newEvent.getHeureFin());
		event.setHeureFin(newEvent.getHeureFin());
		event.setRoom(newEvent.getRoom());
		event.setRepetition(newEvent.getRepetition());
		event.setIdContributor(newEvent.getIdContributor());
		event.setIdActivity(newEvent.getIdActivity());
		event.setNbParticipant(newEvent.getNbParticipant());
		event.setDescription(newEvent.getDescription());
		event.setPrice(newEvent.getPrice());
		event.update();
	}

	public void deleteEvent(int idEvent) throws SQLException {
		Event event = pkit.createEvent();
		event.setIdEvent(idEvent);
		event.delete();
	}

	public List<Event> getEventsActivity(int idActivity) throws SQLException {
		List<Event> lEvent;
		Event event = pkit.createEvent();
		lEvent = event.loadAll(idActivity);
		return lEvent;
	}
	
	public List<Event> getEventsContributor(int idContributor) throws SQLException {
		List<Event> eventsContributor;
		Event event = pkit.createEvent();
		eventsContributor = event.loadEventsContributor(idContributor);
		return eventsContributor;
	}

	public void createEvent2(String name, int nbParticipant, int price,
			String startingTime, String finishingTime, java.util.Date date,
			String description, int idRepetition, int idActivity,
			int idContrib, int idRoom) throws SQLException {
		Event event = pkit.createEvent();
		event.setDate(date);
		event.setName(name);
		event.setHeureDeb(startingTime);
		event.setHeureFin(finishingTime);
		event.setRoom(idRoom);
		event.setRepetition(idRepetition);
		event.setIdContributor(idContrib);
		event.setIdActivity(idActivity);
		event.setNbParticipant(nbParticipant);
		event.setDescription(description);
		event.setPrice(price);
		event.save();
		
		
	}

	public void updateEvent(Event oldEvent, String name, int nbParticipant,
			int price, String startingTime, String finishingTime,
			java.util.Date date, String description, int idRepetition,
			int idActivity, int idContrib, int idRoom) throws SQLException {
		
		Event event = pkit.createEvent();
		event.setIdEvent(oldEvent.getIdEvent());
		event.setDate(date);
		event.setName(name);
		event.setHeureDeb(startingTime);
		event.setHeureFin(finishingTime);
		event.setRoom(idRoom);
		event.setRepetition(idRepetition);
		event.setIdContributor(idContrib);
		event.setIdActivity(idActivity);
		event.setNbParticipant(nbParticipant);
		event.setDescription(description);
		event.setPrice(price);
		event.update();
	}

}
