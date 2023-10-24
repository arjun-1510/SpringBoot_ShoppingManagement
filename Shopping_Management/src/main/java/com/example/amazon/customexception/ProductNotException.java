package com.example.amazon.customexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ProductNotException extends RuntimeException {
	
	
	public String nosuchelement;

	public ProductNotException(String nosuchelement) {
		super();
		this.nosuchelement = nosuchelement;
	}

	
	
	
	
	

}
