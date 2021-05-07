package com.sujata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyFirstController {

	//Mapping Handler
	@RequestMapping("/first")
	public ModelAndView firstController() {
		ModelAndView mv=new ModelAndView();
		//data to be displayed on view
		mv.addObject("message", "Welcome to the world of Spring MVC!");
		//view name
		mv.setViewName("my.jsp");
		return mv;
	}
	
	
	@RequestMapping("/my")
	public ModelAndView secondController() {
		ModelAndView mv=new ModelAndView();
		//data to be displayed on view
		mv.addObject("message", "Welcome once again to the world of Spring MVC!");
		//view name
		mv.setViewName("my.jsp");
		return mv;
	}
}
