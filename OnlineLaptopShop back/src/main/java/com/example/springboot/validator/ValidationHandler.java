package com.example.springboot.validator;


import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.example.springboot.exception.ResourceNotFoundException;
@RestControllerAdvice
public class ValidationHandler {
	
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map <String,String>  handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);		
		});
		return errors;
	}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@ExceptionHandler(ResourceNotFoundException.class)
public Map<String,String> handleResourceNotFoundException(ResourceNotFoundException ex){
	Map<String,String> errors=new HashMap<>();
	errors.put("ErrorMessage",ex.getMessage());
	return errors;
}

}