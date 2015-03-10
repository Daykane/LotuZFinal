package Business;

import java.sql.SQLException;
import java.util.List;

import Class.Activity;

public class FacadeBL {
	
	UserManager userManager = new UserManager();
	ActivityManager activityManager = new ActivityManager();
	
	public void inscription(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException{
		userManager.inscription(lastName, firstName, adress, phone, street, houseNumber, city, postCode, password);
	}
	
	public void login(String mail, String password) throws SQLException{
		userManager.login(mail,password);
	}

	public  List<Activity> getActivities() {
		return activityManager.getActivities();
		
	}
	
}