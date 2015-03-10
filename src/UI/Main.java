package UI;

import java.sql.Connection;

import Business.FacadeBL;
import Model.JdbcKit;

public class Main {

	public static void main(String[] args) {
		

		
		String url = "jdbc:mysql://lotuz.c48krzyl3nim.eu-west-1.rds.amazonaws.com:3306/LotuZ";
		String login = "ROLL";
		String passwd = "rolldevelopment";
		
		JdbcKit jdbcKit = new JdbcKit(url,login,passwd);
		jdbcKit.openConnection(url, login, passwd);
		FacadeBL.init(jdbcKit);
		InscriptionUserUI frame =  new InscriptionUserUI();				
		frame.setVisible(true);

	}

}
