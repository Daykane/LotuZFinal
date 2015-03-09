package Business;

import java.sql.SQLException;

import Class.User;
import Model.JdbcKit;


public class FacadeData {

	JdbcKit JdbcKit = new JdbcKit();
	
	public void inscriptionData(Object object) throws ClassNotFoundException, SQLException{		
		JdbcKit.inscriptionData(object);
	}
	
	public User login(String mail, String password) throws SQLException{
		User user = JdbcKit.login(mail,password);
		return user;
	}
}
