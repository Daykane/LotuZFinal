package Business;

import java.util.List;

import Class.Activity;
import Model.JdbcKit;
import Model.PersistKit;

public class ActivityManager {
	PersistKit jdbcKit = new JdbcKit();

	public  List<Activity> getActivities() {
		List<Activity> ActivityList = jdbcKit.getActivities();
		return ActivityList;
	}
	 
}
