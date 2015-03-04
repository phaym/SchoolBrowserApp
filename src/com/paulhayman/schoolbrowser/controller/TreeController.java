package com.paulhayman.schoolbrowser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paulhayman.schoolbrowser.services.TreeService;
import com.paulhayman.schoolbrowser.services.TreeServiceImpl;


@Controller
public class TreeController {

	private TreeService treeService;
	
	public TreeController(){
		treeService = new TreeServiceImpl();
	}
	
	@RequestMapping("/TreeProcessor")
	public ModelAndView displayTreeForm(){
		
		int value = 5;
		String tree = "4,5,9,8,6,,5,2,7,,,,8";
		List<Integer> result = treeService.getLevelsForValue(tree, value);
		System.out.print("Levels: ");
		for(Integer r: result){
			System.out.print(r + ", ");
		}
		
		ModelAndView model = new ModelAndView();
		return model;
	}
}
