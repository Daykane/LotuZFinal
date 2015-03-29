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
		
		// On déclare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Création de la requête de sélection
			String sql = "Select * From LotuZ.User u ,LotuZ.Member m Where m.idLeader IS NOT NULL and u.idMember = m.idMember";

			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			// Récupération des données 
			while( result.next() ){	
				// Création et ajout d'un utilisateurs dans la liste 
				users.add( map(result));
			}
		} catch (SQLException e) {
				throw e;
		}
		ListUser listUsers = new ListUserJDBC(users);
		return listUsers;
	}
	
	public ListUser loadMembers() throws SQLException{
		
		// On déclare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Création de la requête de sélection
			String sql = "Select * From LotuZ.User  Where idMember IS NOT NULL ";

			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			// Récupération des données 
			while( result.next() ){	
				// Création et ajout d'un utilisateurs dans la liste 
				users.add( map(result));
			}
		} catch (SQLException e) {
				throw e;
		}
		ListUser listUsers = new ListUserJDBC(users);
		return listUsers;
	}
	
	public ListUser loadContributors() throws SQLException{
		
		// On déclare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Création de la requête de sélection
			String sql = "Select * From LotuZ.User  Where idContributor IS NOT NULL ";

			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			// Récupération des données 
			while( result.next() ){	
				// Création et ajout d'un utilisateurs dans la liste 
				users.add( map(result));
			}
		} catch (SQLException e) {
				throw e;
		}
		ListUser listUsers = new ListUserJDBC(users);
		return listUsers;
	}
	
	
	public ListUser loadUsers() throws SQLException{
		
		// On déclare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Création d'un statement
			st = this.cn.createStatement();
			
			// Création de la requête de sélection
			String sql = "Select * From LotuZ.User ";

			// Exécution de la requête
			ResultSet result = st.executeQuery(sql);
			
			// Récupération des données 
			while( result.next() ){	
				// Création et ajout d'un utilisateurs dans la liste 
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
    	// On créée un utlisateur 
    	User user = new UserJDBC();
    	
    	// On lui ajoute ses attributs à partir des résultats de la requête
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