package com.LotuZ.event;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionJdbc;

//import com.mysql.jdbc.Statement;

public class EventJdbc extends Event{
	
	private Connection cn;
	

	/**
	 * @param cn
	 */
	public EventJdbc(Connection cn) {
		super();
		this.cn = cn;
	}

	/**
	 * 
	 */
	public EventJdbc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param description
	 * @param nbParticipant
	 * @param date
	 * @param heureDeb
	 * @param heureFin
	 * @param repetition
	 * @param price
	 * @throws SQLException 
	 */
	/*
	public EventJdbc(String name, String description, int nbParticipant,
			Date date, String heureDeb, String heureFin, int repetition,
			double price) {
		super(name, description, nbParticipant, date, heureDeb, heureFin, repetition,
				price);
		// TODO Auto-generated constructor stub
	}
	*/

	@Override
	public void save() throws SQLException {
		// TODO Auto-generated method stub
		
				Statement st =null;
				// Etape 3 : Création d'un statement
				st = this.cn.createStatement();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(this.getDate());
				String sql = "INSERT INTO `LotuZ`.`Event` (`name`, `nbParticipant`, `startingTime`, `finishingTime`, `date`, `repetition`, `activity`, `contributor`, `room`, `price`, `description`)"+
						"VALUES ('"+ this.getName() +"','"+ this.getNbParticipant() +"','"+ this.getHeureDeb() +"','"+ this.getHeureFin() +"','"+ date +"','"+ this.getRepetition() +"','"+ this.getIdActivity() +"','"+ this.getIdContributor() +"','"+ this.getRoom() +"','"+ this.getPrice() +"','"+ this.getDescription() +"')";
				// Etape 4 : exécution requête
				st.executeUpdate(sql);

		}

	@Override
	public Event load(int idEvent) throws SQLException {
		Event event = null;
		Statement st =null;
		// Création d'un statement
		st = this.cn.createStatement();

		// Requête de sélection à partir de l'identifiant 
		String sql = "Select * From LotuZ.Event Where idEvent="+'"'+idEvent+'"';

		// Exécution de la requête
		ResultSet result = st.executeQuery(sql);

		// Récupération des données 
		while(result.next()){
			event = new EventJdbc();
			event.setIdEvent(idEvent);
			event.setName(result.getString("name"));
			event.setNbParticipant(result.getInt("nbParticipant"));
			event.setHeureDeb(result.getString("startingTime"));
			event.setHeureFin(result.getString("finishingTime"));
			event.setDate(result.getDate("date"));
			event.setRepetition(result.getInt("repetition"));
			event.setIdActivity(result.getInt("activity"));
			event.setIdContributor(result.getInt("contributor"));
			event.setRoom(result.getInt("room"));
			event.setPrice(result.getDouble("price"));
			event.setDescription(result.getString("description"));
			
		}
		return event;
	}

	@Override
	public void update() throws SQLException {
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		
		String sql = "UPDATE Event SET `name`='"+this.getName() +"',`nbParticipant`='"+ this.getNbParticipant()+"',`startingTime`='"+this.getHeureDeb()
				+"',`finishingTime`='"+this.getHeureFin()+"',`date`='"+this.getDate()+"',`repetition`='"+this.getRepetition()+"',`activity`='"+this.getIdActivity()+"',`contributor`='"+this.getIdContributor()+"',`room`='"+this.getRoom()+"',`price`='"+this.getPrice()+"',`description`='"+this.getDescription()+"' Where `idEvent`='"+this.getIdEvent()+"'";
		// Etape 4 : exécution requête
		System.out.println("Dans le Jdbc :" + this.getName());
		System.out.println("Dans le Jdbc :" + this.getIdEvent());
		st.executeUpdate(sql);
		
	}

	@Override
	public void delete() throws SQLException {
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();

		String sql = "Delete From LotuZ.Event Where idEvent = '"+ this.getIdEvent() +"'";

		// Etape 4 : exécution requête
		st.executeUpdate(sql);
		
	}

	@Override
	public List<Event> loadAll(int idActivity) throws SQLException {		
		List<Event> events = new ArrayList();
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "Select * From LotuZ.Event e,LotuZ.Activity a where e.activity = a.idActivity and a.idActivity ='"+idActivity+"'";
		// Etape 4 : exécution requête
		//st.executeUpdate(sql);
		ResultSet result = st.executeQuery(sql);
		while( result.next() ){	
			//`name`, `nbParticipant`, `startingTime`, `finishingTime`, `date`, `repetition`, `activity`, `contributor`, `room`, `price`, `description`)
			Event event = new EventJdbc();
			int id = result.getInt("idEvent");
			String name = result.getString("name");
			event.setIdEvent(result.getInt("idEvent"));
			event.setName( result.getString("name"));
			event.setNbParticipant(result.getInt("nbParticipant"));
			event.setHeureDeb(result.getString("startingTime"));
			event.setHeureFin(result.getString("finishingTime"));
			event.setDate(result.getDate("date"));
			event.setRepetition(result.getInt("repetition"));
			event.setIdActivity(result.getInt("activity"));
			event.setIdContributor(result.getInt("contributor"));
			event.setRoom(result.getInt("room"));
			event.setPrice(result.getDouble("price"));
			event.setDescription(result.getString("description"));
			
			event.setName(name);

			events.add(event);
		}
		return events;
	}
	
	@Override
	public List<Event> loadEventsContributor(int idContributor) throws SQLException {		
		List<Event> events = new ArrayList();
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "Select * From LotuZ.Event where contributor ='"+idContributor+"'";
		// Etape 4 : exécution requête

		ResultSet result = st.executeQuery(sql);
		while( result.next() ){	
			//`name`, `nbParticipant`, `startingTime`, `finishingTime`, `date`, `repetition`, `activity`, `contributor`, `room`, `price`, `description`)
			Event event = new EventJdbc();
			int id = result.getInt("idEvent");
			String name = result.getString("name");
			event.setIdEvent(result.getInt("idEvent"));
			event.setName( result.getString("name"));
			event.setNbParticipant(result.getInt("nbParticipant"));
			event.setHeureDeb(result.getString("startingTime"));
			event.setHeureFin(result.getString("finishingTime"));
			event.setDate(result.getDate("date"));
			event.setRepetition(result.getInt("repetition"));
			event.setIdActivity(result.getInt("activity"));
			event.setIdContributor(result.getInt("contributor"));
			event.setRoom(result.getInt("room"));
			event.setPrice(result.getDouble("price"));
			event.setDescription(result.getString("description"));
			
			event.setName(name);

			events.add(event);
		}
		return events;
	}

}
