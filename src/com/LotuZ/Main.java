package com.LotuZ;


import java.sql.SQLException;

import com.LotuZ.EventInscription.FacadeEventInscription;
import com.LotuZ.activity.FacadeActivity;
import com.LotuZ.event.FacadeEvent;
import com.LotuZ.login.UserNotFoundException;
import com.LotuZ.user.FacadeUser;
import com.LotuZ.user.Homepage;

public class Main {

	public static void main(String[] args) throws SQLException, UserNotFoundException {

		// Info Connection
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";
		
		// Choose the kit
		JdbcKit jdbcKit = new JdbcKit(url,login,passwd);
		jdbcKit.openConnection(url, login, passwd);
		
		// Init the FacadeBL with the kit
		FacadeBL.init(jdbcKit);
		FacadeUser.init(jdbcKit);
		FacadeActivity.init(jdbcKit);
		FacadeEvent.init(jdbcKit);
		FacadeEventInscription.init(jdbcKit);
		//FacadeUser.init();
		
		//First UI to call
		Homepage pageAcceuil = new Homepage();
		pageAcceuil.setVisible(true);
		pageAcceuil.setLocationRelativeTo(null);

	}

}
