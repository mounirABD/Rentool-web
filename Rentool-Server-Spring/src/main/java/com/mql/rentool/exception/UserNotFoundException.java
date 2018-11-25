package com.mql.rentool.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 965561096667443688L;

	public UserNotFoundException(String exception) {
		super(exception);
	}

}