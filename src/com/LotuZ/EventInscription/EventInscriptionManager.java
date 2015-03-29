package com.LotuZ.EventInscription;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.user.user.bl.User;

public class EventInscriptionManager {

	private PersistKit pkit;

	public EventInscriptionManager(PersistKit kit) {
		this.pkit=kit;
	}

	public void addUserInEvent(User user, Event event) throws SQLException {
		EventInscription eventInscr = pkit.createEventInscription();
		eventInscr.setIdMember(user.getMail());
		eventInscr.setIdEvent(event.getIdEvent());
		eventInscr.add();
		
	}

	public List<Event> getUserEvent(User user) throws SQLException {
		List<Integer> lIdEvent;
		List<Event> lEvent = null;
		EventInscription eventInscription = pkit.createEventInscription();
		eventInscription.setIdMember(user.getMail());
		lIdEvent = eventInscription.loadUserEvent();
		lEvent = new ArrayList<Event>();
		for(int i : lIdEvent){
			Event envent = FacadeEvent.getEvent(i);
			lEvent.add(envent);
		}
		return lEvent;
	}

	public List<String> getEventUser(Event event) throws SQLException {
		List<String> lUser;
		EventInscription eventInscription = pkit.createEventInscription();
		eventInscription.setIdEvent(event.getIdEvent());
		lUser = eventInscription.loadEventUser();
		return lUser;
	}

}
