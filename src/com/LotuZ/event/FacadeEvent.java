package com.LotuZ.event;

import com.LotuZ.PersistKit;
import com.LotuZ.activity.ActivityManager;
import com.LotuZ.event.repetition.RepetitionManager;
import com.LotuZ.inscription.InscriptionManager;
import com.LotuZ.login.LoginManager;
import com.LotuZ.user.activityLeader.bl.ActivityLeaderManager;


public class FacadeEvent {
	
	private static EventManager eventManager;
	private static RepetitionManager repetitionManager;
	
	public static void init(PersistKit kit){
		eventManager = new EventManager(kit);
		repetitionManager = new RepetitionManager(kit);
	}

	public static void createRepetition(String name) {
		repetitionManager.createRepetition(name);
		
	}

}
