package com.rodrigo.cursomc.resources.execptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rodrigo.cursomc.services.execptions.DataIntegrityExecption;

import javassist.tools.rmi.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFund(ObjectNotFoundException e, HttpServletRequest request){
			StandardError err= new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityExecption.class)
	public ResponseEntity<StandardError> DataIntegrity(DataIntegrityExecption e, HttpServletRequest request){
			StandardError err= new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
