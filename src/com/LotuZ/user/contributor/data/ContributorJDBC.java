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
	public ContributorJDBC(String lastName, String firstName, String mail,
			String tel, String streetName, String numHouse, String city,
			String postCode) {
		super(lastName, firstName, mail, tel, streetName, numHouse, city, postCode);
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
	 * Lecture d'un responsable d'activit� en base � partir de son identifiant 
	 */
	@Override
	public Contributor load(String idContributor) throws SQLException {
		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.User Where mail="+'"'+idContributor+'"';
			
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while(result.next()){	
				this.setLastName(result.getString("lastName"));
				this.setFirstName(result.getString( "firstName" ));
				this.setMail(result.getString( "Mail" ));
				this.setTel(result.getString( "tel" ));
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
	 * Modification d'un responsable d'activit� en base � partir de son identifiant 
	 */
	@Override
	public Contributor update() throws SQLException {
		try {		
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
		
			// Requ�te de modification
			String sql = "UPDATE User SET `lastName`='"+this.getLastName() +"',`firstName`='"+ this.getFirstName() +"',`mail`='"+this.getMail()
				+"',`tel`='"+this.getTel()+"',`streetName`='"+this.getStreetName()+"',`numHouse`='"+this.getNumHouse()+"',`city`='"+this.getCity()+"',`postCode`='"+this.getPostCode()+"' Where `mail`='"+this.getMail()+"'";
		
			// Ex�cution requ�te
			st.executeUpdate(sql);
		
			} catch (SQLException e) {
				throw e;
			}
		return this;
	}
	

	/**
	 * Suppression d'un responsable d'activit� en base � partir de son identifiant 
	 */
	@Override
	public void delete(String idContributor) throws SQLException {
		try {	
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
		
			// Requ�te de modification
			String sql = "Delete From User Where mail="+'"'+idContributor+'"';
			
			// Ex�cution requ�te
			st.executeUpdate(sql);
		
		} catch (SQLException e) {
			throw e;
		}
	}


}

