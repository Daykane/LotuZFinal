/**
 * @author Alexis
 */

package com.LotuZ.room.bl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.notification.bl.Notification;

/**
 * <b> Room est la classe représentant les salles dans le systeme. </b>
 * <p>
 * Les attributs de la classe Room sont:
 * <ul>
 * <li>idRoom</li>
 * <li>nameRoom</li>
 * <li>surfaceRoom</li>
 * <li>typeRoom</li>
 * <li>nbMaxParticipant</li>
 * <li>listAccessory</li>
 * </ul>
 * </p>
 * 
 * @see
 * 
 * @author Loïc
 * @version 1.0
 */

public abstract class Room {
	/**
	 * idRoom est l'indentifiant de la salle. Cet id n'est pas modifiable. Il
	 * est généré automatiquement lors de l'ajout d'une nouvelle salle dans le
	 * système.
	 * 
	 * @see setIdNotification(int idNotification)
	 * @see getIdNotification()
	 * @see CategoryProduct(int id, String name, int level, int father)
	 * 
	 */
	private int idRoom;

	/**
	 * nameRoom est le nom de la salle. Ce nom est modifiable. Ce nom est entrée
	 * par l'utilisateur du système lors de l'ajout ou la modification d'une
	 * salle.
	 * 
	 * @see setNameCategoryProduct(int idCategoryProduct)
	 * @see getNameCategoryProduct()
	 * @see CategoryProduct(int id, String name, int level, int father)
	 */
	private String nameRoom;

	/**
	 * surfaceRoom représente la surface de la salle en m^2 Cette valeur est
	 * modifiable.
	 * 
	 * @see setDescriptionCategoryProduct(int idCategoryProduct)
	 * @see getDescriptionCategoryProduct()
	 */
	private int surfaceRoom;

	/**
	 * typeRoom représente le type de la salle cette valeur est modifiable
	 * 
	 * @see setDescriptionCategoryProduct(int idCategoryProduct)
	 * @see getDescriptionCategoryProduct()
	 */
	private int typeRoom;

	/**
	 * nbMaxParticipant indique la capacité maximal de la salle cette valeur est
	 * modifiable *
	 * <ul>
	 * <li>0 == SalleCour(nbMaxParticipant, superficie,accesoires)</li>
	 * <li>1 == Cabinet(superficie, accessoires)</li>
	 * </ul>
	 * 
	 * @see setDescriptionCategoryProduct(int idCategoryProduct)
	 * @see getDescriptionCategoryProduct()
	 */
	private int nbMaxParticipant;

	/**
	 * nbMaxParticipant indique la capacité maximal de la salle cette valeur est
	 * modifiable *
	 * <ul>
	 * <li>0 == SalleCour(nbMaxParticipant, superficie,accesoires)</li>
	 * <li>1 == Cabinet(superficie, accessoires)</li>
	 * </ul>
	 * 
	 * @see setDescriptionCategoryProduct(int idCategoryProduct)
	 * @see getDescriptionCategoryProduct()
	 */
	private ArrayList<Accessory> listAccessory;

	// Get & Set

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public String getNameRoom() {
		return nameRoom;
	}

	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}

	public int getSurfaceRoom() {
		return surfaceRoom;
	}

	public void setSurfaceRoom(int surfaceRoom) {
		this.surfaceRoom = surfaceRoom;
	}

	public int getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(int typeRoom) {
		this.typeRoom = typeRoom;
	}

	public int getNbMaxParticipant() {
		return nbMaxParticipant;
	}

	public void setNbMaxParticipant(int nbMaxParticipant) {
		this.nbMaxParticipant = nbMaxParticipant;
	}

	public ArrayList<Accessory> getListAccessory() {
		return listAccessory;
	}

	public void setListAccessory(ArrayList<Accessory> listAccessory) {
		this.listAccessory = listAccessory;
	}

	// Constructeur

	/**
	 * 
	 */
	public Room(int idRoom, String nameRoom, int surfaceRoom, int typeRoom,
			int nbMaxParticipant, ArrayList<Accessory> listAccessory) {
		this.setIdRoom(idRoom);
		this.setNameRoom(nameRoom);
		this.setSurfaceRoom(surfaceRoom);
		this.setTypeRoom(typeRoom);
		this.setNbMaxParticipant(nbMaxParticipant);
		this.setListAccessory(listAccessory);
	}

	// Methodes

	public Room() {
	}

	// Load
	public abstract Room load(int idRoom) throws SQLException;

	public abstract ArrayList<Room> loadAllRoom() throws SQLException;

	public abstract Room load(String nameRoom) throws SQLException;

	// Update
	public abstract void update(int idRoom, String nameRoom, int surfaceRoom,
			int typeRoom, int nbMaxParticipant,
			ArrayList<Accessory> listAccessory) throws SQLException;
	
	public abstract void update(int idRoom, String nameRoom, int surfaceRoom,
			int typeRoom, ArrayList<Accessory> listAccessory)throws SQLException;

	// Save
	public abstract void save() throws SQLException;

	public abstract void save(String nameRoom, int surfaceRoom, int typeRoom,
			ArrayList<Accessory> listAccessory) throws SQLException;

	public abstract void save(String nameRoom, int surfaceRoom, int typeRoom,
			int nbMaxParticipant, ArrayList<Accessory> listAccessory)
			throws SQLException;

	// Delete
	public abstract void delete(int idRoom) throws SQLException;



}
