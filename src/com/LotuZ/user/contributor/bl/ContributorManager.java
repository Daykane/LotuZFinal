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
	 * @param contributor
	 * @return
	 * @throws SQLException
	 */
	public Contributor modifyContributor(Contributor contributor) throws SQLException {
		contributor.update();
		return contributor;
	}
	
	
	/**
	 * @return ListContributor
	 * @throws SQLException
	 */
	public ListContributor getContributors() throws SQLException {
		ListContributor users = pkit.createListContributor();
		return users.load();
	}


	/**
	 * @param idContributor
	 * @throws SQLException
	 */
	public void deleteContributor(String idContributor) throws SQLException {
		Contributor contributor = pkit.createContributor();
		contributor.delete(idContributor);
	}
}
