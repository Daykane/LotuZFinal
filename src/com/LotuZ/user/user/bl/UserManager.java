package com.LotuZ.user.user.bl;

import java.sql.SQLException;
import java.util.Date;

import com.LotuZ.PersistKit;
import com.LotuZ.user.contributor.bl.Contributor;
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
	
	/**
	 * @param user1
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	
	
	/**
	 * @return ListUser
	 * @throws SQLException
	 */
	public ListUser getContributors() throws SQLException {
		ListUser users = pkit.createListUser();
		return users.loadContributors();
	}
	
	/**
	 * @return ListUser
	 * @throws SQLException
	 */
	public ListUser getLeaders() throws SQLException {
		ListUser users = pkit.createListUser();
		return users.loadLeaders();
	}
	
	/**
	 * @return ListUser
	 * @throws SQLException
	 */
	public ListUser getUsers() throws SQLException {
		ListUser users = pkit.createListUser();
		return users.loadUsers();
	}

	public void inscriptionMember(User user, Double cotisation) throws ClassNotFoundException, SQLException {
		Member member = pkit.createMember();
		member.setCotisation(cotisation);
		Date today = new Date();
		member.save(user,today);
	}

	public void inscriptionContributor(User user) throws ClassNotFoundException, SQLException {
		Contributor contributor = pkit.createContributor();
		contributor.save(user.getMail());
	}
}