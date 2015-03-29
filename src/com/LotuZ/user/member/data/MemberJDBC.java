package com.LotuZ.user.member.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * load a member from the database 
	 */
	@Override
	public Member load(String mailMember) throws SQLException {
		
			Member member = null;
			
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();

			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.User u,LotuZ.Member m Where u.idMember = m.idMember and u.idMember is not null and u.mail="+'"'+mailMember+'"';
			
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			if(result.first() == false)
			{
				System.out.println("Aie on passe la ");
				return member;
			}
			else 
			{

					Member member2 = new MemberJDBC();
					member2.setCotisation(result.getDouble("cotisation"));
					member2.setDateCotisation(result.getString("dateCotisation"));
					member2.setIdBoxLetter(result.getInt("idBoxLetter"));
					member2.setIdAdmin(result.getInt("idAdmin"));
					member2.setIdLeader(result.getInt("idLeader"));
					member2.setIdMember(result.getInt("idMember"));
					System.out.println(" On a retourne :"+member2.getCotisation());

			return member2;
			}
	}
	

	/**
	 * update a member  
	 */
	public void update(Member member) throws SQLException {
		try {		
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();

			// Requ�te de modification
			String sql = "UPDATE LotuZ.User u, LotuZ.Member m SET `cotisation`='"+member.getCotisation()+"',`dateCotisation`='"+member.getDateCotisation()
					+"',`idAdmin`='"+member.getIdAdmin()+"',`idLeader`='"+member.getIdLeader()+"' Where u.idMember = m.idMember and m.idMember='"+member.getIdMember()+"'";
			
			// Ex�cution requ�te
			st.executeUpdate(sql);
		
			} catch (SQLException e) {
				throw e;
			}
	}
	


	/**
	 * save a member in the database 
	 */
	public void save(User user) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`Member` ( `cotisation`, `dateCotisation`, `idBoxLetter`, `idAdmin`, `idLeader`, `mailMember` ) VALUES ('"+ this.getCotisation() +"', '"+ this.getDateCotisation() +"', '"+ this.getIdBoxLetter() +"', '"+ this.getIdAdmin() +"', '"+ this.getIdLeader() +"', '"+ user.getMail()+"')";
			String sql2 = "SELECT idMember FROM LotuZ.Member Where mail='"+ user.getMail() +"'";

			
			// Ex�cution requ�te
			st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql2);
			int idmembre = result.getInt("idMembre");

			String sql3 = "UPDATE LotuZ.User SET (`idMember`) = ('"+ idmembre +"') Where mail='"+ user.getMail() +"'";
			st.executeUpdate(sql3);

		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * delete a member  
	 */
	public void delete() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			String sql = "UPDATE LotuZ.User SET `idMember` = null Where idMember='"+ this.getIdMember() +"'";

			String sql2 = "Delete From LotuZ.Member Where idMember='"+ this.getIdMember() +"'";

			// Ex�cution requ�te
			st.executeUpdate(sql);
			st.executeUpdate(sql2);

		} catch (SQLException e) {
			throw e;
		}
	}

}

