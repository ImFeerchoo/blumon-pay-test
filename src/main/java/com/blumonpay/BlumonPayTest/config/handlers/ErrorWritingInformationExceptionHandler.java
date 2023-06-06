package com.blumonpay.BlumonPayTest.config.handlers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blumonpay.BlumonPayTest.exceptions.ErrorWritingInformationException;
import com.blumonpay.BlumonPayTest.exceptions.NoInformationFoundException;

@ControllerAdvice
public class ErrorWritingInformationExceptionHandler {

//	@ExceptionHandler(ErrorWritingInformationException.class)
//	public ResponseEntity<Map<String, String>> errorWritingInformationException(ErrorWritingInformationException e){
//		
//		Map<String, String> response = Map.ofEntries(
//					Map.entry("error", e.getMessage())
//				);
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		
//	}
	@ExceptionHandler(ErrorWritingInformationException.class)
	public String errorWritingInformationException(ErrorWritingInformationException e){
		
//		Map<String, String> response = Map.ofEntries(
//				Map.entry("error", e.getMessage())
//				);
		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		return "redirect:getAll";
		
	}
	
}
