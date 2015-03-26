package com.LotuZ.event;

import java.util.Date;

import com.LotuZ.PersistKit;


public class EventManager {
	
	private PersistKit pkit;

	public EventManager(PersistKit kit) {
		this.pkit=kit;
	}

	public void createEvent(String name, int nbParticipant,
			int price, String startingTime, String finishingTime, Date date,
			int idRepetition, int idActivity, String idContrib, int idRoom) {
		Event event = new Event();
		event.setDate(date);
		event.setName(name);
		event.setHeureDeb(startingTime);
		event.setHeureFin(finishingTime);
		event.setRoom(idRoom);
		event.setRepetition(idRepetition);
		event.setIdContributor(idContrib);
		event.setNbParticipant(nbParticipant);
		//event.setDescription(description);
		//event.setPrice(price);
		
		
	}

}
