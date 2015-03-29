package com.LotuZ.event.repetition;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Alexis
 *
 */
public abstract class Repetition {
	
	@Override
	public String toString() {
		return name;
	}


	private int idRepetition;
	private String name;
	
	/**
	 * @param name
	 */
	public Repetition() {
		super();
	}	
	
	
	/**
	 * @param name
	 */
	public Repetition(String name) {
		super();
		this.name = name;
	}	
	
	public Repetition(String name,int id) {
		super();
		this.name = name;
		this.idRepetition = id;
	}	
	
	/**
	 * @return the idRepetition
	 */
	public int getIdRepetition() {
		return idRepetition;
	}


	/**
	 * @param idRepetition the idRepetition to set
	 */
	public void setIdRepetition(int idRepetition) {
		this.idRepetition = idRepetition;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Save repetition in base
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract void save() throws SQLException, ClassNotFoundException;

	/**
	 * @param id : identifier of repretition
	 * @throws SQLException
	 */
	public abstract Repetition load(int id) throws SQLException;
	
	/**
	 * @param name : Name of repetition like identifier
	 * @throws SQLException
	 */
	public abstract Repetition load(String name) throws SQLException;
	
	/**
	 * Update the Repetition in base
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public abstract void update() throws ClassNotFoundException, SQLException;
	
	/**
	 * delete repetition in the base
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public abstract void delete() throws ClassNotFoundException, SQLException;


	/**
	 * @return List of all repetition
	 * @throws SQLException
	 */
	public abstract List<Repetition> loadAll() throws SQLException;

	

}
