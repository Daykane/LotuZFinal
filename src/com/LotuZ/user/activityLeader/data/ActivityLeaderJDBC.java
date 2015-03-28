package com.LotuZ.user.activityLeader.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.LotuZ.user.activityLeader.bl.ActivityLeader;


/**
 * 
 * @author Ludo
 *
 */

public class ActivityLeaderJDBC extends ActivityLeader{

	

	public ActivityLeaderJDBC() {
		super();
	}
	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;

	/**
	 * @param cn
	 */
	public ActivityLeaderJDBC(Connection cn){
		this.cn = cn;
	}	
	

	/**
	 * Load an activity leader from database  
	 */
	@Override
	public ActivityLeader load(String mailActivityLeader) throws SQLException {

			ActivityLeader activityLeader = null;
			Statement st =null;
			
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User u ,LotuZ.Member m Where m.idMember = u.idMember and m.idLeader is not null and u.mail="+'"'+mailActivityLeader+'"';
			
			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			if(!result.first())
			{
				return activityLeader;
			}
			else 
			{
				activityLeader = new ActivityLeaderJDBC();
				activityLeader.setIdLeader(result.getString("idLeader"));
				return activityLeader;
			}
	}
	


	/**
	 * delete an activity leader  
	 */

	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Suppression de la référence dans membre 
			String sql = "UPDATE LotuZ.Member SET idLeader = null Where idLeader='"+ this.getIdLeader() +"'";

			String sql2 = "Delete From LotuZ.Leader Where idLeader='"+ this.getIdLeader() +"'";

			// Exécution requête
			st.executeUpdate(sql);
			st.executeUpdate(sql2);


		} catch (SQLException e) {
			throw e;
		}
	}


	/**
	 * save an activity leader in database
	 * @param mailLeader
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void save(String mailLeader) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`Leader` (`mailLeader` ) VALUES ('"+ mailLeader +"')'";
			String sql2 = "SELECT idLeader FROM LotuZ.Leader Where mailLeader='"+ mailLeader +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			
			int result = st.executeUpdate(sql2);
			
			String sql3 = "INSERT INTO `LotuZ`.`Member` (`idLeader` ) VALUES ('"+ result +"')'";
			st.executeUpdate(sql3);


		} catch (SQLException e) {
			throw e;
		}
	}

}

