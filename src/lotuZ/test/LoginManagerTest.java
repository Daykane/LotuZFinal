package lotuZ.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.JdbcKit;
import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashTextTest;
import com.LotuZ.login.LoginManager;
import com.LotuZ.user.User;
import com.LotuZ.user.UserJDBC;
import com.LotuZ.user.UserLog;

/**
 * @author Alexis
 *
 */
public class LoginManagerTest extends TestCase{	
	

	static PersistKit pkit;

	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("avant Class");
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";		
		pkit = new JdbcKit(url,login,passwd);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("après class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("avant test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("après test");
	}


	/**
	 * Test method for {@link com.LotuZ.login.LoginManager#LoginManager(com.LotuZ.PersistKit)}.
	 */
	@Test
	public final void testLoginManager() {
		LoginManager lm = new LoginManager(pkit);
		assertSame(lm.getPkit(),pkit);
	}

	/**
	 * Test method for {@link com.LotuZ.login.LoginManager#login(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	public final void testLogin() throws SQLException {
		//LoginManager lm = new LoginManager(pkit);
		int id = 0;
		User user = new UserJDBC(id,"lastName", "firstName", "mail","tel",
				"streetName", "numHouse", "city", "postCode",
				"password",0,0);
		assertNotNull("L'instance est créée", user);
		User userLog = new UserLog(user.getLastName(),user.getFirstName(),user.getMail(),user.getPhone(),user.getStreetName(),user.getNumHouse(),user.getCity(),user.getPostCode(),user.getPassword(),user.getMember(), user.getActivityLeader());
		assertNotNull("L'instance est créée", userLog);
		// Param Test
		assertEquals("id",user.getId());
		assertEquals("lastName",user.getLastName());
		assertEquals("firstName",user.getFirstName());
		assertEquals("mail",user.getMail());
		assertEquals("tel",user.getPhone());
		assertEquals("streetName",user.getStreetName());
		assertEquals("numHouse",user.getNumHouse());
		assertEquals("city",user.getCity());
		assertEquals("postCode",user.getPostCode());
		assertEquals("password",user.getPassword());
		assertEquals(0,user.getMember());
		assertEquals(0,user.getActivityLeader());
	}



	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		String passWordCrypt="";
		String password = "test";
		try {
			passWordCrypt = HashTextTest.sha1(password);		
			assertEquals(passWordCrypt,HashTextTest.sha1(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}



}
