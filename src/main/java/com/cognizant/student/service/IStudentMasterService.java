/**
 * 
 */
package com.cognizant.student.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.student.dto.ProjectMasterDto;
import com.cognizant.student.dto.StudentMasterDto;
import com.cognizant.student.entity.ProjectMasterEntity;
import com.cognizant.student.entity.StudentMasterEntity;
import com.cognizant.student.exception.ProjectNotFoundException;
import com.cognizant.student.exception.StudentNotFoundException;

/**
 * @author sabyasachi
 *
 */
public interface IStudentMasterService {
	
	public StudentMasterEntity saveStudent(StudentMasterEntity studentMasterEntityReq);
	
	public List<StudentMasterEntity> getAllstudents()throws StudentNotFoundException;
	//public List<ProjectMasterDto> getAllProjects();
	
	//public ProjectMasterEntity saveProject(ProjectMasterDto projectMasterDto);
	
	public StudentMasterEntity getStudentById(Integer studentId) throws StudentNotFoundException;


}
