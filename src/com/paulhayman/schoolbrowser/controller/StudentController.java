package com.paulhayman.schoolbrowser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		
		ModelAndView model = new ModelAndView("StudentListing");
		model.addObject("studentListing", studentListing);
		return model;
	}
	
	@RequestMapping(value="/AddStudent", method=RequestMethod.GET)
	public ModelAndView studentForm(){
		
		ModelAndView model = new ModelAndView("AddStudent");
		model.addObject("student", new Student());
		return model;
	}
	
	@RequestMapping(value="/AddStudent", method=RequestMethod.POST)
	public ModelAndView submitStudent(Student newStudent){
		
		studentService.addStudent(newStudent);
		return new ModelAndView("redirect:/StudentListing");
	}
	
	
	@ModelAttribute
	public void addAttributeToAllModels(Model model){
	
	}
	
	@InitBinder
	public void customDataBinder(WebDataBinder binder){
		
	}

}
