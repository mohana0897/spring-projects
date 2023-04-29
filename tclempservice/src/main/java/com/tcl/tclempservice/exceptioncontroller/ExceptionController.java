package com.tcl.tclempservice.exceptioncontroller;

import com.tcl.tclempservice.exceptions.EmployeeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> exceptionHandler(EmployeeException employeeException, WebRequest webReq){
		
		return new ResponseEntity<Object>(employeeException.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
}
