package com.LotuZ.user.activityLeader.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.user.User;
import com.LotuZ.user.UserJDBC;
import com.LotuZ.user.activityLeader.bl.ListActivityLeader;


/**
 * @author Ludo
 *
 */
public class ListActivityLeaderJDBC extends ListActivityLeader {

	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	/**
	 * @param cn
	 */
	public ListActivityLeaderJDBC(Connection cn) {
		this.cn = cn;
	}
	
	/**
	 * @param listActivityLeader
	 */
	public ListActivityLeaderJDBC(List<User> listActivityLeader) {
		super(listActivityLeader);
	}



	

	public ListActivityLeader load() throws SQLException{
		
		// On d�clare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.User Where activityLeader = '1'";
			
			// Ex�cution de la requ�te
			ResultSet result = st.executeQuery(sql);
			
			// R�cup�ration des donn�es 
			while( result.next() ){	
				// Cr�ation et ajout d'un utilisateurs dans la liste 
				users.add( map(result));
			}
		} catch (SQLException e) {
				throw e;
		}
		ListActivityLeader listLeaders = new ListActivityLeaderJDBC(users);
		return listLeaders;
	}
	
	
	
    /**
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private static User map( ResultSet resultSet ) throws SQLException {
    	// On cr��e un utlisateur 
    	User user = new UserJDBC();
    	
    	// On lui ajoute ses attributs � partir des r�sultats de la requ�te
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