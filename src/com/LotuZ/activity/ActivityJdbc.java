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
		System.out.println("activity instanci�");
	}

	@Override
	public void save() throws SQLException, ClassNotFoundException {


		try {		
			Statement st =null;
			// Etape 3 : Cr�ation d'un statement
			st = this.cn.createStatement();
			if ( this == null ){ System.out.println("activity est null avant le sql");}
			String sql = "Insert into Activity Values ('"+ this.getName() +"','"+ this.getLongDescr() +"','"+ this.getShortDescr() +"','"+ "toto le respo" +"','"+ this.getCreateDate() +"','"+ this.getMajDate() +"')";
			System.out.println(sql);
			// Etape 4 : ex�cution requ�te
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
