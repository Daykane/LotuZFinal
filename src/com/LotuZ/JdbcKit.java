package com.LotuZ;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;






import java.util.ArrayList;
import java.util.List;

import com.LotuZ.EventInscription.EventInscription;
import com.LotuZ.EventInscription.EventInscriptionJdbc;
import com.LotuZ.accessory.bl.Accessory;
import com.LotuZ.accessory.data.AccessoryJDBC;
import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityJdbc;
import com.LotuZ.event.Event;
import com.LotuZ.event.EventJdbc;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionJdbc;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.notification.bl.Notification;
import com.LotuZ.notification.data.BoxLetterJDBC;
import com.LotuZ.notification.data.NotificationJDBC;
import com.LotuZ.product.Product;
import com.LotuZ.product.ProductJDBC;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.product.category.data.CatgeoryJdbc;
import com.LotuZ.product.category.data.ListCategoryJDBC;
import com.LotuZ.room.bl.Room;
import com.LotuZ.room.data.RoomJDBC;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.activityLeader.data.ActivityLeaderJDBC;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.admin.data.AdministratorJDBC;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.contributor.data.ContributorJDBC;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.member.data.MemberJDBC;
import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.ListUserJDBC;
import com.LotuZ.user.user.data.UserJDBC;


/**
 * @author LotuZ
 *
 */
public class JdbcKit extends PersistKit{

	private Connection cn;
	
	//List of ConcretObjectJdbc
	private UserJDBC userJdbc;
	// *************************************Loic*************************************
	//Category
	private ListCategoryJDBC listCategoryJDBC;
	private CatgeoryJdbc categoryJDBC;
	
	//Notification
	private NotificationJDBC notificationJDBC;
	private BoxLetterJDBC boxLetterJDBC;
	
	//Room
	private RoomJDBC roomJDBC;
	
	//Accessory
	private AccessoryJDBC accessoryJDBC;
	// *************************************Loic*************************************
	
	
	public JdbcKit(String url, String login, String passwd){
		
		// Create concrete bjetc with the connection
		setUserJdbc(new UserJDBC(this.cn));
		//setActivityJdbc(new ActivityJdbc(this.cn));
		
	}
	
	
	
	
	public void openConnection(String url, String login, String passwd) {
			// Etape 1 : Chargement du driver
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			// Etape 2 : r�cup�ration de la connexion
				try {
					this.cn = DriverManager.getConnection(url, login, passwd);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

	public void closeConnection(Connection cn) {
		try {
			this.cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
		
	}
	
	@Override
	public User createUser() {
		return new UserJDBC(this.cn);
	}



	/*
	@Override
	public void createUserLog() {
		UserLog.init();
	}
	*/

	@Override
	public void createUserLog(User user, Member member, ActivityLeader respo,
			Administrator admin, Contributor contrib) throws SQLException {
		UserLog.init(user,member,respo,admin,contrib,this.cn);
		
	}
	/*
	public void createUserLog(User user) throws SQLException {
		UserLog.init(user,this.cn);

		
	}
	*/




	/**
	 * @return the userJdbc
	 */
	public UserJDBC getUserJdbc() {
		return userJdbc;
	}




	/**
	 * @param userJdbc the userJdbc to set
	 */
	public void setUserJdbc(UserJDBC userJdbc) {
		this.userJdbc = userJdbc;
	}




	// *************************************Loïc*************************************
	//Category
	public ListCategoryProduct createListCategory()
	{
		return new ListCategoryJDBC(this.cn);
		
	}
	
	public CategoryProduct createCategory() {

		return new CatgeoryJdbc(this.cn);
	}
	//Notif
	public Notification createNotification()
	{
		return new NotificationJDBC(this.cn);
		
	}
	
	public BoxLetter createBoxLetter() {

		return new BoxLetterJDBC(this.cn);
	}
	
	//Room
	public Room createRoom()
	{
		return new RoomJDBC(this.cn);
	}
	
	//Accessory
	public Accessory createAccessory()
	{
		return new AccessoryJDBC(this.cn);
	}
	
	
	
	// *************************************Loïc*************************************



	@Override
	public Activity createActivity() {
		return new ActivityJdbc(this.cn);
	}





	@Override
	public ActivityLeader createActivityLeader() {
		return new ActivityLeaderJDBC(this.cn);
	}




	@Override
	public Product createProduct() {
		return new ProductJDBC(this.cn);
	}




	@Override
	public ListUser createListUser() {
		return new ListUserJDBC(this.cn);
	}

	
	@Override
	public Contributor createContributor() {
		return new ContributorJDBC(this.cn);
	}




	@Override
	public Administrator createAdministrator() {
		return new AdministratorJDBC(this.cn);
	}




	@Override
	public Member createMember() {
		return new MemberJDBC(this.cn);
	}




	@Override
	public Repetition createRepetition() {
		return new RepetitionJdbc(this.cn);
	}




	@Override
	public Event createEvent() {
		return new EventJdbc(this.cn);
	}




	@Override
	public EventInscription createEventInscription() {
		return new EventInscriptionJdbc(this.cn);
	}








	

}
