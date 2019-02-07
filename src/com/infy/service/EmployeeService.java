package com.infy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.infy.dao.EmployeeDAOImpl;
import com.infy.entity.EmployeeEntity;
import com.infy.exception.AccelerateAppDBException;
import com.infy.exception.InvalidEmployeeIdException;
import com.infy.model.AddEmployeeDTO;
import com.infy.model.EmployeeDTO;
import com.infy.dao.EmployeeDAO;

@Service
public class EmployeeService {
	
	EmployeeDAO employeeDao = new EmployeeDAOImpl();
	
	public int addEmployee(AddEmployeeDTO addEmpObj) throws AccelerateAppDBException {
		return employeeDao.insertEmployee(addEmpObj);
	}
	
	public EmployeeDTO getEmployee(int empId) throws AccelerateAppDBException, InvalidEmployeeIdException {
		EmployeeEntity empEntity = employeeDao.getEmployee(empId);
		
		if(empEntity == null) {
			throw new InvalidEmployeeIdException(empId);
		}else {
			EmployeeDTO empObj = new EmployeeDTO(empEntity.getEmpId(), empEntity.getName(), empEntity.getEmail(), 
					empEntity.getDept(), empEntity.getBaseLocation(), empEntity.getCurrentLocation(), empEntity.getSalary());
			return empObj;
		}
	}

	public List<EmployeeDTO> getAllEmployees() throws AccelerateAppDBException {
		List<EmployeeEntity> listEmpEntity = employeeDao.getAllEmployees();
		System.out.println(listEmpEntity);
		
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
		for(EmployeeEntity empEntity : listEmpEntity) {
			empList.add(new EmployeeDTO(empEntity.getEmpId(), empEntity.getName(), empEntity.getEmail(), 
					empEntity.getDept(), empEntity.getBaseLocation(), empEntity.getCurrentLocation(), empEntity.getSalary()));
		}
		return empList;
	}
	
	public List<EmployeeDTO> getAllEmployeesByPage(int pageId, int total)
			throws AccelerateAppDBException {
		List<EmployeeEntity> listEmpEntity = employeeDao.getAllEmployeesByPage(pageId, total);
		System.out.println(listEmpEntity);
		
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
		for(EmployeeEntity empEntity : listEmpEntity) {
			empList.add(new EmployeeDTO(empEntity.getEmpId(), empEntity.getName(), empEntity.getEmail(), 
					empEntity.getDept(), empEntity.getBaseLocation(), empEntity.getCurrentLocation(), empEntity.getSalary()));
		}
		return empList;
	}
	
	public String deleteEmployee(int empId) throws AccelerateAppDBException, InvalidEmployeeIdException {
		String responseStr = employeeDao.deleteEmployee(empId);
		
		return responseStr;
	}
	
	
}


