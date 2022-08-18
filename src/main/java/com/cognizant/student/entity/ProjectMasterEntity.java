/**
 * 
 */
package com.cognizant.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sabyasachi
 *
 */

@Entity
@Table(name="PROJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMasterEntity {
	@Id
	@Column(name="projcet_id")
	private Integer projectId;
	
	@Column(name="projcet_name")
	//@NotEmpty(message="Project name should not be empty")
	private String projectName;
	
	@Column(name="location")
	//@NotEmpty(message="Location should not be empty")
	private String clientLocation;
	
	@Column(name="duration")
	//@Length(max=5)
	private Integer duration;
	
}
