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
	public ActivityLeader load(String idActivityLeader) throws SQLException {
		try {
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From LotuZ.User Where mail="+'"'+idActivityLeader+'"';
			// Etape 4 : exécution requête

			ResultSet result = st.executeQuery(sql);
			while(result.next()){	
				this.setLastName(result.getString("lastName"));
				this.setFirstName(result.getString( "firstName" ));
				this.setMail(result.getString( "Mail" ));
				this.setTel(result.getString( "tel" ));
				this.setStreetName(result.getString( "streetName" ));
				this.setNumHouse(result.getString( "numHouse" ));
				this.setCity(result.getString( "city" ));
				this.setPostCode(result.getString( "postCode" ));
			}
			this.setCn(this.cn);
		} catch (SQLException e) {
			throw e;
		}
		return this;
	}
	
	public ActivityLeader update() throws SQLException {
	try {		
		Statement st =null;
		// Etape 3 : Création d'un statement
		st = this.cn.createStatement();

		String sql = "UPDATE User SET `lastName`='"+this.getLastName() +"',`firstName`='"+ this.getFirstName() +"',`mail`='"+this.getMail()
				+"',`tel`='"+this.getTel()+"',`streetName`='"+this.getStreetName()+"',`numHouse`='"+this.getNumHouse()+"',`city`='"+this.getCity()+"',`postCode`='"+this.getPostCode()+"' Where `mail`='"+this.getMail()+"'";
		// Etape 4 : exécution requête
		st.executeUpdate(sql);
		//String sqlCommit = "commit;";
		// Etape 4 : exécution requête
		//st.executeUpdate(sqlCommit);
		
	} catch (SQLException e) {
		throw e;
	}
	return this;
	}
	/**
	 * @param cn the cn to set
	 */
	public void setCn(Connection cn) {
		this.cn = cn;
	}


}

