package com.LotuZ.user.activityLeader;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.FacadeBL;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.User;



public class FacadeActivityLeader {

	public void getActivityLeader(String idActivityLeader) throws SQLException, UserNotFoundException{
		FacadeBL.getActivityLeader(idActivityLeader);
	}
	
	/*public static List<User> getActivityLeaders() throws SQLException, UserNotFoundException{
		return FacadeBL.getActivityLeaders();
	}*/
}
