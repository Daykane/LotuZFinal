package com.LotuZ.user.activityLeader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.LotuZ.user.User;
import com.LotuZ.user.UserJDBC;


public class ListActivityLeaderJDBC extends ListActivityLeader {

	private Connection cn;
	
	public ListActivityLeaderJDBC(List<User> listActivityLeader) {
		super(listActivityLeader);
		// TODO Auto-generated constructor stub
	}



	public ListActivityLeaderJDBC(Connection cn2) {
		this.cn = cn2;
	}

	
	public ListActivityLeader load(){
		
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.User Where activityLeader = '1'";
			// Etape 4 : exécution requête
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			while( result.next() ){	
				users.add( map(result));
			}
		} catch (SQLException e) {
			try {
				throw e;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		ListActivityLeader listLeader = new ListActivityLeaderJDBC(users);
		return listLeader;
	}
	
	
	
    private static User map( ResultSet resultSet ) throws SQLException {

    	User user = new UserJDBC();
		user.setLastName(resultSet.getString( "lastName" ));
		user.setFirstName(resultSet.getString( "firstName" ));
		user.setMail(resultSet.getString( "mail" ));
		user.setPhone(resultSet.getString( "Tel" ));
		user.setStreetName(resultSet.getString( "streetName" ));
		user.setNumHouse(resultSet.getString( "numHouse" ));
		user.setCity(resultSet.getString( "city" ));
		user.setPostCode(resultSet.getString( "postCode" ));
		user.setPassword(resultSet.getString( "password" ));
		user.setMember(resultSet.getInt( "member" ));
		user.setActivityLeader(resultSet.getInt( "activityLeader" ));
        return user;
    }



}