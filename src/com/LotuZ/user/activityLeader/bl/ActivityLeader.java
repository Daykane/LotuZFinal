package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.user.member.bl.Member;


/**
 * @author Ludo
 *
 */


public abstract class ActivityLeader extends Member{
	

	public ActivityLeader() {
		super();
	}


	private List<Activity> namesActivity;


	public ActivityLeader(List<Activity> namesActivity) {
		super();
		this.setNamesActivity(namesActivity);
	}


	
	public List<Activity> getNamesActivity() {
		return namesActivity;
	}


	public void setNamesActivity(List<Activity> namesActivity) {
		this.namesActivity = namesActivity;
	}
	
	
	/**
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract ActivityLeader update() throws SQLException;



	/**
	 * @param idActivityLeader
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract ActivityLeader load(String idActivityLeader) throws SQLException;
	
	
	/**
	 * @param idActivityLeader
	 * @throws SQLException
	 */
	public abstract void delete(String idActivityLeader) throws SQLException;





	
}
