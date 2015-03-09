package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Class.User;


public class UserJDBC extends User{
	private String url;
	private String login;
	private String passwd;
	private Connection cn;
	private Statement st;
	
	public UserJDBC(String url, String login, String passwd, Connection cn){
		this.url = url;
		this.login = login;
		this.passwd = passwd;
		this.cn = cn;
		this.st = null;
	}
	
			
			
			public void load(User user, Connection cn) throws ClassNotFoundException, SQLException {



				try {		
					Statement st =null;
					// Etape 3 : Création d'un statement
					st = cn.createStatement();

					String sql = "Insert into User Values ('"+ user.getLastName() +"','"+ user.getFirstName() +"','"+ user.getMail() +"','"+ user.getPhone() +"','"+ user.getStreetName() +"','"+ user.getNumHouse() +"','"+ user.getCity() +"','"+ user.getPostCode() +"','"+ user.getPassword() +"')";

					// Etape 4 : exécution requête
					st.executeUpdate(sql);

					// Si récup données alors étapes 5 (parcours Resultset)

				} catch (SQLException e) {
					throw e;
				}
			}
			
			public User login(String mail,String password,Connection cn) throws SQLException{
				User user = null;
				try {
					
					Statement st =null;
					// Etape 3 : Création d'un statement
					st = cn.createStatement();
					System.out.println(password);
					System.out.println(mail);
					String sql = "Select * From LotuZ.User Where mail="+'"'+mail+'"'+"and password="+'"'+password+'"';
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
						user = new User(lastName,firstName,mail,tel,streetName,numHouse,city,postCode,password);

					}
					
					
					// Si récup données alors étapes 5 (parcours Resultset)

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


