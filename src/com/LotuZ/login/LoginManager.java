package com.LotuZ.login;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashTextTest;
import com.LotuZ.user.User;


public class LoginManager {

	HashTextTest crypt;
	PersistKit pkit;

	public LoginManager(PersistKit kit){
		this.pkit=kit;
	}

	/**
	 * @param mail
	 * @param password
	 * @param role 
	 * @throws SQLException
	 * @throws UserNotFoundException 
	 */
	public void login(String mail,String password, String role) throws SQLException, UserNotFoundException{
		String passWordCrypt="";
		try {
			passWordCrypt = HashTextTest.sha1(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// Create empty userJdbc for read information
			User user = pkit.createUser();
			user = user.load(mail,passWordCrypt,role);
			if(user != null){
				// Create singleton userJdbc for login
				pkit.createUserLog(user.getLastName(),user.getFirstName(),user.getMail(),user.getPhone(),user.getStreetName(),user.getNumHouse(),user.getCity(),user.getPostCode(),user.getPassword());
			}
			else{
				throw new UserNotFoundException(); 
			}
	}

}




