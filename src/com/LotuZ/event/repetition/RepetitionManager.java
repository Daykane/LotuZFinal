package com.LotuZ.event.repetition;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.PersistKit;
import com.LotuZ.activity.Activity;

public class RepetitionManager {
	
	private PersistKit pkit;
	
	public RepetitionManager(PersistKit kit) {
		this.pkit=kit;
	}

	public void createRepetition(String name) throws ClassNotFoundException, SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep.setName(name);
		rep.save();
		
	}

	public Repetition getRepetition(String name) throws SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep = rep.load(name);
		return rep;
		
		
	}

	public Repetition getRepetition(int idRep) throws SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep = rep.load(idRep);
		return rep;
	}

	public void updateRepetition(Repetition repetition, String name) throws ClassNotFoundException, SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep.setIdRepetition(repetition.getIdRepetition());
		rep.setName(name);
		rep.update();	
		
	}

	public void deleteRepetition(int idRep) throws ClassNotFoundException, SQLException {
		Repetition rep = this.pkit.createRepetition();
		rep.setIdRepetition(idRep);
		rep.delete();
		
	}

	public List<Repetition> getAllRepetion() throws SQLException {
		List<Repetition> lRep;
		Repetition repetition = pkit.createRepetition();
		lRep = repetition.loadAll();
		return lRep;
	}



	


}
