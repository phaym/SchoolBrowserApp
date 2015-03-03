package com.paulhayman.schoolbrowser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paulhayman.schoolbrowser.models.Course;
import com.paulhayman.schoolbrowser.models.Student;
import com.paulhayman.schoolbrowser.services.StudentService;
import com.paulhayman.schoolbrowser.services.StudentServiceImpl;


@Controller
public class StudentController  {
	
	private StudentService studentService;
	
	public StudentController(){
		studentService = new StudentServiceImpl();
	}

	@RequestMapping("/StudentListing")
	public ModelAndView displayStudentListing(){
		
		List<Student> studentListing = studentService.getAllStudents();
		
		ModelAndView model = new ModelAndView();
		model.addObject("studentListing", studentListing);
		return model;
	}
	
	@RequestMapping(value="/AddStudent", method=RequestMethod.GET)
	public ModelAndView studentForm(){
		
		ModelAndView model = new ModelAndView();
		model.addObject("student", new Student());
		return model;
	}
	
	@RequestMapping(value="/AddStudent", method=RequestMethod.POST)
	public ModelAndView submitStudent(Student newStudent){
		
		studentService.addStudent(newStudent);
		return new ModelAndView("redirect:/StudentListing");
	}
	
	@RequestMapping(value="/ViewCourses", method=RequestMethod.GET)
	public List<Course> studentAssignCourse(int id){
		
		List<Course> courseListing = studentService.getCoursesForStudent(id);
		Course test = new Course();
		test.setCourseCode("1001");
		test.setCourseTitle("what what");
		courseListing.add(test);

		return courseListing;
	}
	
	
	

}
