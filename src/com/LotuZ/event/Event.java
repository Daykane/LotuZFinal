/**
 * @author  Alexis
 */
package com.LotuZ.event;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.room.Room;

public abstract class Event {
	
	
	private int idEvent;
	private String name;
	private String description;
	private int nbParticipant;
	private Date date;
	private String heureDeb;
	private String heureFin;
	private int repetition;
	private double price;
	private int room;
	private int idContributor;
	private int idActivity;
	
	public Event() {
		super();
	}
		
	/**
	 * @param name
	 * @param description
	 * @param nbParticipant
	 * @param date
	 * @param heureDeb
	 * @param heureFin
	 * @param repetition
	 * @param price
	 */
	/*
	public Event(String name, String description, int nbParticipant, Date date,
			String heureDeb, String heureFin, int repetition,
			double price) {
		super();
		this.name = name;
		this.description = description;
		this.nbParticipant = nbParticipant;
		this.date = date;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.repetition = repetition;
		this.price = price;
	}
	*/
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the nbParticipant
	 */
	public int getNbParticipant() {
		return nbParticipant;
	}
	/**
	 * @param nbParticipant the nbParticipant to set
	 */
	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date2 the date to set
	 */
	public void setDate( java.sql.Date date) {
		this.date = (Date) date;
	}
	/**
	 * @return the heureDeb
	 */
	public String getHeureDeb() {
		return heureDeb;
	}
	/**
	 * @param heureDeb the heureDeb to set
	 */
	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}
	/**
	 * @return the heureFin
	 */
	public String getHeureFin() {
		return heureFin;
	}
	/**
	 * @param heureFin the heureFin to set
	 */
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	/**
	 * @return the repetition
	 */
	public int getRepetition() {
		return repetition;
	}
	/**
	 * @param idRepetition the repetition to set
	 */
	public void setRepetition(int idRepetition) {
		this.repetition = idRepetition;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * @param idRoom the room to set
	 */
	public void setRoom(int idRoom) {
		this.room = idRoom;
	}

	/**
	 * @return the idContributor
	 */
	public int getIdContributor() {
		return idContributor;
	}

	public void setIdContributor(int idContrib) {
		this.idContributor = idContrib;
		
	}

	/**
	 * @return the idActivity
	 */
	public int getIdActivity() {
		return idActivity;
	}

	/**
	 * @param idActivity the idActivity to set
	 */
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public abstract void save() throws SQLException;

	public abstract Event load(int idEvent) throws SQLException;

	public abstract void update() throws SQLException;

	public abstract void delete() throws SQLException;

	public abstract List<Event> loadAll(int idActivity) throws SQLException;
	

}
