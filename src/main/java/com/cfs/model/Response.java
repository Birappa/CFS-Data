package com.cfs.model;

public class Response<T> { 
	
	private T object;
	private int status;
	private String message;
	
	public Response(T object, int status, String message) {
		super();
		this.object = object;
		this.status = status;
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
