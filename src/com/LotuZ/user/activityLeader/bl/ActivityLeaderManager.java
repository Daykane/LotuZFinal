package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.activity.Activity;


public class ActivityLeaderManager {

	private PersistKit pkit;
	
	public ActivityLeaderManager(PersistKit kit){
		this.pkit=kit;
	}
	
	public ActivityLeader getActivityLeader(String idActivityLeader) throws SQLException {
		ActivityLeader activityLeader = pkit.createActivityLeader();
		activityLeader.load(idActivityLeader);
		return activityLeader;
	}
	
	public ActivityLeader modifyActivityLeader(ActivityLeader activityLeader) throws SQLException {
		activityLeader.update();
		return activityLeader;
	}
	
	
	public ListActivityLeader getActivityLeaders() throws SQLException {
		//ListActivityLeaderJDBC users = null;
		ListActivityLeader users = pkit.createListActivityLeader();
		//users.load()
		return users.load();
	}

}
