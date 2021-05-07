package com.sujata.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sujata.bean.Employee;
import com.sujata.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/")
	public ModelAndView mainPageController() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/getAllEmps")
	public ModelAndView showAllEmployeesController() {
		
		ModelAndView mv=new ModelAndView();
		
		ArrayList<Employee> empList=employeeService.getAllEmployees();
		mv.addObject("employees", empList);
		mv.setViewName("showAllEmployees");
		
		return mv;
	}
	
	@RequestMapping("/inputEmpIDPage")
	public ModelAndView inputEmpIDPageController() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/inputEmpId");
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView searchEmployee(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		Employee employee=employeeService.searchEmployeeById(Integer.parseInt(request.getParameter("empId")));
		
		mv.addObject("employee", employee);
		mv.setViewName("showEmp");
		
		return mv;
	}
}
