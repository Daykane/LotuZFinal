package lotuZ.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.user.user.data.UserJDBC;


public class UserJDBCTest {

	static Connection cn;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// On fait la connection à la base de donnée
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Etape 2 : récupération de la connexion
		try {
			cn = DriverManager.getConnection(url, login, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Ouverture de la connexion");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("fermeture de la connexion");

		//user.Delete();
		cn.close();

	}

	@Before
	public void setUp() throws Exception {
		save();
	}

	@After
	public void tearDown() throws Exception {
		delete();
	}

	@Test
	public final void testSave() {
	}


	@Test
	public final void testLoad() {
		Statement st =null;
		ResultSet result = null;
		// Etape 3 : Création d'un statement
		try {
			st = cn.createStatement();
		} catch (SQLException e) {
			fail("Load : SQL exception create Statement");
		}
		String sql = "Select * From LotuZ.User Where mail='JunitMail' and password='JunitPassword'";
		try {
			result = st.executeQuery(sql);
			assertNotNull("Retour SQL requête null",result);
		} catch (SQLException e) {
			fail("Load : SQL exception exécution requete");
		}
		try {
			while( result.next() ){	
				String lastName = result.getString("lastName");
				String firstName = result.getString("firstName");
				String mail = result.getString("mail");
				String tel = result.getString("tel");
				String streetName = result.getString("streetName");
				String numHouse = result.getString("numHouse");
				String city = result.getString("city");
				String postCode = result.getString("postCode");
				String password = result.getString("password");
				int member = result.getInt("member");
				int activityLeader = result.getInt("activityLeader");
				
				// Param Test
				assertEquals("JunitLastName",lastName);
				assertEquals("JunitFirstName",firstName);
				assertEquals("JunitMail",mail);
				assertEquals("JunitTel",tel);
				assertEquals("JunitStreet",streetName);
				assertEquals("JunitNumHouse",numHouse);
				assertEquals("JunitCity",city);
				assertEquals("JunitPostCode",postCode);
				assertEquals("JunitPassword",password);
				assertEquals(0,member);
				assertEquals(0,activityLeader);
			}
		} catch (SQLException e) {
			fail("Load : SQL exception recupération requete");
		}
	}

	@Test
	public final void testUserJDBCConnection() {
		//Le constructeur avec la Connection
		UserJDBC user = new UserJDBC(cn);
		assertNotNull("UserJDBC avec connection non instancié",user);
	}

	@Test
	public final void testUserJDBCWithAttributes() {
		String lastName = "lastName";
		String firstName = "firstName";
		String streetName = "street";
		String numHouse = "numHouse";
		String city = "city";
		String postCode= "postCode";
		String mail = "mail";
		String password = "password";
		String phone = "phone";
		int idContributor = 0;
		int idMember = 0;
		
		UserJDBC user = new UserJDBC(lastName, firstName, mail, phone,
				streetName, numHouse, city, postCode,
				password, idContributor, idMember);
		
		assertNotNull("UserJDBC avec tous les attributs non instancié",user);
		// Param Test
		assertEquals("lastName",user.getLastName());
		assertEquals("firstName",user.getFirstName());
		assertEquals("mail",user.getMail());
		assertEquals("phone",user.getPhone());
		assertEquals("street",user.getStreetName());
		assertEquals("numHouse",user.getNumHouse());
		assertEquals("city",user.getCity());
		assertEquals("postCode",user.getPostCode());
		assertEquals("password",user.getPassword());
		assertEquals(0,user.getIdContributor());
		assertEquals(0,user.getIdMember());
	}

	@Test
	public final void testUserJDBC() {
		UserJDBC user = new UserJDBC();
		assertNotNull("UserJDBC vide non instancié",user);
	}

	@Test
	public final void testDelete(){
	}

	private void delete() {
		Statement st =null;
		try {
			st = cn.createStatement();
		} catch (SQLException e) {
			fail("SQL exception create Statement");
		}
		String sql = "Delete From LotuZ.User Where mail='JunitMail'";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			fail("SQL exception execute requete suppression");
		}
	}
	public static void save(){
		// Test l'enregistrement et la suppression ?? pas top
				Statement st =null;
				try {
					st = cn.createStatement();
				} catch (SQLException e) {
					fail("Save : SQL exception create Statement");
				}
				String sql = "INSERT INTO `LotuZ`.`User` (`lastName`, `firstName`, `mail`, `tel`, `streetName`, `numHouse`, `city`, `postCode`, `password`, `member`, `activityLeader`) VALUES ('JunitLastName', 'JunitFirstName', 'JunitMail', 'JunitTel', 'JunitStreet', 'JunitNumHouse', 'JunitCity', 'JunitPostCode', 'JunitPassword', '0', '0')";
				try {
					st.executeUpdate(sql);
				} catch (SQLException e) {
					fail("Save : SQL exception execute requete inscription");
				}
		
	}

}
