package Business;

import Model.ConnexionDatabase;

public class FacadeData {
	ConnexionDatabase connexionData = new ConnexionDatabase();

	public void toto() {
		System.out.println("FacadeData");
		connexionData.toto();
		
	}

}
