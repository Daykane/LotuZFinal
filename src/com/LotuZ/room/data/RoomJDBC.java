package com.LotuZ.room.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.accessory.data.AccessoryJDBC;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.notification.data.BoxLetterJDBC;
import com.LotuZ.room.bl.Room;

public class RoomJDBC extends Room
{

	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	public RoomJDBC() {
		super();
	}
	public RoomJDBC(Connection cn) 
	{
		this.cn = cn;
	}
	
	public RoomJDBC(int idRoom, String nameRoom, int surfaceRoom, int typeRoom,
			int nbMaxParticipant, ArrayList<Accessory> listAccessory) {
		super(idRoom, nameRoom, surfaceRoom, typeRoom, nbMaxParticipant,listAccessory);
		// TODO Auto-generated constructor stub
	}

	

	public Room load(int idRoom) throws SQLException 
	{
		Statement st =null;
		
		ArrayList<Accessory> roomAccessory = new ArrayList<Accessory>();	
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Select * From LotuZ.Room where idRoom="+idRoom;
		// Ex�cution de la requ�te
		ResultSet result = st.executeQuery(sql);
		
		// R�cup�ration des donn�es 
		while(result.next()){	
			this.setIdRoom((result.getInt("idRoom")));
			this.setNameRoom((result.getString("name")));
			this.setSurfaceRoom((result.getInt("surface")));
			this.setTypeRoom(result.getInt("type"));
			if (result.getInt("type") == 0) //Si salle de cour
			{
				this.setNbMaxParticipant(result.getInt("nbMaxParticipant")); //Nombre de participant
			}
		}
		
		String sql1 = "Select * From LotuZ.AffectationAccessoryRoom where idRoom="+this.getIdRoom();
		ResultSet result1 = st.executeQuery(sql1);
		while( result1.next() )
		{	
			// Cr�ation et ajout d'un utilisateurs dans la liste 
			roomAccessory.add( mapAccessory(result1));
		}
		this.setListAccessory(roomAccessory);
	return this;
	}
	
	public Room load(String nameRoom) throws SQLException 
	{
		Statement st =null;
		ArrayList<Accessory> roomAccessory = new ArrayList<Accessory>();
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Select * From LotuZ.Room where name="+'"'+nameRoom+'"';
		// Ex�cution de la requ�te
		ResultSet result = st.executeQuery(sql);
		// R�cup�ration des donn�es 
		while(result.next()){	
			this.setIdRoom((result.getInt("idRoom")));
			this.setNameRoom((result.getString("name")));
			this.setSurfaceRoom((result.getInt("surface")));
			this.setTypeRoom(result.getInt("type"));
			if (result.getInt("type") == 0) //Si salle de cour
			{
				this.setNbMaxParticipant(result.getInt("nbMaxParticipant")); //Nombre de participant
			}
		}
		
		String sql1 = "Select LotuZ.Accessory.idAccessory,LotuZ.Accessory.name,LotuZ.Accessory.description From LotuZ.AffectationAccessoryRoom, LotuZ.Accessory where LotuZ.AffectationAccessoryRoom.idRoom="+this.getIdRoom()+" and LotuZ.AffectationAccessoryRoom.idAccessory=LotuZ.Accessory.idAccessory";
		ResultSet result1 = st.executeQuery(sql1);
		while( result1.next() )
		{	
			// Cr�ation et ajout d'un utilisateurs dans la liste 
			roomAccessory.add( mapAccessory(result1));
		}
		this.setListAccessory(roomAccessory);
		

	return this;
	}

	public ArrayList<Room> loadAllRoom() throws SQLException {
		ArrayList<Room> allRoom = new ArrayList<Room>();
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		// Requ�te de s�lection � partir de l'identifiant 
		String sql = "Select * From LotuZ.Room ";
		// Ex�cution de la requ�te
		ResultSet result = st.executeQuery(sql);
		// R�cup�ration des donn�es 
		while( result.next() ){	
			// Cr�ation et ajout d'un utilisateurs dans la liste 
			allRoom.add( mapRoom(result,this.cn));
		}
	return allRoom;
	}
	
