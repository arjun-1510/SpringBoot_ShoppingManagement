package com.example.amazon.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHanding {
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException e) {
		
		
		
		return new  ResponseEntity<String>("No Record Founded  and Please check your Request",HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleNoSuchElement(IllegalArgumentException e) {
		
		
		
		return new  ResponseEntity<String>("Arugument is Empty	 and Please check your Request",HttpStatus.BAD_REQUEST);
	}
	
	
	


}
