package com.LotuZ.user.user.bl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ludo
 *
 */
/**
 * @author Ludo
 *
 */
public abstract class ListUser {

	/**
	 * On déclare une liste de users
	 */
	private List<User> listUser;

	/**
	 * @param listUser
	 */
	public ListUser(List<User> listUser) {
		super();
		this.listUser = listUser;
	}


	public ListUser() {
		super();
	}

	/**
	 * @return une liste de responsables d'activités
	 */
	public List<User> getListUser() {
		return listUser;
	}

	/**
	 * @param listActivityLeader
	 */
	public void setListActivityLeader(List<User> listActivityLeader) {
		this.listUser = listActivityLeader;
	}


	/**
	 * @return une liste de responsables d'activités 
	 * @throws SQLException 
	 */
	public abstract ListUser loadMembers() throws SQLException;
	
	
	/**
	 * @return a ListUser
	 * @throws SQLException
	 */
	public abstract ListUser loadContributors() throws SQLException;
	
	
	/**
	 * @return a ListUser
	 * @throws SQLException
	 */
	public abstract ListUser loadLeaders() throws SQLException;
	
}
