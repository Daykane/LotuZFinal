package com.LotuZ.activity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.LotuZ.user.User;
import com.LotuZ.user.UserJDBC;
import com.LotuZ.user.UserLog;

public class ActivityJdbc extends Activity{
	
	private Connection cn;


	public ActivityJdbc(Connection cn) {
		this.cn = cn;
	}

	public ActivityJdbc(int idActivity, String name, String longDescription,
			String shortDescription, int activityLeader,
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
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();
			String sql = "Insert into Activity Values ('"+ 1 +"','" + this.getName() +"','"+ this.getLongDescr() +"','"+ this.getShortDescr() +"','"+ 1 +"','"+ this.getCreateDate() +"','"+ this.getMajDate() +"')";
			// Etape 4 : ex�cution requ�te
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
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.Activity Where name="+'"'+name+'"';
			// Etape 4 : ex�cution requ�te
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			while( result.next() ){	
				int idActivity = result.getInt("idActivity");
				//String name = result.getString("name");
				String longDescription = result.getString("longDescription");
				String shortDescription = result.getString("shortDescription");
				int activityLeader = result.getInt("activityLeader");
				String creationDate = result.getString("creationDate");
				String updateDate = result.getString("updateDate");
				
				
				activity = new ActivityJdbc(idActivity,name,longDescription,shortDescription,activityLeader,creationDate,updateDate);
			}
		} catch (SQLException e) {
			throw e;
		}
		return activity;
	}
	

}
