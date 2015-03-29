/**
 * 
 */
package com.LotuZ.user.member.bl;

import java.sql.SQLException;



/**
 * @author Ludo
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
	 * @param dateCotisation
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



	/**
	 * @return cotisation 
	 */
	public Double getCotisation() {
		return cotisation;
	}

	/**
	 * @param cotisation to set 
	 */
	public void setCotisation(Double cotisation) {
		this.cotisation = cotisation;
	}

	/**
	 * @return idBoxLetter
	 */
	public int getIdBoxLetter() {
		return idBoxLetter;
	}

	/**
	 * @param idBoxLetter to set 
	 */
	public void setIdBoxLetter(int idBoxLetter) {
		this.idBoxLetter = idBoxLetter;
	}

	
	/**
	 * @return dateCotisation
	 */
	public String getDateCotisation() {
		return dateCotisation;
	}

	/**
	 * @param dateCotisation to set
	 */
	public void setDateCotisation(String dateCotisation) {
		this.dateCotisation = dateCotisation;
	}

	/**
	 * @return idAdmin
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * @return idLeader
	 */
	public int getIdLeader() {
		return idLeader;
	}

	/**
	 * @param idLeader to set 
	 */
	public void setIdLeader(int idLeader) {
		this.idLeader = idLeader;
	}
	

	/**
	 * @return idMember
	 */
	public int getIdMember() {
		return idMember;
	}


	/**
	 * @param idMember to set
	 */
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}


	/**
	 * load a member
	 * @param idMember
	 * @return Member
	 * @throws SQLException
	 */
	public abstract Member load(String idMember) throws SQLException;
	
	
	/**
	 * delete a member
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public abstract void delete() throws ClassNotFoundException, SQLException;
	
	
	
	/**
	 * update a member
	 * @param member
	 * @throws SQLException
	 */
	public abstract void update(Member member) throws SQLException;

}
