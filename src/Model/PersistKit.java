package Model;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class PersistKit {
	
	public abstract void openConnection(String url, String login, String passwd, Connection cn);
	public abstract void closeConnection(Connection cn);
	}
