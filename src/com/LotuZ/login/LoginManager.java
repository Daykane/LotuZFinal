package com.LotuZ.login;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashTextTest;
import com.LotuZ.user.UserLog;

public class LoginManager {

	HashTextTest crypt;
	PersistKit pkit;

	public LoginManager(PersistKit kit){
		this.pkit=kit;
	}

	/**
	 * @param mail
	 * @param password
	 * @throws SQLException
	 */
	public void login(String mail,String password) throws SQLException{
		String passWordCrypt="";
		try {
			passWordCrypt = HashTextTest.sha1(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		UserLog.init();		
	}
}




