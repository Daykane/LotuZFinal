package com.LotuZ.user.admin.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.LotuZ.user.admin.bl.Administrator;



/**
 * 
 * @author Ludo
 *
 */

public class AdministratorJDBC extends Administrator{
	
	/**
	 * @param lastName
	 * @param firstName
	 * @param mail
	 * @param tel
	 * @param streetName
	 * @param numHouse
	 * @param city
	 * @param postCode
	 */
	public AdministratorJDBC() {
		super();
	}
	
	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;

	/**
	 * @param cn
	 */
	public AdministratorJDBC(Connection cn){
		this.cn = cn;
	}	
	

	/**
	 * Lecture d'un membre en base à partir de son identifiant 
	 */
	@Override
	public Administrator load(String idMember) throws SQLException {
		try {
			Statement st =null;
			Administrator administrator = null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User u,LotuZ.Member m Where u.idMember = m.idMember and m.idAdmin ='1' and u.mail="+'"'+idMember+'"';
			
			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			if(!result.first())
			{
				return administrator;
			} else 
			{
				administrator = new AdministratorJDBC();
				return administrator;
			}
			// Récupération des données 

		} catch (SQLException e) {
			throw e;
		}

	}
	

	public void save(String mailAdministrator) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "UPDATE LotuZ.Member SET (`idAdmin`) = 1 Where mailMember='"+ mailAdministrator +"'";
			
			// Etape 4 : exécution requête
			st.executeUpdate(sql);


		} catch (SQLException e) {
			throw e;
		}
	}


	public void delete(String mailAdministrator) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			
			String sql = "UPDATE LotuZ.Member SET (`idAdmin`) = null Where mailMember='"+ mailAdministrator +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);


		} catch (SQLException e) {
			throw e;
		}
	}



}

