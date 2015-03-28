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
	 * @return
	 * @throws SQLException
	 */
	public Contributor getContributor(String idContributor) throws SQLException {
		Contributor contributor = pkit.createContributor();
		contributor.load(idContributor);
		return contributor;
	}
	
	public Contributor getContributorEvents(int idContributor) throws SQLException {
		List<Event> listEvents = new ArrayList<Event>();
		FacadeEvent.getEventsContributor(idContributor);
		Contributor contributor = pkit.createContributor();
		contributor.setEvents(listEvents);
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
