package com.LotuZ.activity;

import java.sql.Connection;
import java.sql.SQLException;



import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.LotuZ.user.User;
import com.LotuZ.user.UserLog;

public class ActivityJdbc extends Activity{
	
	private Connection cn;


	public ActivityJdbc(Connection cn) {
		this.cn = cn;
	}

	@Override
	public void save() throws SQLException, ClassNotFoundException {


		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Insert into Activity Values ('"+ 1 +"','" + this.getName() +"','"+ this.getLongDescr() +"','"+ this.getShortDescr() +"','"+ 1 +"','"+ this.getCreateDate() +"','"+ this.getMajDate() +"')";
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public User load(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
