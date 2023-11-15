package com.mindgate.main.domain;

public class Employees {
	private int employeeId;
	private String employeeName;
	private String role;
	private int managerId;
	private Slab slab;
	private String projectName;
	private String email;
	private String employeePassword;
	private String loginStatus;
	private int count;
	
	public Employees() {
		
	}

	public Employees(int employeeId, String employeeName, String role, int managerId, Slab slab, String projectName,
			String email, String employeePassword, String loginStatus, int count) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.role = role;
		this.managerId = managerId;
		this.slab = slab;
		this.projectName = projectName;
		this.email = email;
		this.employeePassword = employeePassword;
		this.loginStatus = loginStatus;
		this.count = count;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Slab getSlab() {
		return slab;
	}

	public void setSlab(Slab slab) {
		this.slab = slab;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", employeeName=" + employeeName + ", role=" + role
				+ ", managerId=" + managerId + ", slab=" + slab + ", projectName=" + projectName + ", email=" + email
				+ ", employeePassword=" + employeePassword + ", loginStatus=" + loginStatus + ", count=" + count + "]";
	}

	
}