    /**
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private static Room mapRoom( ResultSet resultSet , Connection cn ) throws SQLException {
    	// On cr��e un utlisateur 
    	Room room = new RoomJDBC();
    	
    	// On lui ajoute ses attributs � partir des r�sultats de la requ�te
    	room.setIdRoom((resultSet.getInt("idRoom")));
    	room.setNameRoom((resultSet.getString("name")));
    	room.setSurfaceRoom((resultSet.getInt("surface")));
    	room.setTypeRoom(resultSet.getInt("type"));
		if (resultSet.getInt("type") == 0) //Si salle de cour
		{
			room.setNbMaxParticipant(resultSet.getInt("nbMaxParticipant")); //Nombre de participant
		}
		
		String sql1 = "Select LotuZ.Accessory.idAccessory,LotuZ.Accessory.name,LotuZ.Accessory.description From LotuZ.AffectationAccessoryRoom, LotuZ.Accessory where LotuZ.AffectationAccessoryRoom.idRoom="+room.getIdRoom()+" and LotuZ.AffectationAccessoryRoom.idAccessory=LotuZ.Accessory.idAccessory";
		Statement st =null;
		ArrayList<Accessory> roomAccessory = new ArrayList<Accessory>();
		// Cr�ation d'un statement
		st = cn.createStatement();
		ResultSet result1 = st.executeQuery(sql1);
		while( result1.next() )
		{	
			// Cr�ation et ajout d'un utilisateurs dans la liste 
			roomAccessory.add( mapAccessory(result1));
		}
		room.setListAccessory(roomAccessory);
		
        return room;
    }
    
    private static Accessory mapAccessory( ResultSet resultSet ) throws SQLException {
    	// On cr��e un utlisateur 
    	Accessory accessory = new AccessoryJDBC();
    	// On lui ajoute ses attributs � partir des r�sultats de la requ�te
    	accessory.setIdAccesorry((resultSet.getInt("idAccessory")));
    	accessory.setNameAccessory((resultSet.getString("name")));
    	accessory.setDescriptionAccessory((resultSet.getString("description")));

        return accessory ;
    }
    
	public void update(int idRoom, String nameRoom, int surfaceRoom,
			int typeRoom, int nbMaxParticipant,ArrayList<Accessory> listAccessory ) throws SQLException {
		Statement st =null;
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te de s�lection � partir de l'identifiant
		String sql = "Update LotuZ.Room Set name='"+nameRoom+"' and surface="+surfaceRoom+" and type="+typeRoom+" and nbMaxParticipant="+nbMaxParticipant+" Where idBoxLetter="+idRoom;
		st.executeUpdate(sql);
		for (int i=0;i<listAccessory.size();i++)
		{
			String sql1 = "Insert Into LotuZ.AffectionAccessoryRoom (idAccessory,idRoom) values("+listAccessory.get(i).getIdAccesorry()+","+idRoom+")";
			st.executeUpdate(sql1);
		}
		
	}
	
	public void update(int idRoom, String nameRoom, int surfaceRoom,
			int typeRoom, ArrayList<Accessory> listAccessory)
			throws SQLException 
	{
		Statement st =null;
		// Cr�ation d'un statement
		st = this.cn.createStatement();		
		// Requ�te de s�lection � partir de l'identifiant
		String 	sql = "Update LotuZ.Room Set name='"+nameRoom+"' and surface="+surfaceRoom+" and type="+typeRoom+" Where idBoxLetter="+idRoom;
		st.executeUpdate(sql);
		for (int i=0;i<listAccessory.size();i++)
		{
			String sql1 = "Insert Into LotuZ.AffectionAccessoryRoom (idAccessory,idRoom) values("+listAccessory.get(i).getIdAccesorry()+","+idRoom+")";
			st.executeUpdate(sql1);
		}
		
	}

	public void save() throws SQLException 
	{
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant
		String sql;
		if (this.getTypeRoom() ==0)
		{
		sql = "INSERT INTO LotuZ.Room (name,surface,type,nbMaxParticipant) VALUES "
				+ "("
				+'"'+this.getNameRoom()+'"'+","
				+this.getSurfaceRoom()+","
				+this.getTypeRoom()+","
				+this.getNbMaxParticipant()+")";
		}
		else
		{
			sql = "INSERT INTO LotuZ.Room (name,surface,type) VALUES "
					+ "("
					+'"'+this.getNameRoom()+'"'+","
					+this.getSurfaceRoom()+","
					+this.getTypeRoom()+")";
		}
		
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		
		for (int i=0;i<this.getListAccessory().size();i++)
		{
			String sql1 = "Insert Into LotuZ.AffectationAccessoryRoom (idAccessory,idRoom) values("+this.getListAccessory().get(i).getIdAccesorry()+","+this.getIdRoom()+")";
			st.executeUpdate(sql1);
		}
		
		
	}

	public void save(String nameRoom, int surfaceRoom, int typeRoom,
			int nbMaxParticipant,ArrayList<Accessory> listAccessory ) throws SQLException {
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant
		String sql = "INSERT INTO LotuZ.Room (name,surface,type,nbMaxParticipant) VALUES "
				+ "("
				+'"'+nameRoom+'"'+","
				+surfaceRoom+","
				+typeRoom+","
				+nbMaxParticipant+")";
		
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		
		String sql2 = "Select idRoom from LotuZ.Room where name="+'"'+nameRoom+'"';
		ResultSet result =st.executeQuery(sql2);
		int idRoom=0;
		while(result.next()){	
			idRoom=(result.getInt("idRoom"));
		}
		
		for (int i=0;i<listAccessory.size();i++)
		{
			String sql1 = "Insert Into LotuZ.AffectationAccessoryRoom (idAccessory,idRoom) values("+listAccessory.get(i).getIdAccesorry()+","+idRoom+")";
			st.executeUpdate(sql1);
		}
		
	}
	
	public void save(String nameRoom, int surfaceRoom, int typeRoom, ArrayList<Accessory> listAccessory ) throws SQLException 
	{
		Statement st =null;
		
		// Cr�ation d'un statement
		st = this.cn.createStatement();
		
		// Requ�te d insertion � partir de l'identifiant
		String sql = "INSERT INTO LotuZ.Room (name,surface,type) VALUES "
					+ "("
					+'"'+nameRoom+'"'+","
					+surfaceRoom+","
					+typeRoom+")";
		// Ex�cution de la requ�te
		st.executeUpdate(sql);
		
		String sql2 = "Select idRoom from LotuZ.Room where name="+'"'+nameRoom+'"';
		ResultSet result =st.executeQuery(sql2);
		int idRoom=0;
		while(result.next()){	
			idRoom=(result.getInt("idRoom"));
		}
		
		for (int i=0;i<listAccessory.size();i++)
		{
			String sql1 = "Insert Into LotuZ.AffectationAccessoryRoom (idAccessory,idRoom) values("+listAccessory.get(i).getIdAccesorry()+","+idRoom+")";
			st.executeUpdate(sql1);
		}
		
	}

	public void delete(int idRoom) throws SQLException 
	{
		Statement st =null;
		
		// Creation d'un statement
		st = this.cn.createStatement();
		
		// Requete de suppression a partir de l'identifiant 
		String sql = "Delete From LotuZ.Room where idRoom="+idRoom;
		// Execution de la requete
		st.executeUpdate(sql);
		
	}

}
