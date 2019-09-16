package com.coding.assignment.exception;

/**
 * Business Exception for the Project.
 */
public class TollParkingException extends RuntimeException{
	
	private static final long serialVersionUID = 1809171676156468921L;

	public TollParkingException() {
		super();
	}

	public TollParkingException(String arg0) {
		super(arg0);
	}

	public TollParkingException(Exception e) {
		super(e);
	}
		

}
