package com.LotuZ;


import java.sql.SQLException;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityManager;
import com.LotuZ.inscription.InscriptionManager;
import com.LotuZ.login.LoginManager;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.product.category.bl.CategoryManager;
import com.LotuZ.product.category.bl.CategoryProduct;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.activityLeader.bl.ActivityLeaderManager;
import com.LotuZ.user.activityLeader.bl.ListActivityLeader;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.contributor.bl.ContributorManager;
import com.LotuZ.user.contributor.bl.ListContributor;
import com.LotuZ.user.user.bl.User;

public class FacadeBL {
	
	private static LoginManager loginManager;
	private static InscriptionManager inscriptionManager;
	private static ActivityManager activityManager;
	private static ActivityLeaderManager activityLeaderManager;
	private static ContributorManager contributorManager;
	private static CategoryManager categoryManager;
	

	
	public static void init(PersistKit kit){
		loginManager = new LoginManager(kit);
		inscriptionManager = new InscriptionManager(kit);
		activityManager = new ActivityManager(kit);
		activityLeaderManager = new ActivityLeaderManager(kit);
		contributorManager = new ContributorManager(kit);
		categoryManager = new CategoryManager(kit);
	}
	
	// (^.^(*************************************Loic Start*************************************)^.^)
	
	//Category

	public static  ListCategoryProduct getAllCategories() 
	{
		return categoryManager.getAllCategories();
	}
	
	public static  ListCategoryProduct getCategories() 
	{
		return categoryManager.getCategories();
	}



public static  CategoryProduct getCategory(int idCategory) 
{
	return categoryManager.getCategory(idCategory);
}

public static  void createCategory(int idCategory, String nameCategory, String descriptionCategory, int levelCategory, int fatherCategory) 
{
	categoryManager.createCategory(idCategory, nameCategory, descriptionCategory, levelCategory, fatherCategory);
}

public static  void updateCategory(int idCategory, String nameCategory, String descriptionCategory, int levelCategory, int fatherCategory) 
{
	categoryManager.updateCategory(idCategory, nameCategory, descriptionCategory, levelCategory, fatherCategory);
}

public static  void deleteCategory(int idCategory) 
{
	System.out.println("FBL");
	categoryManager.deleteCategory(idCategory);
}

// )^.^)*************************************Loic End*************************************(^.^(
	
	public static void inscription(String lastName, String firstName, String adress,
			String phone, String street, String houseNumber, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException{
		inscriptionManager.inscription(lastName, firstName, adress, phone, street, houseNumber, city, postCode, password);
	}
	
	public static void loginUser(String mail, String password) throws SQLException, UserNotFoundException{
		loginManager.loginUser(mail,password);
	}	

	public  List<Activity> getActivities() {
		return activityManager.getActivities();
	}
	
	public static ActivityLeader getActivityLeader(String idActivityLeader) throws SQLException, UserNotFoundException{
		return activityLeaderManager.getActivityLeader(idActivityLeader);
	}
	

	
	public static ListActivityLeader getActivityLeaders() throws SQLException, UserNotFoundException{
		return activityLeaderManager.getActivityLeaders();
	}

	public static void createActivity(String name, String shortDescr, String longDescr) throws ClassNotFoundException, SQLException {
		activityManager.create(name, shortDescr, longDescr);

		
	}

	public static Activity readActivity(String name) throws SQLException {
		Activity acti = activityManager.read(name);
		return acti;
		
	}

	public static Activity readActivity(int i) throws SQLException {
		Activity acti = activityManager.read(i);
		return acti;
	}

	public static Activity updateActivity(Activity acti, String name, String shortDescr,
			String longDescr, String idRespo) throws SQLException {	
		Activity activity = activityManager.update(acti,name,shortDescr,longDescr,idRespo);
		return activity;	
	}
	
	public static Contributor getContributor(String idContributor) throws SQLException, UserNotFoundException{
		return contributorManager.getContributor(idContributor);
	}
	

	
	public static ListContributor getContributors() throws SQLException, UserNotFoundException{
		return contributorManager.getContributors();
	}
}