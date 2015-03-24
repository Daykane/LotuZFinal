package com.LotuZ.user;

/**
 * @author Alexis
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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


	private UserLog() {
		super();
	}


	public UserLog(User user) throws SQLException {
		super(user.getLastName(), user.getFirstName(), user.getMail(),
				user.getPhone(), user.getStreetName(), user.getNumHouse(), user.getCity(),
				user.getPostCode(), user.getPassword(),user.getIdContributor(),user.getIdMember());
	}


	public static User getUserLog(){
		return UserLog.user;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		//this.admin = admin;
	}



	public final static void init() {
		if (UserLog.dispo ) {

			synchronized(UserLog.class) {
				UserLog.user = new UserLog();
				UserLog.dispo = false;
			}
		}
	}

	@Override
	public void save() throws SQLException, ClassNotFoundException {		
	}

	@Override
	public User load(String mail) {
		return null;		
	}


	public static void init(User user, Connection cn) throws SQLException {
		if (UserLog.user == null) {
			synchronized(UserLog.class) {
				if (UserLog.user == null) {
					UserLog.user = new UserLog(user);
				}
			}
		}
	}


	public static void init(User user, Member member, ActivityLeader respo,
			Administrator admin, Contributor contrib, Connection cn) throws SQLException {
		if (UserLog.dispo) {
			synchronized(UserLog.class) {
				//TODO
				if (admin != null) {
					// prend un admin
					UserLog.user = new UserLog(user);
				}
				else if (respo != null){
					// prend un respo
					UserLog.user = new UserLog(user);
				}
				else if (contrib != null){
					// prend un contributor	
					UserLog.user = new UserLog(user);
				}
				else if(member != null){
					// prend un member
					UserLog.user = new UserLog(user);
				}
				else{
					// 
					UserLog.user = new UserLog(user);
				}
			}
		}
		
	}


	@Override
	public void update() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public boolean isAdmin() throws SQLException {
		boolean flag = false;
		int answer = 0;
		try{
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select idAdmin From LotuZ.Member m,LotuZ.User u where m.idMember=u.idMember and u.mail='"+this.getMail()+"'";
			ResultSet result = st.executeQuery(sql);
			while( result.next() ){	
				answer = result.getInt("idAdmin");			
			}
		}
		catch  (SQLException e) {
			throw e;
		}
		if(answer == 1){
			flag = true;
		}
		return flag;
	}*/
}








