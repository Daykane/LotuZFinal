package com.LotuZ.EventInscription;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Alexis
 *
 */
public abstract class EventInscription {
	
	private String idMember;
	private int idEvent;
	/**
	 * @return the idMember
	 */
	public String getIdMember() {
		return idMember;
	}
	/**
	 * @param idMember the idMember to set
	 */
	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}
	/**
	 * @return the idEvent
	 */
	public int getIdEvent() {
		return idEvent;
	}
	/**
	 * @param idEvent the idEvent to set
	 */
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	
	/**
	 * 
	 */
	public EventInscription() {
		super();
	}
	
	/**
	 * @param idMember
	 * @param idEvent
	 */
	public EventInscription(String idMember, int idEvent) {
		super();
		this.idMember = idMember;
		this.idEvent = idEvent;
	}
	
	/**
	 * Add inscription in the base
	 * @throws SQLException
	 */
	public abstract void add() throws SQLException;
	
	
	/**
	 * Get the event where the user is register
	 * @return List with identifer of Event
	 * @throws SQLException
	 */
	public abstract List<Integer> loadUserEvent() throws SQLException;
	/**
	 * Get the user register in the event
	 * @return List with the idenfier of User
	 * @throws SQLException
	 */
	public abstract List<String> loadEventUser() throws SQLException;
}
