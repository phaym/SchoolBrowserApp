package com.paulhayman.schoolbrowser.services;

import java.util.List;

import com.paulhayman.schoolbrowser.data.CourseRepo;
import com.paulhayman.schoolbrowser.data.Repository;
import com.paulhayman.schoolbrowser.models.Course;

public class CourseServiceImpl implements CourseService{

private Repository<Course> repo;
	
	public CourseServiceImpl(){		
		repo = new CourseRepo();
	}
	
	@Override
	public List<Course> getAllCourses() {		
		return repo.getAll();
	}

	@Override
	public void addCourse(Course course) {		
		repo.insert(course);		
	}

}
