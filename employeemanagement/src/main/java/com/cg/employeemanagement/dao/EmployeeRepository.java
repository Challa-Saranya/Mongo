package com.cg.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.employeemanagement.dto.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
