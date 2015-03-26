package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.user.member.bl.Member;


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


	public ActivityLeader(String nameActivity) {
		super();
		this.setNameActivity(nameActivity);
	}


	
	public String getNameActivity() {
		return nameActivity;
	}


	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}
	
	


	/**
	 * @param idActivityLeader
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract ActivityLeader load(String idActivityLeader) throws SQLException;



	public String getIdLeader() {
		return idLeader;
	}



	public void setIdLeader(String idLeader) {
		this.idLeader = idLeader;
	}



	public abstract void delete() throws ClassNotFoundException, SQLException ;
	




	
}
