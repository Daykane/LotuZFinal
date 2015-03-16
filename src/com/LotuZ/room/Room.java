/**
 * @author Alexis
 */

package com.LotuZ.room;

public abstract class Room {
	
	private String idRoom;
	private double surface;
	
	/**
	 * @param idRoom
	 * @param surface
	 */
	public Room(String idRoom, double surface) {
		super();
		this.idRoom = idRoom;
		this.surface = surface;
	}
	/**
	 * @return the idRoom
	 */
	public String getIdRoom() {
		return idRoom;
	}
	/**
	 * @param idRoom the idRoom to set
	 */
	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}
	/**
	 * @return the surface
	 */
	public double getSurface() {
		return surface;
	}
	/**
	 * @param surface the surface to set
	 */
	public void setSurface(double surface) {
		this.surface = surface;
	}	

}
