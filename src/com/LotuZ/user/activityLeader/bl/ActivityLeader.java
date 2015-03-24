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

	private List<String> namesActivity;
	private String idLeader;


	public ActivityLeader(List<String> namesActivity) {
		super();
		this.setNamesActivity(namesActivity);
	}


	
	public List<String> getNamesActivity() {
		return namesActivity;
	}


	public void setNamesActivity(List<String> namesActivity) {
		this.namesActivity = namesActivity;
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
