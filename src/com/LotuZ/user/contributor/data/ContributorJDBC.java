package com.LotuZ.user.contributor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.user.contributor.bl.Contributor;



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
	 * save a contributor in database 
	 */
	public void save(String mailContributor) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO Contributor (`mailContributor`) VALUES ('"+ mailContributor +"')";
			String sql2 = "SELECT idContributor FROM LotuZ.Contributor Where mailContributor='"+ mailContributor +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql2);
			System.out.println(" RESULT : "+result);
			
			int idContrib = 0;
			while (result.next())
			{
				idContrib = result.getInt("idContributor");
			}
			
			String sql3 = "INSERT INTO User (`idContributor`) VALUES ('"+ idContrib +"')";
			st.executeUpdate(sql3);


		} catch (SQLException e) {
			throw e;
		}
	}

	
	/**
	 * load a contributor in database with his mail
	 */
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
			contributor2.setIdContributor(result.getString("idContributor"));

			return contributor2;
		}
}
	

	
	/**
	 * delete a contributor in database 
	 */
	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			
			String sql = "UPDATE LotuZ.User SET idContributor = null Where idContributor='"+ this.getIdContributor() +"'";

			String sql2 = "Delete From LotuZ.Contributor Where idContributor='"+ this.getIdContributor() +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			st.executeUpdate(sql2);


		} catch (SQLException e) {
			throw e;
		}
	}
	



}

