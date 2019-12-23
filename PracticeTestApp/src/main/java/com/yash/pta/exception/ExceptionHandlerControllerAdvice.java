package com.yash.pta.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yash.pta.model.ErrorResponse;

//Global exception handler which handles the exceptions and validate the entity properties
//
@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler 
{
	
	/**
	 * This method validate all the properties of entity and catches the errors and sends them to user.
	 * @param MethodArgumentNotValidException
	 * @param HttpHeaders
	 * @param HttpStatus
	 * @param WebRequest
	 * @return ResponseEntity with body,headers,status
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String,Object>body=new LinkedHashMap<String,Object>();
		body.put("timestamp", new Date());
		body.put("status",status.value());
		
		List<String>error=ex.getBindingResult().getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
		body.put("errors",error);
		
		return new ResponseEntity<Object>(body,headers,status);
	}
	
	 /**
	  * This method handles EmptyTechListException.
	  * @param Exception object
	  * @param WebRequest object
	  * @return ResponseEntity with errors, HTTP status
	  */
	 @ExceptionHandler(EmptyTechListException.class)
	    public ResponseEntity<ErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {

		 ErrorResponse errors = new ErrorResponse();
	        errors.setMessage(ex.getMessage());
	        errors.setStatus(HttpStatus.NOT_FOUND.value());

	        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	    }
	 /**
	  * This method handles InvalidHeaderException.
	  * @param InvalidHeaderException object
	  * @return ResponseEntity with exception messages and HTTP status
	  */
	 @ExceptionHandler(InvalidHeaderException.class)
		public final ResponseEntity<Object> InvalidFileHeadersException(InvalidHeaderException ex) {
			 return new ResponseEntity<>(ex.getLocalizedMessage(),
			  HttpStatus.NOT_ACCEPTABLE);
	    }
}
