import java.util.ArrayList;
import java.util.Calendar;
/*
• Each Developer has a set of projects that the developer works on and a
numberOfDevelopers data fields.
• Each Developer can be created with one of the given two constructors.
o In Developer’s constructor, you are supposed to call the super class’s constructor.
o When you create a new Developer, you should increment numberOfDevelopers
value by 1.
• In addProject method, you should add the given Projects s to the list of projects.
• In removeProject method, you should remove the given Product s from the list of
projects.
• There are setter/getter and toString() methods.
 */
public class Developer extends RegularEmployee {
	private ArrayList<Project> projects;
	public static int numberOfDevelopers;
	
	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department, double performanceScore, ArrayList<Project> p) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department, performanceScore);
		projects = p;
	}
	
	public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMarialStatus(), re.getHasDriverLicense(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		projects = p;
	}
	
	public boolean addProject(Project s) {
		projects.add(s);
		return true;
	}
	
	public boolean removeProject(Project s) {
		projects.remove(s);
		return false;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}

	public static void setNumberOfDevelopers(int numberOfDevelopers) {
		Developer.numberOfDevelopers = numberOfDevelopers;
	}

	@Override
	public String toString() {
		return super.toString() + "				[projects=" + projects + "]";
	}
	
}
