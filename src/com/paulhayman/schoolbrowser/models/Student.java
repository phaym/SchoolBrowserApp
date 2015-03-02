package com.paulhayman.schoolbrowser.models;

import java.util.Date;

public class Student extends BaseEntity{
	
	private String firstName;
	private String lastName;
	private String address;
	private Date studentDOB;

	public Student(){
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return studentDOB;
	}

	public void setBirthday(Date birthday) {
		this.studentDOB = birthday;
	}

}
