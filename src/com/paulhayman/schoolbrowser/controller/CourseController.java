package com.paulhayman.schoolbrowser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.paulhayman.schoolbrowser.models.Course;
import com.paulhayman.schoolbrowser.models.Student;
import com.paulhayman.schoolbrowser.services.CourseService;
import com.paulhayman.schoolbrowser.services.CourseServiceImpl;


@Controller
public class CourseController  {
	
	private CourseService courseService;
	
	public CourseController(){
		courseService = new CourseServiceImpl();
	}
	
	@RequestMapping("/CourseListing")
	public ModelAndView displayCourseListing(){
		
		List<Course> courseListing = courseService.getAllCourses();
		
		ModelAndView model = new ModelAndView();
		model.addObject("courseListing", courseListing);
		return model;
	}
	
	@RequestMapping(value="/AddCourse", method=RequestMethod.GET)
	public ModelAndView courseForm(){
		
		ModelAndView model = new ModelAndView();
		model.addObject("course", new Course());
		return model;
	}
	
	@RequestMapping(value="/AddCourse", method=RequestMethod.POST)
	public ModelAndView submitCourse(Course course){
		
		courseService.addCourse(course);
		return new ModelAndView("redirect:/CourseListing");
	}
	
	@RequestMapping(value="/StudentsInCourse", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String studentAssignCourse(int id){
		
		List<Student> studentListing = courseService.getStudentsInCourse(id);
		Gson gson = new Gson();
		return gson.toJson(studentListing);
	}

}
