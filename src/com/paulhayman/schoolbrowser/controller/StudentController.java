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
import com.paulhayman.schoolbrowser.services.StudentService;
import com.paulhayman.schoolbrowser.services.StudentServiceImpl;


@Controller
public class StudentController  {
	
	private StudentService studentService;
	private CourseService courseService;
	
	public StudentController(){
		studentService = new StudentServiceImpl();
		courseService = new CourseServiceImpl();
	}

	@RequestMapping("/StudentListing")
	public ModelAndView displayStudentListing(){
		
		List<Student> studentListing = studentService.getAllStudents();
		
		ModelAndView model = new ModelAndView();
		model.addObject("infoStudent", new Student());
		model.addObject("studentListing", studentListing);
		return model;
	}
	
	@RequestMapping(value="/StudentInfo", method=RequestMethod.POST)
	public ModelAndView displayStudentInfo(Student infoStudent){
		
		List<Course> coursesForStudent = studentService.getCoursesForStudent(infoStudent.getId());
		List<Course> allCourses = courseService.getAllCourses();
		ModelAndView model = new ModelAndView();
		model.addObject("student", infoStudent);
		model.addObject("coursesForStudent", coursesForStudent);
		model.addObject("allCourses", allCourses);
		return model;
	}

	@RequestMapping(params = "update",value="/UpdateStudent", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateStudent(Student newStudent){
		
		studentService.updateStudentInfo(newStudent);
		return new ModelAndView("redirect:/StudentListing");
	}
	
	@RequestMapping(params = "delete",value="/UpdateStudent", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView deleteStudent(Student student){
		
		studentService.deleteStudent(student);
		return new ModelAndView("redirect:/StudentListing");
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
	
	@RequestMapping(value="/CoursesForStudent", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String coursesForStudent(int id){
		
		List<Course> courseListing = studentService.getCoursesForStudent(id);
		Gson gson = new Gson();
		return gson.toJson(courseListing);
	}
	
	@RequestMapping(value="/EnrollStudent", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String enrollStudent(int studentId, int courseId){
		
		String response = studentService.enrollStudent(studentId, courseId);
		Gson gson = new Gson();
		return gson.toJson(response);
	}
	
	@RequestMapping(value="/WithdrawStudent", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String withdrawStudent(int studentId, int courseId){
		
		studentService.withdrawStudent(studentId, courseId);
		Gson gson = new Gson();
		return gson.toJson("Success");
	}

}
