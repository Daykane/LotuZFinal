/**
 * 
 */
package com.LotuZ.user.member.bl;

import java.sql.SQLException;

import com.LotuZ.user.user.bl.User;


/**
 * @author Alexis & Ludo
 *
 */
public abstract class Member {
	
	private int idMember;
	private Double cotisation;
	private String dateCotisation;
	private int idBoxLetter;
	private int idAdmin;
	private int idLeader;
	
	/**
	 * 
	 */
	public Member(String dateCotisation) {
		super();
		this.setCotisation(cotisation);
		this.setDateCotisation(dateCotisation);
		this.setIdBoxLetter(idBoxLetter);
		this.setIdAdmin(idAdmin);
		this.setIdLeader(idLeader);
	}
	
	public Member() {
		super();
	}



	public Double getCotisation() {
		return cotisation;
	}

	public void setCotisation(Double cotisation) {
		this.cotisation = cotisation;
	}

	public int getIdBoxLetter() {
		return idBoxLetter;
	}

	public void setIdBoxLetter(int idBoxLetter) {
		this.idBoxLetter = idBoxLetter;
	}

	public String getDateCotisation() {
		return dateCotisation;
	}

	public void setDateCotisation(String dateCotisation) {
		this.dateCotisation = dateCotisation;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public int getIdLeader() {
		return idLeader;
	}

	public void setIdLeader(int idLeader) {
		this.idLeader = idLeader;
	}
	

	public int getIdMember() {
		return idMember;
	}


	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}


	public abstract Member load(String idMember) throws SQLException;
	public abstract void delete(Member member) throws ClassNotFoundException, SQLException;
	public abstract void update(Member member) throws SQLException;

}
