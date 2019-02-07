package com.infy.api;

import java.lang.management.MemoryType;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.exception.AccelerateAppDBException;
import com.infy.exception.InvalidEmployeeIdException;
import com.infy.model.AddEmployeeDTO;
import com.infy.model.EmployeeDTO;
import com.infy.service.EmployeeService;

@RestController
@RequestMapping(value= {"/Employee_api"})
public class EmployeeAPI {
	
	@Autowired
	EmployeeService empService;

	@RequestMapping(value="", method=RequestMethod.POST
			, consumes=MediaType.APPLICATION_JSON_VALUE, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Integer> addEmployee(@RequestBody @Valid AddEmployeeDTO addEmpObj, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("EmployeeAPI : addEmployee :has Errors");
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}else {
			System.out.println(addEmpObj);
			int empId;
			try {
				empId = empService.addEmployee(addEmpObj);
			} catch (AccelerateAppDBException e) {
				e.printStackTrace();
				return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Integer>(empId, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
		List<EmployeeDTO> empList = null;
		try {
			empList = empService.getAllEmployees();
		} catch (AccelerateAppDBException e) {
			e.printStackTrace();
			return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.BAD_REQUEST);
		} 
		
		return new ResponseEntity<List<EmployeeDTO>>(empList ,HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") int empId) {
		
		EmployeeDTO empObj;
		try {
			empObj = empService.getEmployee(empId);
		} catch (AccelerateAppDBException e) {
			e.printStackTrace();
			return new ResponseEntity<EmployeeDTO>(HttpStatus.BAD_REQUEST);
		} catch (InvalidEmployeeIdException e) {
			e.printStackTrace();
			return new ResponseEntity<EmployeeDTO>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<EmployeeDTO>(empObj, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int empId) {
		
		String responseStr = "Failure";
		try {
			responseStr = empService.deleteEmployee(empId);
		} catch (AccelerateAppDBException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (InvalidEmployeeIdException e) {
			e.printStackTrace();
			responseStr = "Employee Id doesn`t exist";
		}
		return new ResponseEntity<String>(responseStr, HttpStatus.OK); 
	}
	
	
//	@RequestMapping(value="/{id}", method=RequestMethod.)
//	public ResponseEntity<String> updateEmployee(@PathVariable("id") int empId) {
//		return null;
//	}
	
}
