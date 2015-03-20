package com.LotuZ;


import java.sql.SQLException;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityManager;
import com.LotuZ.inscription.InscriptionManager;
import com.LotuZ.login.LoginManager;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.User;
import com.LotuZ.user.activityLeader.ActivityLeader;
import com.LotuZ.user.activityLeader.ActivityLeaderManager;

public class FacadeBL {
	
	private static LoginManager loginManager;
	private static InscriptionManager inscriptionManager;
	private static ActivityManager activityManager;
	private static ActivityLeaderManager activityLeaderManager;
	
	public static void init(PersistKit kit){
		loginManager = new LoginManager(kit);
		inscriptionManager = new InscriptionManager(kit);
		activityManager = new ActivityManager(kit);
		activityLeaderManager = new ActivityLeaderManager(kit);
	}
	
	public static void inscription(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException{
		inscriptionManager.inscription(lastName, firstName, adress, phone, street, houseNumber, city, postCode, password);
	}
	
	public static void login(String mail, String password, String role) throws SQLException, UserNotFoundException{
		loginManager.login(mail,password,role);
	}

	public  List<Activity> getActivities() {
		return activityManager.getActivities();
		
	}
	
	public static ActivityLeader getActivityLeader(String idActivityLeader) throws SQLException, UserNotFoundException{
		return activityLeaderManager.getActivityLeader(idActivityLeader);
	}
	
	public static ActivityLeader updateActivityLeader(ActivityLeader activityLeader) throws SQLException {	
		return activityLeaderManager.modifyActivityLeader(activityLeader);	
	}
	/*public static List<User> getActivityLeaders() throws SQLException, UserNotFoundException{
		return ActivityLeaderManager.getActivityLeaders();
	}*/

	public static void createActivity(String name, String shortDescr, String longDescr) throws ClassNotFoundException, SQLException {
		activityManager.create(name, shortDescr, longDescr);

		
	}

	public static Activity readActivity(String name) throws SQLException {
		Activity acti = activityManager.read(name);
		return acti;
		
	}

	public static Activity readActivity(int i) throws SQLException {
		Activity acti = activityManager.read(i);
		return acti;
	}

	public static Activity updateActivity(Activity acti, String name, String shortDescr,
			String longDescr, String idRespo) throws SQLException {	
		Activity activity = activityManager.update(acti,name,shortDescr,longDescr,idRespo);
		return activity;	
	}
}