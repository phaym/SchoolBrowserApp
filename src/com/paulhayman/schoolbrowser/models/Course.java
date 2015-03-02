package com.paulhayman.schoolbrowser.models;


public class Course extends BaseEntity {

	private String courseTitle;
	private String courseCode;
	
	public Course(){
	}
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
