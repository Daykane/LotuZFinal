package com.LotuZ.event.repetition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexis
 *
 */
public class RepetitionJdbc extends Repetition {

	private Connection cn;

	public RepetitionJdbc(String name) {
		super(name);
	}

	public RepetitionJdbc(String name,int id) {
		super(name,id);
	}


	/**
	 * init the repetition with the connexion for the base
	 * @param cn : the Connexion
	 */
	public RepetitionJdbc(Connection cn) {
		super();
		this.cn = cn;
	}

	public RepetitionJdbc() {
		super();
	}


	/**
	 * @return the connexion
	 */
	public Connection getCn() {
		return cn;
	}

	/**
	 * @param cn the connexion to set
	 */
	public void setCn(Connection cn) {
		this.cn = cn;
	}

	@Override
	public void save() throws SQLException, ClassNotFoundException {
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "INSERT INTO `LotuZ`.`Repetition` (`name`) VALUES ('"+this.getName()+"')";	
		// Etape 4 : exécution requête
		st.executeUpdate(sql);

	}


	@Override
	public void delete() throws ClassNotFoundException, SQLException {
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();

		String sql = "Delete From LotuZ.Repetition Where idRepetition = '"+ this.getIdRepetition() +"'";

		// Etape 4 : exécution requête
		st.executeUpdate(sql);

	}
	@Override
	public Repetition load(int idRepet) throws SQLException {
		Repetition repetition = null;
		Statement st =null;
		// Création d'un statement
		st = this.cn.createStatement();

		// Requête de sélection à partir de l'identifiant 
		String sql = "Select * From LotuZ.Repetition Where idRepetition="+'"'+idRepet+'"';

		// Exécution de la requête
		ResultSet result = st.executeQuery(sql);

		// Récupération des données 
		while(result.next()){
			repetition = new RepetitionJdbc();
			repetition.setIdRepetition(result.getInt("idRepetition"));
			repetition.setName(result.getString("name"));
		}
		return repetition;
	}

	@Override
	public Repetition load(String name) throws SQLException {
		Repetition repetition = null;
		Statement st =null;
		// Création d'un statement
		st = this.cn.createStatement();

		// Requête de sélection à partir du nom
		String sql = "Select * From LotuZ.Repetition Where name="+'"'+name+'"';

		// Exécution de la requête
		ResultSet result = st.executeQuery(sql);

		// Récupération des données 
		while(result.next()){
			repetition = new RepetitionJdbc();
			repetition.setIdRepetition(result.getInt("idRepetition"));
			repetition.setName(result.getString("name"));
		}
		return repetition;
	}


	@Override
	public void update() throws ClassNotFoundException, SQLException {
		Statement st =null;
		// Création d'un statement
		st = this.cn.createStatement();

		String sql = "UPDATE Repetition SET `name`='"+this.getName()+"' WHERE `idRepetition`='"+this.getIdRepetition()+"'";
		System.out.println(sql);
		st.executeUpdate(sql);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Repetition> loadAll() throws SQLException {
		@SuppressWarnings("rawtypes")
		List<Repetition> repetitions = new ArrayList();

		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "Select * From LotuZ.Repetition";
		// Etape 4 : exécution requête
		ResultSet result = st.executeQuery(sql);
		while( result.next() ){	
			Repetition repetition = null;
			String name = result.getString("name");
			int id = result.getInt("idRepetition");
			repetition = new RepetitionJdbc(name,id);

			repetitions.add(repetition);
		}
		return repetitions;
	}

}


