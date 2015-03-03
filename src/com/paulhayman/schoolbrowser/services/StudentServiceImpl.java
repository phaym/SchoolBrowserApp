package com.paulhayman.schoolbrowser.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paulhayman.schoolbrowser.data.Repository;
import com.paulhayman.schoolbrowser.data.StudentRepo;
import com.paulhayman.schoolbrowser.models.Course;
import com.paulhayman.schoolbrowser.models.Student;

public class StudentServiceImpl implements StudentService{

	private Repository<Student> studentRepo;
	
	public StudentServiceImpl(){
		studentRepo = new StudentRepo();
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepo.getAll();
	}

	@Override
	public void addStudent(Student student) {
		studentRepo.insert(student);
	}

	@Override
	public List<Course> getCoursesForStudent(int id) {	
		List<Course> coursesForStudent = new ArrayList<Course>();
	
		ResultSet rs = studentRepo.executeQuery("SELECT Student_Id, CourseId, CourseTitle, "
				+ "CourseCode FROM CourseForStudent, Courses WHERE Student_Id =" + id);
		try {
			while(rs.next()){
				Course studentCourse = new Course();
				studentCourse.setCourseCode(rs.getString("CourseId"));
				studentCourse.setCourseTitle(rs.getString("CourseTitle"));
				coursesForStudent.add(studentCourse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coursesForStudent;
	}

}
