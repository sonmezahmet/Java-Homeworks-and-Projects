import java.util.Calendar;

/*
• Employee is the superclass of Manager and RegularEmployee classes.
• Each Employee has a salary, a hireDate (the date when the employee starts to the job), a
department and numberofEmployees data fields.
• Each Employee can be created with one of the given two constructors.
o In Employee’s constructor, you are supposed to call the super class’s constructor.
o When a new employee is created, you should increment the value of
numberofEmployees by 1.
• There are two overloaded implementations of raiseSalary method.
o In the first one, take the increment value as a double (0 >= percent >= 1) and raise
the salary value based on the percentage value. For example, if the percent value
is 0.5, increment the salary of the employee by 50%.
o In the second one, raise the salary of the employee by the given fixed amount.
• There are setter/getter and toString() methods. 
*/
public class Employee extends Person {
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public static int numberOfEmployee;
	
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		numberOfEmployee++;
	}
	
	public Employee(Person person, double salary, Calendar hireDate, Department department) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMarialStatus(), person.getHasDriverLicense());
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		numberOfEmployee++;
	}
	
	public double raiseSalary(double percent) throws Exception {
		if (percent > 1) {
			throw new Exception("Invalid percent");
		}
		else {
			salary += salary * percent;
		}
		return salary;
	}
	
	public double raiseSalary(int amount) throws Exception {
		if (amount < 0) {
			throw new Exception("Invalid amount");
		}
		else {
			salary += amount;
		}
		return salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws Exception {
		if (salary < 0) {
			throw new Exception("Invalid salary");
		}
		else {
			this.salary = salary;
		}
	}

	public java.util.Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public static int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	@Override
	public String toString() {
		if (hireDate.get(Calendar.MONTH) == 12) {
			return super.toString() + "				Employee Info [salary=" + salary + ", hireDate=" + hireDate.get(Calendar.DATE) + "/" + (hireDate.get(Calendar.MONTH) + 12) + "/" + (hireDate.get(Calendar.YEAR) - 1) + "]";
		}
		else {
			return super.toString() + "				Employee Info [salary=" + salary + ", hireDate=" + hireDate.get(Calendar.DATE) + "/" + hireDate.get(Calendar.MONTH) + "/" + hireDate.get(Calendar.YEAR) + "]";
		}
	}
}
