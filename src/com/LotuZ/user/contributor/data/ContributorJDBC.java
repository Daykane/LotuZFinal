package com.LotuZ.user.contributor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.activityLeader.data.ActivityLeaderJDBC;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;


/**
 * 
 * @author Ludo
 *
 */

public class ContributorJDBC extends Contributor{
	

	public ContributorJDBC() {
		super();
	}
	
	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;

	/**
	 * @param cn
	 */
	public ContributorJDBC(Connection cn){
		this.cn = cn;
	}	
	

	/**
	 * Lecture d'un intervenant en base à partir de son identifiant 
	 */
	public void save(String mailContributor) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`Contributor` (`mailContributor` ) VALUES ('"+ mailContributor +"')'";
			String sql2 = "SELECT idContributor FROM LotuZ.Contributor Where mailContributor='"+ mailContributor +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			int result = st.executeUpdate(sql2);
			
			String sql3 = "INSERT INTO `LotuZ`.`User` (`idContributor` ) VALUES ('"+ result +"')'";
			st.executeUpdate(sql3);


		} catch (SQLException e) {
			throw e;
		}
	}

	public Contributor load(String mailContributor) throws SQLException {

		Contributor contributor = null;
		Statement st =null;
		
		// Création d'un statement
		st = this.cn.createStatement();
		
		// Requête de sélection à partir de l'identifiant 
		String sql = "Select * From LotuZ.Contributor Where idContributor is not null and mailContributor="+'"'+mailContributor+'"';
		
		// Exécution de la requête
		ResultSet result = st.executeQuery(sql);
		
		if(!result.first())
		{
			return contributor;
		}
		else 
		{
			// Récupération des données 
			Contributor contributor2 = new ContributorJDBC();
			contributor2.setIdContributor(result.getInt("idContributor"));

			return contributor2;
		}
}
	
	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			
			String sql = "UPDATE LotuZ.User SET (`idContributor`) = null Where idContributor='"+ this.getIdContributor() +"'";

			String sql2 = "Delete From LotuZ.Contributor Where idContributor='"+ this.getIdContributor() +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			st.executeUpdate(sql2);


		} catch (SQLException e) {
			throw e;
		}
	}
	



}

