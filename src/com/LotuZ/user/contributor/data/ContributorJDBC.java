package com.LotuZ.user.contributor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * Lecture d'un intervenant en base � partir de son identifiant 
	 */
	public void save() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`Contributor` (`mailContributor`) VALUES ('"+ this.getLastName() +"')";
			st.executeUpdate(sql);
			
			String sql2 = "SELECT idContributor FROM LotuZ.Contributor Where mail='"+ this.getMail() +"'";
			ResultSet result = st.executeQuery(sql2);
			int idContributor = result.getInt("idContributor");
			
			String sql3 = "INSERT INTO `LotuZ`.`User` (`idContributor`) VALUES ('"+ idContributor +"') Where mail='"+ this.getMail() +"'";
			
			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql3);

		} catch (SQLException e) {
			throw e;
		}
	}

	public Contributor load(String idmail) throws SQLException {
		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.User  Where mail='"+idmail+"'";
			
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while(result.next()){	
				this.setLastName(result.getString("lastName"));
				this.setFirstName(result.getString( "firstName" ));
				this.setMail(result.getString( "Mail" ));
				this.setPhone(result.getString( "tel" ));
				this.setStreetName(result.getString( "streetName" ));
				this.setNumHouse(result.getString( "numHouse" ));
				this.setCity(result.getString( "city" ));
				this.setPostCode(result.getString( "postCode" ));
				this.setPassword(result.getString("password"));
				this.setIdContributor(result.getInt("idContributor"));
				this.setIdMember(result.getInt("idMember"));
			}
		
		} catch (SQLException e) {
			throw e;
		}
		return this;
	}
	
	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();
			
			String sql = "Delete u,c From LotuZ.User u JOIN LotuZ.Contributor m ON u.idContributor=m.idContributor Where mail='"+ this.getMail() +"'";

			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void update() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();

			String sql = "UPDATE User SET `lastName`='"+this.getLastName() +"',`firstName`='"+ this.getFirstName() +"',`mail`='"+this.getMail()
					+"',`tel`='"+this.getPhone()+"',`streetName`='"+this.getStreetName()+"',`numHouse`='"+this.getNumHouse()+"',`city`='"+this.getCity()+"',`postCode`='"+this.getPostCode()
					+"',`idMember`='"+this.getIdMember()+"',`idContributor`='"+this.getIdContributor()+"' Where `mail`='"+this.getMail()+"'";
			
					
			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw e;
		}
	}


}

