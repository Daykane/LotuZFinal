package com.LotuZ.accessory.bl;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * <b> Accessory est la classe représentant les accessoires dans le systeme. </b>
 * <p> 
 * Les attributs de la classe Accessory sont:
 * <ul>
 * <li> idAccesorry </li> 
 * <li> nameAccessory </li> 
 * <li> descriptionAccessory </li> 
 * </ul>
 * </p>
 * 
 * @see Room
 * 
 * @author Loïc
 * @version 1.0
 */

public abstract class Accessory 
{
	/**
	 * idAccesorry est l'indentifiant de l'accessoire.
	 * Cet id n'est pas modifiable.
	 * Il est généré automatiquement lors de la création d'un nouvelle  accessoire dans le système.
	 * 
	 * @see setIdNotification(int idNotification)
	 * @see getIdNotification()
	 * @see CategoryProduct(int id, String name, int level, int father)
	 *  
	 */
	private int idAccesorry;
	
	/**
	 * nameAccessory est le nom de l'accesoire.
	 * Ce nom est modifiable.
	 * Ce nom est entrée par l'utilisateur du système lors de la création ou la modification d'un accessoire.
	 * 
	 * @see setNameCategoryProduct(int idCategoryProduct)
	 * @see getNameCategoryProduct()
	 * @see CategoryProduct(int id, String name, int level, int father)
	 */
	private String nameAccessory;
	
	/**
	 * descriptionAccessory est une courte description de l'accesoire
	 * Cete description est modifiable.
	 * 
	 * @see setDescriptionCategoryProduct(int idCategoryProduct)
	 * @see getDescriptionCategoryProduct()
	 */
	private String descriptionAccessory;
	
	
	// Get & Set

	public int getIdAccesorry() {
		return idAccesorry;
	}

	public void setIdAccesorry(int idAccesorry) {
		this.idAccesorry = idAccesorry;
	}

	public String getNameAccessory() {
		return nameAccessory;
	}

	public void setNameAccessory(String nameAccessory) {
		this.nameAccessory = nameAccessory;
	}

	public String getDescriptionAccessory() {
		return descriptionAccessory;
	}

	public void setDescriptionAccessory(String descriptionAccessory) {
		this.descriptionAccessory = descriptionAccessory;
	}
	
	//Constructeur
	
	/**
	 * 
	 */
	public Accessory(int idAccessory, String nameAccessory, String descriptionAccessory) 
	{

		this.setIdAccesorry(idAccessory);
		this.setNameAccessory(nameAccessory);
		this.setDescriptionAccessory(descriptionAccessory);
		}
	
	//Methodes
	
	public Accessory() {
		// TODO Auto-generated constructor stub
	}

	//Load
	public abstract Accessory load(int idAccessory) throws SQLException;
	public abstract ArrayList<Accessory>  loadAllAccessories() throws SQLException;
	
	//Update
	public abstract void update(int idAccessory, String nameAccessory, String descriptionAccessory) throws SQLException;
	
	//Save
	public abstract void save() throws SQLException;
	public abstract void save(String nameAccessory, String descriptionAccessory) throws SQLException;
	
	//Delete
	public abstract void delete(int idAccessory) throws SQLException;

}
