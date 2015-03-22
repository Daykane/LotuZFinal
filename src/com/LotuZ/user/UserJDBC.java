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

	/**
	 * @param cn
	 */
	public UserJDBC(Connection cn){
		this.cn = cn;
	}

	public UserJDBC(String lastName, String firstName, String mail, String tel,
			String streetName, String numHouse, String city, String postCode,
			String password, int idContributor, int idMember) {
		super(lastName, firstName, mail, tel,
				streetName, numHouse, city, postCode,
				password, idContributor, idMember);
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

			//String sql = "Insert into User Values ('"+ this.getLastName() +"','"+ this.getFirstName() +"','"+ this.getMail() +"','"+ this.getPhone() +"','"+ this.getStreetName() +"','"+ this.getNumHouse() +"','"+ this.getCity() +"','"+ this.getPostCode() +"','"+ this.getPassword() +"','"+ 0 +"','"+ 0 +"')";
			//String sql = "Insert into User Values ('"+ this.getLastName() +"','"+ this.getFirstName() +"','"+ this.getMail() +"','"+ this.getPhone() +"','"+ this.getStreetName() +"','"+ this.getNumHouse() +"','"+ this.getCity() +"','"+ this.getPostCode() +"','"+ this.getPassword() + "')";
			String sql = "INSERT INTO `LotuZ`.`User` (`lastName`, `firstName`, `mail`, `tel`, `streetName`, `numHouse`, `city`, `postCode`, `password`) VALUES ('"+ this.getLastName() +"', '"+ this.getFirstName() +"', '"+ this.getMail() +"', '"+ this.getPhone() +"', '"+ this.getStreetName() +"', '"+ this.getNumHouse() +"', '"+ this.getCity() +"', '"+ this.getPostCode() +"', '"+ this.getPassword() +"')";
			// Etape 4 : exécution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw e;
		}
	}

	public UserJDBC load(String mail) throws SQLException{
		UserJDBC user = null;
		Connection cn = this.cn;
		try {

			Statement st =null;
			// Etape 3 : Création d'un statement
			st = cn.createStatement();
			String sql = "Select * From LotuZ.User Where mail="+'"'+mail+'"';
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
				String password = result.getString("password");
				int idContributor = result.getInt("idContributor");
				int idMember = result.getInt("idMember");

				user = new UserJDBC(lastName,firstName,mail,tel,streetName,numHouse,city,postCode,password,idContributor,idMember);
				user.setCn(cn);
			}
		} catch (SQLException e) {
			throw e;
		}
		return user;
	}
	
	@Override
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
	}
}


