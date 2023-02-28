package com.student.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.springboot.exception.PageNotFoundException;
import com.student.springboot.model.Employee;
import com.student.springboot.repository.EmployeeRepository;
import com.student.springboot.service.EmployeeServices;

@Service
public class EmployeeServiceImpl implements EmployeeServices{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
	return employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
		
	}

	@Override
	public Employee getEmployeeById(long id) {
	Optional<Employee> employee = employeeRepository.findById(id);
	if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new PageNotFoundException("Employee","id",id);
	}
//		return employeeRepository.findById(id).orElse(()-> new PageNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee employee1=employeeRepository.findById(id).orElseThrow(
				()-> new PageNotFoundException("Employee", "id", id));
		
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setEmail(employee.getEmail());
		employeeRepository.save(employee1);
		return employee1;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(
				()->new PageNotFoundException("Employee", "id", id));

		this.employeeRepository.deleteById(id);
		
	}

	

}
