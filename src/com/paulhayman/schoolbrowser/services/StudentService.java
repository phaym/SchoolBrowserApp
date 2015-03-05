package com.paulhayman.schoolbrowser.services;

import java.util.List;

import com.paulhayman.schoolbrowser.models.Course;
import com.paulhayman.schoolbrowser.models.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	public void addStudent(Student student);
	public List<Course> getCoursesForStudent(int id);
	public String enrollStudent(int studentId, int courseId);
	public void updateStudentInfo(Student newStudent);
}
