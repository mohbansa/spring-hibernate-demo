package com.infy.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
//@XmlRootElement(name="Employee")
public class EmployeeDTO {
	
	private long id;
	private String name;
	private String email;
	private String dept;
	private String baseLocation;
	private String currentLocation;
	private long salary;
	
	public EmployeeDTO() {
		
	}

	public EmployeeDTO(long id, String name, String email, String dept, String baseLocation, String currentLocation,
			long salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.baseLocation = baseLocation;
		this.currentLocation = currentLocation;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	
}
