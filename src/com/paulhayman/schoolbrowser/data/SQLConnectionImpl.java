package com.paulhayman.schoolbrowser.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectionImpl implements DBConnection{

	private static String connectionString = "jdbc:sqlserver://localhost:1433;instance=SQLExpress;databaseName=SchoolBrowser;user=ReadWriteUser;password=p@ssword;";
	private Connection conn = null;
	
	public SQLConnectionImpl(){
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void connect() throws SQLException{
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query){
		
		ResultSet queryResult = null;
		try {
			Statement stmt = conn.createStatement();
			queryResult = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryResult;
	}

	@Override
	public void executeUpdate(String query) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
