package com.paulhayman.schoolbrowser.services;

import java.util.List;

import com.paulhayman.schoolbrowser.models.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	public void addStudent(Student student);
}
