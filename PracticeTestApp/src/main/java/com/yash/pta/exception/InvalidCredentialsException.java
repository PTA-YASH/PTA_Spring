package com.yash.pta.exception;

/**
 * This is custom exception, throws when user credentials are not valid.
 */
@SuppressWarnings("serial")
public class InvalidCredentialsException extends Exception {
	public InvalidCredentialsException() {
		super();
	}
	
	/**
	 * This is constructor which sends exception message
	 * @param message
	 */
	public InvalidCredentialsException(String message){
		super(message);
	}
}
