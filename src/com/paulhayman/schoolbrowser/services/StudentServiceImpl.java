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
	public void updateStudentInfo(Student newStudent) {
		studentRepo.update(newStudent);
	}
	
	@Override
	public List<Course> getCoursesForStudent(int id) {	
		List<Course> coursesForStudent = new ArrayList<Course>();
	
		ResultSet rs = studentRepo.executeQuery("SELECT Student_Id, Course_Id, CourseId, CourseTitle, "
				+ "CourseCode FROM CourseForStudent, Courses WHERE Course_Id = CourseId AND Student_Id =" + id);
		try {
			if(rs != null){
				while(rs.next()){
					Course studentCourse = new Course();
					studentCourse.setCourseCode(rs.getString("CourseCode"));
					studentCourse.setCourseTitle(rs.getString("CourseTitle"));
					coursesForStudent.add(studentCourse);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coursesForStudent;
	}

	@Override
	public String enrollStudent(int studentId, int courseId) {
		
		String response = "";
		String checkIfEnrolled = "SELECT Student_Id, Course_Id FROM CourseForStudent WHERE "
				+ "Course_Id = " + courseId + " AND Student_Id =" + studentId;
		String enrollStudent ="INSERT INTO CourseForStudent (Student_Id, Course_Id) Values('" 
				+ studentId +"','"
				+ courseId 
				+"')";
		ResultSet rs = studentRepo.executeQuery(checkIfEnrolled);
		try {
			if(rs.isBeforeFirst()){
				response = "Already Enrolled";
			}
			else{
				studentRepo.executeUpdate(enrollStudent);
				response = "Success";	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;					
		
	}



}
