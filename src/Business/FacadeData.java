package Business;

import java.sql.SQLException;


public class FacadeData {

	UserJDBC userJDBC = new UserJDBC();
	public void inscriptionData(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9) throws ClassNotFoundException, SQLException{
		userJDBC.inscriptionData( text,  text2,  text3,
				 text4,  text5,  text6,  text7,
				 text8,  text9);
	}

}
