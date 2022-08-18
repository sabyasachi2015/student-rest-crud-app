/**
 * 
 */
package com.cognizant.student.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.student.dto.ProjectMasterDto;
import com.cognizant.student.dto.StudentMasterDto;
import com.cognizant.student.entity.ProjectMasterEntity;
import com.cognizant.student.entity.StudentMasterEntity;
import com.cognizant.student.exception.ProjectNotFoundException;
import com.cognizant.student.exception.StudentNotFoundException;
import com.cognizant.student.repository.ProjectMasterRepository;
import com.cognizant.student.repository.StudentMasterRepository;
import com.cognizant.student.service.IStudentMasterService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sabyasachi
 *
 */
@Service
@Slf4j
public abstract class StudentMasterServiceImpl implements IStudentMasterService {

	@Autowired
	private StudentMasterRepository studentMasterRepository;

	@Autowired
	private ProjectMasterRepository projectMasterRepository;

	@Override
	@Transactional()
	public StudentMasterEntity saveStudent(StudentMasterEntity studentMasterDto) {
		log.info("StudentMsterserviceImpl::saveStudent() Exceuction started");

		List<ProjectMasterEntity> projectEntityList = new ArrayList<>();

		StudentMasterEntity studentMasterEntity = new StudentMasterEntity();

		studentMasterEntity.setStudentId(studentMasterDto.getStudentId());
		studentMasterEntity.setStudentFirstName(studentMasterDto.getStudentFirstName());
		studentMasterEntity.setStudentLastName(studentMasterDto.getStudentLastName());
		studentMasterEntity.setStudentEmail(studentMasterDto.getStudentEmail());
		// studentMasterEntity.setMobileNumber(studentMasterDto.getMobileNumber());
		studentMasterEntity.setStudentCourseFees(studentMasterDto.getStudentCourseFees());

		for (ProjectMasterEntity projectMasterDto : studentMasterDto.getProjects()) {

			ProjectMasterEntity projectMasterEntity = new ProjectMasterEntity();

			projectMasterEntity.setProjectId(projectMasterDto.getProjectId());
			projectMasterEntity.setProjectName(projectMasterDto.getProjectName());
			projectMasterEntity.setClientLocation(projectMasterDto.getClientLocation());
			projectMasterEntity.setDuration(projectMasterDto.getDuration());

			projectEntityList.add(projectMasterEntity);
		}
		studentMasterEntity.setProjects(projectEntityList);
		return studentMasterRepository.save(studentMasterEntity);
	}

	@Override
	public List<StudentMasterEntity> getAllstudents() throws StudentNotFoundException {
		log.info("***getAllstudents()::Execution Started****");

		List<StudentMasterEntity> studentsList = new ArrayList<>();

		// Call repository layer method

		studentsList = studentMasterRepository.findAll();

		return studentsList.stream()
				// .map(studentMasterEntity ->
				// modelMapper.map(studentMasterEntity, StudentMasterDto.class))
				// .sorted(Comparator.comparingDouble(StudentMasterDto::getStudentCourseFees).reversed())
				.sorted(Comparator.comparingDouble(StudentMasterEntity::getStudentCourseFees).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public StudentMasterEntity getStudentById(Integer studentId) throws StudentNotFoundException {

		// call repository
		Optional<StudentMasterEntity> optionalStudent = studentMasterRepository.findById(studentId);

		// modelMapper.map(optionalStudent, StudentMasterDto.class);

		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			throw new StudentNotFoundException("Student Not Found with id:" + studentId);
		}
	}
}