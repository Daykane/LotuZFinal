package com.LotuZ.activity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexis
 *
 */
public class ActivityJdbc extends Activity{

	private Connection cn;


	/**
	 * @return the cn, the connexion for the base
	 */
	public Connection getCn() {
		return cn;
	}

	/**
	 * @param cn the connexion to set
	 */
	public void setCn(Connection cn) {
		this.cn = cn;
	}

	/**
	 * Constructeur for the base connexion
	 * @param cn : Connexion
	 */
	public ActivityJdbc(Connection cn) {
		this.cn = cn;
	}

	public ActivityJdbc(int idActivity, String name, String longDescription,
			String shortDescription, String activityLeader,
			String creationDate, String updateDate) {
		this.setIdActivity(idActivity);
		this.setName(name);
		this.setLongDescr(longDescription);
		this.setShortDescr(shortDescription);
		this.setIdRespo(activityLeader);
		this.setCreateDate(creationDate);
		this.setMajDate(updateDate);

	}

	@Override
	public void save() throws SQLException, ClassNotFoundException {


		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "INSERT INTO Activity (`name`, `longDescription`, `shortDescription`, `activityLeader`, `creationDate`, `updateDate`)"
					+ " Values ('"+ this.getName() +"','"+ this.getLongDescr() +"','"+ this.getShortDescr() +"','"+ this.getIdRespo() +"','"+ this.getCreateDate() +"','"+ this.getMajDate() +"')";
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public Activity load(String name) throws SQLException {
		Activity activity = null;
		try {

			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.Activity Where name="+'"'+name+'"';
			
			// Etape 4 : exécution requête
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			int i = result.getInt("idActivity");
			this.load(i);
			//activity = getAndCreateActivity(result);
			//Aller chercher les event qui ont pour IdActivity le name

		} catch (SQLException e) {
			throw e;
		}
		return activity;
	}



	@Override
	public Activity load(int i) throws SQLException {
		ActivityJdbc activity = null;
		try {

			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.Activity Where idActivity="+'"'+i+'"';
			// Etape 4 : exécution requête
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			activity = (ActivityJdbc) getAndCreateActivity(result);
			//activity.setCn(this.cn);
		} catch (SQLException e) {
			throw e;
		}
		return activity;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Activity> loadAll() throws SQLException {
		@SuppressWarnings("unchecked")
		List<Activity> activities = new ArrayList();

			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.Activity";
			// Etape 4 : exécution requête
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			while( result.next() ){	
				ActivityJdbc activity = null;
				int idActivity = result.getInt("idActivity");
				String name = result.getString("name");
				String longDescription = result.getString("longDescription");
				String shortDescription = result.getString("shortDescription");
				String activityLeader = result.getString("activityLeader");
				String creationDate = result.getString("creationDate");
				String updateDate = result.getString("updateDate");


				activity = new ActivityJdbc(idActivity,name,longDescription,shortDescription,activityLeader,creationDate,updateDate);
				activities.add(activity);
			}
		return activities;
	}

	private static Activity getAndCreateActivity(ResultSet result) throws SQLException {
		ActivityJdbc activity = null;
		while( result.next() ){	
			int idActivity = result.getInt("idActivity");
			String name = result.getString("name");
			String longDescription = result.getString("longDescription");
			String shortDescription = result.getString("shortDescription");
			String activityLeader = result.getString("activityLeader");
			String creationDate = result.getString("creationDate");
			String updateDate = result.getString("updateDate");


			activity = new ActivityJdbc(idActivity,name,longDescription,shortDescription,activityLeader,creationDate,updateDate);
		}
		return activity;
	}

	@Override
	public void update() throws SQLException {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "UPDATE Activity SET `name`='"+this.getName() +"',`longDescription`='"+ this.getLongDescr() +"',`shortDescription`='"+this.getShortDescr()
					+"',`activityLeader`='"+this.getIdRespo()+"',`updateDate`='"+this.getMajDate()+"' Where `idActivity`='"+this.getIdActivity()+"'";
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			
	}

	@Override
	public void delete() throws SQLException {
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();

		//delete before event with the id activity
		String sql = "Delete From LotuZ.Event Where activity = '"+ this.getIdActivity() +"'";

		// Etape 4 : exécution requête
		st.executeUpdate(sql);
		
		sql = "Delete From LotuZ.Activity Where idActivity = '"+ this.getIdActivity() +"'";

		// Etape 4 : exécution requête
		st.executeUpdate(sql);

	}

	@Override
	public List<Activity> loadForRespo() throws SQLException {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Activity> activities = new ArrayList();

		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();
		String sql = "Select * From LotuZ.Activity a, LotuZ.User u where a.activityLeader = u.mail and activityLeader='"+this.getIdRespo()+"'";
		// Etape 4 : exécution requête
		//st.executeUpdate(sql);
		ResultSet result = st.executeQuery(sql);
		while( result.next() ){	
			ActivityJdbc activity = null;
			int idActivity = result.getInt("idActivity");
			String name = result.getString("name");
			String longDescription = result.getString("longDescription");
			String shortDescription = result.getString("shortDescription");
			String activityLeader = result.getString("activityLeader");
			String creationDate = result.getString("creationDate");
			String updateDate = result.getString("updateDate");


			activity = new ActivityJdbc(idActivity,name,longDescription,shortDescription,activityLeader,creationDate,updateDate);
			activities.add(activity);
		}
	return activities;
	}

	
}
