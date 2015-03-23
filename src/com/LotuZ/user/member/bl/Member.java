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
public abstract class Member extends User{
	

	private Double cotisation;
	private String dateCotisation;
	private Integer idBoxLetter;
	private Integer idAdmin;
	private Integer idLeader;
	
	/**
	 * 
	 */
	public Member() {
		super();
		this.setCotisation(cotisation);
		this.setDateCotisation(dateCotisation);
		this.setIdBoxLetter(idBoxLetter);
		this.setIdAdmin(idAdmin);
		this.setIdLeader(idLeader);
	}



	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public abstract User load(String mail) throws SQLException;

	public abstract Member update() throws SQLException ;

	public abstract void delete(String idMember) throws SQLException ;

	public Double getCotisation() {
		return cotisation;
	}

	public void setCotisation(Double cotisation) {
		this.cotisation = cotisation;
	}

	public Integer getIdBoxLetter() {
		return idBoxLetter;
	}

	public void setIdBoxLetter(Integer idBoxLetter) {
		this.idBoxLetter = idBoxLetter;
	}

	public String getDateCotisation() {
		return dateCotisation;
	}

	public void setDateCotisation(String dateCotisation) {
		this.dateCotisation = dateCotisation;
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Integer getIdLeader() {
		return idLeader;
	}

	public void setIdLeader(Integer idLeader) {
		this.idLeader = idLeader;
	}

}
