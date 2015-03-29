package com.LotuZ.event.repetition;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;

public class RepetitionManager {
	
	private PersistKit pkit;
	
	/**
	 * init the RepetitonManager with the persistance kit to use
	 * @param kit the persistance kit
	 */
	public RepetitionManager(PersistKit kit) {
		this.pkit=kit;
	}

	/**
	 * Create and save the Repetition
	 * @param name : repetition name
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void createRepetition(String name) throws ClassNotFoundException, SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep.setName(name);
		rep.save();
		
	}

	/**
	 * @param name : repetition name
	 * @return Repetiton from the base
	 * @throws SQLException
	 */
	public Repetition getRepetition(String name) throws SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep = rep.load(name);
		return rep;
		
		
	}
	/**
	 * @param idRep : repetition identifier
	 * @return Repetiton from the base
	 * @throws SQLException
	 */
	public Repetition getRepetition(int idRep) throws SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep = rep.load(idRep);
		return rep;
	}

	/**
	 * Update the repetiton in param with the other param
	 * @param repetition : Repetition
	 * @param name : new name
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateRepetition(Repetition repetition, String name) throws ClassNotFoundException, SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep.setIdRepetition(repetition.getIdRepetition());
		rep.setName(name);
		rep.update();	
		
	}

	/**
	 * Delete in base the Repetition with identifier in param
	 * @param idRep : Repetition identifier
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleteRepetition(int idRep) throws ClassNotFoundException, SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep.setIdRepetition(idRep);
		rep.delete();
		
	}

	/**
	 * @return All repetition from the Base
	 * @throws SQLException
	 */
	public List<Repetition> getAllRepetion() throws SQLException {
		List<Repetition> lRep;
		Repetition repetition = pkit.createRepetition();
		lRep = repetition.loadAll();
		return lRep;
	}



	


}
