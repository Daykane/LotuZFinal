package com.LotuZ.notification.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.notification.bl.Notification;

/**
 * <b> NotificationJDBC est la classe représentant les notifications dans le système via JDBC. </b>
 * <p> 
 * Les attributs de la classe NotificationJDBC sont:
 * <ul>
 * <li> idNotification </li> 
 * <li> textNotification </li> 
 * <li> objetNotification </li> 
 * </ul>
 * </p>
 * 
 * @see Notification
 * 
 * @author Loïc
 * @version 1.0
 */


public class NotificationJDBC extends Notification {

	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	public NotificationJDBC(int idNotification, String textNotification,String objetNotification) 
		{
		super(idNotification, textNotification, objetNotification);
		}
	
	public NotificationJDBC(Connection cn) 
	{
		this.cn = cn;
	}

	//Load
	public Notification load(int idNotification) throws SQLException {			
			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te de s�lection � partir de l'identifiant 
			String sql = "Select * From LotuZ.Notification where idNotification="+idNotification;
			System.out.println(sql);
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while(result.next()){	
				this.setIdNotification(result.getInt("idNotification"));
				this.setTextNotification(result.getString("textNotification"));
				this.setObjetNotification(result.getString("objectNotification"));
			}
		return this;
	}

	//Update
	public void update(int idNotification, String textNotification,String objetNotification) throws SQLException 
	{
		Statement st =null;
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Update LotuZ.Notification Set textNotification='"+textNotification+"', objetNotification='"+objetNotification+"' Where idCategory="+idNotification;
		System.out.println(sql);
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		
	}

	//Save
	public void save() throws SQLException 
	{

			Statement st =null;
			
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Requ�te d insertion � partir de l'identifiant 
			String sql = "INSERT INTO LotuZ.Notification (textNotification,objetNotification) VALUES "
					+ "("
					+this.getTextNotification()+","
					+this.getObjetNotification()+")";
			System.out.println(sql);
			// Ex�cution de la requ�te
			st.executeQuery(sql);
		
	}

	
	public void save(String textNotification, String objetNotification) throws SQLException 
	{

		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant 
		String sql = "INSERT INTO LotuZ.Notification (textNotification,objetNotification) VALUES  "
				+ "("
				+this.getIdNotification()+","
				+'"'+textNotification+'"'+","
				+'"'+objetNotification+'"'+")";
		System.out.println(sql);
		// Ex�cution de la requ�te
		st.executeQuery(sql);
		
	}

	//Delete
	public void delete(int idNotification) throws SQLException 
	{
		
		Statement st =null;
		
		// Creation d'un statement
		st = this.cn.createStatement();
		
		// Requete de suppression a partir de l'identifiant 
		String sql = "Delete From LotuZ.Notification where idNotification="+idNotification;	// pour réaliser un suppression il faut utiliser "executeUpdate" et non pas executeQuery " 	
		System.out.println(sql);
		// Execution de la requete
		st.executeUpdate(sql);
		
	}

}