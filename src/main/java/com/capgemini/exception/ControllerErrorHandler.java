package com.capgemini.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.model.Employee;

@ControllerAdvice
public class ControllerErrorHandler {

	@ExceptionHandler(EmployeeNotExistException.class)
	public ResponseEntity<Employee> handleUserNotExistException(EmployeeNotExistException exception) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("message", exception.getMessage());
		Employee employee=null;
		return new ResponseEntity<>(employee, responseHeaders, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AlreadyEmployeeExistException.class)
	public ResponseEntity<Employee> handleAlreadyUserExistException(AlreadyEmployeeExistException exception) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("message", exception.getMessage());
		Employee employee=null;
		return new ResponseEntity<>(employee, responseHeaders, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Employee> handleAllExceptions(Exception exception) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("message", exception.getMessage());
		Employee employee=null;
		return new ResponseEntity<>(employee, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
