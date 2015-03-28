package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.user.FacadeUser;



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
		activityLeader = activityLeader.load(idActivityLeader);
		return activityLeader;
	}
	



	/**
	 * @param idActivityLeader
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void deleteActivityLeader(String idActivityLeader) throws SQLException, ClassNotFoundException {
		ActivityLeader activityLeader = pkit.createActivityLeader();
		activityLeader = activityLeader.load(idActivityLeader);
		activityLeader.delete();
	}
}
