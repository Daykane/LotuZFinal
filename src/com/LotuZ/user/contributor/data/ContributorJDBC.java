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
	 * Lecture d'un responsable d'activité en base à partir de son identifiant 
	 */
	@Override
	public Contributor load(String idContributor) throws SQLException {
		try {
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User Where mail="+'"'+idContributor+'"';
			
			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			// Récupération des données 
			while(result.next()){	
				this.setLastName(result.getString("lastName"));
				this.setFirstName(result.getString( "firstName" ));
				this.setMail(result.getString( "Mail" ));
				this.setPhone(result.getString( "tel" ));
				this.setStreetName(result.getString( "streetName" ));
				this.setNumHouse(result.getString( "numHouse" ));
				this.setCity(result.getString( "city" ));
				this.setPostCode(result.getString( "postCode" ));
			}
		
		} catch (SQLException e) {
			throw e;
		}
		return this;
	}
	

	/**
	 * Modification d'un responsable d'activité en base à partir de son identifiant 
	 */
	@Override
	public Contributor update() throws SQLException {
		try {		
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
		
			// Requête de modification
			String sql = "UPDATE User SET `lastName`='"+this.getLastName() +"',`firstName`='"+ this.getFirstName() +"',`mail`='"+this.getMail()
				+"',`tel`='"+this.getPhone()+"',`streetName`='"+this.getStreetName()+"',`numHouse`='"+this.getNumHouse()+"',`city`='"+this.getCity()+"',`postCode`='"+this.getPostCode()+"' Where `mail`='"+this.getMail()+"'";
		
			// Exécution requête
			st.executeUpdate(sql);
		
			} catch (SQLException e) {
				throw e;
			}
		return this;
	}
	

	/**
	 * Suppression d'un responsable d'activité en base à partir de son identifiant 
	 */
	@Override
	public void delete(String idContributor) throws SQLException {
		try {	
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
		
			// Requête de modification
			String sql = "Delete From User Where mail="+'"'+idContributor+'"';
			
			// Exécution requête
			st.executeUpdate(sql);
		
		} catch (SQLException e) {
			throw e;
		}
	}


	@Override
	public void save() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isAdmin() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



}

