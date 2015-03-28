package com.LotuZ.user.user.bl;

import java.sql.SQLException;

import com.LotuZ.PersistKit;
import com.LotuZ.user.member.bl.Member;


/**
 * @author Ludo
 *
 */
public class UserManager {

	private PersistKit pkit;
	
	/**
	 * 
	 * @param kit
	 */
	public UserManager(PersistKit kit){
		this.pkit=kit;
	}
	
	/**
	 * @param idContributor
	 * @return
	 * @throws SQLException
	 */
	public User getUser(String idUser) throws SQLException {
		User user = pkit.createUser();
		user = user.load(idUser);
		return user;
	}
	
	

	/**
	 * @param idContributor
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void deleteUser(User user1) throws SQLException, ClassNotFoundException {
		User user = pkit.createUser();
		user.delete(user1);
	}
	
	public void updateUser(User user1) throws SQLException, ClassNotFoundException {
		User user = pkit.createUser();
		user.update(user1);
	}
	
	/**
	 * @return ListActivityLeader
	 * @throws SQLException
	 */
	public ListUser getMembers() throws SQLException {
		ListUser users = pkit.createListUser();
		return users.loadMembers();
	}
	
	public ListUser getContributors() throws SQLException {
		ListUser users = pkit.createListUser();
		return users.loadContributors();
	}
	
	public ListUser getLeaders() throws SQLException {
		ListUser users = pkit.createListUser();
		return users.loadLeaders();
	}
}