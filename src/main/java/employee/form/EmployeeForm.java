package employee.form;

public class EmployeeForm {
	private String employeeId;
	private String name;
	private int age;
	private String department;

	// 社員ID
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	// 名前
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 年齢
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 部署
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String departmenr) {
		this.department = departmenr;
	}
}
