package com.LotuZ.event.repetition;

import com.LotuZ.PersistKit;

public class RepetitionManager {
	
	private PersistKit pkit;
	
	public RepetitionManager(PersistKit kit) {
		this.pkit=kit;
	}

	public void createRepetition(String name) {
		Repetition rep = this.pkit.createRepetition();
		
	}



}
