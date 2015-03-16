package com.LotuZ;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityJdbc;
import com.LotuZ.user.User;
import com.LotuZ.user.UserJDBC;
import com.LotuZ.user.UserLog;


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
		userJdbc = new UserJDBC(this.cn);
		activityJdbc = new ActivityJdbc();
		
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
	/*
	public User login(String mail, String password) throws SQLException{
		User user;
		try {
			
			user = userJdbc.login(mail,password,cn);	
			
		} catch (SQLException e) {
			throw e;
			// TODO Auto-generated catch block
		}
		return user;
		
	}
	*/
	@Override
	public User createUser() {
		return new UserJDBC(this.cn);
	}




	@Override
	public User createUserLog() {
		// TODO Auto-generated method stub
		return null;
	}




	public static void main(String[] args) {
		UserLog.init();
	}

}
