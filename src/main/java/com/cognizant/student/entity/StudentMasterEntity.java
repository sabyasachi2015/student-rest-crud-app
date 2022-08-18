/**
 * 
 */
package com.cognizant.student.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cognizant.student.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author sabyasachi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "STUDENT")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate" }, 
                        allowGetters = true)

public class StudentMasterEntity extends Auditable<String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "first_name")
	//@NotBlank
	 @NotEmpty(message = "Student first name must not be empty")
	// @Length(min = 3, max = 25)
	private String studentFirstName;

	@Column(name = "last_name")
	//@NotBlank
	 @NotEmpty(message = "Student last name must not be empty")
	// @Length(min = 3, max = 15)
	private String studentLastName;

	@Column(name = "email_id")
	@Email
	@NotEmpty(message = "email should be unique")
	private String studentEmail;

	@Column(name = "course_fees")
	private Double studentCourseFees;

	@OneToMany(targetEntity = ProjectMasterEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "sp_fk", referencedColumnName = "student_id")
	// @ManyToOne(cascade =CascadeType.ALL,targetEntity = ProjectMasterEntity.class)
	// @JoinColumn(name="project_id")
	private List<ProjectMasterEntity> projects = new ArrayList<>();

}
