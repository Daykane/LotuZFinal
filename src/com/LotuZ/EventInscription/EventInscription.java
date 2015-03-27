package com.LotuZ.EventInscription;

import java.sql.SQLException;
import java.util.List;

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
	
	public abstract void add() throws SQLException;
	public abstract List<Integer> loadUserEvent() throws SQLException;
	public abstract List<String> loadEventUser() throws SQLException;
}
