package com.student.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.springboot.exception.PageNotFoundException;
import com.student.springboot.model.Employee;
import com.student.springboot.service.EmployeeServices;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
 
	private static final int ResponseEntity = 0;
	private EmployeeServices employeeServices;

	public EmployeeController(EmployeeServices employeeServices) {
		super();
		this.employeeServices = employeeServices;
	}
	
	//build and create new employee
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeServices.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	//build and get all employee
	@GetMapping
	public List<Employee> getAllEmployee(){
		List<Employee> allEmployee = this.employeeServices.getAllEmployee();
		return allEmployee;
	}
	
	//build single Employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> saveEmployee(@PathVariable("id") Long id){
		return new ResponseEntity<Employee>(employeeServices.getEmployeeById(id),HttpStatus.OK);
	}
	
//	/built update Employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeServices.updateEmployee(employee, id),HttpStatus.OK);
	}
	
	//build and delete Employee
	@DeleteMapping("{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") long id) {
		
		employeeServices.deleteEmployee(id);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	

}
