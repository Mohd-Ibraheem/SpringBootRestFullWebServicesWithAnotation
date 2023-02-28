package com.student.springboot.service;

import java.util.List;

import com.student.springboot.model.Employee;

public interface EmployeeServices {

	//save Employee
	Employee saveEmployee(Employee employee);
	
	//get all employee
	List<Employee> getAllEmployee();
	
	//get single employee by id
	Employee  getEmployeeById(long id);
	
	//update Employee by id
	Employee updateEmployee(Employee employee, long id);

	//deleta employee by id
	void deleteEmployee(long id);
}
