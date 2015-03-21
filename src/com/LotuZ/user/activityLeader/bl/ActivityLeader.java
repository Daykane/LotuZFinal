package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;


/**
 * @author Ludo
 *
 */


public abstract class ActivityLeader {
	

	public ActivityLeader() {
		super();
	}


	private String lastName;
	private String firstName;
	private String mail;
	private String tel;
	private String streetName;
	private String numHouse;
	private String city;
	private String postCode;
	private final boolean isActivityLeader = true;
	private final boolean isMember = false;


	


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
	public ActivityLeader(String lastName, String firstName, String mail,String tel, String streetName,String numHouse, String city, String postCode ) {
		super();
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setMail(mail);
		this.setTel(tel);
		this.setStreetName(streetName);
		this.setNumHouse(numHouse);
		this.setCity(city);
		this.setPostCode(postCode);
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the phone number 
	 */
	public String getTel() {
		return tel;
	}


	/**
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}


	/**
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}


	/**
	 * @return the street name
	 */
	public String getStreetName() {
		return streetName;
	}


	/**
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}



	/**
	 * @return the number of house
	 */
	public String getNumHouse() {
		return numHouse;
	}



	/**
	 * @param numHouse
	 */
	public void setNumHouse(String numHouse) {
		this.numHouse = numHouse;
	}



	/**
	 * @return the post code
	 */
	public String getPostCode() {
		return postCode;
	}



	/**
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}



	/**
	 * @return the city 
	 */
	public String getCity() {
		return city;
	}



	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}



	/**
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract ActivityLeader update() throws SQLException;



	/**
	 * @param idActivityLeader
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract ActivityLeader load(String idActivityLeader) throws SQLException;
	
	
	/**
	 * @param idActivityLeader
	 * @throws SQLException
	 */
	public abstract void delete(String idActivityLeader) throws SQLException;


	/**
	 * @return bool activityLeader
	 */
	public boolean isActivityLeader() {
		return isActivityLeader;
	}


	public boolean isMember() {
		return isMember;
	}
	
}
