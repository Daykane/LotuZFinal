package com.LotuZ.activity;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.LotuZ.PersistKit;

/**
 * @author Alexis
 *
 */
public class ActivityManager {
	
	private PersistKit pkit;
	
	/**
	 * @return the persistance kit
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
	
	/**
	 * @param kit : PersitKit to use
	 */
	public ActivityManager(PersistKit kit){
		this.setPkit(kit);
	}
	
	/**
	 * Save the activity in base
	 * @param name
	 * @param idRespo : Activity leader identifier
	 * @param shortDescr : short description
	 * @param longDescr : long description
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void create(String name, String idRespo, String shortDescr, String longDescr) throws ClassNotFoundException, SQLException {
			//User user = UserLog.getUserLog();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			// Create empty ActivityJdbc
			Activity activity = pkit.createActivity();
			// set informations into the userJdbc
			activity.setName(name);
			activity.setShortDescr(shortDescr);
			activity.setLongDescr(longDescr);
			activity.setIdRespo(idRespo);
			activity.setCreateDate(dateFormat.format(date));
			activity.setMajDate(dateFormat.format(date));
			// Save in database the user
			activity.save();
		}
	
	
	/**
	 * Return All activities in Base
	 * @throws SQLException
	 */
	public List<Activity> getActivities() throws SQLException {
		List<Activity> lAct;
		Activity activity = pkit.createActivity();
		lAct = activity.loadAll();
		return lAct;
	}

	/**
	 * Return Activity with its name like identifier
	 * @param name
	 * @throws SQLException
	 */
	public Activity read(String name) throws SQLException {
		Activity activity = pkit.createActivity();
		Activity acti = activity.load(name);
		return acti;
		
	}

	/**
	 * Return Activity with its identifier
	 * @param i : identifier of Activity
	 * @throws SQLException
	 */
	public Activity read(int i) throws SQLException {
		Activity activity = pkit.createActivity();
		activity = activity.load(i);
		return activity;
	}

	/**
	 * Delete activity in param
	 * @param act : Activity
	 * @throws SQLException
	 */
	public void deleteActivity(Activity act) throws SQLException {
		Activity activity = pkit.createActivity();
		activity.setIdActivity(act.getIdActivity());		
		activity.delete();
		
	}

	/**
	 * Replace Activity in param with the others param
	 * @param acti : activity to replace
	 * @param name
	 * @param shortDescr : Short description
	 * @param longDescr : Long description
	 * @param idRespo : Activity Leader identifier
	 * @throws SQLException
	 */
	public void update(Activity acti, String name, String shortDescr, String longDescr,
			String idRespo) throws SQLException {
		//Parse forma Date
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
		
		
		activity.update();
		
	}

	/**
	 * @param idRespo : identifier of Leader Activity
	 * @return Leader Activity's list Activity
	 * @throws SQLException
	 */
	public List<Activity> getActivityOfLeader(String idRespo) throws SQLException {
		List<Activity> lAct;
		Activity activity = pkit.createActivity();
		activity.setIdRespo(idRespo);
		lAct = activity.loadForRespo();
		return lAct;
	}
	
	

	
	 
}
