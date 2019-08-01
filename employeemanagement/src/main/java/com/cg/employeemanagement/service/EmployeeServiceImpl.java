package com.cg.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeemanagement.dao.EmployeeRepository;
import com.cg.employeemanagement.dto.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepository;

	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		return employeerepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeerepository.save(emp);
	}

	@Override
	public Employee searchByEmployeeId(int empId) {
		// TODO Auto-generated method stub
		Employee id = employeerepository.findById(empId).get();
		return id;
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		employeerepository.deleteById(empId);
		
	}

	@Override
	/*public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeerepository.save(emp);
		return emp;
	}*/
	public Employee updateEmployee(Employee emp) {
	// TODO Auto-generated method stub
	Optional<Employee> pro1=employeerepository.findById(emp.getEmpId());
	        Employee pro=pro1.get();
	  pro.setEmpName(emp.getEmpName()); 
	  pro.setEmpSalary(emp.getEmpSalary());
	  employeerepository.save(pro);
	return emp;

	}

}
