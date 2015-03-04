package com.paulhayman.schoolbrowser.services;

import java.util.List;

import com.paulhayman.schoolbrowser.models.Course;
import com.paulhayman.schoolbrowser.models.Student;

public interface CourseService {
	
	public List<Course> getAllCourses();
	public void addCourse(Course course);
	public List<Student> getStudentsInCourse(int id);
}
