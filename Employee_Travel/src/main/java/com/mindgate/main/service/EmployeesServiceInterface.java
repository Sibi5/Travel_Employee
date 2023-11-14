package com.mindgate.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Employees;

@Service
public interface EmployeesServiceInterface {
	public boolean addNewEmployee(Employees employees);
	public Employees updateEmployee(Employees employees );
	public boolean deleteEmployeeByEmployeeId(int employeeId);
	public Employees getEmployeeByEmployeeId(int employeeId);
	public List<Employees> getAllEmployees();
	public Employees login(Employees employees);

}
