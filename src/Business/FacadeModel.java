package Business;

import Class.User;

public class FacadeModel {
	
User user;
	
	public User createUser(){
		user= new User();
		return user;
	}
	
	public User createUser(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password){
		user = new User(lastName, firstName, adress,
			phone, street, houseNumber, city,
			postCode, password);
		return user;
	}

}
