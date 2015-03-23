package com.LotuZ.user.member.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;


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
	 * Lecture d'un responsable d'activit� en base � partir de son identifiant 
	 */
	@Override
	public Member load(String idMember) throws SQLException {
		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.User u,LotuZ.Member m Where u.idMember = m.idMember and u.mail="+'"'+idMember+'"';
			
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
	public Member update() throws SQLException {
		try {		
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
		
			// Requ�te de modification
			String sql = "UPDATE User SET `lastName`='"+this.getLastName() +"',`firstName`='"+ this.getFirstName() +"',`mail`='"+this.getMail()
				+"',`tel`='"+this.getPhone()+"',`streetName`='"+this.getStreetName()+"',`numHouse`='"+this.getNumHouse()+"',`city`='"+this.getCity()+"',`postCode`='"+this.getPostCode()+"' Where `mail`='"+this.getMail()+"'";
		
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

	public void delete(String idMember) throws SQLException {
		try {	
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
		
			// Requ�te de modification
			String sql = "Delete From User Where mail="+'"'+idMember+'"';
			
			// Ex�cution requ�te
			st.executeUpdate(sql);
		
		} catch (SQLException e) {
			throw e;
		}
	}


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return false;
	}


}

