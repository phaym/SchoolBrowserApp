package com.paulhayman.schoolbrowser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
			
		ModelAndView model = new ModelAndView();
		return model;
	}
	
	@RequestMapping(value="/LevelsForValue", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getLevelsForValue(String tree, int nodeValue){
		
		List<Integer> levels = treeService.getLevelsForValue(tree, nodeValue);
		Gson gson = new Gson();
		return gson.toJson(levels);
	}
}
