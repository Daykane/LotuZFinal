package com.LotuZ;


import java.sql.Connection;



import com.LotuZ.user.User;

public abstract class PersistKit {
	
	public abstract void openConnection(String url, String login, String passwd);
	public abstract void closeConnection(Connection cn);
	//public abstract User login(String mail, String passWordCrypt) throws SQLException;
	public abstract User createUser();
	public abstract void createUserLog();
	public abstract void createUserLog(String lastName, String firstName, String mail,
			String phone, String streetName, String numHouse, String city,
			String postCode, String password);
	}
