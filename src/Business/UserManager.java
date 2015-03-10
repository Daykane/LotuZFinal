package Business;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Model.JdbcKit;
import Model.PersistKit;
import UI.HomePageUserUI;
import Business.HashTextTest;
import Class.User;

public class UserManager
{
	HashTextTest crypt;
	PersistKit jdbcKit = new JdbcKit();
	
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
			User user = jdbcKit.createUser();
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
	
	
	public void login(String mail,String password) throws SQLException{
		String passWordCrypt="";
		try {
			passWordCrypt = HashTextTest.sha1(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Object object = jdbcKit.login(mail,passWordCrypt);
		if (object == null){
			System.out.println("Inexistant");			
		}
		else{
			if( object instanceof User){
					System.out.println("C'est un user qui vient de s'authentifier");
					HomePageUserUI frame = new HomePageUserUI();
					frame.setVisible(true);
				}
			}
		}
	
		
}
