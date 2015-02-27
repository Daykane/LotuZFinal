package Model;

public class User {
	
	/*
	 * Attribut
	 */
	private String lastname;
	private String firstName;
	private String mail;
	private String phone;
	private String streetName;
	private int numHouse;
	private int postCode;
	private String city;	

	/*
	 * Getter / Setter
	 */	
	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	
	public String getStreetName() {return streetName;}
	public void setStreetName(String streetName) {this.streetName = streetName;}
	
	public int getNumHouse() {return numHouse;}
	public void setNumHouse(int numHouse) {this.numHouse = numHouse;}
	
	public int getPostCode() {return postCode;}
	public void setPostCode(int postCode) {this.postCode = postCode;}
	
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	
	/*
	 * Constructor
	 */
	
	// Construtor complete
	public User(String lastname, String firstName, String mail,
			String phone, String streetName, int numHouse, int postCode,
			String city) {
		super();
		this.lastname = lastname;
		this.firstName = firstName;
		this.mail = mail;
		this.phone = phone;
		this.streetName = streetName;
		this.numHouse = numHouse;
		this.postCode = postCode;
		this.city = city;
	}
	
	// Constructor without phone
	public User(String lastname, String firstName, String mail, String streetName, int numHouse, int postCode,
			String city) {
		super();
		this.lastname = lastname;
		this.firstName = firstName;
		this.mail = mail;
		this.streetName = streetName;
		this.numHouse = numHouse;
		this.postCode = postCode;
		this.city = city;
	}
	

	
}
