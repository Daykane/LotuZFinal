package com.LotuZ.user.user.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.User;


/**
 * @author LotuZ
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
		try {		
			Statement st =null;
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();

			//String sql = "Insert into User Values ('"+ this.getLastName() +"','"+ this.getFirstName() +"','"+ this.getMail() +"','"+ this.getPhone() +"','"+ this.getStreetName() +"','"+ this.getNumHouse() +"','"+ this.getCity() +"','"+ this.getPostCode() +"','"+ this.getPassword() +"','"+ 0 +"','"+ 0 +"')";
			//String sql = "Insert into User Values ('"+ this.getLastName() +"','"+ this.getFirstName() +"','"+ this.getMail() +"','"+ this.getPhone() +"','"+ this.getStreetName() +"','"+ this.getNumHouse() +"','"+ this.getCity() +"','"+ this.getPostCode() +"','"+ this.getPassword() + "')";
			String sql = "INSERT INTO `LotuZ`.`User` (`lastName`, `firstName`, `mail`, `tel`, `streetName`, `numHouse`, `city`, `postCode`, `password`) VALUES ('"+ this.getLastName() +"', '"+ this.getFirstName() +"', '"+ this.getMail() +"', '"+ this.getPhone() +"', '"+ this.getStreetName() +"', '"+ this.getNumHouse() +"', '"+ this.getCity() +"', '"+ this.getPostCode() +"', '"+ this.getPassword() +"')";
			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw e;
		}
	}

	public User load(String mail) throws SQLException {
		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.User u Where u.mail="+'"'+mail+'"';
			
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
	
	/*@Override
	public boolean isAdmin() throws SQLException {
		boolean flag = false;
		int answer = 0;
		try{
			Statement st =null;
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();
			String sql = "Select idAdmin From LotuZ.Member m,LotuZ.User u where m.idMember=u.idMember and u.mail='"+this.getMail()+"'";
			ResultSet result = st.executeQuery(sql);
			while( result.next() ){	
				answer = result.getInt("idAdmin");			
			}	
		}
		catch  (SQLException e) {
			throw e;
		}
		if(answer == 1){
			flag = true;
		}
		return flag;
	}*/
}


