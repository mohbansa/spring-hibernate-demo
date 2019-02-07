package com.infy.dao;

import java.util.List;

import com.infy.entity.EmployeeEntity;
import com.infy.exception.AccelerateAppDBException;
import com.infy.exception.InvalidEmployeeIdException;
import com.infy.model.AddEmployeeDTO;
import com.infy.model.EmployeeDTO;

public interface EmployeeDAO {

	public int insertEmployee(AddEmployeeDTO addEmpObj) throws AccelerateAppDBException;

	public EmployeeEntity getEmployee(int empId) throws AccelerateAppDBException;

	public List<EmployeeEntity> getAllEmployees() throws AccelerateAppDBException;
	
	public String deleteEmployee(int empId) throws AccelerateAppDBException, InvalidEmployeeIdException;

	List<EmployeeEntity> getAllEmployeesByPage(int pageId, int total) throws AccelerateAppDBException;
	
}
