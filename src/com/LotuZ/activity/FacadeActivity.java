package com.LotuZ.activity;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;


/**
 * @author Alexis
 *
 */
public class FacadeActivity {

	private static ActivityManager activityManager;
	
	/**
	 * Init activityManager with the kit
	 * @param kit : Persist Kit to use
	 */
	public static void init(PersistKit kit){
		activityManager = new ActivityManager(kit);
	}

	/**
	 * @param i : identifier of Activity
	 * @throws SQLException
	 */
	public static Activity getActivity(int i) throws SQLException {
		return activityManager.read(i);
	}

	/**
	 * @return All Activities
	 * @throws SQLException
	 */
	public static List<Activity> getAllActivities() throws SQLException {
		return activityManager.getActivities();
	}
	
	/**
	 * @param idRespo : Leader Activity identifier
	 * @return Activity list of the Leader
	 * @throws SQLException
	 */
	public static List<Activity> getActivityOfLeader(String idRespo) throws SQLException {
		return activityManager.getActivityOfLeader(idRespo);
	}

	/**
	 * Update the activity in param with the parameters
	 * @param act : activity to update
	 * @param name : name activity
	 * @param shortDescr : short description
	 * @param LongDescr : long description
	 * @param idRespo : Leader Activity identifier
	 * @throws SQLException
	 */
	public static void updateActivity(Activity act, String name, String shortDescr, String LongDescr, String idRespo) throws SQLException{
		activityManager.update(act, name, shortDescr, LongDescr, idRespo);
	}

	/**
	 * Delete activity in param
	 * @param act : activity
	 * @throws SQLException
	 */
	public static void deleteActivity(Activity act) throws SQLException {
		activityManager.deleteActivity(act);
		
	}



}
