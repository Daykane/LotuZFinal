package com.LotuZ;


import java.sql.Connection;




import java.util.List;

import com.LotuZ.activity.Activity;
import com.LotuZ.product.Product;
import com.LotuZ.user.User;
import com.LotuZ.user.activityLeader.ActivityLeader;
import com.LotuZ.user.activityLeader.ListActivityLeader;

public abstract class PersistKit {
	
	public abstract void openConnection(String url, String login, String passwd);
	public abstract void closeConnection(Connection cn);
	//public abstract User login(String mail, String passWordCrypt) throws SQLException;
	public abstract User createUser();
	public abstract void createUserLog();
	public abstract void createUserLog(User user);
	public abstract Activity createActivity();
	public abstract ListActivityLeader createListActivityLeader();
	public abstract ActivityLeader createActivityLeader();
	public abstract Product createProduct();
	}
