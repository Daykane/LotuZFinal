package com.LotuZ.notification.bl;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <b> BoxLetter est la classe représentant les notifications des utlisateurs dans le système. </b>
 * <p> 
 * Les attributs de la classe BoxLetter sont:
 * <ul>
 * <li> idBoxLetter </li> 
 * <li> idNotification </li> 
 * <li> idMember </li> 
 * </ul>
 * </p>
 * 
 * @see Notification
 * 
 * @author Loïc
 * @version 1.0
 */

public abstract class BoxLetter 
{
	/**
	 * idBoxLetter est l identifiant de la boite de reception des notifications des utilisateurs.
	 * Cet id n'est pas modifiable.
	 * Il est généré automatiquement lors de la création d'une nouvelle  boite aux notifications dans le système.
	 * 
	 * @see setIdBoxLetter(int idBoxLetter)
	 * @see getIdBoxLetter()
	 * @see BoxLetter(int idBoxLetter, int idNotification, int idMember)
	 *  
	 */
	private int idBoxLetter;
	
	/**
	 * idNotification permet d identifier les notifications dans le système
	 * Cet id est non modifiable.
	 * Il est généré automatiquement lors de la création d'une nouvelle notification dans le système.
	 * 
	 * @see setIdNotification(int idNotification)
	 * @see getIdNotificationProduct()
	 * @see BoxLetter(int idBoxLetter, int idNotification, int idMember)
	 * @see Notification
	 */
	private int idNotification;
	
	/**
	 * idMember permet d identifier le proprietaire de la boite aux notifications
	 * Cet id est non modifiable.
	 * Il est genere automatiquement lors de la création d'une nouvelle notification dans le système.
	 * 
	 * @see setIdMember(int idMember)
	 * @see getIdMember()
	 * @see BoxLetter(int idBoxLetter, int idNotification, int idMember)
	 * @see Member
	 */
	private int idMember;

	/**
	 * dateReceived permet de savoir la date à laquelle la notification a été envoyé
	 */
	private String dateReceived;
	
	/**
	 * readNotification permet de savoir si un notification a deja ete lu par son proprietaire
	 * Lorsque la notification est non lu, readNotification == 0, dans le cas contraire readNotification ==1
	 * r
	 */
	private int readNotification;
	
	//Get & Set

	/**
	 * @return
	 */
	public int getIdBoxLetter() {
		return idBoxLetter;
	}

	public void setIdBoxLetter(int idBoxLetter) {
		this.idBoxLetter = idBoxLetter;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	
	public String getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	
	public int getReadNotification() {
		return readNotification;
	}

	public void setReadNotification(int readNotification) {
		this.readNotification = readNotification;
	}
	
	//Constructeur
	
	protected BoxLetter(int idBoxLetter, int idNotification, int idMember, int readNotification)
	{
		this.idBoxLetter = idBoxLetter;
		this.idNotification = idNotification;
		this.idMember = idMember;
		this.readNotification = readNotification;
	}
	
	protected BoxLetter(){}
	
	//Methodes
	
	//Load
	public abstract BoxLetter loadLetter(int idNotification, int idMember) throws SQLException;
	public abstract ArrayList<BoxLetter> loadAllLetter(int idMember) throws SQLException;
	
	//Update
	public abstract void update(int idBoxLetter, int idNotification, int idMember, int readNotification) throws SQLException;
	
	//Save
	public abstract void save() throws SQLException;
	public abstract void save(int idNotification, int idMember, String dateReceived, int readNotification) throws SQLException;
	
	//Delete
	public abstract void delete(int idNotification, int idMember) throws SQLException;


	
}