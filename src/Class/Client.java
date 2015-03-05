package Class;
/**
 * @author Alexis
 */

import java.util.Vector;

public class Client extends Member{

	private Vector<Event> event;

	


	/**
	 * @param event
	 */
	public Client(Vector<Event> event) {
		super();
		this.event = event;
	}

	/**
	 * 
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param streeName
	 * @param numHouse
	 * @param city
	 * @param postCode
	 * @param mail
	 */
	public Client(String lastName, String firstName, String streeName,
			String numHouse, String city, String postCode, String mail) {
		super(lastName, firstName, streeName, numHouse, city, postCode, mail);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the event
	 */
	public Vector<Event> getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Vector<Event> event) {
		this.event = event;
	}

}
