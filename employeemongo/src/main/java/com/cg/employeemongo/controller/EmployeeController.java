package com.cg.employeemongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeemongo.dto.Employee;
import com.cg.employeemongo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping("/getall")
	public ResponseEntity <List<Employee>> getAllEmployee(){
		List<Employee> myList= employeeservice.showAllEmployee();
		if(myList.isEmpty()) {
			return new ResponseEntity("No Employee Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(myList,HttpStatus.OK);
		
		
	}
	@PostMapping("/addall")
	public ResponseEntity<Employee> addAllEmployee(@RequestBody Employee emp) {
		Employee data= employeeservice.addEmployee(emp);
		if(data==null) {
			return new ResponseEntity("Data Not Added", HttpStatus.NOT_FOUND);
		}
		
		 return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	@PutMapping("/updateall")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee data= employeeservice.updateEmployee(emp);
		if(data==null) {
			return new ResponseEntity("data not added",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete")
	public void deleteEmployee(@RequestParam("eid") int empId) {
		employeeservice.deleteEmployee(empId);
	}
	@GetMapping("/search")
	public ResponseEntity<Employee> searchEmployeeById(@RequestParam("eid") int empId) {
		Employee data= employeeservice.searchEmployeeById(empId);
		if(data==null) {
			return new ResponseEntity("data not found",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Employee>(data,HttpStatus.OK);
		
		
	}

}
