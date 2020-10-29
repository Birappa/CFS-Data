package com.cfs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotExistException extends RuntimeException {

	public EmployeeNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
