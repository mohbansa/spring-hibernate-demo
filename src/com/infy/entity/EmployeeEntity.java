package com.infy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee_Table")
//@SequenceGenerator(name="Emp_ID_SEQ_GENERATOR", initialValue=1001, allocationSize=10)

@GenericGenerator(name="Emp_ID_SEQ_GENERATOR", strategy = "increment")

public class EmployeeEntity {
	
	@Id
	@GeneratedValue(generator="Emp_ID_SEQ_GENERATOR")
	@Column(name="EMPLOYEE_ID", nullable=false)
	private int empId;
	
	@Column(name="EMPLOYEE_NAME", nullable=false)
	private String name;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="DEPARTMENT")
	private String dept;
	
	@Column(name="BASE_LOCATION", nullable=false)
	private String baseLocation;

	@Column(name="CURRENT_LOCATION")
	private String currentLocation;
	
	@Column(name="SALARY", nullable=false)
	private long salary;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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
		return "EmployeeEntity [empId=" + empId + ", name=" + name + ", email=" + email + ", dept=" + dept
				+ ", baseLocation=" + baseLocation + ", currentLocation=" + currentLocation + ", salary=" + salary
				+ "]";
	}
	
}
