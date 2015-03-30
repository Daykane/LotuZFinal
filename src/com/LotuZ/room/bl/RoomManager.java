package com.LotuZ.room.bl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.LotuZ.PersistKit;
import com.LotuZ.accessory.bl.Accessory;

public class RoomManager 
{
	private PersistKit pkit;
	
	public RoomManager(PersistKit kit){
		this.pkit=kit;
	}

	public ArrayList<Room> getAllRoom() {
		Room room = pkit.createRoom();
		ArrayList<Room> rooms=null;
		try {
			rooms = room.loadAllRoom();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public Room getRoom(int idRoom) {
		Room room = pkit.createRoom();
		try {
			room = room.load(idRoom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}
	
	public Room getRoom(String nameRoom) 
	{
		Room room = pkit.createRoom();
		try {
			room = room.load(nameRoom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}

	public void createRoom(String nameRoom, int surfaceRoom, int typeRoom,
			int nbMaxParticipant,ArrayList<Accessory> listAccessory) {
		Room room = pkit.createRoom();
		try {
			room.save(nameRoom, surfaceRoom, typeRoom,
					nbMaxParticipant,listAccessory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createRoom(String nameRoom, int surfaceRoom, int typeRoom,ArrayList<Accessory> listAccessory) 
	{
		Room room = pkit.createRoom();
		try {
			room.save(nameRoom, surfaceRoom, typeRoom,listAccessory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateRoom(int idRoom, String nameRoom, int surfaceRoom,
			int typeRoom, int nbMaxParticipant,ArrayList<Accessory> listAccessory) {
		Room room = pkit.createRoom();
		try {
			room.update(idRoom, nameRoom, surfaceRoom,
					typeRoom, nbMaxParticipant,listAccessory);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	public void updateRoom(int idRoom, String nameRoom, int surfaceRoom,
			int typeRoom, ArrayList<Accessory> listAccessory) {
		Room room = pkit.createRoom();
		try {
			room.update(idRoom, nameRoom, surfaceRoom,
					typeRoom, listAccessory);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	public void deleteRoom(int idRoom) 
	{
		Room room = pkit.createRoom();
		try {
			room.delete(idRoom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}
