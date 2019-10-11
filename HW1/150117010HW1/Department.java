/*
• Each Department has an id and a name data fields.
• There are setter/getter and toString() methods.
*/
public class Department {
	private int departmentId;
	private String derpartmentName;
	
	public Department(int departmentId, String departmentName) throws Exception {
		setDepartmentId(departmentId);
		setDerpartmentName(departmentName);
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) throws Exception {
		if (departmentId < 0) {
			throw new Exception("Invalid departmentId");
		}
		else {
			this.departmentId = departmentId;
		}
	}

	public String getDerpartmentName() {
		return derpartmentName;
	}

	public void setDerpartmentName(String derpartmentName) throws Exception {
		if (derpartmentName.length() < 3) {
			throw new Exception("Invalid departmentName");
		}
		else {
			this.derpartmentName = derpartmentName;	
		}
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", derpartmentName=" + derpartmentName + "]";
	}
	
}
