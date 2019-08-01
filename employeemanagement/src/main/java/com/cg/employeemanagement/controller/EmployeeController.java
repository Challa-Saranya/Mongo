package com.cg.employeemanagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeemanagement.dto.Employee;
import com.cg.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/emplist")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	//@RequestMapping(value="/getalldata",method = RequestMethod.GET)
	@GetMapping("/getalldata")
	public ResponseEntity<List<Employee>> getAllEnployees() {
		List<Employee> myList=employeeservice.showAllEmployee();
		if(myList.isEmpty()) {
			return new ResponseEntity("No Employee Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(myList,HttpStatus.OK);
		
	}
	@PostMapping("/adddata")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee data=employeeservice.addEmployee(emp);
		if(data==null) {
			return new ResponseEntity("Data Not Added", HttpStatus.NOT_FOUND);
		}
		
		 return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}

	/*
	 * @RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
	 * public Employee updateProduct(@RequestBody Employee employee) { return
	 * employeeservice.updateEmployee(employee); }
	 */
	@PostMapping("/updateData")
	public ResponseEntity<Employee> update(@RequestBody Employee emp) {
		Employee data=employeeservice.updateEmployee(emp);
		if(data==null) {
		return new ResponseEntity("data not added",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
	@RequestMapping(value="/searchemployee/{eid}",method=RequestMethod.GET)
	public Employee searchemployee(@PathVariable("eid") Integer employeeid)
	{
	return employeeservice.searchByEmployeeId(employeeid);
	}
	@RequestMapping(value = "/deletemployee/{eid}", method = RequestMethod.DELETE)
	public String delProduct(@PathVariable("eid") Integer employeeid) {
	employeeservice.deleteEmployee(employeeid);
	return  employeeid+" is deleted";
	}

}
