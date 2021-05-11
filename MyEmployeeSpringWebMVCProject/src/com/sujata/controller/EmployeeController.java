package com.sujata.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/insertEmployeePage")
	public ModelAndView insertEmployeePage() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("command", new Employee());
		mv.setViewName("/insertEmployee");
		return mv;
	}
	
	@RequestMapping("/save")
	public ModelAndView saveEmpController(@ModelAttribute Employee emp) {
		ModelAndView mv=new ModelAndView();
		String message=null;
		if(employeeService.insertEmployee(emp))
			message="Employee added Successfully!";
		else
			message="Employee insertion failed!";
		
		mv.addObject("msg", message);
		mv.setViewName("output");
		
		return mv;
	}
	
//	@RequestMapping("/save")
//	public ModelAndView saveEmpController(HttpServletRequest request) {
//		ModelAndView mv=new ModelAndView();
//		String id=request.getParameter("id");
//		String fn=request.getParameter("fname");
//		String ln=request.getParameter("lname");
//		String uid=request.getParameter("uId");
//		String salary=request.getParameter("salary");
//		
//		Employee emp=new Employee(Integer.parseInt(id), fn, ln, uid, Integer.parseInt(salary));
//		String message=null;
//		if(employeeService.insertEmployee(emp))
//			message="Employee added Successfully!";
//		else
//			message="Employee insertion failed!";
//		
//		mv.addObject("msg", message);
//		mv.setViewName("output");
//		
//		return mv;
//	}
	
	@RequestMapping("/insertSalPage")
	public ModelAndView insertSalaryPageController() {
		return new ModelAndView("insertSalary");
	}
	
	@RequestMapping("/searchBySal")
	public ModelAndView searchEmployeesBySalController(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		String sal=request.getParameter("salary");
		ArrayList<Employee> empList=employeeService.getEmpWithGreaterThanSpecifiedSalary(Integer.parseInt(sal));
		mv.addObject("employees", empList);
		mv.setViewName("showAllEmployees");
		
		return mv;
	}
}
