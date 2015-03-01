package Business;

import java.sql.SQLException;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


public class UserManager {
	FacadeData facadeData = new FacadeData();

	public void Inscription(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9) {
		try {
			facadeData.Inscription( text,  text2,  text3,
					 text4,  text5,  text6,  text7,
					 text8,  text9);
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("Exception remontée");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
