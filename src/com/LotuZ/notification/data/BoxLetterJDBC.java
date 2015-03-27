package com.LotuZ.notification.data;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.notification.bl.Notification;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.data.CatgeoryJdbc;
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

public class BoxLetterJDBC extends BoxLetter {


	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	public BoxLetterJDBC(int idBoxLetter, int idNotification, int idMember, int readNotification) 
		{
			super(idBoxLetter, idNotification, idMember, readNotification);
		}
	
	public BoxLetterJDBC(Connection cn) 
	{
		this.cn = cn;
	}

	public BoxLetterJDBC() {
		super();
	}

	public BoxLetter loadLetter(int idNotification,
			int idMember) throws SQLException {
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Select * From LotuZ.BoxLette where idNotification="+idNotification+" and idMember="+idMember;
		
		// Ex�cution de la requ�te
		ResultSet result = st.executeQuery(sql);
		
		// R�cup�ration des donn�es 
		while(result.next()){	
			this.setIdNotification(result.getInt("idNotification"));
			this.setIdBoxLetter(result.getInt("idBoxLetter"));
			this.setIdMember(result.getInt("idMember"));
			this.setReadNotification(result.getInt("readNotification"));
		}
	return this;
	}

	public ArrayList<BoxLetter> loadAllLetter(int idMember)
			throws SQLException {
		
		ArrayList<BoxLetter> allLetter = new ArrayList<BoxLetter>();
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Select * From LotuZ.BoxLette where idMember="+idMember;
		
		// Ex�cution de la requ�te
		ResultSet result = st.executeQuery(sql);
		
		// R�cup�ration des donn�es 
		while( result.next() ){	
			// Cr�ation et ajout d'un utilisateurs dans la liste 
			allLetter.add( map(result));
		}
	return allLetter;
	}
	
    /**
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private static BoxLetter map( ResultSet resultSet ) throws SQLException {
    	// On cr��e un utlisateur 
    	BoxLetter letter = new BoxLetterJDBC();
    	
    	// On lui ajoute ses attributs � partir des r�sultats de la requ�te
    	letter.setIdNotification(resultSet.getInt("idNotification"));
    	letter.setIdBoxLetter(resultSet.getInt("idBoxLetter"));
    	letter.setIdMember(resultSet.getInt("idMember"));
    	letter.setReadNotification(resultSet.getInt("readNotification"));
        return letter;
    }

	public void update(int idBoxLetter, int idNotification, int idMember,
			int readNotification) throws SQLException {
		System.out.println("cJDBC1");	
		Statement st =null;
		System.out.println("cJDBC1'");
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		System.out.println("cJDBC2");
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Update LotuZ.Notification Set readNotification="+readNotification+"Where idBoxLetter="+idBoxLetter+" and idNotification="+idNotification+" and idMember="+idMember;
		System.out.println("cJDBC3");
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		System.out.println("cJDBC4");
		
	}

	@Override
	public void save() throws SQLException {
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant 
		String sql = "INSERT INTO LotuZ.Category (idNotification,idMember,readNotification) VALUES "
				+ "("
				+this.getIdNotification()+","
				+this.getIdMember()+","
				+this.getReadNotification()+")";
		
		// Ex�cution de la requ�te
		st.executeQuery(sql);
		
	}

	@Override
	public void save(int idNotification, int idMember,
			int readNotification) throws SQLException {
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant 
		String sql = "INSERT INTO LotuZ.Category (idNotification,idMember,readNotification) VALUES "
				+ "("
				+idNotification+","
				+idMember+","
				+readNotification+")";
		
		// Ex�cution de la requ�te
		st.executeQuery(sql);
		
	}

	@Override
	public void delete(int idNotification, int idMember)
			throws SQLException {
		Statement st =null;
		
		// Creation d'un statement
		st = this.cn.createStatement();
		
		// Requete de suppression a partir de l'identifiant 
		String sql = "Delete From LotuZ.BoxLette where idNotification="+idNotification+" and idMember="+idMember;	// pour réaliser un suppression il faut utiliser "executeUpdate" et non pas executeQuery " 	
		System.out.println(sql);
		// Execution de la requete
		st.executeUpdate(sql);
		System.out.println("cJDBC3");
		
	}

}
