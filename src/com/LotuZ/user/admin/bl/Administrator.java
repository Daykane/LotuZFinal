package com.LotuZ.user.admin.bl;


import java.sql.SQLException;



/**
 * @author Ludo
 *
 */


public abstract class Administrator {
	

	public Administrator() {
		super();
	}
	
	/**
	 * @param idActivityLeader
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract Administrator load(String idAdmin) throws SQLException;
	
	


	
}
