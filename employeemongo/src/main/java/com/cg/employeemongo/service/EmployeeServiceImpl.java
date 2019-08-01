package com.cg.employeemongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeemongo.dao.EmployeeDao;
import com.cg.employeemongo.dto.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeedao;

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeedao.addEmployee(emp);
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		return employeedao.showAllEmployee();
	}

	@Override
	public Employee searchEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeedao.searchEmployeeById(empId);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeedao.updateEmployee(emp);
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		employeedao.deleteEmployee(empId);
		
	}

}
