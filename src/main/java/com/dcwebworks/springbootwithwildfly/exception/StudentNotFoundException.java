package com.dcwebworks.springbootwithwildfly.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
	public static final long serialVersionUID = 1L;
	
	public StudentNotFoundException() {
		super("Student Not Found!");
	}
}
