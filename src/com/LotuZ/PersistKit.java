package com.LotuZ;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.user.User;

public abstract class PersistKit {
	
	public abstract void openConnection(String url, String login, String passwd);
	public abstract void closeConnection(Connection cn);
	//public abstract User login(String mail, String passWordCrypt) throws SQLException;
	public abstract User createUser();
	public abstract User createUserLog();
	}
