package Business;


public class UserManager {
	FacadeData facadeData = new FacadeData();

	public void toto() {
		System.out.println("UserManager");
		facadeData.toto();
		
	}

	public void Inscription(String text, String text2, String text3,
			String text4, String text5, String text6, String text7,
			String text8, String text9) {
		facadeData.Inscription( text,  text2,  text3,
				 text4,  text5,  text6,  text7,
				 text8,  text9);
		// TODO Auto-generated method stub
		
	}
}
