package com.LotuZ.user;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.LotuZ.user.contributor.bl.Contributor;

public final class UserLog extends User{

	private static volatile User user = null;
	private boolean admin = false;

	private Connection cn;


	private UserLog(Connection cn) {
		super();
		this.cn = cn;
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
		this.admin = admin;
	}

	/**
	 * @return the cn
	 */
	public Connection getCn() {
		return cn;
	}

	/**
	 * @param cn the cn to set
	 */
	public void setCn(Connection cn) {
		this.cn = cn;
	}

	public final static void init(Connection cn) {
		if (UserLog.user == null) {

			synchronized(UserLog.class) {
				UserLog.user = new UserLog(cn);
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


	public static void init(User user) throws SQLException {
		if (UserLog.user == null) {
			synchronized(UserLog.class) {
				if (UserLog.user == null) {
					UserLog.user = new UserLog(user);
				}
			}
		}
	}

	@Override
	public boolean isAdmin() throws SQLException {
		System.out.println("dis moi que tu viens là !!!!!!!!!!");
		boolean flag = false;
		int answer = 0;
		try{
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select idAdmin From LotuZ.Member m,LotuZ.User u where m.idMember=u.idMember and u.mail='"+this.getMail()+"'";
			System.out.println(sql);
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
	}

}








