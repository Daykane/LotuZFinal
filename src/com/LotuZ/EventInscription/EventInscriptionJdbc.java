package com.LotuZ.EventInscription;

import java.sql.Connection;

public class EventInscriptionJdbc extends EventInscription {
	
	private Connection cn;
	
	public EventInscriptionJdbc(Connection cn) {
		super();
		this.cn = cn;
	}
	
	public EventInscriptionJdbc() {
		super();
	}
	
	

}
