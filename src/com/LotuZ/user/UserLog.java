package com.LotuZ.user;


import java.sql.SQLException;

public final class UserLog extends User{

	private static volatile UserLog instance = null;
	 
	private UserLog() {
		super();
    }
	 
	public final static void init() {
         if (UserLog.instance == null) {

            synchronized(UserLog.class) {
              if (UserLog.instance == null) {
            	  UserLog.instance = new UserLog();
              }
            }
         }
	}
      
	@Override
	public void save() throws SQLException, ClassNotFoundException {		
	}

	@Override
	public User load(String mail2, String passWordCrypt) {
		return null;		
	}


	
	

}
