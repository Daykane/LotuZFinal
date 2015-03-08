package Business;

import java.sql.SQLException;

import Class.User;
import Model.JdbcKit;


public class FacadeData {

	JdbcKit JdbcKit = new JdbcKit();
	
	public void inscriptionData(User user) throws ClassNotFoundException, SQLException{
		
		JdbcKit.load(user);
	}

}
