package com.LotuZ.user;

import java.util.List;
import java.sql.SQLException;

import com.LotuZ.FacadeBL;
import com.LotuZ.login.UserNotFoundException;

public class FacadeUser {
	
	public static void login(String mail, String password) throws SQLException, UserNotFoundException{
		FacadeBL.login(mail,password,"user");
	}
	
	public static void getActivityLeader(int idActivityLeader) throws SQLException, UserNotFoundException{
		FacadeBL.getActivityLeader(idActivityLeader);
	}
	
	public static List<User> getActivityLeaders() throws SQLException, UserNotFoundException{
		return FacadeBL.getActivityLeaders();
	}

}
