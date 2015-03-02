package com.paulhayman.schoolbrowser.services;

import java.util.List;

import com.paulhayman.schoolbrowser.data.Repository;
import com.paulhayman.schoolbrowser.data.StudentRepo;
import com.paulhayman.schoolbrowser.models.Student;

public class StudentServiceImpl implements StudentService{

	private Repository<Student> repo;
	
	public StudentServiceImpl(){
		repo = new StudentRepo();
	}
	
	@Override
	public List<Student> getAllStudents() {
		return repo.getAll();
	}

	@Override
	public void addStudent(Student student) {
		repo.insert(student);
	}

}
