package lotuZ.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.JdbcKit;

public class UserJDBCTest {
	
	static Connection cn;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Info Connection
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";
				
		// Choose the kit
		JdbcKit jdbcKit = new JdbcKit(url,login,passwd);
		jdbcKit.openConnection(url, login, passwd);
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
	public final void testSave() {
		fail("Not yet implemented"); // TODO
		//Create le statement
		//execute la commande sql
	}

	@Test
	public final void testLoad() {
		fail("Not yet implemented"); // TODO
		//Create le statement
		//Execute la commande sql
		//Recupère les infos en retour
		//Creer un userJDBC avec les infos récupéré
	}

	@Test
	public final void testUserJDBCConnection() {
		fail("Not yet implemented"); // TODO
		//Le constructeur avec la Connection
	}

	@Test
	public final void testUserJDBCStringStringStringStringStringStringStringStringStringIntInt() {
		fail("Not yet implemented"); // TODO
		//Le constructeur avec les paramètres
	}

	@Test
	public final void testUserJDBC() {
		fail("Not yet implemented"); // TODO
		// Lui il sert à quoi ?
	}



}
