package com.LotuZ.user.contributor.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.event.Event;

/**
 * @author Ludo
 *
 */

public abstract class Contributor{
	


	public Contributor() {
		super();
	}


	private List<Event> events;
	private String idContributor;

	
	/**
	 * @param events
	 */
	public Contributor(List<Event> events ) {
		super();
		this.setEvents(events);
	}


	

	/**
	 * @return events
	 */
	public List<Event> getEvents() {
		return events;
	}


	/**
	 * @param events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}


	

	/**
	 * @param idContributor
	 * @return contributor
	 * @throws SQLException
	 */
	public abstract Contributor load(String idContributor) throws SQLException;




	/**
	 * @return the id of the contributor
	 */
	public String getIdContributor() {
		return idContributor;
	}




	/**
	 * @param idContributor to set
	 */
	public void setIdContributor(String idContributor) {
		this.idContributor = idContributor;
	}




	/**
	 * delete a contributor
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public abstract void delete() throws ClassNotFoundException, SQLException;




	public abstract void save(String mail) throws ClassNotFoundException, SQLException;



	
}
