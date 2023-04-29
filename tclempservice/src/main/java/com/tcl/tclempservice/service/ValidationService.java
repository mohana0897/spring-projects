package com.tcl.tclempservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class ValidationService {
	
	public ResponseEntity<?> validationResult(BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			Map<String,String> validatemap=new HashMap<>();
			
			for(FieldError error:   bindingResult.getFieldErrors()) {
				validatemap.put(error.getField(), error.getDefaultMessage());
		}
		return new	ResponseEntity<Map<String,String>>(validatemap,HttpStatus.BAD_REQUEST);
		}
	return null;	
	}
	

}
