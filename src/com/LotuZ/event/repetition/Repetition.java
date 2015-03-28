package com.LotuZ.event.repetition;

import java.sql.SQLException;
import java.util.List;

import com.LotuZ.user.user.bl.User;

public abstract class Repetition {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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

	public abstract void save() throws SQLException, ClassNotFoundException;

	public abstract Repetition load(int id) throws SQLException;
	
	public abstract Repetition load(String name) throws SQLException;
	
	public abstract void update() throws ClassNotFoundException, SQLException;
	
	public abstract void delete() throws ClassNotFoundException, SQLException;


	public abstract List<Repetition> loadAll() throws SQLException;

	

}
