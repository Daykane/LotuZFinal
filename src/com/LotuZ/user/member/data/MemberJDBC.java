package com.LotuZ.user.member.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			// Création d'un statement
			st = this.cn.createStatement();

			// Requête de sélection à partir de l'identifiant 
			String sql = "Select * From LotuZ.User u,LotuZ.Member m Where u.idMember = m.idMember and u.idMember is not null and u.mail="+'"'+mailMember+'"';
			
			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			if(result.first() == false)
			{
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
			return member2;
			}
	}
	

	/**
	 * update a member  
	 */
	public void update(Member member) throws SQLException {
		try {		
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();

			// Requête de modification
			String sql = "UPDATE LotuZ.User u, LotuZ.Member m SET `cotisation`='"+member.getCotisation()+"',`dateCotisation`='"+member.getDateCotisation()
					+"' Where u.idMember = m.idMember and m.idMember='"+member.getIdMember()+"'";
			
			// Exécution requête
			st.executeUpdate(sql);
		
			} catch (SQLException e) {
				throw e;
			}
	}
	


	/**
	 * save a member in the database 
	 */
	public void save(User user,Date date) throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Création d'un statement
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String output = formatter.format(date);
			
			st = this.cn.createStatement();

			String sql = "INSERT INTO `LotuZ`.`Member` ( `cotisation`, `dateCotisation`, `mailMember` ) VALUES ('"+ this.getCotisation() +"', '"+ output +"', '"+ user.getMail()+"')";
			
			String sql2 = "SELECT idMember FROM LotuZ.Member Where mailMember='"+ user.getMail() +"'";

			
			// Exécution requête
			st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql2);
			int idmembre = 0;
			while (result.next())
			{
				idmembre = result.getInt("idMember");
			}
			String sql3 = "UPDATE LotuZ.User SET idMember = ('"+ idmembre +"') Where mail='"+ user.getMail() +"'";
			st.executeUpdate(sql3);
			
			String sql4 = "INSERT INTO BoxLetter (`idMember`) VALUES ('"+ idmembre +"')";
			st.executeUpdate(sql4);
			String sql5 = "SELECT * FROM LotuZ.BoxLetter Where idMember='"+ idmembre +"'";
			
			ResultSet result2 = st.executeQuery(sql5);
			int idbox = 0;
			while (result2.next())
			{
				idbox = result2.getInt("idBoxLetter");
			}
			String sql6 = "UPDATE LotuZ.Member SET idBoxLetter = ('"+ idbox +"') Where mail='"+ user.getMail() +"'";
			st.executeUpdate(sql6);


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
			// Création d'un statement
			st = this.cn.createStatement();
			
			String sql = "UPDATE LotuZ.User SET `idMember` = null Where idMember='"+ this.getIdMember() +"'";

			String sql2 = "Delete From LotuZ.Member Where idMember='"+ this.getIdMember() +"'";

			// Exécution requête
			st.executeUpdate(sql);
			st.executeUpdate(sql2);

		} catch (SQLException e) {
			throw e;
		}
	}

}

