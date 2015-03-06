package com.paulhayman.schoolbrowser.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paulhayman.schoolbrowser.data.CourseRepo;
import com.paulhayman.schoolbrowser.data.Repository;
import com.paulhayman.schoolbrowser.models.Course;
import com.paulhayman.schoolbrowser.models.Student;

public class CourseServiceImpl implements CourseService{

private Repository<Course> courseRepo;
	
	public CourseServiceImpl(){		
		courseRepo = new CourseRepo();
	}
	
	@Override
	public List<Course> getAllCourses() {		
		return courseRepo.getAll();
	}

	@Override
	public void addCourse(Course course) {		
		courseRepo.insert(course);		
	}
	
	@Override
	public void updateCourseInfo(Course newCourse) {	
		courseRepo.update(newCourse);
	}
	
	@Override
	public void deleteCourse(Course course) {
		courseRepo.delete(course);
	}

	@Override
	public List<Student> getStudentsInCourse(int id) {
		
		List<Student> studentsInCourse = new ArrayList<Student>();
		ResultSet rs = courseRepo.executeQuery("SELECT Course_Id, Student_Id, FirstName, LastName, StudentId "
				+ "FROM CourseForStudent, Students WHERE Student_Id = StudentId AND Course_Id =" + id);
		try {
			if(rs != null){
				while(rs.next()){
					Student studentInCourse = new Student();
					studentInCourse.setId(Integer.parseInt(rs.getString("StudentId")));
					studentInCourse.setFirstName(rs.getString("FirstName"));
					studentInCourse.setLastName(rs.getString("LastName"));
					studentsInCourse.add(studentInCourse);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentsInCourse;
	}


}
