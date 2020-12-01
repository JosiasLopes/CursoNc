package com.cursonc.demo.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	public ObjectNotFoundException(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String string) {
		super(string);
	}
	
	public ObjectNotFoundException(String string, Throwable cause) {
		super(string);
	}

}
