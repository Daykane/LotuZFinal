package Business;

import java.sql.SQLException;

public class FacadeBL {
	
	UserManager userManager = new UserManager();
	
	public void inscription(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException{
		userManager.inscription(lastName, firstName, adress, phone, street, houseNumber, city, postCode, password);
	}
}