package com.LotuZ.EventInscription;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.event.Event;

import com.LotuZ.user.user.bl.User;

public class FacadeEventInscription {
	
	private static EventInscriptionManager eventInscriptionManager;
	
	/**
	 * Init Manager with persistance kit
	 * @param kit : the persistance
	 */
	public static void init(PersistKit kit){
		eventInscriptionManager = new EventInscriptionManager(kit);
	}

	/**
	 * register the user in the event
	 * @param user
	 * @param event
	 * @throws SQLException
	 */
	public static void addUserInEvent(User user, Event event) throws SQLException {
		eventInscriptionManager.addUserInEvent(user,event);
		
	}

	/**
	 * ListEvent where the user is register
	 * @param user
	 * @throws SQLException
	 */
	public static List<Event> getUserEvent(User user) throws SQLException {
		return eventInscriptionManager.getUserEvent(user);		
	}
	/**
	 * List identifer User register in the Event
	 * @param event
	 * @return List user identifier
	 * @throws SQLException
	 */
	public static List<String> getEventUser(Event event) throws SQLException {
		return eventInscriptionManager.getEventUser(event);	
	}

}
