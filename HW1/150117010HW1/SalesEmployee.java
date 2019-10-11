import java.util.ArrayList;
import java.util.Calendar;

/*
• Each SalesEmloyee has a set of sales that contains a product list that the SalesEmployee
sells and a numberOfSalesEmployees data fields.
• Each SalesEmloyee can be created with one of the given two constructors.
o In SalesEmloyee’s constructor, you are supposed to call the super class’s
constructor.
o When you create a new SalesEmloyee, you should increment
numberOfSalesEmployees value by 1.
• In addSale method, you should add the given Product s to the list of sales.
• In removeSale method, you should remove the given Product s from the list of sales
• There are setter/getter and toString() methods.
 */
public class SalesEmployee extends RegularEmployee {
	private ArrayList<Product> sales;
	public static int numberOfSalesEmployee;
	
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Product> s) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department, pScore);
		sales = s;
		numberOfSalesEmployee++;
	}
	
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMarialStatus(), re.getHasDriverLicense(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		sales = s;
		numberOfSalesEmployee++;
	}
	
	public boolean addSale(Product s) {
		sales.add(s);
		if (sales.contains(s)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeSale(Product s) {
		sales.remove(s);
		if (sales.contains(s)) {
			return false;
		}
		else {
			return true;
		}
	}

	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}

	public static int getNumberOfSalesEmployee() {
		return numberOfSalesEmployee;
	}

	public static void setNumberOfSalesEmployee(int numberOfSalesEmployee) {
		SalesEmployee.numberOfSalesEmployee = numberOfSalesEmployee;
	}

	@Override
	public String toString() {
		return super.toString() + "				[Product " + sales + "]";
	}
}
