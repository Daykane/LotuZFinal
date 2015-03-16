/**
 * 
 */
package RespoActi;

import Admin.Room;

/**
 * @author Alexis
 *
 */
public class ClassRoom extends Room{
	
	private int nbParticipant;

	public ClassRoom(String idRoom, double surface, int nbParticipant) {
		super(idRoom, surface);
		this.nbParticipant = nbParticipant;
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

	

}
