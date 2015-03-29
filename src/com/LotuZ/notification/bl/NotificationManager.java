package com.LotuZ.notification.bl;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.LotuZ.PersistKit;
import com.LotuZ.product.category.bl.ListCategoryProduct;



public class NotificationManager 
{
	
	PersistKit pkit;
	
	public NotificationManager(PersistKit kit){
		this.pkit=kit;
	}

	public Notification getNotification(int idNotification) 
	{
		Notification notification = pkit.createNotification();
		try {
			notification = notification.load(idNotification);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notification;
	}
	
	public ArrayList<BoxLetter> getAllNotificationInBox(int idMember) 
	{
		BoxLetter boxLetter = pkit.createBoxLetter();
		ArrayList<BoxLetter> boxLetterCenter=null;
		try {
			boxLetterCenter = boxLetter.loadAllLetter(idMember);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boxLetterCenter;
	}

	public void createBoxLetter(int idNotification, int idMember) 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		BoxLetter boxLetter = pkit.createBoxLetter();
		try {
			boxLetter.save(idNotification, idMember,dateFormat.format(cal.getTime()), 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void createNotification(String textNotification,
			String objectNotification) 
	{
		Notification notification = pkit.createNotification();
		try {
			notification.save(textNotification, objectNotification);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void updateNotification(int idNotification, String textNotification,
			String objectNotification) 
	{
		Notification notification = pkit.createNotification();
		try {
			notification.update(idNotification,textNotification, objectNotification);
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}

	public void updateBoxLetter(int idBoxLetter, int idNotification,
			int idMember, int readNotification) 
	{
		BoxLetter boxLetter = pkit.createBoxLetter();
		try {
			boxLetter.update(idBoxLetter, idNotification, idMember, readNotification);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteNotificationInBox(int idNotification, int idMember) 
	{
		BoxLetter boxLetter = pkit.createBoxLetter();
		try {
			boxLetter.delete(idNotification, idMember);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteNotification(int idNotification) 
	{
		Notification notification = pkit.createNotification();
	try {
		notification.delete(idNotification);
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}

}