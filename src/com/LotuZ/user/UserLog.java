package com.LotuZ.user;

/**
 * @author Alexis
 */
import java.sql.Connection;
import java.sql.SQLException;


import com.LotuZ.user.activityLeader.bl.ActivityLeader;
import com.LotuZ.user.admin.bl.Administrator;
import com.LotuZ.user.contributor.bl.Contributor;
import com.LotuZ.user.member.bl.Member;
import com.LotuZ.user.user.bl.User;

public final class UserLog extends User{

	private static User user;
	private static Member member;
	private static Administrator admin;
	private static ActivityLeader respo;
	private static Contributor contrib;
	private static boolean dispo = true;
	//private boolean admin = false;

	//private Connection cn;





	public UserLog(User user, Member member, ActivityLeader respo, Administrator admin, Contributor contrib) throws SQLException {
		super(user.getLastName(), user.getFirstName(), user.getMail(),
				user.getPhone(), user.getStreetName(), user.getNumHouse(), user.getCity(),
				user.getPostCode(), user.getPassword(),user.getIdContributor(),user.getIdMember());
		UserLog.member = member;
		UserLog.respo = respo;
		UserLog.admin = admin;
		UserLog.contrib = contrib;

	}


	public static User getUserLog(){
		return UserLog.user;
	}

	public static Member getMemberLog(){
		return UserLog.member;
	}

	public static Administrator getAdminLog(){
		return UserLog.admin;
	}

	public static ActivityLeader getRespoLog(){
		return UserLog.respo;
	}

	public static Contributor getContribLog(){
		return UserLog.contrib;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		//this.admin = admin;
	}


	/*
	public final static void init() {
		if (UserLog.dispo ) {

			synchronized(UserLog.class) {
				UserLog.user = new UserLog();
				UserLog.dispo = false;
			}
		}
	}
	 */

	@Override
	public void save() throws SQLException, ClassNotFoundException {		
	}

	@Override
	public User load(String mail) {
		return null;		
	}

	/*
	public static void init(User user, Connection cn) throws SQLException {
		if (UserLog.user == null) {
			synchronized(UserLog.class) {
				if (UserLog.user == null) {
					UserLog.user = new UserLog(user);
				}
			}
		}
	}
	 */


	public static void init(User user, Member member, ActivityLeader respo,
			Administrator admin, Contributor contrib, Connection cn) throws SQLException {
		if (UserLog.dispo) {
			synchronized(UserLog.class) {
				//TODO
				UserLog.user = new UserLog(user,member,respo,admin,contrib);
				UserLog.dispo = false;

			}
		}
		else{
			//TODO
		}
	}




	@Override
	public void update(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}


	@Override
	public void delete(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}


	public static void logOff() {
		if (!UserLog.dispo) {
			synchronized(UserLog.class) {
				//TODO
				UserLog.user = null;
				UserLog.member = null;
				UserLog.contrib = null;
				UserLog.respo = null;
				UserLog.admin= null;
				UserLog.dispo = true;

			}
		}
		else{
			//TODO
		}
		//return user;
	}

}









