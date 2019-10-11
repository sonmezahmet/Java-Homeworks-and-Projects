import java.util.Calendar;

/*
• Person is the superclass of Customer and Employee classes.
• Person class has several data fields, getter/setter and toString methods.
• Each person should have an id, a name, a surname, a gender (1: woman, 2: man), birthDate
(05/05/2000), maritalStatus (1: single, 2:married) and hasDriverLicense attributes.
• Since the parameter/return value types are different for getter/setter methods of gender,
maritalStatus, and hasDriverLicence attributes, we show them in the UML diagram. You
are responsible for implementing getter/setter methods of all data fields.
• In setGender method, a string value (“Man” or “Woman”) is given, and the method
should set the gender as 1 or 2.
• In getGender method, a string value (“Man” or “Woman”) should be returned based on
the gender value.
• In setMaritalStatus method, a string value (“Single” or “Married”) is given, and the
method should set the maritalStatus as 1 or 2.
• In getMaritalStatus method, a string value (“Single” or “Married”) should be returned
based on the maritalStatus value.
• In setHasDriverLicence method, a string value (“Yes” or “No”) is given, and the method
should set the hasDriverLicence as true or false.
• In getHasDriverLicence method, a string value (“Yes” or “No”) should be returned based
on the hasDriverLicence value.
• There are setter/getter and toString() methods.
*/
public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicense;

	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicense) throws Exception {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setBirthDate(birthDate);
		setMarialStatus(maritalStatus);
		setHasDriverLicense(hasDriverLicense);
	}

	public String getGender() {
		if (gender == 1) {
			return "Woman";
		}
		else {
			return "Man";
		}
	}

	public void setGender(String gender) throws Exception {
		if (gender.equals("Woman")) {
			this.gender = 1;
		}
		else if (gender.equals("Man")){
			this.gender = 2;
		}
		else {
			throw new Exception("Invalid gender");
		}
	}

	public String getMarialStatus() {
		if (maritalStatus == 1) {
			return "Single";
		}
		else {
			return "Married";
		}
	}

	public void setMarialStatus(String status) throws Exception {
		if (status.equals("Single")) {
			this.maritalStatus = 1;
		}
		else if (status.equals("Married")){
			this.maritalStatus = 2;
		}
		else {
			throw new Exception("Invalid maritalStatus");
		}
	}

	public String getHasDriverLicense() {
		if (hasDriverLicense == true) {
			return "Yes";
		}
		else {
			return "No";
		}
	}

	public void setHasDriverLicense(String info) throws Exception {
		if (info.equals("Yes")) {
			this.hasDriverLicense = true;
		}
		else if (info.equals("No")) {
			this.hasDriverLicense = false;
		}
		else {
			throw new Exception("Invalid hasDriverLicense");
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		this.id = id;
		if (id < 0) {
			throw new Exception();
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		this.firstName = firstName;
		if (firstName.length() < 3) {
			throw new Exception("Invalid firstName");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws Exception {
		this.lastName = lastName;
		if (lastName.length() < 3) {
			throw new Exception("Invalid LastName");
		}
	}

	public java.util.Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person Info [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender() + "]";
	}


}
