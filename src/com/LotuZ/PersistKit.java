package com.LotuZ;


import java.sql.Connection;




import java.sql.SQLException;
import java.util.List;

import com.LotuZ.EventInscription.EventInscription;
import com.LotuZ.activity.Activity;
import com.LotuZ.event.Event;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.notification.bl.Notification;
import com.LotuZ.product.Product;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;

public abstract class PersistKit {
	
	
	public abstract void openConnection(String url, String login, String passwd);
	public abstract void closeConnection(Connection cn);
	//public abstract User login(String mail, String passWordCrypt) throws SQLException;
	public abstract User createUser();
	//public abstract void createUserLog();
	public abstract void createUserLog(User user, Member member, ActivityLeader respo, Administrator admin, Contributor contrib) throws SQLException;
	public abstract Activity createActivity();
	public abstract Repetition createRepetition();
	public abstract Event createEvent();
	public abstract ActivityLeader createActivityLeader();
	public abstract Product createProduct();
	public abstract EventInscription createEventInscription();
	public abstract Contributor createContributor();
	public abstract Administrator createAdministrator();
	public abstract Member createMember();
	// *************************************Loic*************************************
	//Category
	public abstract ListCategoryProduct createListCategory();
	public abstract CategoryProduct createCategory();
	//Notification
	public abstract Notification createNotification();
	public abstract BoxLetter createBoxLetter();
	public abstract ListUser createListUser() ;
	
	// *************************************Loic*************************************
	}
