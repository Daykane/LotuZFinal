package com.LotuZ.EventInscription;

import com.LotuZ.PersistKit;
import com.LotuZ.event.Event;
import com.LotuZ.event.EventManager;
import com.LotuZ.event.repetition.RepetitionManager;
import com.LotuZ.user.user.bl.User;

public class FacadeEventInscription {
	
	private static EventInscriptionManager eventInscriptionManager;
	
	public static void init(PersistKit kit){
		eventInscriptionManager = new EventInscriptionManager(kit);
	}

	public static void addUserInEvent(User user, Event event) {
		eventInscriptionManager.addUserInEvent(user,event);
		
	}

}
