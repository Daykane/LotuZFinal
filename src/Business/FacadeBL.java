package Business;

import java.sql.SQLException;
import java.util.List;

import Class.Activity;
import Model.PersistKit;

public class FacadeBL {
	
	private static LoginManager loginManager;
	private static UserManager userManager;
	private static ActivityManager activityManager;
	
	public static void init(PersistKit kit){
		loginManager = new LoginManager(kit);
		userManager = new UserManager(kit);
		activityManager = new ActivityManager(kit);
	}
	
	public static void inscription(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException{
		userManager.inscription(lastName, firstName, adress, phone, street, houseNumber, city, postCode, password);
	}
	
	public static void login(String mail, String password) throws SQLException{
		loginManager.login(mail,password);
	}

	public  List<Activity> getActivities() {
		return activityManager.getActivities();
		
	}
	
}