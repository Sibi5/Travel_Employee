package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Employees;
import com.mindgate.main.domain.Slab;

public class EmployeesRowMapper implements RowMapper<Employees> {

	@Override
	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {

		int slabId = rs.getInt("slab_id");
		String employeeCategory = rs.getString("employee_category");
		double maxBudget = rs.getDouble("max_budget");
		String internationalTravelAllowed = rs.getString("international_travel_allowed");
		String flightTravelAllowed = rs.getString("flight_travel_allowed");

		Slab slab = new Slab(slabId, employeeCategory, maxBudget, internationalTravelAllowed, flightTravelAllowed);

		int employeeId = rs.getInt("employee_id");
		String employeeName = rs.getString("employee_name");
		String role = rs.getString("role");
		int managerId = rs.getInt("manager_id");

		String projectName = rs.getString("project_name");
		String email = rs.getNString("email");
		String employeePassword = rs.getString("employee_password");
		String loginStatus = rs.getString("login_status");
		int count = rs.getInt("count");

		Employees employees = new Employees(employeeId, employeeName, role, managerId, slab, projectName, email,
				employeePassword, loginStatus, count);
		return employees;
	}

}
