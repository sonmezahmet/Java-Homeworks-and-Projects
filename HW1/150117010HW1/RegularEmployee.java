import java.util.Calendar;
/*
• RegularEmployee is the superclass of SalesEmployee and Developer classes.
• Each RegularEmployee has a performanceScore and an amount of bonus, which will be
given by his/her manager based on the performance score.
• Each RegularEmployee can be created with one of the given two constructors.
o In RegularEmployee ‘s constructor, you are supposed to call the super class’s
constructor.
• There are setter/getter and toString() methods.
 */

public class RegularEmployee extends Employee {
	private double performanceScore;
	private double bonus;
	
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department, double performanceScore) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department);
		setPerformanceScore(performanceScore);
	}
	public RegularEmployee(Employee employee, double performanceScore) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMarialStatus(), employee.getHasDriverLicense(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setPerformanceScore(performanceScore);
	}
	public double getPerformanceScore() {
		return performanceScore;
	}
	public void setPerformanceScore(double performanceScore) throws Exception {
		if (performanceScore < 0) {
			throw new Exception("Invalid performanceScore");
		}
		else {
			this.performanceScore = performanceScore;
		}
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) throws Exception {
		if (bonus < 0) {
			throw new Exception("Invalid bonus");
		}
		else {
			this.bonus = bonus;
		}
	}
	@Override
	public String toString() {
		return super.toString() + "				RegularEmployee Info [performanceScore=" + performanceScore + ", bonus=" + bonus + "]";
	}
}
