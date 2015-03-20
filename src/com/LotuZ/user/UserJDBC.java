package com.LotuZ.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author LotuZ
 *
 */
public class UserJDBC extends User{
	private Connection cn;

	/**
	 * @param cn
	 */
	public UserJDBC(Connection cn){
		this.cn = cn;
	}			
	public UserJDBC(String lastName, String firstName, String mail, String tel,
			String streetName, String numHouse, String city, String postCode,
			String password, int member, int activityLeader) {
		super(lastName, firstName, mail, tel,
			streetName, numHouse, city, postCode,
			password, member, activityLeader);
		/*
		this.setLastName(lastName);
		this.setFirstName(firstName);
		this.setMail(mail);
		this.setPhone(tel);
		this.setStreetName(streetName);
		this.setNumHouse(numHouse);
		this.setCity(city);
		this.setPostCode(postCode);
		this.setPassword(password);
		this.setMember(member);
		this.setActivityLeader(activityLeader);
		*/
	}
	
	public UserJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	public void save() throws ClassNotFoundException, SQLException {
		try {		
			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();

			String sql = "Insert into User Values ('"+ this.getLastName() +"','"+ this.getFirstName() +"','"+ this.getMail() +"','"+ this.getPhone() +"','"+ this.getStreetName() +"','"+ this.getNumHouse() +"','"+ this.getCity() +"','"+ this.getPostCode() +"','"+ this.getPassword() +"','"+ this.getMember() +"','"+ this.getActivityLeader() +"')";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public User load(String mail,String password, String role) throws SQLException{
		User user = null;
		String table = null;
		if (role == "user"){
			table = "LotuZ.User";
		}
		try {

			Statement st =null;
			// Etape 3 : Création d'un statement
			st = this.cn.createStatement();
			String sql = "Select * From "+table+" Where mail="+'"'+mail+'"'+"and password="+'"'+password+'"';
			// Etape 4 : exécution requête
			//st.executeUpdate(sql);
			ResultSet result = st.executeQuery(sql);
			while( result.next() ){	
				String lastName = result.getString("lastName");
				String firstName = result.getString("firstName");
				//String mail = result.getString("mail");
				String tel = result.getString("tel");
				String streetName = result.getString("streetName");
				String numHouse = result.getString("numHouse");
				String city = result.getString("city");
				String postCode = result.getString("postCode");
				//String password = result.getString("password");
				int member = result.getInt("member");
				int activityLeader = result.getInt("activityLeader");
				

				user = new UserJDBC(lastName,firstName,mail,tel,streetName,numHouse,city,postCode,password,member,activityLeader);
			}
		} catch (SQLException e) {
			throw e;
		}
		return user;
	}
}


