package com.LotuZ.EventInscription;

import java.sql.SQLException;
import java.util.List;

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

	public static void addUserInEvent(User user, Event event) throws SQLException {
		eventInscriptionManager.addUserInEvent(user,event);
		
	}

	public static List<Integer> getUserEvent(User user) throws SQLException {
		return eventInscriptionManager.getUserEvent(user);		
	}

	public static List<String> getEventUser(Event event) throws SQLException {
		return eventInscriptionManager.getEventUser(event);	
	}

}
