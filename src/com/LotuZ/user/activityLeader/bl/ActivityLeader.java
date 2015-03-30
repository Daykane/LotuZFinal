package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;



/**
 * @author Ludo
 *
 */



public abstract class ActivityLeader {
	


	public ActivityLeader() {
		super();
	}


	private String nameActivity;
	private String idLeader;


	/**
	 * @param nameActivity
	 */
	public ActivityLeader(String nameActivity) {
		super();
		this.setNameActivity(nameActivity);
	}


	
	/**
	 * @return nameActivity
	 */
	public String getNameActivity() {
		return nameActivity;
	}


	/**
	 * @param nameActivity to set
	 */
	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}
	
	


	/**
	 * @param idActivityLeader
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract ActivityLeader load(String idActivityLeader) throws SQLException;



	/**
	 * @return idLeader
	 */
	public String getIdLeader() {
		return idLeader;
	}



	/**
	 * @param idLeader to set
	 */
	public void setIdLeader(String idLeader) {
		this.idLeader = idLeader;
	}



	/**
	 * delete an Activity Leader
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public abstract void delete() throws ClassNotFoundException, SQLException ;



	public abstract void save(String mail) throws ClassNotFoundException, SQLException ;
	




	
}
