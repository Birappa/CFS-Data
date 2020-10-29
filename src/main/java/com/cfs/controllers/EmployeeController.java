package com.cfs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfs.exception.AlreadyEmployeeExistException;
import com.cfs.exception.EmployeeNotExistException;
import com.cfs.model.Employee;
import com.cfs.model.Response;

@RestController
public class EmployeeController {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	
	//returns employee object from employee collection that matches the id
	@GetMapping("/employee/{empId}")
	public Response<Employee> getEmployeeById(@PathVariable long empId) {

		Employee employee=mongoTemplate.findById(empId, Employee.class);
		if(employee==null) {
			throw new EmployeeNotExistException("Employee Not Exist");
		}
		
		return new Response<Employee>(employee, HttpStatus.OK.value(), "success");
	}

	//save the provided employee object in employee collection and returns same object back
	@PostMapping("/employee")
	public Response<Employee> saveEmployee(@RequestBody Employee newEmployee) {
		
		Employee employee=mongoTemplate.findById(newEmployee.getEmpId(), Employee.class);
		
		if(employee!=null) {
			throw new AlreadyEmployeeExistException("Already Employee Exist");
		}
		
		employee=mongoTemplate.save(newEmployee);
		return new Response<Employee>(employee, HttpStatus.OK.value(), "success");
		
	}
	
}

