/**
 * 
 */
package com.cognizant.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.student.entity.ProjectMasterEntity;

/**
 * @author sudipta subhadarshin
 *
 */
@Repository
public interface ProjectMasterRepository extends JpaRepository<ProjectMasterEntity, Integer> {
	
	//@Query("SELECT ProjectMasterEntity FROM p where p.st")
	//public ProjectMasterEntity findProjectWithStudentId(Integer studentId);
	
	//public List<ProjectMasterEntity> findAllProject();
	

}
