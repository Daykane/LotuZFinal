package Model;

import java.sql.SQLException;

import Class.User;

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

	
	

}
