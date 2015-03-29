package com.LotuZ.notification.bl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.LotuZ.product.category.bl.CategoryProduct;

/**
 * <b> Notification est la classe représentant les notfications dans le systeme. </b>
 * <p> 
 * Les attributs de la classe Notification sont:
 * <ul>
 * <li> idNotification </li> 
 * <li> textNotification </li> 
 * <li> objetNotification </li> 
 * </ul>
 * </p>
 * 
 * @see 
 * 
 * @author Loïc
 * @version 1.0
 */

public abstract class Notification 
{
	/**
	 * idNotification est l'indentifiant de la notification.
	 * Cet id n'est pas modifiable.
	 * Il est généré automatiquement lors de la création d'une nouvelle  notification dans le système.
	 * 
	 * @see setIdNotification(int idNotification)
	 * @see getIdNotification()
	 * @see CategoryProduct(int id, String name, int level, int father)
	 *  
	 */
	private int idNotification;
	
	/**
	 * nameCategory est le nom de la catégorie.
	 * Ce nom est modifiable.
	 * Ce nom est entrée par l'utilisateur du système lors de la création ou la modification d'une categorie.
	 * 
	 * @see setNameCategoryProduct(int idCategoryProduct)
	 * @see getNameCategoryProduct()
	 * @see CategoryProduct(int id, String name, int level, int father)
	 */
	private String textNotification;
	
	/**
	 * descriptionCategory est une courte description de la catégorie
	 * Cete description est modifiable.
	 * 
	 * @see setDescriptionCategoryProduct(int idCategoryProduct)
	 * @see getDescriptionCategoryProduct()
	 */
	private String objetNotification;
	
	// Get & Set

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public String getTextNotification() {
		return textNotification;
	}

	public void setTextNotification(String textNotification) {
		this.textNotification = textNotification;
	}

	public String getObjetNotification() {
		return objetNotification;
	}

	public void setObjetNotification(String objetNotification) {
		this.objetNotification = objetNotification;
	}
	
	//Constructeur

	public Notification() {
	}
	
	public Notification(int idNotification, String textNotification, String objetNotification)
	{
		this.idNotification = idNotification;
		this.textNotification = textNotification;
		this.objetNotification =objetNotification;
	}
	
	

	//Methodes
	
	//Load
	public abstract Notification load(int idNotification) throws SQLException;	
	
	//Update
	public abstract void update(int idNotification, String textNotification, String objetNotification) throws SQLException;
	
	//Save
	public abstract void save() throws SQLException;
	public abstract void save(String textNotification, String objetNotification) throws SQLException;
	
	//Delete
	public abstract void delete(int idNotification) throws SQLException;
	
	

}