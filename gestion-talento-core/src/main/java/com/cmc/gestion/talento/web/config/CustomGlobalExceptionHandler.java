package com.cmc.gestion.talento.web.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex, WebRequest request)
			throws IOException {
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		ErrorResponse error = new ErrorResponse("Error Server", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		List<String> details = new ArrayList<>();
		details.add("Error Al procesar la petición");
		ErrorResponse error = new ErrorResponse("Error Server", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR); 
	} 

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Error Al procesar la petición");
		ErrorResponse error = new ErrorResponse("Error Server", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ArqGestionExcepcion.class)
	public final ResponseEntity<Object> handleArqGestionExcepcion(ArqGestionExcepcion ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		details.add(ex.getMessage());
		if(ex.getTipo().equals(ExcepcionType.ERROR_VALIDATION)) {
			status= HttpStatus.BAD_REQUEST;
		}
		ErrorResponse error = new ErrorResponse("Validation Failed", details);
		return new ResponseEntity<Object>(error, status);
	}
	
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error = new ErrorResponse("Validation Failed", details);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
}
