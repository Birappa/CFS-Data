package com.cfs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cfs.model.Employee;
import com.cfs.model.Feedback;
import com.cfs.model.Response;

@ControllerAdvice
public class ControllerErrorHandler {

	@ExceptionHandler(EmployeeNotExistException.class)
	public Response<Employee> handleEmployeeNotExistException(EmployeeNotExistException exception) {

		return new Response<Employee>(null, HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}

	@ExceptionHandler(AlreadyEmployeeExistException.class)
	public Response<Employee> handleAlreadyEmployeeExistException(AlreadyEmployeeExistException exception) {

		return new Response<Employee>(null, HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}
	
	@ExceptionHandler(SequenceException.class)
	public Response<Feedback> handleSequenceException(SequenceException exception){
		
		return new Response<Feedback>(null, HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}
	
	@ExceptionHandler(FeedbackNotFoundException.class)
	public Response<Feedback> handleFeedbackNotFoundException(FeedbackNotFoundException exception){
		
		return new Response<Feedback>(null, HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
	
	@ExceptionHandler(FeedbackDatabaseException.class)
	public Response<Feedback> handleFeedbackDatabaseException(FeedbackDatabaseException exception){
		
		return new Response<Feedback>(null, HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public Response<Employee> handleAllExceptions(Exception exception) {

		return new Response<Employee>(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());

	}
}
