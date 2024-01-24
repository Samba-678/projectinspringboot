package com.samba.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samba.springboot.exception.ResourceNotFoundException;
import com.samba.springboot.model.Employee;
import com.samba.springboot.repository.EmployeeRepository;

@CrossOrigin("*") // *-> any client can able to access restapi
//@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// @path variable:-used to retrive data(values) from url path ,we can bind url
	// placeholders to () parameters annoted with path variable
	// @request body;-is used to receive entire data as Http request

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();

	}

	// build create employee REST API
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);

	}

	// build get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
		return ResponseEntity.ok(employee);
	}

	// build update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setEmailId(employeeDetails.getEmailId());
		employeeRepository.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);

	}

	// build delete employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
		Employee deleteEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));

		employeeRepository.delete(deleteEmployee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
