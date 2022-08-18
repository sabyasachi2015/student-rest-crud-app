package com.cognizant.student.exception;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	private int statusCode;
	
	private Date timeStamp;
	
	private String errorMessage;
	
	private List<String> errorDetails;
}
