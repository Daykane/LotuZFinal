package com.LotuZ.user.activityLeader.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.user.User;

/**
 * @author Ludo
 *
 */
public abstract class ListActivityLeader {

	/**
	 * On déclare une liste de responsables d'activités 
	 */
	private List<User> listActivityLeader;

	/**
	 * @param listActivityLeader
	 */
	public ListActivityLeader(List<User> listActivityLeader) {
		super();
		this.listActivityLeader = listActivityLeader;
	}


	public ListActivityLeader() {
		super();
	}

	/**
	 * @return une liste de responsables d'activités
	 */
	public List<User> getListActivityLeader() {
		return listActivityLeader;
	}

	/**
	 * @param listActivityLeader
	 */
	public void setListActivityLeader(List<User> listActivityLeader) {
		this.listActivityLeader = listActivityLeader;
	}


	/**
	 * @return une liste de responsables d'activités 
	 * @throws SQLException 
	 */
	public abstract ListActivityLeader load() throws SQLException;
	
}
