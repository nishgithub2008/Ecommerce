package com.sprinbootdemo_ecommerce.advice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandllerController {
	
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerExceptionHandller() {
		System.out.println("Exception Has handled");
		
		return "index";
		
	}
	
	@ExceptionHandler(Exception.class)
	public String genericExceptionHandller( ) {
		return null;
		
	}

}
