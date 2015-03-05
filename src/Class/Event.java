/**
 * @author  Alexis
 */
package Class;

import java.sql.Date;

public class Event {
	
	
	private String name;
	private String description;
	private int nbParticipant;
	private Date date;
	private String heureDeb;
	private String heureFin;
	private Repetition repetition;
	private double price;
	private Room room;
	
	public Event() {
		super();
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
	 */
	public Event(String name, String description, int nbParticipant, Date date,
			String heureDeb, String heureFin, Repetition repetition,
			double price) {
		super();
		this.name = name;
		this.description = description;
		this.nbParticipant = nbParticipant;
		this.date = date;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.repetition = repetition;
		this.price = price;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the nbParticipant
	 */
	public int getNbParticipant() {
		return nbParticipant;
	}
	/**
	 * @param nbParticipant the nbParticipant to set
	 */
	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the heureDeb
	 */
	public String getHeureDeb() {
		return heureDeb;
	}
	/**
	 * @param heureDeb the heureDeb to set
	 */
	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}
	/**
	 * @return the heureFin
	 */
	public String getHeureFin() {
		return heureFin;
	}
	/**
	 * @param heureFin the heureFin to set
	 */
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	/**
	 * @return the repetition
	 */
	public Repetition getRepetition() {
		return repetition;
	}
	/**
	 * @param repetition the repetition to set
	 */
	public void setRepetition(Repetition repetition) {
		this.repetition = repetition;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	

}
