package com.LotuZ.user.admin.bl;


import java.sql.SQLException;

import com.LotuZ.user.member.bl.Member;


/**
 * @author Ludo
 *
 */


public abstract class Administrator extends Member{
	

	public Administrator() {
		super();
	}


	
	/**
	 * @return Administrator
	 * @throws SQLException
	 */
	public abstract Administrator update() throws SQLException;



	/**
	 * @param idAdministrator
	 * @return Administrator
	 * @throws SQLException
	 */
	public abstract Administrator load(String idAdministrator) throws SQLException;
	
	
	/**
	 * @param idAdministrator
	 * @throws SQLException
	 */
	public abstract void delete(String idAdministrator) throws SQLException;





	
}
