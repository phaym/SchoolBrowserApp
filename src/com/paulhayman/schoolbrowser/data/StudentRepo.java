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
		
		String insertQuery = mapStudentToInsertStr(entity);
		connection.executeUpdate(insertQuery);
	}

	private String mapStudentToInsertStr(Student entity) {
		
		String query = "INSERT INTO Students (FirstName, LastName) Values ('"
						+entity.getFirstName()+ "','" 
						+entity.getLastName()
						+"')";
		return query;
	}

	@Override
	public void update(Student entity) {
		
		String query = "UPDATE Students SET FirstName='" + entity.getFirstName() 
						+ "', LastName='" +  entity.getLastName() 
						+  "' WHERE StudentId ='" + entity.getId()+ "'";
		connection.executeUpdate(query);
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
			if(rs != null){
				while(rs.next()){
					Student student = mapRepoEntryToStudent(rs);
					studentListing.add(student);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentListing;
	}

	private Student mapRepoEntryToStudent(ResultSet rs) throws SQLException{
		
		Student student = new Student();
		student.setId(Integer.parseInt(rs.getString("StudentId")));
		student.setFirstName(rs.getString("FirstName"));
		student.setLastName(rs.getString("LastName"));
		return student;
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
