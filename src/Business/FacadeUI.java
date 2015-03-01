package Business;

import UI.UserUI;

public class FacadeUI {
	
	UserUI userUI;
	UserManager userManager = new UserManager();
	public void toto() {
		System.out.println("FacadeUI");
		userManager.toto();
		
	}

}
