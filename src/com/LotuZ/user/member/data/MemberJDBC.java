package com.LotuZ.user.member.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.User;


/**
 * 
 * @author Ludo
 *
 */

public class MemberJDBC extends Member{
	
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
	public MemberJDBC() {
		super();
	}
	
	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;

	/**
	 * @param cn
	 */
	public MemberJDBC(Connection cn){
		this.cn = cn;
	}	
	

	/**
	 * Lecture d'un membre en base à partir de son identifiant 
	 */
	@Override
	public Member load(String mailMember) throws SQLException {
		
			Member member = null;
			
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			System.out.println(mailMember+"Retour null MembreJDBC");

			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User u,LotuZ.Member m Where u.idMember = m.idMember and u.idMember is not null and u.mail="+'"'+mailMember+'"';
			
			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			if(result.first() == false)
			{
				System.out.println("Retour null MembreJDBC");
				return member;
			}
			else 
			{
				// Récupération des données 
				while(result.next()){	
					member = new MemberJDBC();
					member.setCotisation(result.getDouble("cotisation"));
					member.setDateCotisation(result.getString("dateCotisation"));
					member.setIdBoxLetter(result.getInt("idBoxLetter"));
					member.setIdAdmin(result.getInt("idAdmin"));
					member.setIdLeader(result.getInt("idLeader"));
					member.setIdMember(result.getInt("idMember"));
				}
			System.out.println("Retour non null MembreJDBC");
			return member;
			}
	}
	

	/**
	 * Modification d'un membre en base à partir de son identifiant 
	 */

	public void update() throws SQLException {
		try {		
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
		
			// Requête de modification
			String sql = "UPDATE LotuZ.User u, LotuZ.Member m SET `cotisation`='"+this.getCotisation()+"',`dateCotisation`='"+this.getDateCotisation()
					+"',`idBoxLetter`='"+this.getIdBoxLetter()+"',`idAdmin`='"+this.getIdAdmin()+"',`idLeader`='"+this.getIdLeader()+"' Where u.idMember = m.idMember and `idMember`='"+this.getIdMember()+"'";
			
			// Exécution requête
			st.executeUpdate(sql);
		
			} catch (SQLException e) {
				throw e;
			}
	}
	



	public void save(User user) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`Member` ( `cotisation`, `dateCotisation`, `idBoxLetter`, `idAdmin`, `idLeader`, `mailMember` ) VALUES ('"+ this.getCotisation() +"', '"+ this.getDateCotisation() +"', '"+ this.getIdBoxLetter() +"', '"+ this.getIdAdmin() +"', '"+ this.getIdLeader() +"', '"+ user.getMail()+"')";
			String sql2 = "SELECT idMember FROM LotuZ.Member Where mail='"+ user.getMail() +"'";

			
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql2);
			int idmembre = result.getInt("idMembre");

			String sql3 = "UPDATE LotuZ.User SET (`idMember`) = ('"+ idmembre +"') Where mail='"+ user.getMail() +"'";
			st.executeUpdate(sql3);

		} catch (SQLException e) {
			throw e;
		}
	}


	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			
			String sql = "UPDATE LotuZ.User SET (`idMember`) = null Where idMember='"+ this.getIdMember() +"'";

			String sql2 = "Delete From LotuZ.Member Where mail='"+ this.getIdMember() +"'";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			st.executeUpdate(sql2);


		} catch (SQLException e) {
			throw e;
		}
	}








}

