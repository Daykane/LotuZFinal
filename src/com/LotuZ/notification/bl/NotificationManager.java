package com.LotuZ.notification.bl;

import java.sql.Date;
import java.util.ArrayList;

import com.LotuZ.PersistKit;



public class NotificationManager {
	
	PersistKit pkit;
	
	public NotificationManager(PersistKit kit){
		this.pkit=kit;
	}

	public Notification getNotification(int idNotification) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createBoxLetter(int idNotification, int idNotification2) {
		// TODO Auto-generated method stub
		
	}

	public void createNotification(String textNotification,
			String objectNotification) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<BoxLetter> getAllNotificationInBox(int idBoxLetter,
			int idMember) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateNotification(int idNotification, String textNotification,
			String objectNotification) {
		// TODO Auto-generated method stub
		
	}

	public void updateBoxLetter(int idBoxLetter, int idNotification,
			int idMember) {
		// TODO Auto-generated method stub
		
	}

	public void deleteNotificationInBox(int idCategory) {
		// TODO Auto-generated method stub
		
	}

	public void deleteNotificationInBox(int idNotification, int idMember) {
		// TODO Auto-generated method stub
		
	}

	public void deleteNotification(int idNotification) {
		// TODO Auto-generated method stub
		
	}

}
