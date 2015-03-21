package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;
import java.util.Vector;

import com.LotuZ.activity.Activity;



public abstract class ActivityLeader {
	
	public ActivityLeader() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String lastName;
	private String firstName;
	private String mail;
	private String tel;
	private String streetName;
	private String numHouse;
	private String city;
	private String postCode;


	


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
	 * @return the name
	 */
	public String getLastName() {
		return lastName;
	}


	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getStreetName() {
		return streetName;
	}



	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}



	public String getNumHouse() {
		return numHouse;
	}



	public void setNumHouse(String numHouse) {
		this.numHouse = numHouse;
	}



	public String getPostCode() {
		return postCode;
	}



	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public abstract ActivityLeader update() throws SQLException;



	public abstract ActivityLeader load(String idActivityLeader) throws SQLException;
	
	
	




}
