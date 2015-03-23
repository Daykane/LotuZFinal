package com.LotuZ.login;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashText;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;


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
			//Member member = this.pkit.createMember();
			ActivityLeader respo = this.pkit.createActivityLeader();
			//Administrator admin = this.pkit.createAdministrator();
			Contributor contrib = this.pkit.createContributor();
			
			respo = respo.load(mail);
			user = user.load(mail);
			if ( user == null){
				System.out.println("La personne n'existe pas");
			}
			else if (respo == null) {
				System.out.println("ce n'est pas un respo");
			}
			else if (contrib == null) {
				System.out.println("ce n'est pas un contrib");
			}
			else if (respo != null) {
				System.out.println("c'est un respo");
			}

			
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
}




