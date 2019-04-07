package com.capgemini.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private String empId;
	
	private String fullName;
	private String email;
	private long contact;
	private String role;
	private String password;
	

	public Employee(String empId, String fullName, String email, long contact, String role, String password) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.email = email;
		this.contact = contact;
		this.role = role;
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	
}
