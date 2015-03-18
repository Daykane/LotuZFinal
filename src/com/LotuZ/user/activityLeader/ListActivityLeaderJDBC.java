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


public class ListActivityLeaderJDBC extends User{
	
	private Connection cn;

	public ListActivityLeaderJDBC(Connection cn) {
		this.cn = cn;
	}

	
	public List<User> load() throws SQLException{
		
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
			throw e;
		}
		return users;
	}
	
	
	
    private static User map( ResultSet resultSet ) throws SQLException {

    	User user = new UserJDBC();
		user.setLastName(resultSet.getString( "lastName" ));
		user.setFirstName(resultSet.getString( "firstName" ));
		user.setMail(resultSet.getString( "mail" ));
		user.setPhone(resultSet.getString( "phone" ));
		user.setStreetName(resultSet.getString( "streetName" ));
		user.setNumHouse(resultSet.getString( "numHouse" ));
		user.setCity(resultSet.getString( "city" ));
		user.setPostCode(resultSet.getString( "postCode" ));
		user.setPassword(resultSet.getString( "password" ));
		user.setMember(resultSet.getInt( "member" ));
		user.setActivityLeader(resultSet.getInt( "activityLeader" ));
        return user;
    }


	@Override
	public void save() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User load(String mail, String passWordCrypt, String role)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}