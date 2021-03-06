package com.LotuZ.user.user.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.LotuZ.user.user.bl.ListUser;
import com.LotuZ.user.user.bl.User;


/**
 * @author Ludo
 *
 */
public class ListUserJDBC extends ListUser {

	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	/**
	 * @param cn
	 */
	public ListUserJDBC(Connection cn) {
		this.cn = cn;
	}
	
	/**
	 * @param listActivityLeader
	 */
	public ListUserJDBC(List<User> listUser) {
		super(listUser);
	}



	

	public ListUser loadLeaders() throws SQLException{
		
		// On d�clare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.User u ,LotuZ.Member m Where m.idLeader IS NOT NULL and u.idMember = m.idMember";

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
		ListUser listUsers = new ListUserJDBC(users);
		return listUsers;
	}
	
	public ListUser loadMembers() throws SQLException{
		
		// On d�clare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.User  Where idMember IS NOT NULL ";

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
		ListUser listUsers = new ListUserJDBC(users);
		return listUsers;
	}
	
	public ListUser loadContributors() throws SQLException{
		
		// On d�clare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.User  Where idContributor IS NOT NULL ";

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
		ListUser listUsers = new ListUserJDBC(users);
		return listUsers;
	}
	
	
	public ListUser loadUsers() throws SQLException{
		
		// On d�clare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.User ";

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
		ListUser listUsers = new ListUserJDBC(users);
		return listUsers;
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
		user.setIdContributor(resultSet.getInt( "idContributor" ));
		user.setIdMember(resultSet.getInt( "idMember" ));
        return user;
    }





}