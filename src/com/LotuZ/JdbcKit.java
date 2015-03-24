package com.LotuZ;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;






import java.util.ArrayList;
import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.activity.ActivityJdbc;
import com.LotuZ.product.Product;
import com.LotuZ.product.ProductJDBC;
import com.LotuZ.product.category.bl.ListCategoryProduct;
import com.LotuZ.product.category.data.ListCategoryJDBC;
import com.LotuZ.user.UserLog;
import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.activityLeader.bl.ListActivityLeader;
import com.LotuZ.user.activityLeader.data.ActivityLeaderJDBC;
import com.LotuZ.user.activityLeader.data.ListActivityLeaderJDBC;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.admin.data.AdministratorJDBC;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.contributor.bl.ListContributor;
import com.LotuZ.user.contributor.data.ContributorJDBC;
import com.LotuZ.user.contributor.data.ListContributorJDBC;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.member.data.MemberJDBC;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;


/**
 * @author LotuZ
 *
 */
public class JdbcKit extends PersistKit{

	private Connection cn;
	
	//List of ConcretObjectJdbc
	private UserJDBC userJdbc;
	private ContributorJDBC contribJdbc;
	private ActivityJdbc activityJdbc;
	// *************************************Loïc*************************************
	private ListCategoryJDBC listCategoryJDBC;
	// *************************************Loïc*************************************
	
	
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




	/**
	 * @return the activityJdbc
	 */
	public ActivityJdbc getActivityJdbc() {
		return activityJdbc;
	}




	/**
	 * @param activityJdbc the activityJdbc to set
	 */
	public void setActivityJdbc(ActivityJdbc activityJdbc) {
		this.activityJdbc = activityJdbc;
	}

	// *************************************Loïc*************************************
	public ListCategoryProduct createListCategory()
	{
		return new ListCategoryJDBC(this.cn);
		
	}
	
	// *************************************Loïc*************************************



	@Override
	public Activity createActivity() {
		return new ActivityJdbc(this.cn);
	}



	@Override
	public ListActivityLeader createListActivityLeader() {
		//List<User> userList = null;
		return new ListActivityLeaderJDBC(this.cn);
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
	public ListContributor createListContributor() {
		return new ListContributorJDBC(this.cn);
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




	

}
