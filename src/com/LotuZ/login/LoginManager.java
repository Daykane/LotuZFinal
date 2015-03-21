package com.LotuZ.login;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashText;
import com.LotuZ.user.User;
import com.LotuZ.user.contributor.bl.Contributor;


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
	public void loginUser(String mail,String password) throws SQLException, UserNotFoundException{
		// Create empty userJdbc for read information
			User user = this.pkit.createUser();
			user = user.load(mail);

			try {
				password = HashText.sha1(password);
				//passWordCrypt = HashText.sha1(user.getPassword());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			if(user != null && password.equals(user.getPassword())  ){
					// Create singleton userJdbc for login
					this.pkit.createUserLog(user);
				}
				
			else{
				throw new UserNotFoundException(); 
			}
	}

	public void loginContri(String mail, String password) throws SQLException {
		// TODO Auto-generated method stub
		Contributor contrib = this.pkit.createContributor();
		contrib = contrib.load(mail);
		System.out.println("il c'est passé quelque chose");
		if (contrib == null){
			System.out.println("on a pas de contributor");
		}
		else{
			System.out.println(contrib.getLastName());
			System.out.println("il n'est pas null");
		}
		

	}


}




