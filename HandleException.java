package com.grocery.allexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException 
{
@ExceptionHandler(value=ProductNotFoundException.class)
public ResponseEntity<?>ProductNotFoundException(ProductNotFoundException exception)
{
	return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.OK);
	
}
}
