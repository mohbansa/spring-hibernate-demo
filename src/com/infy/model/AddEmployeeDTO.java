package com.infy.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class AddEmployeeDTO {

	@NotNull(message="Employee name must not be blank.")
	private String name;

	@NotNull(message="Employee email must not be blank.")
	private String email;

	@NotNull(message="Employee department must not be blank.")
	private String dept;
	
	@NotNull(message="Employee base location must not be blank.")
	private String baseLocation;
	
	private String currentLocation;
	
	private long salary;

	public AddEmployeeDTO() {
		
	}
	
	public AddEmployeeDTO(String name, String email, String dept, String baseLocation, String currentLocation,
			long salary) {
		super();
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.baseLocation = baseLocation;
		this.currentLocation = currentLocation;
		this.salary = salary;
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
	

	@Override
	public String toString() {
		return "AddEmployeeDTO [name=" + name + ", email=" + email + ", dept=" + dept + ", baseLocation=" + baseLocation
				+ ", currentLocation=" + currentLocation + ", salary=" + salary + "]";
	}
	
}
