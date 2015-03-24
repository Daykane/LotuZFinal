package com.LotuZ.user.admin.bl;


import java.sql.SQLException;

import com.LotuZ.user.activityLeader.bl.ActivityLeader;
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
	 * @param idActivityLeader
	 * @return activityLeader
	 * @throws SQLException
	 */
	public abstract Administrator load(String idAdmin) throws SQLException;
	
	


	
}
