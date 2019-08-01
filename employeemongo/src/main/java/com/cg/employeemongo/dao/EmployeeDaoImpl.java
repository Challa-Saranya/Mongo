package com.cg.employeemongo.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.employeemongo.dto.Employee;
import com.mongodb.client.result.DeleteResult;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	MongoTemplate mongotemplate;

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return mongotemplate.insert(emp);
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		return mongotemplate.findAll(Employee.class);
	}

	@Override
	public Employee searchEmployeeById(int empId) {
		// TODO Auto-generated method stub
	
		 Employee emp=mongotemplate.findById(empId,Employee.class); return emp;
		 
		//Query query=Query.query(Criteria.where("empId").is(empId));
		/*
		 * Query query=Query.query(Criteria.where("empSalary").gte(5000));
		 * List<Employee> emp= mongotemplate.find(query,
		 * Employee.class,"employee_mongo"); return emp;
		 */
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		//System.out.println("In Dao..."+emp);
		 return mongotemplate.save(emp);
		 
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		Employee emp=mongotemplate.findById(empId,Employee.class);
		mongotemplate.remove(emp);
		
		
	}

}
