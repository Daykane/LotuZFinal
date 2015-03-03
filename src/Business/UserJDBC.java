package Business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserJDBC {
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
	
			
			
			public void load(String lastName, String firstName, String mail, String tel, String streetName, String numHouse, String city, String postCode, String password, Connection cn) throws ClassNotFoundException, SQLException {



				try {		
					Statement st =null;
					// Etape 3 : Cr�ation d'un statement
					st = cn.createStatement();

					String sql = "Insert into User Values ('"+ lastName +"','"+ firstName +"','"+ mail +"','"+ tel +"','"+ streetName +"','"+ numHouse +"','"+ city +"','"+ postCode +"','"+ password +"')";

					// Etape 4 : ex�cution requ�te
					st.executeUpdate(sql);

					// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

				} catch (SQLException e) {
					throw e;
				}
			}
			
			public static void Read() {

				// Information d'acc�s � la base de donn�es
				String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
				
				String login = "ROLL";
				String passwd = "rolldevelopment";
				Connection cn =null;
				Statement st =null;
				ResultSet rs =null;

				try {

					// Etape 1 : Chargement du driver
					Class.forName("com.mysql.jdbc.Driver");

					// Etape 2 : r�cup�ration de la connexion
					cn = DriverManager.getConnection(url, login, passwd);

					// Etape 3 : Cr�ation d'un statement
					st = cn.createStatement();

					String sql = "SELECT * FROM User";

					// Etape 4 : ex�cution requ�te
					rs = st.executeQuery(sql);

					// Si r�cup donn�es alors �tapes 5 (parcours Resultset)
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
						System.out.println("\nDonn�es contenues dans la ligne "+row);
						System.out.println("lastName : "+lastName+"\nfirstName : "+firstName+"\nmail : "+mail+"\ntel : "+tel+"\nstreetName : "+streetName+"\nnumHouse : "+numHouse+"\ncity : "+city+"\npostCode : "+ postCode +"\npassword : "+password);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

					
	}


