package com.LotuZ.event.repetition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.user.user.bl.User;

public class RepetitionJdbc extends Repetition {
	
	private Connection cn;
	
	/**
	 * 
	 */
	public RepetitionJdbc(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param cn
	 */
	public RepetitionJdbc(Connection cn) {
		super();
		this.cn = cn;
	}

	public RepetitionJdbc() {
		super();
	}


	/**
	 * @return the cn
	 */
	public Connection getCn() {
		return cn;
	}

	/**
	 * @param cn the cn to set
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
		System.out.println(sql);
		
		// Etape 4 : exécution requête
		st.executeUpdate(sql);
		
	}

	@Override
	public Repetition load(int idActivity) throws SQLException {
		Repetition repetition = null;
		Statement st =null;
		// Création d'un statement
		st = this.cn.createStatement();
		
		// Requête de sélection à partir de l'identifiant 
		String sql = "Select * From LotuZ.Repetition r,LotuZ.Event e Where r.idRepetition = e.idRepetition and e.idRepetition is not null and e.idEvent="+'"'+idActivity+'"';
		
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
	
		// Requête de modification
		String sql = "UPDATE LotuZ.Event e, LotuZ.Repetition r SET `name`='"+this.getName()+"' Where e.idRepetition= r.idRepetition and `idRepetition`='"+this.getIdRepetition()+"'";
		
		// Exécution requête
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
	
	
	

}
