package com.LotuZ.activity;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

public class ActivityManager {
	
	private PersistKit pkit;
	
	/**
	 * @return the pkit
	 */
	public PersistKit getPkit() {
		return pkit;
	}

	/**
	 * @param pkit the pkit to set
	 */
	public void setPkit(PersistKit pkit) {
		this.pkit = pkit;
	}
	
	public ActivityManager(PersistKit kit){
		this.setPkit(kit);
	}
	
	public void create(String name, String shortDescr, String longDescr) throws ClassNotFoundException, SQLException {
			User user = UserLog.getUserLog();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			// Create empty ActivityJdbc
			Activity activity = pkit.createActivity();
			// set informations into the userJdbc
			activity.setName(name);
			activity.setShortDescr(shortDescr);
			activity.setLongDescr(longDescr);
			activity.setIdRespo(user.getMail());
			activity.setCreateDate(dateFormat.format(date));
			activity.setMajDate(dateFormat.format(date));
			// Save in database the user
			activity.save();
		}
	
	
	public List<Activity> getActivities() {
		// TODO Auto-generated method stub
		return null;
	}

	public Activity read(String name) throws SQLException {
		Activity activity = pkit.createActivity();
		Activity acti = activity.load(name);
		return acti;
		
	}

	public Activity read(int i) throws SQLException {
		Activity activity = pkit.createActivity();
		Activity acti = activity.load(i);
		return acti;
	}
	
	

	
	 
}
