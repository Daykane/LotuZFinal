package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;

import com.LotuZ.PersistKit;



/**
 * @author Ludo
 *
 */
public class ActivityLeaderManager {

	private PersistKit pkit;
	
	/**
	 * 
	 * @param kit
	 */
	public ActivityLeaderManager(PersistKit kit){
		this.pkit=kit;
	}
	
	/**
	 * @param idActivityLeader
	 * @return
	 * @throws SQLException
	 */
	public ActivityLeader getActivityLeader(String idActivityLeader) throws SQLException {
		ActivityLeader activityLeader = pkit.createActivityLeader();
		activityLeader.load(idActivityLeader);
		if (activityLeader == null)
		{
			System.out.println("FAUX");
		}
		return activityLeader;
	}
	



	/**
	 * @param idActivityLeader
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void deleteActivityLeader(String idActivityLeader) throws SQLException, ClassNotFoundException {
		ActivityLeader activityLeader = pkit.createActivityLeader();
		activityLeader.delete();
	}
}
