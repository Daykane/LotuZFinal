package com.LotuZ.user;
import java.sql.Connection;
import java.sql.DriverManager;
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
	public UserJDBC(int id,String lastName, String firstName, String mail, String tel,
			String streetName, String numHouse, String city, String postCode,
			String password, int member, int activityLeader) {
		this.setId(id);
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
				//int id = result.getInt("idUser");
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
				
				//user = new UserJDBC(id,lastName,firstName,mail,tel,streetName,numHouse,city,postCode,password,member,activityLeader);

				user = new UserJDBC(1,lastName,firstName,mail,tel,streetName,numHouse,city,postCode,password,member,activityLeader);
			}
		} catch (SQLException e) {
			throw e;
		}
		return user;
	}
	
	public static void Read() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";

		String login = "ROLL";
		String passwd = "rolldevelopment";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM User";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)
			while(rs.next()){	
				//int id = rs.getInt(0);
				String lastName = rs.getString(1);
				String firstName = rs.getString(2);
				String mail = rs.getString(3); 
				String tel = rs.getString(4);
				String streetName = rs.getString(5);
				String numHouse = rs.getString(6);
				String city = rs.getString(7);
				String postCode = rs.getString(8);
				String password = rs.getString(9);
				int row = rs.getRow();
				System.out.println("\nDonnées contenues dans la ligne "+row);
				System.out.println("lastName : "+lastName+"\nfirstName : "+firstName+"\nmail : "+mail+"\ntel : "+tel+"\nstreetName : "+streetName+"\nnumHouse : "+numHouse+"\ncity : "+city+"\npostCode : "+ postCode +"\npassword : "+password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


