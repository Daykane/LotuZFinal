package com.LotuZ.user.admin.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;







import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.member.data.MemberJDBC;


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
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User u,LotuZ.Member m Where u.idMember = m.idMember and u.idMember is not null and u.mail="+'"'+idMember+'"';
			
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
				this.setCotisation(result.getDouble("cotisation"));
				this.setDateCotisation(result.getString("dateCotisation"));
				this.setIdBoxLetter(result.getInt("idBoxLetter"));
				this.setIdAdmin(result.getInt("idAdmin"));
				this.setIdLeader(result.getInt("idLeader"));
				
			}
		
		} catch (SQLException e) {
			throw e;
		}
		return this;
	}
	

	/**
	 * Modification d'un membre en base à partir de son identifiant 
	 */
	@Override
	public void update() throws SQLException {
		try {		
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
		
			// Requête de modification
			String sql = "UPDATE LotuZ.User u, LotuZ.Member m SET `lastName`='"+this.getLastName() +"',`firstName`='"+ this.getFirstName() +"',`mail`='"+this.getMail()
					+"',`tel`='"+this.getPhone()+"',`streetName`='"+this.getStreetName()+"',`numHouse`='"+this.getNumHouse()+"',`city`='"+this.getCity()+"',`postCode`='"+this.getPostCode()
					+"',`cotisation`='"+this.getCotisation()+"',`dateCotisation`='"+this.getDateCotisation()
					+"',`idAdmin`='"+this.getIdAdmin()+"',`idLeader`='"+this.getIdLeader()+"' Where u.idMember = m.idMember and `mail`='"+this.getMail()+"'";
			
			// Exécution requête
			st.executeUpdate(sql);
		
			} catch (SQLException e) {
				throw e;
			}
	}
	



	public void save() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`Member` (`idAdmin` ) VALUES ('"+ '1' +"') Where mail='"+ this.getMail() +"'";;
			
			// Etape 4 : exécution requête
			st.executeUpdate(sql);


		} catch (SQLException e) {
			throw e;
		}
	}


	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			
			String sql = "Delete u,m From LotuZ.User u JOIN LotuZ.Member m ON u.idMember=m.idMember Where mail='"+ this.getMail() +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);


		} catch (SQLException e) {
			throw e;
		}
	}



}

