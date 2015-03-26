package com.LotuZ.user.activityLeader.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.activity.Activity;
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
	 * Lecture d'un responsable d'activité en base à partir de son identifiant 
	 */
	@Override
	public ActivityLeader load(String mailActivityLeader) throws SQLException {

			//List<String> activities = new ArrayList<String>();
			String nameActivity;
			ActivityLeader activityLeader = null;
			Statement st =null;
			
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User u ,LotuZ.Member m, LotuZ.Activity a Where m.idMember = u.idMember and u.mail = a.activityLeader and m.idLeader is not null and u.mail="+'"'+mailActivityLeader+'"';
			
			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			if(!result.first())
			{
				return activityLeader;
			}
			else 
			{
				// Récupération des données 
				while(result.next()){	
					activityLeader = new ActivityLeaderJDBC();
					//activities.add(result.getString("name"));
					nameActivity = result.getString("name");
					activityLeader.setNameActivity(nameActivity);
					activityLeader.setIdLeader(result.getString("idLeader"));
				}
				return activityLeader;
			}
	}
	


	/**
	 * Suppression d'un responsable d'activité en base à partir de son identifiant 
	 */

	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			
			String sql = "UPDATE LotuZ.Member SET (`idLeader`) = null Where idLeader='"+ this.getIdLeader() +"'";

			String sql2 = "Delete From LotuZ.Leader Where idLeader='"+ this.getIdLeader() +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			st.executeUpdate(sql2);


		} catch (SQLException e) {
			throw e;
		}
	}


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

