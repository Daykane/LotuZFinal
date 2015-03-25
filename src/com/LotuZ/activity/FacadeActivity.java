package com.LotuZ.activity;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;


public class FacadeActivity {

	private static ActivityManager activityManager;
	
	public static void init(PersistKit kit){
		activityManager = new ActivityManager(kit);
	}

	public static Activity getActivity(int i) throws SQLException {
		return activityManager.read(i);
	}

	public static List<Activity> getAllActivities() throws SQLException {
		return activityManager.getActivities();
	}

	public static void updateActivity(Activity act, String name, String shortDescr, String LongDescr, String idRespo) throws SQLException{
		activityManager.update(act, name, shortDescr, LongDescr, idRespo);
	}

}
