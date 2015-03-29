/**
 * 
 * @author Alexis
 *
 */
package com.LotuZ.activity;

import java.sql.SQLException;
import java.util.List;


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
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name ;
	}


	/**
	 * Save Activity in base
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract void save() throws SQLException, ClassNotFoundException;
	/**
	 * Get Activity in base with its name
	 * @param name : name of activity
	 * @throws SQLException
	 */
	public abstract Activity load(String name) throws SQLException;
	/**
	 * Get Activity in base with its id
	 * @param i : identifier of Activity
	 * @throws SQLException
	 */
	public abstract Activity load(int i) throws SQLException;
	/**
	 * Update the Activity in base
	 * @throws SQLException
	 */
	public abstract void update() throws SQLException;
	/**
	 * Return all Activity in Base
	 * @throws SQLException
	 */
	public abstract List<Activity> loadAll() throws SQLException;
	/**
	 * Return List Activity managed by the respo
	 * @throws SQLException
	 */
	public abstract List<Activity> loadForRespo() throws SQLException;
	/**
	 * Delete the Activity in Base
	 * @throws SQLException
	 */
	public abstract void delete() throws SQLException;
	

	
}
