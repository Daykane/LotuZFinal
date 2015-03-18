/**
 * 
 * @author Alexis
 *
 */
package com.LotuZ.activity;

import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import com.LotuZ.event.Event;
import com.LotuZ.user.User;

public abstract class Activity {	
	
	private String name;
	private String shortDescr;
	private String longDescr;
	private User respo;
	private Vector<Event> event;
	private Date createDate;
	private Date majDate;

	public Activity() {
		super();
	}
	


	/**
	 * @param name
	 * @param shortDescr
	 * @param longDescr
	 * @param respo
	 * @param event
	 * @param createDate
	 * @param majDate
	 */
	public Activity(String name, String shortDescr, String longDescr) {
		super();
		this.name = name;
		this.shortDescr = shortDescr;
		this.longDescr = longDescr;
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
	 * @return the shortDescr
	 */
	public String getShortDescr() {
		return shortDescr;
	}

	/**
	 * @param shortDescr the shortDescr to set
	 */
	public void setShortDescr(String shortDescr) {
		this.shortDescr = shortDescr;
	}

	/**
	 * @return the longDescr
	 */
	public String getLongDescr() {
		return longDescr;
	}

	/**
	 * @param longDescr the longDescr to set
	 */
	public void setLongDescr(String longDescr) {
		this.longDescr = longDescr;
	}

	/**
	 * @return the respo
	 */
	public User getRespo() {
		return respo;
	}

	/**
	 * @param respo the respo to set
	 */
	public void setRespo(User respo) {
		this.respo = respo;
	}

	/**
	 * @return the event
	 */
	public Vector<Event> getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Vector<Event> event) {
		this.event = event;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the majDate
	 */
	public Date getMajDate() {
		return majDate;
	}

	/**
	 * @param majDate the majDate to set
	 */
	public void setMajDate(Date majDate) {
		this.majDate = majDate;
	}

	public abstract void save() throws SQLException, ClassNotFoundException;

	public abstract User load(String name) throws SQLException;
}
