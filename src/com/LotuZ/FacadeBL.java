package com.LotuZ;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityManager;
import com.LotuZ.inscription.InscriptionManager;
import com.LotuZ.login.LoginManager;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.notification.bl.BoxLetter;
import com.LotuZ.notification.bl.Notification;
import com.LotuZ.notification.bl.NotificationManager;
import com.LotuZ.product.Product;
import com.LotuZ.product.ProductManager;
import com.LotuZ.product.category.bl.CategoryManager;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.activityLeader.bl.ActivityLeaderManager;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.contributor.bl.ContributorManager;
import com.LotuZ.user.user.bl.User;

public class FacadeBL {
	
	private static LoginManager loginManager;
	private static InscriptionManager inscriptionManager;
	private static ActivityManager activityManager;
	private static ActivityLeaderManager activityLeaderManager;
	private static ContributorManager contributorManager;
	private static CategoryManager categoryManager;
	private static NotificationManager notificationManager;
	private static ProductManager productManager;

	
	public static void init(PersistKit kit){
		loginManager = new LoginManager(kit);
		inscriptionManager = new InscriptionManager(kit);
		activityManager = new ActivityManager(kit);
		activityLeaderManager = new ActivityLeaderManager(kit);
		contributorManager = new ContributorManager(kit);
		categoryManager = new CategoryManager(kit);
		notificationManager = new NotificationManager(kit);
		productManager = new ProductManager(kit);
		//setProductManager(new ProductManager(kit));
		
	}
	
	// (^.^(*************************************Loic Start*************************************)^.^)
	
	//Category
	
//	public static int generateId() 
//	{
//		return categoryManager.generateId();
//	}

	public static  ListCategoryProduct getAllCategories() 
	{
		return categoryManager.getAllCategories();
	}
	
	public static  ListCategoryProduct getCategories() 
	{
		return categoryManager.getCategories();
	}
	
	
	public static ListCategoryProduct getSubCategories() 
	{
		return categoryManager.getSubCategories();
	}
	
	public static ListCategoryProduct getSubCategories(int idCategoryProduct) 
	{
		return categoryManager.getSubCategories(idCategoryProduct);
	}
	
	public static CategoryProduct getCategory(int idCategoryProduct) 
	{
		return categoryManager.getCategory(idCategoryProduct);
	}

	
	public static  void createCategory(String nameCategory, String descriptionCategory, int levelCategory, int fatherCategory) 
	{
		categoryManager.createCategory(nameCategory, descriptionCategory, levelCategory, fatherCategory);
	}
	
	public static  void updateCategory(int idCategory, String nameCategory, String descriptionCategory, int levelCategory, int fatherCategory) 
	{
		categoryManager.updateCategory(idCategory, nameCategory, descriptionCategory, levelCategory, fatherCategory);
	}
	
	public static  void deleteCategory(int idCategory) 
	{
		categoryManager.deleteCategory(idCategory);
	}
	
	//Notification
	
	public static  ArrayList<BoxLetter> getAllNotificationInBox(int idMember) 
	{
		System.out.println(idMember);
		System.out.println("FBL");
		return notificationManager.getAllNotificationInBox(idMember);
	}
	
	public static  Notification getNotification(int idNotification) 
	{
		return notificationManager.getNotification(idNotification);
	}
	
	public static  void createNotification(String textNotification, String objectNotification) 
	{
		notificationManager.createNotification(textNotification, objectNotification);
	}
	
	public static  void createBoxLetter(int idNotification, int idMember) 
	{
		notificationManager.createBoxLetter(idNotification, idMember);
	}
	
	public static  void updateNotification(int idNotification, String textNotification, String objectNotification) 
	{
		notificationManager.updateNotification(idNotification,textNotification, objectNotification);
	}
	
	public static  void updateBoxLetter(int idBoxLetter, int idNotification, int idMember, int readNotification) 
	{
		notificationManager.updateBoxLetter(idBoxLetter,idNotification, idMember, readNotification);
	}

	public static  void deleteNotificationInBox(int idNotification, int idMember) 
	{
		notificationManager.deleteNotificationInBox(idNotification, idMember);
	}

	public static  void deleteNotification(int idNotification) 
	{
		notificationManager.deleteNotification(idNotification);
	}
		
	
	// )^.^)*************************************Loic End*************************************(^.^(	
	public static void inscription(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException{
		inscriptionManager.inscription(lastName, firstName, adress, phone, street, houseNumber, city, postCode, password);
	}
	
	/*
	public static void product(int idMember,String productName, int price, int quantity, int category, int reduction) throws ClassNotFoundException, SQLException{
		productManager.createProduct(idMember,productName, price, quantity, category, reduction );
	}

	 */
	
	public static void product(String productName, int price, int quantity, int category, int reduction, String creationDate) throws ClassNotFoundException, SQLException{
		productManager.createProduct(productName, price, quantity, category, reduction, creationDate );
	}
	
	public static Product loadProduct(int idProduct) throws SQLException {
		Product product = productManager.readProduct(idProduct);
		return product;
	}
	
	public static void UpdateProduct(Product product, String productName, int category, int quantity, int price, int reduction, String updateDate) throws SQLException {
		productManager.updateProduct(product, productName, category, quantity, price, reduction, updateDate);
	}
	
	public static void loginUser(String mail, String password) throws SQLException, UserNotFoundException{
		loginManager.loginUser(mail,password);
	}	

	public  List<Activity> getActivities() throws SQLException {
		return activityManager.getActivities();
	}
	
	public static ActivityLeader getActivityLeader(String idActivityLeader) throws SQLException, UserNotFoundException{
		return activityLeaderManager.getActivityLeader(idActivityLeader);
	}
	


	public static void createActivity(String name, String idRespo, String shortDescr, String longDescr) throws ClassNotFoundException, SQLException {
		activityManager.create(name,idRespo, shortDescr, longDescr);

		
	}

	public static Activity readActivity(String name) throws SQLException {
		Activity acti = activityManager.read(name);
		return acti;
		
	}

	public static Activity readActivity(int i) throws SQLException {
		Activity acti = activityManager.read(i);
		return acti;
	}

	public static void updateActivity(Activity acti, String name, String shortDescr,
			String longDescr, String idRespo) throws SQLException {	
			activityManager.update(acti,name,shortDescr,longDescr,idRespo);	
	}
	
	public static Contributor getContributor(String idContributor) throws SQLException, UserNotFoundException{
		return contributorManager.getContributor(idContributor);
	}
	

	
	/**
	 * @return the productManager
	 */
	public static ProductManager getProductManager() {
		return productManager;
	}

	/**
	 * @param productManager the productManager to set
	 */
	public static void setProductManager(ProductManager productManager) {
		FacadeBL.productManager = productManager;
	}
	
	public static List<Product> getAllProducts(int idCategory) throws SQLException {
		return productManager.getAllProducts(idCategory);
	}
	
	public static void deleteProduct(int idProduct) throws SQLException {
		productManager.deleteProduct(idProduct);
	}



}