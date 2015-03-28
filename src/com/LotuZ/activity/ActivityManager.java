package com.LotuZ.activity;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.user.bl.User;

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
	
	public void create(String name, int idRespo, String shortDescr, String longDescr) throws ClassNotFoundException, SQLException {
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
	
	
	public List<Activity> getActivities() throws SQLException {
		List<Activity> lAct;
		Activity activity = pkit.createActivity();
		lAct = activity.loadAll();
		return lAct;
	}

	public Activity read(String name) throws SQLException {
		Activity activity = pkit.createActivity();
		Activity acti = activity.load(name);
		return acti;
		
	}

	public Activity read(int i) throws SQLException {
		Activity activity = pkit.createActivity();
		activity = activity.load(i);
		return activity;
	}

	public void deleteActivity(Activity act) throws SQLException {
		Activity activity = pkit.createActivity();
		activity.setIdActivity(act.getIdActivity());		
		activity.delete();
		
	}

	public void update(Activity acti, String name, String shortDescr, String longDescr,
			String idRespo) throws SQLException {
		//User user = UserLog.getUserLog();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// Create empty ActivityJdbc
		Activity activity = pkit.createActivity();
		
		// set informations into the userJdbc
		activity.setIdActivity(acti.getIdActivity());
		activity.setName(name);
		activity.setShortDescr(shortDescr);
		activity.setLongDescr(longDescr);
		activity.setIdRespo(idRespo);
		activity.setMajDate(dateFormat.format(date));
		// Save in database the user
		//if (this.cn == null)
		//{
		//	System.out.println("le this.cn est null");
		//}
		activity.update();
		
	}
	
	

	
	 
}
