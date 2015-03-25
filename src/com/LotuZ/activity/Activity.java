/**
 * 
 * @author Alexis
 *
 */
package com.LotuZ.activity;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.LotuZ.event.Event;
import com.LotuZ.user.user.bl.User;

public abstract class Activity {	
	
	private int IdActivity;
	private String name;
	private String shortDescr;
	private String longDescr;
	private String idRespo;
	private List<Integer> event;
	private String createDate;
	private String majDate;

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
	 * @return the idActivity
	 */
	public int getIdActivity() {
		return IdActivity;
	}



	/**
	 * @param idActivity the idActivity to set
	 */
	public void setIdActivity(int idActivity) {
		IdActivity = idActivity;
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
	public String getIdRespo() {
		return idRespo;
	}

	/**
	 * @param respo the respo to set
	 */
	public void setIdRespo(String idRespo) {
		this.idRespo = idRespo;
	}

	/**
	 * @return the event
	 */
	public List<Integer> getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(List<Integer> event) {
		this.event = event;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param date the createDate to set
	 */
	public void setCreateDate(String date) {
		this.createDate = date;
	}

	/**
	 * @return the majDate
	 */
	public String getMajDate() {
		return majDate;
	}

	/**
	 * @param date the majDate to set
	 */
	public void setMajDate(String date) {
		this.majDate = date;
	}

	public abstract void save() throws SQLException, ClassNotFoundException;

	public abstract Activity load(String name) throws SQLException;

	public abstract Activity load(int i) throws SQLException;

	public abstract Activity update() throws SQLException;

	public abstract List<Activity> loadAll() throws SQLException;
	
}
