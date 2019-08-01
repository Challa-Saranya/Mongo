package com.cg.employeemanagement.service;

import java.util.List;

import com.cg.employeemanagement.dto.Employee;

public interface EmployeeService {
	public List<Employee> showAllEmployee();
	public Employee addEmployee(Employee emp);
	public Employee searchByEmployeeId(int empId);
	public void deleteEmployee(int empId);
	public Employee updateEmployee(Employee emp);

}
