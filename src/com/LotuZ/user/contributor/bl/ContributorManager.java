package com.LotuZ.user.contributor.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.event.Event;
import com.LotuZ.event.FacadeEvent;


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
	 * @return contributor
	 * @throws SQLException
	 */
	public Contributor getContributor(String idContributor) throws SQLException {
		Contributor contributor = pkit.createContributor();
		contributor = contributor.load(idContributor);
		return contributor;
	}
	
	
	
	/**
	 * get the events of a contributor
	 * @param idContributor
	 * @return contributor
	 * @throws SQLException
	 */
	public Contributor getContributorEvents(String idContributor) throws SQLException {
		List<Event> listEvents = new ArrayList<Event>();
		int idContrib = (Integer.parseInt(idContributor));
		listEvents = FacadeEvent.getEventsContributor(idContrib);
		Contributor contributor = pkit.createContributor();
		contributor.setEvents(listEvents);
		contributor.setIdContributor(idContributor);
		return contributor;
	}
	


	/**
	 * @param idContributor
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void deleteContributor(String idContributor) throws SQLException, ClassNotFoundException {
		Contributor contributor = pkit.createContributor();
		contributor.setIdContributor(idContributor);
		contributor.delete();
	}


}
