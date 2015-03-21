package com.LotuZ.user;

import java.util.List;
import java.sql.SQLException;

import com.LotuZ.FacadeBL;
import com.LotuZ.login.UserNotFoundException;

public class FacadeUser {
	
	public static void login(String mail, String password) throws SQLException, UserNotFoundException{
		FacadeBL.loginUser(mail,password);
	}
	


}
