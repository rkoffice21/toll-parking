package com.coding.assignment.exception;

/**
 * If the Parking in not available then we throw is exception. 
 */
public class NoParkingAvailableException extends RuntimeException{
	
	private static final long serialVersionUID = 1809171676156468921L;

	public NoParkingAvailableException() {
		super();
	}

	public NoParkingAvailableException(String arg0) {
		super(arg0);
	}

	public NoParkingAvailableException(Exception e) {
		super(e);
	}
		

}
