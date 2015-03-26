package com.LotuZ.event;

import java.sql.SQLException;
import java.sql.Date;

import com.LotuZ.PersistKit;


public class EventManager {
	
	private PersistKit pkit;

	public EventManager(PersistKit kit) {
		this.pkit=kit;
	}

	public void createEvent(String name, int nbParticipant,
			int price, String startingTime, String finishingTime, Date date,
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

}
