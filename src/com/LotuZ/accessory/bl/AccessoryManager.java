package com.LotuZ.accessory.bl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.LotuZ.PersistKit;

public class AccessoryManager 
{
	
	private PersistKit pkit;
	
	public AccessoryManager(PersistKit kit){
		this.pkit=kit;
	}

	public ArrayList<Accessory> getAllAccessory() {
		Accessory accessory = pkit.createAccessory();
		ArrayList<Accessory> accessories=null;
		try {
			accessories = accessory.loadAllAccessories();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return accessories;
	}


	public Accessory getAccessory(int idAccessory) 
	{
		Accessory accessory = pkit.createAccessory();
		try {
			accessory = accessory.load(idAccessory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accessory;
	}

	public void createAccessory(String nameAccessory,String descriptionAccessory) 
	{
		Accessory accessory = pkit.createAccessory();
		try {
			accessory.save(nameAccessory,descriptionAccessory);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void updateAccessory(int idAccessory, String nameAccessory,
			String descriptionAccessory) 
	{
		Accessory accessory = pkit.createAccessory();
		try 
		{
			accessory.update(idAccessory, nameAccessory,descriptionAccessory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
