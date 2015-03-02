package com.paulhayman.schoolbrowser.services;

import java.util.List;

import com.paulhayman.schoolbrowser.models.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();
	public void addCourse(Course course);
}
