package com.paulhayman.schoolbrowser.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/Courses")
public class MainController  {

	@RequestMapping("/Display")
	public ModelAndView displayHome() {

		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage", "HELLO THIS IS AN APPLICATION");
		
		return modelandview;
	}
	
	@RequestMapping("/StudentListing")
	public ModelAndView displayStudentListing(){
		List<Student> studentListing = new ArrayList<Student>();
		
		studentListing.add(new Student("Paul"));
		studentListing.add(new Student("Mark"));
		studentListing.add(new Student("Tom"));

		ModelAndView model = new ModelAndView("StudentListing");
		model.addObject("studentListing", studentListing);
		return model;
	}
	
	@ModelAttribute
	public void addAttributeToAllModels(Model model){
	
	}
	@InitBinder
	public void customDataBinder(WebDataBinder binder){
		
	}

}
