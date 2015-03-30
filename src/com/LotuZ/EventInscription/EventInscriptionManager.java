package com.LotuZ.EventInscription;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.user.user.bl.User;

/**
 * @author Alexis
 *
 */
public class EventInscriptionManager {

	private PersistKit pkit;

	/**
	 * initialize Manager with the persistance
	 * @param kit persistance kit
	 */
	public EventInscriptionManager(PersistKit kit) {
		this.pkit=kit;
	}

	/**
	 * register the user in the event
	 * @param user
	 * @param event
	 * @throws SQLException
	 */
	public void addUserInEvent(User user, Event event) throws SQLException {
		EventInscription eventInscr = pkit.createEventInscription();
		eventInscr.setIdMember(user.getMail());
		eventInscr.setIdEvent(event.getIdEvent());
		eventInscr.add();
		
	}

	/**
	 * ListEvent where the user is register
	 * @param user
	 * @throws SQLException
	 */
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

	/**
	 * List identifer User register in the Event
	 * @param event
	 * @return List user identifier
	 * @throws SQLException
	 */
	public List<String> getEventUser(Event event) throws SQLException {
		List<String> lUser;
		EventInscription eventInscription = pkit.createEventInscription();
		eventInscription.setIdEvent(event.getIdEvent());
		lUser = eventInscription.loadEventUser();
		return lUser;
	}

}
