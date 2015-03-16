package UI;

import Business.FacadeBL;
import Model.JdbcKit;

public class Main {

	public static void main(String[] args) {

		// Info Connection
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";
		
		// Choose the kit
		JdbcKit jdbcKit = new JdbcKit(url,login,passwd);
		jdbcKit.openConnection(url, login, passwd);
		
		// Init the FacadeBL with the kit
		FacadeBL.init(jdbcKit);
		
		//First UI to call
		HomepageUI frame =  new HomepageUI();				
		frame.setVisible(true);

	}

}
