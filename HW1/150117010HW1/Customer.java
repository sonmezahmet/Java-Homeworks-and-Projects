import java.util.ArrayList;
import java.util.Calendar;

/*
• Each Customer can be created with one of the given two constructors.
• In Customer’s constructor, you are supposed to call the super class’s constructor.
• Each Customer has a list of products that he/she bought.
• There are setter/getter and toString() methods.
*/

public class Customer extends Person {
	private ArrayList<Product> products;
	
	public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, ArrayList<Product> products) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
		products = new ArrayList<Product> ();
		products.addAll(products);
	}
	public Customer(Person person, ArrayList<Product> products) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMarialStatus(), person.getHasDriverLicense());
		this.products = products;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Customer [id: " + getId() + " " + "products=" + products + "]";
	}
	
	
}
