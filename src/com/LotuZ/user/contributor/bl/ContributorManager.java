package com.LotuZ.user.contributor.bl;

import java.sql.SQLException;

import com.LotuZ.PersistKit;


/**
 * @author Ludo
 *
 */
public class ContributorManager {

	private PersistKit pkit;
	
	/**
	 * 
	 * @param kit
	 */
	public ContributorManager(PersistKit kit){
		this.pkit=kit;
	}
	
	/**
	 * @param idContributor
	 * @return
	 * @throws SQLException
	 */
	public Contributor getContributor(String idContributor) throws SQLException {
		Contributor contributor = pkit.createContributor();
		contributor.load(idContributor);
		return contributor;
	}
	
	
	


	/**
	 * @param idContributor
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void deleteContributor() throws SQLException, ClassNotFoundException {
		Contributor contributor = pkit.createContributor();
		contributor.delete();
	}
}
