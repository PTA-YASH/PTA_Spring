package com.yash.pta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * This is Custom exception class for InvalidHeaderException, throws when Header of file is not valid.
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InvalidHeaderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * This is constructor which sends exception message
	 * @param message
	 */
	public InvalidHeaderException(String message){
		super(message);
	}
	
}
