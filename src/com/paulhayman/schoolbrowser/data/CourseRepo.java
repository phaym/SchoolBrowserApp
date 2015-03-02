package com.paulhayman.schoolbrowser.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paulhayman.schoolbrowser.models.Course;

public class CourseRepo implements Repository<Course> {

	private DBConnection connection;
	
	public CourseRepo(){
		connection = new SQLConnectionImpl();
	}
	@Override
	public Course getById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Course entity) {
		connection.executeUpdate("INSERT INTO Courses (CourseTitle) Values('" + entity.getCourseTitle() + "')");
	}

	@Override
	public void update(Course entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Course entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Course> getAll() {
		List<Course> courseListing = new ArrayList<Course>();

		ResultSet rs = connection.executeQuery("Select * FROM Courses");
		
		try {
			while(rs.next()){
				Course course = new Course();
				course.setCourseTitle(rs.getString("CourseTitle"));
				courseListing.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseListing;
	}

}
