package com.capgemini.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyEmployeeExistException extends RuntimeException {

	public AlreadyEmployeeExistException(String errorMessage) {
		super(errorMessage);
	}
}
