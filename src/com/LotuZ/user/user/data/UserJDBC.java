package com.LotuZ.user.user.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.user.user.bl.User;


/**
 * @author Ludo
 *
 */
public class UserJDBC extends User{
	
	private Connection cn;

	/**
	 * @return the cn
	 */
	public Connection getCn() {
		return cn;
	}

	/**
	 * @param cn the cn to set
	 */
	public void setCn(Connection cn) {
		this.cn = cn;
	}

	/**
	 * @param cn
	 */
	public UserJDBC(Connection cn){
		this.cn = cn;
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param mail
	 * @param tel
	 * @param streetName
	 * @param numHouse
	 * @param city
	 * @param postCode
	 * @param password
	 * @param idContributor
	 * @param idMember
	 */
	public UserJDBC(String lastName, String firstName, String mail, String tel,
			String streetName, String numHouse, String city, String postCode,
			String password, int idContributor, int idMember) {
		super(lastName, firstName, mail, tel,
				streetName, numHouse, city, postCode,
				password, idContributor, idMember);

	}

	public UserJDBC() {
		// TODO Auto-generated constructor stub
	}


	public void save() throws ClassNotFoundException, SQLException {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`User` (`lastName`, `firstName`, `mail`, `tel`, `streetName`, `numHouse`, `city`, `postCode`, `password`) VALUES ('"+ this.getLastName() +"', '"+ this.getFirstName() +"', '"+ this.getMail() +"', '"+ this.getPhone() +"', '"+ this.getStreetName() +"', '"+ this.getNumHouse() +"', '"+ this.getCity() +"', '"+ this.getPostCode() +"', '"+ this.getPassword() +"')";
			
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
	}

	public User load(String idmail) throws SQLException {
		try {

			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User  Where mail='"+idmail+"'";
			
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
				this.setPassword(result.getString("password"));
				this.setIdContributor(result.getInt("idContributor"));
				this.setIdMember(result.getInt("idMember"));
			}
		
		} catch (SQLException e) {
			throw e;
		}
		System.out.println("JDBC");
		return this;
	}
	
	public void delete(User user) throws ClassNotFoundException, SQLException {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "Delete From LotuZ.User Where mail = '"+ user.getMail() +"'";
			System.out.println("Delete User" +user);
	
			// Etape 4 : exécution requête
			st.executeUpdate(sql);

	}
	
	public void update(User user) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "UPDATE User SET `lastName`='"+user.getLastName() +"',`firstName`='"+ user.getFirstName() +"',`mail`='"+user.getMail()
					+"',`tel`='"+user.getPhone()+"',`streetName`='"+user.getStreetName()+"',`numHouse`='"+user.getNumHouse()+"',`city`='"+user.getCity()+"',`postCode`='"+user.getPostCode()
					+"' Where `mail`='"+user.getMail()+"'";
			
					
			// Etape 4 : exécution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw e;
		}
	}

}


