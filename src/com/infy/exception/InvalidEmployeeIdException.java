package com.infy.exception;

public class InvalidEmployeeIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidEmployeeIdException(int id) {
		super(String.valueOf(id));
	}
	
}
