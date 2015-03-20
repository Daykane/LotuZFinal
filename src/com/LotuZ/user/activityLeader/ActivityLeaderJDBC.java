package com.LotuZ.user.activityLeader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ActivityLeaderJDBC extends ActivityLeader{
	
	
	public ActivityLeaderJDBC(String lastName, String firstName, String mail,
			String tel, String streetName, String numHouse, String city,
			String postCode) {
		super(lastName, firstName, mail, tel, streetName, numHouse, city, postCode);
	}
	
	
	private Connection cn;

	/**
	 * @param cn
	 */
	public ActivityLeaderJDBC(Connection cn){
		this.cn = cn;
	}	
	

	public ActivityLeaderJDBC() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public ActivityLeader load(int idActivityLeader) throws SQLException {
		ActivityLeaderJDBC activityLeader = new ActivityLeaderJDBC();
		try {
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.User Where idActivity="+'"'+idActivityLeader+'"';
			// Etape 4 : exécution requête

			ResultSet result = st.executeQuery(sql);
			while(result.next()){	
				activityLeader.setLastName(result.getString("lastName"));
				activityLeader.setFirstName(result.getString( "firstName" ));
				activityLeader.setMail(result.getString( "firstName" ));
				activityLeader.setTel(result.getString( "phone" ));
				activityLeader.setStreetName(result.getString( "streetName" ));
				activityLeader.setNumHouse(result.getString( "numHouse" ));
				activityLeader.setCity(result.getString( "city" ));
				activityLeader.setPostCode(result.getString( "postCode" ));
			}
			activityLeader.setCn(this.cn);
		} catch (SQLException e) {
			throw e;
		}
		return activityLeader;
	}

	/**
	 * @param cn the cn to set
	 */
	public void setCn(Connection cn) {
		this.cn = cn;
	}

/*
	@Override
	public Activity update() throws SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "UPDATE Activity SET `name`='"+this.getName() +"',`longDescription`='"+ this.getLongDescr() +"',`shortDescription`='"+this.getShortDescr()
					+"',`activityLeader`='"+this.getIdRespo()+"',`updateDate`='"+this.getMajDate()+"' Where `idActivity`='"+this.getIdActivity()+"'";
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			throw e;
		}
		
		return this;
	}

*/

}

