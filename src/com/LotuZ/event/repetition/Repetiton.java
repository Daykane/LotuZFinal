package com.LotuZ.event.repetition;

public abstract class Repetiton {
	

	private int IdActivity;
	private String name;
	
	/**
	 * @param name
	 */
	public Repetiton(String name) {
		super();
		this.name = name;
	}	
	
	/**
	 * @return the idActivity
	 */
	public int getIdActivity() {
		return IdActivity;
	}
	/**
	 * @param idActivity the idActivity to set
	 */
	public void setIdActivity(int idActivity) {
		IdActivity = idActivity;
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


}
