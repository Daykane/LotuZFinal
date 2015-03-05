/**
 * 
 * @author Alexis
 *
 */

package Class;


public class User {

	private String lastName;
	private String firstName;
	private String streeName;
	private String numHouse;
	private String city;
	private String postCode;
	private String mail;
	
	
	public User() {
		super();
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param streeName
	 * @param numHouse
	 * @param city
	 * @param postCode
	 * @param mail
	 */
	public User(String lastName, String firstName, String streeName,
			String numHouse, String city, String postCode, String mail) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.streeName = streeName;
		this.numHouse = numHouse;
		this.city = city;
		this.postCode = postCode;
		this.mail = mail;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the streeName
	 */
	public String getStreeName() {
		return streeName;
	}

	/**
	 * @param streeName the streeName to set
	 */
	public void setStreeName(String streeName) {
		this.streeName = streeName;
	}

	/**
	 * @return the numHouse
	 */
	public String getNumHouse() {
		return numHouse;
	}

	/**
	 * @param numHouse the numHouse to set
	 */
	public void setNumHouse(String numHouse) {
		this.numHouse = numHouse;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}



}
