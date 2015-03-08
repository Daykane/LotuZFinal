package Business;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Business.HashTextTest;
import Class.User;

public class UserManager
{
	HashTextTest crypt;
	FacadeData facadedata = new FacadeData();
	FacadeModel facadeModel = new FacadeModel();
	public void inscription(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException {
			String passWordCrypt="";
			try {
				passWordCrypt = HashTextTest.sha1(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			User user = facadeModel.createUser(lastName, firstName, adress, phone, street, houseNumber, city, postCode, passWordCrypt);
			facadedata.inscriptionData(user);
		}
}
