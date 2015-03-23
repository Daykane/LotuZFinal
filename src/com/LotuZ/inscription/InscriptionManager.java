package com.LotuZ.inscription;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashText;
import com.LotuZ.user.user.bl.User;

/**
 * @author LotuZ
 *
 */

public class InscriptionManager
{
	private PersistKit pkit;
	
	public InscriptionManager(PersistKit kit){
		this.pkit=kit;
	}
	
	/**
	 * @param lastName
	 * @param firstName
	 * @param mail
	 * @param phone
	 * @param street
	 * @param houseNumber
	 * @param city
	 * @param postCode
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void inscription(String lastName, String firstName, String mail,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException {
			String passWordCrypt="";
			try {
				passWordCrypt = HashText.sha1(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			// Create empty userJdbc
			User user = pkit.createUser();
			// set informations into the userJdbc
			user.setCity(city);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setMail(mail);
			user.setNumHouse(houseNumber);
			user.setPassword(passWordCrypt);
			user.setPhone(phone);
			user.setPostCode(postCode);
			user.setStreetName(street);
			// Save in database the user
			user.save();
		}
}
	
	


