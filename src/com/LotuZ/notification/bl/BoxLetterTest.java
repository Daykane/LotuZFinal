/**
 * 
 */
package com.LotuZ.notification.bl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.LotuZ.FacadeBL;
import com.LotuZ.JdbcKit;
import com.LotuZ.EventInscription.FacadeEventInscription;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.event.repetition.Repetition;
import com.LotuZ.event.repetition.RepetitionJdbc;
import com.LotuZ.notification.data.BoxLetterJDBC;
import com.LotuZ.user.FacadeUser;

/**
 * @author lowx
 *
 */
public class BoxLetterTest {

	static Connection cn;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		// On fait la connection � la base de donn�e
				String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
				String login = "ROLL";
				String passwd = "rolldevelopment";

				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				// Etape 2 : r�cup�ration de la connexion
				try {
					cn = DriverManager.getConnection(url, login, passwd);
				} catch (SQLException e) {
					e.printStackTrace();
				}

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
			cn.close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//testSave();
		
	}

	@After
	public void tearDown() throws Exception {
		//testDelete();
	}

	@Test
	public final void testSendNotification() throws ClassNotFoundException, SQLException {
		BoxLetter boxLetter= new BoxLetterJDBC(cn);
		try{
		boxLetter.sendNotification(2,1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
