package com.cognizant.student.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProjectMasterDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1904377595314647789L;
	
	private Integer projectId;
	private String projectName;
	private String clientLocation;
	private Integer duration;
	//private Integer teamsize;

}
