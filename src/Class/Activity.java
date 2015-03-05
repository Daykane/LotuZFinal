/**
 * 
 * @author Alexis
 *
 */
package Class;

import java.util.Vector;

public class Activity {	
	
	private String name;
	private String shortDescr;
	private String longDescr;
	private Vector<Event> event;	

	public Activity() {
		super();
	}
	
	/**
	 * @param name
	 * @param shortDescr
	 * @param longDescr
	 * @param event
	 */
	public Activity(String name, String shortDescr, String longDescr,
			Vector<Event> event) {
		super();
		this.name = name;
		this.shortDescr = shortDescr;
		this.longDescr = longDescr;
		this.event = event;
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
	 * @return the shortDescr
	 */
	public String getShortDescr() {
		return shortDescr;
	}

	/**
	 * @param shortDescr the shortDescr to set
	 */
	public void setShortDescr(String shortDescr) {
		this.shortDescr = shortDescr;
	}

	/**
	 * @return the longDescr
	 */
	public String getLongDescr() {
		return longDescr;
	}

	/**
	 * @param longDescr the longDescr to set
	 */
	public void setLongDescr(String longDescr) {
		this.longDescr = longDescr;
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
