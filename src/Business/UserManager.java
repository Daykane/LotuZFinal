package Business;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Business.HashTextTest;

public class UserManager
{
	HashTextTest crypt;
	FacadeData facadedata = new FacadeData();
	public void inscription(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9) throws ClassNotFoundException, SQLException {
			String passWordCrypt="";
			User user = new User( text,  text2,  text3,
			 text4,  text5,  text6,  text7, text8);
			//User user = FactoryUser.createUser(String text, String text2, String text3,
			//String text4, String text5, String text6, String text7,
			//String text8, String text9);
			try {
				passWordCrypt = HashTextTest.sha1(text9);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			facadedata.inscriptionData( text,  text2,  text3,
					 text4,  text5,  text6,  text7,
					 text8, passWordCrypt );
		}
}
