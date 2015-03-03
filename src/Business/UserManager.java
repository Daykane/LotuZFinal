package Business;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import Business.HashTextTest;

public class UserManager
{
	HashTextTest crypt;
	FacadeData facadedata = new FacadeData();
	public void Inscription(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9) throws ClassNotFoundException, SQLException {
			String passWordCrypt="";
			try {
				passWordCrypt = HashTextTest.sha1(text9);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			facadedata.InscriptionData( text,  text2,  text3,
					 text4,  text5,  text6,  text7,
					 text8, passWordCrypt );
		}
}
