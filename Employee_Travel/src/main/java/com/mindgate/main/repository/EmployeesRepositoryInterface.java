package com.mindgate.main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Employees;

@Repository
public interface EmployeesRepositoryInterface {
	public boolean addNewEmployee(Employees employees);
	public Employees updateEmployee(Employees employees );
	public boolean deleteEmployeeByEmployeeId(int employeeId);
	public Employees getEmployeeByEmployeeId(int employeeId);
	public List<Employees> getAllEmployees();
	public boolean updateCount(int count, String email);
	public Employees getEmployeeByEmail(String email);
}
