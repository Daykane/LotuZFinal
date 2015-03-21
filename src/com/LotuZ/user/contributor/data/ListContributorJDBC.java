package com.LotuZ.user.contributor.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.LotuZ.user.User;
import com.LotuZ.user.UserJDBC;
import com.LotuZ.user.contributor.bl.ListContributor;


/**
 * @author Ludo
 *
 */
public class ListContributorJDBC extends ListContributor {

	
	/**
	 *  Necessary for the connection of the database
	 */
	private Connection cn;
	
	/**
	 * @param cn
	 */
	public ListContributorJDBC(Connection cn) {
		this.cn = cn;
	}
	
	/**
	 * @param listContributor
	 */
	public ListContributorJDBC(List<User> listContributor) {
		super(listContributor);
	}



	

	public ListContributor load() throws SQLException{
		
		// On d�clare une liste d'utilisateurs 
		List<User> users = new ArrayList<User>();

		try {
			Statement st =null;
			// Cr�ation d'un statement
			st = this.cn.createStatement();
			
			// Cr�ation de la requ�te de s�lection
			String sql = "Select * From LotuZ.Contributor";
			
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
		ListContributor listContributors = new ListContributorJDBC(users);
		return listContributors;
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

        return user;
    }



}