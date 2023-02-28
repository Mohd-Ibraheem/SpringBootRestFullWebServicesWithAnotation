package com.student.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PageNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fildName;
	private long fildValue;
	
	public PageNotFoundException(String resourceName, String fildName, long id) {
		super(String.format("%s not found with %s: '%s'", resourceName,fildName,id));
		this.resourceName = resourceName;
		this.fildName = fildName;
		this.fildValue = id;
	}
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFildName() {
		return fildName;
	}
	public long getFildValue() {
		return fildValue;
	}
	
	

}
