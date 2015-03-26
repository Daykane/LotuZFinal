package com.LotuZ.EventInscription;

import com.LotuZ.PersistKit;
import com.LotuZ.event.Event;
import com.LotuZ.user.user.bl.User;

public class EventInscriptionManager {

	private PersistKit pkit;

	public EventInscriptionManager(PersistKit kit) {
		this.pkit=kit;
	}

	public void addUserInEvent(User user, Event event) {
		EventInscription eventInscr = pkit.createEventInscription();		
	}

}
