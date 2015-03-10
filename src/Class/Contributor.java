/**
 * 
 */
package Class;

import java.util.Vector;

/**
 * @author Alexis
 *
 */
public class Contributor {
	private Vector<Event> event;

	/**
	 * @param event
	 */
	public Contributor(Vector<Event> event) {
		super();
		this.event = event;
	}

	/**
	 * 
	 */
	public Contributor() {
		super();
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