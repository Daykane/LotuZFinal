package Business;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Model.PersistKit;
import UI.HomePageUser;
import UI.HomepageUI;
import Business.HashTextTest;
import Class.User;

public class UserManager
{
	HashTextTest crypt;
	FacadeData facadedata = new FacadeData();
	FacadeModel facadeModel = new FacadeModel();
	PersistKit persistKit;
	
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
	
	/*
	public void login(String mail,String password) throws SQLException{
		String passWordCrypt="";
		try {
			passWordCrypt = HashTextTest.sha1(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		User user = facadedata.login(mail,passWordCrypt);
		if (user == null){
			System.out.println("Inexistant");
		}
		else {
			HomePageUser frame = new HomePageUser();
			frame.setVisible(true);
		}
			

	}
		*/
}
