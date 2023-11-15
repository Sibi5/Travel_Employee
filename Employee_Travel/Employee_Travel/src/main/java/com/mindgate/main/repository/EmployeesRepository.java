package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Employees;

@Repository
public class EmployeesRepository implements EmployeesRepositoryInterface {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	private final static String INSERT_NEW_EMPLOYEE="insert into employees(employee_id,employee_name,role,manager_id,project_name,email,employee_password,login_status,count) values(employee_id_sequence.nextVal,?,?,?,?,?,?,?,?,?)";   
	private final static String INSERT_NEW_EMPLOYEE="insert into employees values(employee_id_sequence.nextVal,?,?,?,?,?,?,?,?,?)";   
	private final static String UPDATE_EXISTING_EMPLOYEE ="update employees set employee_name=?,role=?,manager_id=?,project_name=?,email=?,employee_password=? where employee_id=?";
	private final static String DELETE_EXISTING_EMPLOYEE="delete from employees where employee_id=?";
	private final static String SELECT_ALL_EMPLOYEE="select * from employees join slab using (slab_id)";
	private final static String SELECT_ONE_EMPLOYEE="select * from employees join slab using (slab_id) where employee_id=?";
	private final static String SELECT_ONE_EMPLOYEE_BY_EMAIL="select * from employees join slab using (slab_id) where email=?";
	private final static String UPDATE_LOGIN_COUNT = "update employees set count=?, login_status=? where email=?";
	
	@Override
	public List<Employees> getAllEmployees() {
			
		EmployeesRowMapper employeesRowMapper = new EmployeesRowMapper();
		List<Employees> employeesList = jdbcTemplate.query(SELECT_ALL_EMPLOYEE, employeesRowMapper);
		return employeesList;
	}
	
	@Override
	public Employees getEmployeeByEmployeeId(int employeeId) {
		EmployeesRowMapper employeesRowMapper=new EmployeesRowMapper();
		Employees employees=jdbcTemplate.queryForObject(SELECT_ONE_EMPLOYEE, employeesRowMapper,employeeId);
		return employees;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		int rowCount=jdbcTemplate.update(DELETE_EXISTING_EMPLOYEE,employeeId);
		if (rowCount>0) {
			return true;
		}
		else {
		return false;
		}
	}

	
	
	@Override
    public boolean addNewEmployee(Employees employees) {
        Object [] parameter={employees.getEmployeeName(),employees.getRole()
                ,employees.getManagerId(),employees.getSlab().getSlabId(),
                employees.getProjectName(),employees.getEmail(),
                employees.getEmployeePassword(),employees.getLoginStatus(),
                employees.getCount()};        
        int rowCount = jdbcTemplate.update(INSERT_NEW_EMPLOYEE, parameter);
        if (rowCount > 0)
            return true;
        else
            return false;
    }

	@Override
    public Employees updateEmployee(Employees employees) {
        Object [] parameter= {employees.getEmployeeName(),
                employees.getRole()
                ,employees.getManagerId(),
                employees.getProjectName(),
                employees.getEmail(),
                employees.getEmployeePassword(),employees.getEmployeeId()}; 
        int rowCount = jdbcTemplate.update(UPDATE_EXISTING_EMPLOYEE, parameter);
        
        if (rowCount > 0)
            return employees;
        else
            return employees;
    }

	@Override
	public boolean updateCount(int count, String email) {
		String status = count<3 ? "active" : "blocked";
		Object[] parameters = {count, status, email};
		int rowCount = jdbcTemplate.update(UPDATE_LOGIN_COUNT, parameters);
		if (rowCount > 0)
            return true;
        else
            return false;
	}
	
	@Override
	public Employees getEmployeeByEmail(String email) {
		EmployeesRowMapper employeesRowMapper=new EmployeesRowMapper();
		try {
		Employees employees=jdbcTemplate.queryForObject(SELECT_ONE_EMPLOYEE_BY_EMAIL, employeesRowMapper, email);
		return employees;
		}catch (Exception e) {
			return null;
		}
	}
	

		
}
