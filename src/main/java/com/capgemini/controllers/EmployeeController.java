package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.AlreadyEmployeeExistException;
import com.capgemini.exception.EmployeeNotExistException;
import com.capgemini.model.Employee;

@RestController
public class EmployeeController {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	//returns employee object from employee collection that matches the id
	@PostMapping("/users/{id}")
	public ResponseEntity<Employee> getUserById(@PathVariable long empId) {

		Employee employee=mongoTemplate.findById(empId, Employee.class);
		if(employee==null) {
			throw new EmployeeNotExistException("Employee Not Exist");
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("message","Success");
		return new ResponseEntity<>(employee, responseHeaders, HttpStatus.OK);
	}

	//save the provided employee object in employee collection and returns same object back
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee newEmployee) {
		
		Employee employee=mongoTemplate.findById(newEmployee.getEmpId(), Employee.class);
		
		if(employee!=null) {
			throw new AlreadyEmployeeExistException("Already Employee Exist");
		}
		
		employee=mongoTemplate.save(newEmployee);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("message","Success");
		return new ResponseEntity<>(employee, responseHeaders, HttpStatus.OK);
		
	}
	
}

