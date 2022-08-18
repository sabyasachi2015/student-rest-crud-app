/**
 * 
 */
package com.cognizant.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.student.constants.AppConstants;
import com.cognizant.student.dto.StudentMasterDto;
import com.cognizant.student.entity.StudentMasterEntity;
import com.cognizant.student.exception.StudentNotFoundException;
import com.cognizant.student.properties.AppProperties;
import com.cognizant.student.service.IStudentMasterService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sabyasachi
 *
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class StudentMasterRestController {

	@Autowired
	private IStudentMasterService studentMasterService;

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/regStudent")
	public ResponseEntity<String> registerStudent(@Valid @RequestBody StudentMasterDto studentMasterDto) {

		log.debug("StudentRestController::saveStudent() Execution Started");

		try {
			// convert dto to entity using modelMapper
			StudentMasterEntity studentMasterEntity = modelMapper.map(studentMasterDto, StudentMasterEntity.class);

			// call service layer
			StudentMasterEntity savedStudentEntity = studentMasterService.saveStudent(studentMasterEntity);
			// convert entity to dto using modelmapper
			StudentMasterDto studentMasterDtoRes = modelMapper.map(savedStudentEntity, StudentMasterDto.class);
			if (null != studentMasterDtoRes) {
				String successMsg = appProperties.getProperties().get(AppConstants.STUDENT_REG_SUCCESS);
				return new ResponseEntity<>(successMsg, HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Exception Occured::" + e);
		}
		log.debug("StudentRestController::saveStudent() Execution Started");
		String failureMsg = appProperties.getProperties().get(AppConstants.STUDENT_REG_FAILED);
		return new ResponseEntity<>(failureMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<? extends Object> findOneStudentById(@PathVariable Integer studentId) {
		log.info("StudentRestController::findAllStudents() Execution Started");

		// Call service method to fetch student
		StudentMasterEntity studentEntity = studentMasterService.getStudentById(studentId);
		// convert entity to dto
		StudentMasterDto studentResponse = modelMapper.map(studentEntity, StudentMasterDto.class);

		if (studentResponse != null) {
			log.info("Student Retrieved by Id:" + studentId);
			return new ResponseEntity<>(studentResponse, HttpStatus.OK);
		} else {
			log.error("Unable to Fetch Student with id:" + studentId);
			throw new StudentNotFoundException("Student Not Found With id:" + studentId);
		}
	}	
}
