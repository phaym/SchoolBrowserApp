package com.paulhayman.schoolbrowser.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paulhayman.schoolbrowser.models.Student;

public class StudentRepo implements Repository<Student>{

	private DBConnection connection;
	
	public StudentRepo(){
		connection = new SQLConnectionImpl();
	}
	
	@Override
	public Student getById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Student entity) {	
		connection.executeUpdate("INSERT INTO Students (FirstName) Values('" + entity.getFirstName() + "')");
	}

	@Override
	public void update(Student entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getAll() {
		List<Student> studentListing = new ArrayList<Student>();

		ResultSet rs = connection.executeQuery("Select * FROM Students");
		
		try {
			while(rs.next()){
				Student student = new Student();
				student.setFirstName(rs.getString("FirstName"));
				studentListing.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentListing;
	}


}
