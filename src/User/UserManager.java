package User;

import HashTextTest;
import PersistKit;
import UserLog;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * @author LotuZ
 *
 */

public class UserManager
{
	HashTextTest crypt;
	PersistKit pkit;
	
	public UserManager(PersistKit kit){
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
				passWordCrypt = HashTextTest.sha1(password);
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
	
	


