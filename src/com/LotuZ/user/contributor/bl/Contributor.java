package com.LotuZ.user.contributor.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.user.User;
import com.LotuZ.event.Event;

/**
 * @author Ludo
 *
 */


public abstract class Contributor {
	

	public Contributor() {
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
	private String password;
	private List<Event> events;

	


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
	public Contributor(String lastName, String firstName, String mail,String tel, String streetName,String numHouse, String city, String postCode ) {
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
	 * @return contributor
	 * @throws SQLException
	 */
	public abstract Contributor update() throws SQLException;



	/**
	 * @param idContributor
	 * @return contributor
	 * @throws SQLException
	 */
	public abstract Contributor load(String idContributor) throws SQLException;
	
	
	/**
	 * @param idContributor
	 * @throws SQLException
	 */
	public abstract void delete(String idContributor) throws SQLException;


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}



	
}
