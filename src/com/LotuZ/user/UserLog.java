package com.LotuZ.user;


import java.sql.SQLException;

public final class UserLog extends User{

	private static volatile User user = null;
	 
	private UserLog() {
		super();
    }
	 
	public UserLog(User user) {
		super(user.getLastName(), user.getFirstName(), user.getMail(),
				user.getPhone(), user.getStreetName(), user.getNumHouse(), user.getCity(),
				user.getPostCode(), user.getPassword(),user.getMember(),user.getActivityLeader());
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
	public User load(String mail2, String passWordCrypt,String role) {
		return null;		
	}
	

	public static void init(User user) {
		if (UserLog.user == null) {
            synchronized(UserLog.class) {
              if (UserLog.user == null) {
            	  UserLog.user = new UserLog(user);
              }
            }
         }
	}
         
		


	
	

}
