package com.paulhayman.schoolbrowser.data;

import java.sql.ResultSet;
import java.util.List;

public interface Repository<T>{

	T getById(Object id);
	void insert(T entity);
	void update(T entity);
	void delete(T entity);
	List<T> getAll();
	ResultSet executeQuery(String proc);
}
