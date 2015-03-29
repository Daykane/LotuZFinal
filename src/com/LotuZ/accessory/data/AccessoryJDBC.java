package com.LotuZ.accessory.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.room.bl.Room;
import com.LotuZ.room.data.RoomJDBC;

public class AccessoryJDBC extends Accessory 
{

	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	public AccessoryJDBC() 
	{
		super();
	}
	
	public AccessoryJDBC(Connection cn) 
	{
		this.cn = cn;
	}
	
	public AccessoryJDBC(int idAccessory, String nameAccessory,
			String descriptionAccessory) {
		super(idAccessory, nameAccessory, descriptionAccessory);
		// TODO Auto-generated constructor stub
	}



	public Accessory load(int idAccessory) throws SQLException {
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Select * From LotuZ.Accessory where idAccessory="+idAccessory;
		System.out.println(sql);
		// Ex�cution de la requ�te
		ResultSet result = st.executeQuery(sql);
		
		while(result.next()){	
			this.setIdAccesorry((result.getInt("idAccessory")));
			this.setNameAccessory((result.getString("name")));
			this.setDescriptionAccessory((result.getString("description")));
		}
	return this;
	}
	
	public ArrayList<Accessory> loadAllAccessories() throws SQLException 
	{
		ArrayList<Accessory> allAccessories = new ArrayList<Accessory>();
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Select * From LotuZ.Accessory ";
		System.out.println(sql);
		// Ex�cution de la requ�te
		ResultSet result = st.executeQuery(sql);
		
		// R�cup�ration des donn�es 
		while( result.next() ){	
			// Cr�ation et ajout d'un utilisateurs dans la liste 
			allAccessories.add( map(result));
		}
	return allAccessories;
	}
    /**
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private static Accessory map( ResultSet resultSet ) throws SQLException {
    	// On cr��e un utlisateur 
    	Accessory accessory = new AccessoryJDBC();
    	
    	// On lui ajoute ses attributs � partir des r�sultats de la requ�te
    	accessory.setIdAccesorry((resultSet.getInt("idAccessory")));
    	accessory.setNameAccessory((resultSet.getString("name")));
    	accessory.setDescriptionAccessory((resultSet.getString("description")));

        return accessory ;
    }

	public void update(int idAccessory, String nameAccessory,
			String descriptionAccessory) throws SQLException 
	{
		Statement st =null;
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Update LotuZ.Accessory Set name='"+nameAccessory+"' and description='"+descriptionAccessory+" Where idAccessory="+idAccessory;
		System.out.println(sql);
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		
	}

	public void save() throws SQLException {
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant
		String sql = "INSERT INTO LotuZ.Accessory (name,description) VALUES "
				+ "("
				+'"'+this.getNameAccessory()+'"'+","
				+'"'+this.getDescriptionAccessory()+'"'+")";
		System.out.println(sql);
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		
	}

	public void save(String nameAccessory, String descriptionAccessory) throws SQLException {
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant
		String sql = "INSERT INTO LotuZ.Accessory (name,description) VALUES"
				+ "("
				+'"'+nameAccessory+'"'+","
				+'"'+descriptionAccessory+'"'+")";
		System.out.println(sql);
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		System.out.println("Ok:"+sql);
	}

	public void delete(int idAccessory) throws SQLException 
	{
		Statement st =null;
		
		// Creation d'un statement
		st = this.cn.createStatement();
		
		// Requete de suppression a partir de l'identifiant 
		String sql = "Delete From LotuZ.Accessory where idAccessory="+idAccessory;
		System.out.println(sql);
		// Execution de la requete
		st.executeUpdate(sql);
		
		
	}

}
