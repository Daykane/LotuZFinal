package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Class.Activity;
import Class.User;

public abstract class PersistKit {
	
	public abstract void openConnection(String url, String login, String passwd, Connection cn);
	public abstract void closeConnection(Connection cn);
	public abstract void inscriptionData(Object object) throws ClassNotFoundException, SQLException;
	public abstract User login(String mail, String passWordCrypt) throws SQLException;
	public abstract List<Activity> getActivities();
	}
