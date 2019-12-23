package com.yash.pta.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * This is Custom exception class for EmptyTechListException, throws when Technology list is empty.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyTechListException extends RuntimeException  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * This is constructor which sends exception message
	 * @param exception
	 */
	public EmptyTechListException(String exception) {
        super(exception);
    }
}
