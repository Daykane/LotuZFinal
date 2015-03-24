package com.LotuZ.user.contributor.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.user.user.bl.User;
import com.LotuZ.event.Event;

/**
 * @author Ludo
 *
 */


public abstract class Contributor extends User{
	

	public Contributor() {
		super();
	}


	private List<Event> events;

	
	public Contributor(List<Event> events ) {
		super();
		this.setEvents(events);
	}


	

	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}


	

	/**
	 * @param idContributor
	 * @return contributor
	 * @throws SQLException
	 */
	public abstract Contributor load(String idContributor) throws SQLException;
	



	
}
