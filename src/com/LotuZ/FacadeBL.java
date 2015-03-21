package com.LotuZ;


import java.sql.SQLException;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityManager;
import com.LotuZ.inscription.InscriptionManager;
import com.LotuZ.login.LoginManager;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.User;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.activityLeader.bl.ActivityLeaderManager;
import com.LotuZ.user.activityLeader.bl.ListActivityLeader;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.contributor.bl.ContributorManager;
import com.LotuZ.user.contributor.bl.ListContributor;

public class FacadeBL {
	
	private static LoginManager loginManager;
	private static InscriptionManager inscriptionManager;
	private static ActivityManager activityManager;
	private static ActivityLeaderManager activityLeaderManager;
	private static ContributorManager contributorManager;
	
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
	
	public static void loginUser(String mail, String password) throws SQLException, UserNotFoundException{
		loginManager.loginUser(mail,password);
	}
	
	public static void loginContri(String mail, String password) throws SQLException, UserNotFoundException{
		loginManager.loginContri(mail,password);
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
	
	public static ListActivityLeader getActivityLeaders() throws SQLException, UserNotFoundException{
		return activityLeaderManager.getActivityLeaders();
	}

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
	
	public static Contributor getContributor(String idContributor) throws SQLException, UserNotFoundException{
		return contributorManager.getContributor(idContributor);
	}
	
	public static Contributor updateContributor(Contributor contributor) throws SQLException {	
		return contributorManager.modifyContributor(contributor);	
	}
	
	public static ListContributor getContributors() throws SQLException, UserNotFoundException{
		return contributorManager.getContributors();
	}
}