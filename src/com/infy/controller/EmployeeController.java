package com.infy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infy.exception.AccelerateAppDBException;
import com.infy.model.AddEmployeeDTO;
import com.infy.model.EmployeeDTO;
import com.infy.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="employee", method=RequestMethod.GET)
	public ModelAndView getAllEmployee(@RequestParam(value="pageId", defaultValue="1") int pageId, 
			@RequestParam(value="total", defaultValue="5") int total) {

		System.out.println(1111);
		List<EmployeeDTO> empList = null;
		try {
			empList = empService.getAllEmployeesByPage(pageId, total);
		} catch (AccelerateAppDBException e) {
			e.printStackTrace();
			return new ModelAndView("addEmployee");
		} 
		
		System.out.println(2222222);
		
		ModelAndView modelAndView = new ModelAndView("viewEmployees", "list", empList);
		modelAndView.addObject("total", 13);
		

		System.out.println(3333);
		return new ModelAndView("viewEmployees", "list", empList);
	}
	
	@RequestMapping(value="registerEmployee", method=RequestMethod.GET)
	public ModelAndView getAllEmployee() {
		return new ModelAndView("addEmployee", "command", new EmployeeDTO());
	}
	
	@RequestMapping(value="employee", method=RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("command") @Valid AddEmployeeDTO addEmpObj
			, BindingResult result) {
		ModelAndView modelAndView = null;
		if(result.hasErrors()) {
			System.out.println("EmployeeAPI : addEmployee :has Errors");
			modelAndView = new ModelAndView("addEmployee");
		}else {
			System.out.println("EmployeeAPI : addEmployee : **** NO Errors ****");
			int empId;
			try {
				empId = empService.addEmployee(addEmpObj);
				modelAndView = new ModelAndView("addEmployee");
			} catch (AccelerateAppDBException e) {
				e.printStackTrace();
				modelAndView = new ModelAndView("addEmployee");
			}
		}
		
		return modelAndView;
	}
	
	
	
	
}
