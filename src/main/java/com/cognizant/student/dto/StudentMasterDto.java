package com.cognizant.student.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.cognizant.student.audit.Auditable;
import com.cognizant.student.entity.ProjectMasterEntity;

import lombok.Data;

@Data
public class StudentMasterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2486764703792667141L;
	
	private Integer studentId;
	@NotEmpty(message = "Student first name must not be empty")
	
	private String studentFirstName;
	@NotEmpty(message = "Student last name must not be empty")
	private String studentLastName;
	private String studentEmail;
	//private Long mobileNumber;
	private Double studentCourseFees;
	private List<ProjectMasterEntity> projects=new ArrayList<>();

}
