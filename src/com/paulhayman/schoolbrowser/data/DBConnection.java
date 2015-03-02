package com.paulhayman.schoolbrowser.data;

import java.sql.ResultSet;

public interface DBConnection {

	public ResultSet executeQuery(String query);
	public void executeUpdate(String query);
}
