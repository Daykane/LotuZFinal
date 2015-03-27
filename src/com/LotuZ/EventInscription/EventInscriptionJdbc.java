package com.LotuZ.EventInscription;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionJdbc;

public class EventInscriptionJdbc extends EventInscription {
	
	private Connection cn;
	
	public EventInscriptionJdbc(Connection cn) {
		super();
		this.cn = cn;
	}
	
	public EventInscriptionJdbc() {
		super();
	}

	@Override
	public void add() throws SQLException {
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "INSERT INTO `LotuZ`.`InscriptionEvent` (`mail`, `idEvent`) VALUES ('"+ this.getIdMember() +"','"+ this.getIdEvent() +"')";
		// Etape 4 : exécution requête
		st.executeUpdate(sql);
		
	}

	@Override
	public List<Integer> loadUserEvent() throws SQLException {
		List<Integer> userEvent = new ArrayList();

		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "Select * From LotuZ.InscriptionEvent where mail= '"+ this.getIdMember()+"'";
		// Etape 4 : exécution requête
		//st.executeUpdate(sql);
		ResultSet result = st.executeQuery(sql);
		while( result.next() ){	
			int idEvent = result.getInt("idEvent");

			userEvent.add(idEvent);
		}
		return userEvent;
	}

	@Override
	public List<String> loadEventUser() throws SQLException {
		List<String> eventUser = new ArrayList();

		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "Select * From LotuZ.InscriptionEvent where idEvent= '"+ this.getIdEvent()+"'";
		// Etape 4 : exécution requête
		//st.executeUpdate(sql);
		ResultSet result = st.executeQuery(sql);
		while( result.next() ){	
			String idUser = result.getString("mail");

			eventUser.add(idUser);
		}
		return eventUser;
	}
	
	

}
