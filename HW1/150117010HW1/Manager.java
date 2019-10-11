import java.util.ArrayList;
import java.util.Calendar;
/*
• Each Manager has a set of regularEmployees working in his/her department and a
bonusBudget to distribute to the regular employees in the department.
• Each Manager can be created with one of the given two constructors.
o In Manager’s constructor, you are supposed to call the super class’s constructor.
• In addEmployee method, you should add the given RegularEmployee e to the list of
regularEmployees.
• In removeEmployee method, you should remove the given RegularEmployee e from the
list of regularEmployees.
• Each Manager has bonusBudget to distribute it to the regular employees working in
his/her department. The distribution will be based on the given formula:
o Suppose that the bonus budget of the manager is 10000 and there are 4 regular
employees in the department with the following salaries and performance scores:
▪ E1 → salary: 1000, performanceScore:50
▪ E2 → salary: 2000, performanceScore:50
▪ E3 → salary: 6000, performanceScore:75
▪ E4 → salary: 4000, performanceScore:100
o Then, the bonus value of each regular employee is:
▪ bonus = unit * salary * performanceScore
▪ unit = bonusBudget / Σ(𝐬𝐚𝐥𝐚𝐫𝐲 ∗ 𝐩𝐞𝐫𝐟𝐨𝐫𝐦𝐚𝐧𝐜𝐞𝐒𝐜𝐨𝐫𝐞)
o Based on the example above, the bonus value for each regular employee is:
▪ E1 → bonus: 500
▪ E2 → bonus: 1000
▪ E3 → bonus: 4500
▪ E4 → bonus: 4000
• There are setter/getter and toString() methods.
 */
public class Manager extends Employee {
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
	private double bonusBudget;
	
	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setBonusBudget(bonusBudget);
	}
	
	public Manager(Employee employee, double bonusBudget) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMarialStatus(), employee.getHasDriverLicense(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		this.bonusBudget = bonusBudget;
	}
	
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}
	
	public void distributeBonusBudget() throws Exception {
		int size = regularEmployees.size();
		double unit;
		double unitWithoutBonusBudget = 0;
		for (int i = 0 ; i < size ; i++) {
			unitWithoutBonusBudget += regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
		}
		unit = bonusBudget / unitWithoutBonusBudget;
		
		for (int i = 0 ; i < size ; i++) {
			regularEmployees.get(i).setBonus(unit * regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore());
		}
	}

	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	public double getBonusBudget() {
		return bonusBudget;
	}

	public void setBonusBudget(double bonusBudget) throws Exception {
		if (bonusBudget < 0) {
			throw new Exception("Invalid bonusBudget");
		}
		else {
			this.bonusBudget = bonusBudget;
		}
	}

	@Override
	public String toString() {
		return "Manager [id: " + getId() + ", " + getFirstName() + " " + getLastName() +  "			# of Employees: " + regularEmployees.size() + "]";
	}
}
