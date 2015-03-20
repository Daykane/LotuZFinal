package lotuZ.test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.hashText.HashText;

public class HashTextTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSha1() {
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
