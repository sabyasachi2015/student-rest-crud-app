package com.cognizant.student.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {

		List<String> errorDetails = new ArrayList<>();
		// add exception message to errorDetails
		errorDetails.add(exception.getLocalizedMessage());

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatusCode(500);
		errorResponse.setTimeStamp(new Date());
		errorResponse.setErrorMessage("Internal Server Error");
		errorResponse.setErrorDetails(errorDetails);

		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException exception,
			WebRequest request) {

		List<String> errorDetails = new ArrayList<>();
		// add exception message to errorDetails
		errorDetails.add(exception.getLocalizedMessage());

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatusCode(404);
		errorResponse.setTimeStamp(new Date());
		errorResponse.setErrorMessage("Not Found");
		errorResponse.setErrorDetails(errorDetails);

		return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorDetails = new ArrayList<>();
		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
			errorDetails.add(error.getDefaultMessage());
		}
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatusCode(400);
		errorResponse.setTimeStamp(new Date());
		errorResponse.setErrorMessage("Bad Request");
		errorResponse.setErrorDetails(errorDetails);

		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
