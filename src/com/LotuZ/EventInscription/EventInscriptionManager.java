package com.LotuZ.EventInscription;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.event.Event;
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

	public List<Integer> getUserEvent(User user) throws SQLException {
		List<Integer> lEvent;
		EventInscription eventInscription = pkit.createEventInscription();
		eventInscription.setIdMember(user.getMail());
		lEvent = eventInscription.loadUserEvent();
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
