package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDatabase {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			//Load("Laboureur","Alexis","sonmail@gmail","0625102689","Rue du Village",52,"Montpellier",34000,1253);
			Read();
		}

			public static void Load(String lastName, String firstName, String mail, String tel, String streetName, int numHouse, String city, int postCode, int password) {

				// Information d'accès à la base de données
				String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
				String login = "ROLL";
				String passwd = "rolldevelopment";
				Connection cn =null;
				Statement st =null;

				try {

					// Etape 1 : Chargement du driver
					Class.forName("com.mysql.jdbc.Driver");

					// Etape 2 : récupération de la connexion
					cn = DriverManager.getConnection(url, login, passwd);

					// Etape 3 : Création d'un statement
					st = cn.createStatement();

					String sql = "Insert into User Values ('"+ lastName +"','"+ firstName +"','"+ mail +"','"+ tel +"','"+ streetName +"','"+ numHouse +"','"+ city +"','"+ postCode +"','"+ password +"')";

					// Etape 4 : exécution requête
					st.executeUpdate(sql);

					// Si récup données alors étapes 5 (parcours Resultset)

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					try {
					// Etape 6 : libérer ressources de la mémoire.
						cn.close();
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
						int postCode = rs.getInt(8);
						int password = rs.getInt(9);
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

			public void toto() {
				System.out.println("connexionDatabase");
				Read();				
			}
					
	}


