package RespoActi;

import JdbcKit;
import PersistKit;

import java.util.List;

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
