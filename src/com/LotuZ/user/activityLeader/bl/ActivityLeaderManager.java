package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.login.UserNotFoundException;
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
	 * @return activityLeader
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
	 * @throws UserNotFoundException 
	 */
	public void deleteActivityLeader(String idActivityLeader) throws SQLException, ClassNotFoundException, UserNotFoundException {
		ActivityLeader activityLeader = pkit.createActivityLeader();
		activityLeader.setIdLeader(idActivityLeader);
		activityLeader.delete();
	}
}
