
import java.util.Calendar;
/*
Each Project has a name, startDate and state data fields. If the Project is open, state
should be true; otherwise, false.
• In setState method, a string value (“Open” or “Close”) is given, and the method should set
the state as true or false.
• In getState method, a string value (“Open” or “Close”) should be returned based on the
state value.
• In close method, you should close the project if it is open.
• There are setter/getter and toString() methods.
 */
public class Project {
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;
	
	public Project(String pName, Calendar startDate, String state) throws Exception {
		projectName = pName;
		if (projectName.length() < 3) {
			throw new Exception();
		}
		this.startDate = startDate;
		setState(state);
	}
	public void setState(String state) throws Exception {
		if (state.equals("Open")) {
			this.state = true;
		}
		else if (state.equals("Close")) {
			this.state = false;
		}
		else {
			throw new Exception();
		}
	}
	public String getState() {
		if (state == true) {
			return "Open";
		}
		else {
			return "Close";
		}
	}
	public void close() {
		if (state == true) {
			state = false;
		}
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public java.util.Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Calendar startDate) {
		this.startDate = startDate;
	}
	@Override
	public String toString() {
		if (startDate.get(Calendar.MONTH) == 0) {
			return "Project [projectName=" + projectName + ", startDate=" + startDate.get(Calendar.DAY_OF_MONTH) + "/" + (startDate.get(Calendar.MONTH) + 12) + "/" + (startDate.get(Calendar.YEAR) - 1) + ", state=" + state + "]";
		}
		else {
			return "Project [projectName=" + projectName + ", startDate=" + startDate.get(Calendar.DAY_OF_MONTH) + "/" + startDate.get(Calendar.MONTH) + "/" + startDate.get(Calendar.YEAR) + ", state=" + state + "]";
		}
		
	}
	
}
