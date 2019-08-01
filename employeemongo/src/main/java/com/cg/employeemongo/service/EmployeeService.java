package com.cg.employeemongo.service;

import java.util.List;

import com.cg.employeemongo.dto.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);
	public List<Employee> showAllEmployee();
	public Employee searchEmployeeById(int empId);
	public Employee updateEmployee(Employee emp);
	public void deleteEmployee(int empId);
		
	

}
