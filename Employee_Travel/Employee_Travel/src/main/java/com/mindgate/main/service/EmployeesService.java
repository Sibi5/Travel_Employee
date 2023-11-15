package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Employees;
import com.mindgate.main.repository.EmployeesRepositoryInterface;

@Service
public class EmployeesService implements EmployeesServiceInterface {
	
	@Autowired
	EmployeesRepositoryInterface employeesRepositoryInterface;
	
	@Override
	public boolean addNewEmployee(Employees employees) {
		// TODO Auto-generated method stub
		return employeesRepositoryInterface.addNewEmployee(employees);
	}

	@Override
	public Employees updateEmployee(Employees employees) {
		// TODO Auto-generated method stub
		return employeesRepositoryInterface.updateEmployee(employees);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeesRepositoryInterface.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public Employees getEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeesRepositoryInterface.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeesRepositoryInterface.getAllEmployees();
	}

	@Override
	public Employees login(Employees employees) {
		Employees existing_employee = employeesRepositoryInterface.getEmployeeByEmail(employees.getEmail());
		if(existing_employee!=null) {
			if(existing_employee.getCount()>=3 || existing_employee.getLoginStatus().equalsIgnoreCase("blocked")) {
				employees.setEmployeePassword("");
				employees.setCount(existing_employee.getCount());
				employees.setLoginStatus(existing_employee.getLoginStatus());
				return employees;
			}else {
				if(existing_employee.getEmployeePassword().equals(employees.getEmployeePassword())) {
					employeesRepositoryInterface.updateCount(0, existing_employee.getEmail());
					existing_employee.setEmployeePassword("");
					existing_employee.setCount(0);
					return existing_employee;
				}else {
					employeesRepositoryInterface.updateCount(existing_employee.getCount()+1, existing_employee.getEmail());
					employees.setEmployeePassword("");
					employees.setCount(existing_employee.getCount()+1);
					
					employees.setLoginStatus(existing_employee.getCount()+1 < 3 ? existing_employee.getLoginStatus(): "blocked");
					return employees;
				}
			}
		}else {
			employees.setEmployeePassword("");
			employees.setCount(0);
			return employees;
		}
		
	}

}
