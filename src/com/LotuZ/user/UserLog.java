package com.LotuZ.user;


import java.sql.SQLException;

import com.LotuZ.user.contributor.bl.Contributor;

public final class UserLog extends User{

	private static volatile User user = null;
	private static volatile UserLog contrib = null;
	 
	private UserLog() {
		super();
    }
	 
	public UserLog(User user) {
		super(user.getLastName(), user.getFirstName(), user.getMail(),
				user.getPhone(), user.getStreetName(), user.getNumHouse(), user.getCity(),
				user.getPostCode(), user.getPassword(),user.getIdContributor(),user.getIdMember());
	}
	
	public UserLog(Contributor contrib) {
		super();
		/* faire le bon constructeur
		Contributor(user.getLastName(), user.getFirstName(), user.getMail(),
				user.getPhone(), user.getStreetName(), user.getNumHouse(), user.getCity(),
				user.getPostCode(), user.getPassword(),user.getMember(),user.getActivityLeader());
		*/
	}
	
	public static User getUserLog(){
		return UserLog.user;
	}

	public final static void init() {
         if (UserLog.user == null) {

            synchronized(UserLog.class) {
              if (UserLog.user == null) {
            	  UserLog.user = new UserLog();
              }
            }
         }
	}
      
	@Override
	public void save() throws SQLException, ClassNotFoundException {		
	}

	@Override
	public User load(String mail) {
		return null;		
	}
	

	public static void init(User user) {
		if (UserLog.user == null & UserLog.contrib == null) {
            synchronized(UserLog.class) {
              if (UserLog.user == null) {
            	  UserLog.user = new UserLog(user);
              }
            }
         }
	}

	public static void init(Contributor contrib) {
		if (UserLog.user == null & UserLog.contrib == null) {
            synchronized(UserLog.class) {
              if (UserLog.contrib == null) {
            	  UserLog.contrib = new UserLog(contrib);
              }
            }
         }
		
	}
         
		


	
	

}
