package com.cognizant.model;

public class UserRecord {
	
	public Long userId=0L;
	public String firstName="";
	public String lastName="";
	public String employeeId="";

	public UserRecord(Long userId, String firstName, String lastName, String employeeId) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
	}
}
