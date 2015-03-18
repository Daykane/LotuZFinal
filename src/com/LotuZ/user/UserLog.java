package com.LotuZ.user;


import java.sql.SQLException;

public final class UserLog extends User{

	private static volatile User user = null;
	 
	private UserLog() {
		super();
    }
	 
	public UserLog(String lastName, String firstName, String mail,
			String phone, String streetName, String numHouse, String city,
			String postCode, String password, int member, int activityLeader) {
		super(lastName, firstName, mail,
				phone, streetName, numHouse, city,
				postCode, password,member,activityLeader);
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
	

	public static void init(String lastName, String firstName, String mail,
			String phone, String streetName, String numHouse, String city,
			String postCode, String password, int member, int activityLeader) {
		if (UserLog.user == null) {
            synchronized(UserLog.class) {
              if (UserLog.user == null) {
            	  UserLog.user = new UserLog(lastName, firstName, mail,
            				phone, streetName, numHouse, city,
            				postCode, password,member,activityLeader);
              }
            }
         }
		
	}


	
	

}
