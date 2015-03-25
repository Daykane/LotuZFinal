package lotuZ.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionJdbc;

public class RepetitionJdbcTest {
	
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
		cn.close();
	}

	@Before
	public void setUp() throws Exception {
		//testSave();
		
	}

	@After
	public void tearDown() throws Exception {
		//testDelete();
	}

	@Test
	public final void testSave() throws ClassNotFoundException, SQLException {
		Repetition repetition = new RepetitionJdbc(cn);
		repetition.setName("Junittest3");
		repetition.save();
		//TODO changer ça
		//repetition.delete();
	}

	@Test
	public final void testLoad() {
		//Repetition repetition = new RepetitionJdbc(cn);
		//repetition.load();
	}

	@Test
	public final void testUpdate() throws ClassNotFoundException, SQLException {
		//Repetition repetition = new RepetitionJdbc(cn);
		//repetition.setName("Junittest");
		//repetition.save();
		
	}

	@Test
	public final void testDelete() throws ClassNotFoundException, SQLException {
		//Repetition repetition = new RepetitionJdbc(cn);
		//repetition.delete();
	}

	@Test
	public final void testRepetitionJdbcString() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRepetitionJdbcConnection() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRepetitionJdbc() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCn() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetCn() {
		//fail("Not yet implemented"); // TODO
	}

}
