/**
 * 
 * @author Alexis
 *
 */

package com.LotuZ.user;

import java.sql.SQLException;


public abstract class User {

	private String lastName;
	private String firstName;
	private String streetName;
	private String numHouse;
	private String city;
	private String postCode;
	private String mail;
	private String password;
	private String phone;
	private int idContributor;
	private int idMember;
	
	
	public User() {
		super();
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param streeName
	 * @param numHouse
	 * @param city
	 * @param postCode
	 * @param mail
	 * @param activityLeader 
	 * @param member 
	 */
	public User(String lastName, String firstName, String mail,
			String phone, String streetName, String numHouse, String city,String postCode,String password, int idContributor, int idMember) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.streetName = streetName;
		this.numHouse = numHouse;
		this.city = city;
		this.postCode = postCode;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.idContributor=idContributor;
		this.idMember =idMember;
		
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the streeName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streeName the streeName to set
	 */
	public void setStreetName(String streeName) {
		this.streetName = streeName;
	}

	/**
	 * @return the numHouse
	 */
	public String getNumHouse() {
		return numHouse;
	}

	/**
	 * @param numHouse the numHouse to set
	 */
	public void setNumHouse(String numHouse) {
		this.numHouse = numHouse;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * @return the idContributor
	 */
	public int getIdContributor() {
		return idContributor;
	}

	/**
	 * @param idContributor the idContributor to set
	 */
	public void setIdContributor(int idContributor) {
		this.idContributor = idContributor;
	}

	/**
	 * @return the idMember
	 */
	public int getIdMember() {
		return idMember;
	}

	/**
	 * @param idMember the idMember to set
	 */
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public abstract void save() throws SQLException, ClassNotFoundException;

	public abstract User load(String mail) throws SQLException;

	public abstract boolean isAdmin();


}
