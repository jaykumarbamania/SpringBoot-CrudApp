package com.neosoft.springboot.myexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

//Custom Exception class

@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 8454382943281286778L;
	private @Getter String resourceName;
	private @Getter String fieldName;
	private @Getter Object fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(resourceName+" not found with "+fieldName+" : "+fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
