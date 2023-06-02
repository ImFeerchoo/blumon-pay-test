package com.blumonpay.BlumonPayTest.config.handlers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blumonpay.BlumonPayTest.exceptions.NoInformationFoundException;

@ControllerAdvice
public class NoInformationFoundExceptionHandler {

	@ExceptionHandler(NoInformationFoundException.class)
	public ResponseEntity<Map<String, String>> noInformationFoundException(NoInformationFoundException e){
		
		Map<String, String> response = Map.ofEntries(
					Map.entry("error", e.getMessage())
				);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		
	}
	
}
