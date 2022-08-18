/**
 * 
 */
package com.cognizant.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.student.entity.ProjectMasterEntity;
import com.cognizant.student.entity.StudentMasterEntity;

/**
 * @author sudipta subhadarshin
 *
 */
@Repository
public interface StudentMasterRepository extends JpaRepository<StudentMasterEntity,Integer> {

	//public ProjectMasterEntity findProjectWithStudentId(Integer studentId);
}
