package Business;

import java.util.List;

import Class.Activity;
import Model.JdbcKit;
import Model.PersistKit;

public class ActivityManager {
	
	PersistKit pkit;
	
	public ActivityManager(PersistKit kit){
		this.pkit=kit;
	}
	


	public  List<Activity> getActivities() {
		//List<Activity> ActivityList = pkit.getActivities();
		return null;
	}
	 
}
