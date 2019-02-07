package com.infy.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeServiceAspect {

	@Before(value="execution(* com.infy.service.EmployeeService.*(..))")
	public void beforeAdvice() {
		System.out.println("Before: EmployeeService");
	}
	
	@After("execution(* com.infy.service.EmployeeService.*(..))")
	public void afterAdvice() {
		System.out.println("After : EmployeeService");
	}
	
	@AfterThrowing("execution(* com.infy.service.EmployeeService.*(..))")
	public void afterThrowingAdvice() {
		System.out.println("After Throwing : EmployeeService");
	}
	
	
}
