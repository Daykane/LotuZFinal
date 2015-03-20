package com.LotuZ;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;






import java.util.ArrayList;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityJdbc;
import com.LotuZ.user.User;
import com.LotuZ.user.UserJDBC;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.ActivityLeader;


/**
 * @author LotuZ
 *
 */
public class JdbcKit extends PersistKit{

	private Connection cn;
	
	//List of ConcretObjectJdbc
	private UserJDBC userJdbc;
	private ActivityJdbc activityJdbc;
	
	
	public JdbcKit(String url, String login, String passwd){
		
		// Create concrete bjetc with the connection
		setUserJdbc(new UserJDBC(this.cn));
		//setActivityJdbc(new ActivityJdbc(this.cn));
		
	}
	
	
	
	
	public void openConnection(String url, String login, String passwd) {
			// Etape 1 : Chargement du driver
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			// Etape 2 : récupération de la connexion
				try {
					this.cn = DriverManager.getConnection(url, login, passwd);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

	public void closeConnection(Connection cn) {
		try {
			this.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		
	}
	
	@Override
	public User createUser() {
		return new UserJDBC(this.cn);
	}




	@Override
	public void createUserLog() {
		UserLog.init();
	}



	public void createUserLog(String lastName, String firstName, String mail,
			String phone, String streetName, String numHouse, String city,
			String postCode, String password,int member, int activityLeader) {
		UserLog.init(lastName, firstName, mail,
				phone, streetName, numHouse, city,
				postCode, password,member,activityLeader);

		
	}




	/**
	 * @return the userJdbc
	 */
	public UserJDBC getUserJdbc() {
		return userJdbc;
	}




	/**
	 * @param userJdbc the userJdbc to set
	 */
	public void setUserJdbc(UserJDBC userJdbc) {
		this.userJdbc = userJdbc;
	}




	/**
	 * @return the activityJdbc
	 */
	public ActivityJdbc getActivityJdbc() {
		return activityJdbc;
	}




	/**
	 * @param activityJdbc the activityJdbc to set
	 */
	public void setActivityJdbc(ActivityJdbc activityJdbc) {
		this.activityJdbc = activityJdbc;
	}




	@Override
	public Activity createActivity() {
		return new ActivityJdbc(this.cn);
	}




	@Override
	public List<User> createListActivityLeader() {
		return 	new ArrayList<User>();
	}




	@Override
	public ActivityLeader createActivityLeader() {
		// TODO Auto-generated method stub
		return null;
	}

}
