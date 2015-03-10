package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Class.Activity;
import Class.User;


public class JdbcKit extends PersistKit{
	/*	
	// Information d'accès à la base de données
	String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
	String login = "ROLL";
	String passwd = "rolldevelopment";
	Connection cn =null;
	*/
	private String url;
	private String login;
	private String passwd;
	private Connection cn;
	
	UserJDBC userJdbc= new UserJDBC(url,login,passwd,cn);
	ActivityJdbc activityJdbc = new ActivityJdbc();

	public JdbcKit(String url, String login, String passwd){
		this.url = url;
		this.login=login;
		this.passwd = passwd;
	}
	public JdbcKit() {
	}
	public void openConnection(String url, String login, String passwd) {
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
	
	public User login(String mail, String password) throws SQLException{
		this.openConnection(url, login, passwd, cn);
		User user;
		try {

			user = userJdbc.login(mail,password,cn);

			
		} catch (SQLException e) {
			throw e;
			// TODO Auto-generated catch block
		}
		this.closeConnection(cn);
		return user;
		
	}

	@Override
	public  List<Activity> getActivities() {
		List<Activity> ActivityList = activityJdbc.getActivities();
		return ActivityList;
	}

	@Override
	public User createUser() {
		return new UserJDBC(this.cn);
	}
	@Override
	public void openConnection(String url, String login, String passwd,
			Connection cn) {
		// TODO Auto-generated method stub
		
	}

}
