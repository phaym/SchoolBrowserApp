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
		
		String insertQuery = mapStudentToInsertStr(entity);
		connection.executeUpdate(insertQuery);
	}

	private String mapStudentToInsertStr(Course entity) {
		
		String query = "INSERT INTO Courses (CourseTitle, CourseCode) Values('" 
				+ entity.getCourseTitle() +"','"
				+ entity.getCourseCode()  
				+"')";
		return query;
	}
	@Override
	public void update(Course entity) {
		String query = "UPDATE Courses SET CourseTitle='" + entity.getCourseTitle() 
				+ "', CourseCode='" +  entity.getCourseCode() 
				+  "' WHERE CourseId ='" + entity.getId()+ "'";
		connection.executeUpdate(query);
	}

	@Override
	public void delete(Course entity) {
		
		String query = "DELETE FROM Courses WHERE CourseId=" + entity.getId();
		connection.executeUpdate(query);
	}

	@Override
	public List<Course> getAll() {
		List<Course> courseListing = new ArrayList<Course>();

		ResultSet rs = connection.executeQuery("Select * FROM Courses");
		
		try {
			while(rs.next()){
				Course course = mapRepoEntryToCourse(rs);
				courseListing.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseListing;
	}
	private Course mapRepoEntryToCourse(ResultSet rs) throws SQLException {
		Course course = new Course();
		course.setId(Integer.parseInt(rs.getString("CourseId")));
		course.setCourseTitle(rs.getString("CourseTitle"));
		course.setCourseCode(rs.getString("CourseCode"));
		return course;
	}
	@Override
	public ResultSet executeQuery(String proc) {
		
		ResultSet rs = connection.executeQuery(proc);
		return rs;
	}
	@Override
	public void executeUpdate(String proc) {
		
		connection.executeUpdate(proc);
	}


}
