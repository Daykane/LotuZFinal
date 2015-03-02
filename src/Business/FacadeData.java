package Business;

import java.sql.SQLException;


import Model.ConnexionDatabase;

public interface FacadeData {
	ConnexionDatabase connexionData = new ConnexionDatabase();

	public void Inscription(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9) throws ClassNotFoundException, SQLException;

}
