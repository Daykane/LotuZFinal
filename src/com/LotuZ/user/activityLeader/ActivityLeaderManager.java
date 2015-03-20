package com.LotuZ.user.activityLeader;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.activity.Activity;


public class ActivityLeaderManager {

	private PersistKit pkit;
	
	public ActivityLeaderManager(PersistKit kit){
		this.pkit=kit;
	}
	
	public ActivityLeader getActivityLeader(int idActivityLeader) throws SQLException {
		ActivityLeader activityLeader = pkit.createActivityLeader();
		ActivityLeader acti = activityLeader.load(idActivityLeader);
		return null;
		
	}
	/*public static List<User> getActivityLeaders() throws SQLException {
		ListActivityLeaderJDBC users = null;
		//ListActivityLeaderJDBC users = pkit.createListActivityLeader();
		//users.load()
		return users.load();
	}*/

}
