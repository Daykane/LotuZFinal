package com.LotuZ.user.activityLeader;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.user.User;

public class ActivityLeaderManager {

	private PersistKit pkit;
	
	public ActivityLeaderManager(PersistKit kit){
		this.pkit=kit;
	}
	
	public static User getActivityLeader(int idActivityLeader) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public static List<User> getActivityLeaders() throws SQLException {
		ListActivityLeaderJDBC users = null;
		//ListActivityLeaderJDBC users = pkit.createListActivityLeader();
		//users.load()
		return users.load();
	}

}
