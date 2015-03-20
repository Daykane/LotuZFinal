package com.LotuZ.login;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashText;
import com.LotuZ.user.User;


public class LoginManager {

	private PersistKit pkit;

	/**
	 * @return the pkit
	 */
	public PersistKit getPkit() {
		return pkit;
	}

	/**
	 * @param pkit the pkit to set
	 */
	public void setPkit(PersistKit pkit) {
		this.pkit = pkit;
	}

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
			passWordCrypt = HashText.sha1(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// Create empty userJdbc for read information
			User user = this.pkit.createUser();
			user = user.load(mail,passWordCrypt,role);
			if(user != null){
				// Create singleton userJdbc for login
				this.pkit.createUserLog(user);
			}
			else{
				throw new UserNotFoundException(); 
			}
	}


}




