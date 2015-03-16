package com.LotuZ.login;

import java.lang.reflect.Field;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashTextTest;
import com.LotuZ.user.User;
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
		// Create empty userJdbc for read information
			User user = pkit.createUser();
			user.load(mail,passWordCrypt);
			//System.out.println(user.getLastName());
			/*
			for (Field u : user.getClass().getFields()) {
				  u.setAccessible(true);
				  try {
					System.out.println("champ vide avant test");
					if (u.get(user) == null) {
					     System.out.println("champ vide");
					  }
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				}
				//*/
		// Create empty singleton userJdbc for login
		pkit.createUserLog();
		//System.out.println("toto");
		
	}
}




