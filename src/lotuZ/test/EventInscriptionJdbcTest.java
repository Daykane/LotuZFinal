package lotuZ.test;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.EventInscription.EventInscription;
import com.LotuZ.EventInscription.EventInscriptionJdbc;
import com.LotuZ.event.Event;
import com.LotuZ.event.EventJdbc;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionJdbc;
import com.LotuZ.user.user.bl.User;
import com.LotuZ.user.user.data.UserJDBC;
import com.mysql.jdbc.Connection;

public class EventInscriptionJdbcTest {
	
	private static java.sql.Connection cn;

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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSave() {
		EventInscription eventInscription = new EventInscriptionJdbc(cn);
		Event event = new EventJdbc(cn);
		User user = new UserJDBC(cn);
		try {
			event = event.load(27);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			user = user.load("admin");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		eventInscription.setIdEvent(event.getIdEvent());
		eventInscription.setIdMember(user.getMail());
		try {
			eventInscription.add();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
