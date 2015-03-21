package com.LotuZ.user.contributor.bl;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.user.User;

/**
 * @author Ludo
 *
 */
public abstract class ListContributor {

	/**
	 * On déclare une liste de responsables d'activités 
	 */
	private List<User> listContributor;

	/**
	 * @param listContributor
	 */
	public ListContributor(List<User> listContributor) {
		super();
		this.listContributor = listContributor;
	}


	public ListContributor() {
		super();
	}

	/**
	 * @return une liste de responsables d'activités
	 */
	public List<User> getListContributor() {
		return listContributor;
	}

	/**
	 * @param listContributor
	 */
	public void setListContributor(List<User> listContributor) {
		this.listContributor = listContributor;
	}


	/**
	 * @return une liste de responsables d'activités 
	 * @throws SQLException 
	 */
	public abstract ListContributor load() throws SQLException;
	
}
