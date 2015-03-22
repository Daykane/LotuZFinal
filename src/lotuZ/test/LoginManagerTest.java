package lotuZ.test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.PersistKit;
import com.LotuZ.hashText.HashText;
import com.LotuZ.login.LoginManager;
import com.LotuZ.login.UserNotFoundException;
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
		//System.out.println("avant Class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//System.out.println("après class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//System.out.println("avant test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//System.out.println("après test");
	}


	/**
	 * Test method for {@link com.LotuZ.login.LoginManager#LoginManager(com.LotuZ.PersistKit)}.
	 */
	@Test
	public final void testLoginManager() {
		LoginManager lm = new LoginManager(pkit);
		assertNotNull("L'instance n'est pas créée", lm);
		assertSame(lm.getPkit(),pkit);
	}
	
	/**
	 * Test method for {@link com.LotuZ.login.LoginManager#login(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws SQLException 
	 */
	/*
	@Test
	public final void testLogin() throws SQLException {
		// faire un mock pour UserJDBC
		LoginManager lm = new LoginManager(pkit);
		assertNotNull("L'instance n'est pas créée", lm);
		
		String mail = "mail";
		String password = "password";
		String role ="role";
			
		
		User user = createUser();
		
		
		assertNotNull("L'instance n'est pas créée", user);
		// constructeur avec user en param
		User userLog = new UserLog(user);
		assertNotNull("L'instance n'est pas créée", userLog);
		// Param Test
		assertEquals("lastName",user.getLastName());
		assertEquals("firstName",user.getFirstName());
		assertEquals("mail",user.getMail());
		assertEquals("tel",user.getPhone());
		assertEquals("streetName",user.getStreetName());
		assertEquals("numHouse",user.getNumHouse());
		assertEquals("city",user.getCity());
		assertEquals("postCode",user.getPostCode());
		assertEquals("password",user.getPassword());
		assertEquals(0,user.getIdContributor());
		assertEquals(0,user.getIdMember());
	}
*/
	protected User createUser() {
		User user = pkit.createUser();
		user = new UserJDBC("lastName", "firstName", "mail","tel",
				"streetName", "numHouse", "city", "postCode",
				"password",0,0);
		return user;
	}

	// existe pas dans LoginManager
	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		String passWordCrypt="";
		String password = "test";
		try {
			passWordCrypt = HashText.sha1(password);
			assertTrue("Le mot de passe n'est pas crypté", password!=passWordCrypt);
			assertEquals(passWordCrypt,HashText.sha1(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}



}
