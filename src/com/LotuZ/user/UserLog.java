package com.LotuZ.user;


import java.sql.SQLException;

public final class UserLog extends User{

	private static volatile UserLog instance = null;
	 
	private UserLog() {
		super();
    }
	 
	public UserLog(String lastName, String firstName, String mail,
			String phone, String streetName, String numHouse, String city,
			String postCode, String password) {
		super(lastName, firstName, mail,
				phone, streetName, numHouse, city,
				postCode, password);
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
	

	public static void init(String lastName, String firstName, String mail,
			String phone, String streetName, String numHouse, String city,
			String postCode, String password) {
		if (UserLog.instance == null) {

            synchronized(UserLog.class) {
              if (UserLog.instance == null) {
            	  UserLog.instance = new UserLog(lastName, firstName, mail,
            				phone, streetName, numHouse, city,
            				postCode, password);
              }
            }
         }
		
	}


	
	

}
