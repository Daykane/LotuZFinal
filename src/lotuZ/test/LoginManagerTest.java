/**
 * 
 */
package lotuZ.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.PersistKit;
import com.LotuZ.login.LoginManager;

/**
 * @author Alexis
 *
 */
public class LoginManagerTest {
	
	//private PersistKit pkit;
	//LoginManager loginManager = new LoginManager(pkit);
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("avant Class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("après class");
	}



	private PersistKit pkit;


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
	public final void testLoginManager(PersistKit kit) {
		this.pkit=kit;
		assertTrue("attibute pkit", this.pkit == kit);
	}

	/**
	 * Test method for {@link com.LotuZ.login.LoginManager#login(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testLogin() {
		fail("Not yet implemented"); // TODO
	}



	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}



}
