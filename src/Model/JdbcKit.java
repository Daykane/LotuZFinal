package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcKit extends PersistKit{
		
	// Information d'accès à la base de données
	String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
	String login = "ROLL";
	String passwd = "rolldevelopment";
	Connection cn =null;
	
	UserJDBC userJdbc= new UserJDBC(url,login,passwd,cn);

	public void openConnection(String url, String login, String passwd,
			Connection cn) {
		// Etape 1 : Chargement du driver
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Etape 2 : récupération de la connexion
				try {
					this.cn = DriverManager.getConnection(url, login, passwd);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public void closeConnection(Connection cn) {
		try {
			this.cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			}
		
	}
	
	public void load(String lastName, String firstName, String mail,
			String tel, String streetName, String numHouse, String city,
			String postCode, String password) throws ClassNotFoundException, SQLException {
		//System.out.println("Début ouverture connexion");
		this.openConnection(url, login, passwd, cn);
		//System.out.println("Fin ouverture connexion");
		try {
			userJdbc.load(lastName, firstName, mail, tel, streetName, numHouse, city, postCode, password,cn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (SQLException e) {
			throw e;
			// TODO Auto-generated catch block
		}
		this.closeConnection(cn);
	}
}
