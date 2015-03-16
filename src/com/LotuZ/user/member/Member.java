/**
 * 
 */
package com.LotuZ.user.member;

import java.sql.SQLException;

import com.LotuZ.user.User;


/**
 * @author Alexis
 *
 */
public class Member extends User{

	/**
	 * 
	 */
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param streeName
	 * @param numHouse
	 * @param city
	 * @param postCode
	 * @param mail
	 */
	public Member(String lastName, String firstName, String streeName,
			String numHouse, String city, String postCode, String mail,String password, String phone) {
		super(lastName, firstName, streeName, numHouse, city, postCode, mail,password, phone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User load(String mail2, String passWordCrypt) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
