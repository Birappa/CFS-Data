package com.cfs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FeedbackDatabaseException extends RuntimeException {

	public FeedbackDatabaseException(String message) {
		super(message);
	}
}
