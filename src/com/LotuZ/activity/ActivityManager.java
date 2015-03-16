package com.LotuZ.activity;

import java.util.List;

import com.LotuZ.JdbcKit;
import com.LotuZ.PersistKit;

public class ActivityManager {
	
	PersistKit pkit;
	
	public ActivityManager(PersistKit kit){
		this.pkit=kit;
	}
	


	public  List<Activity> getActivities() {
		//List<Activity> ActivityList = pkit.getActivities();
		return null;
	}
	 
}
