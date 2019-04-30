package com.cognizant.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="project")

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
	private Long projectId;
	
	@Column(name="project")
	private String projectName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
    @Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
    @Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
	
	@Column(name="Priority")
	private int priority;
	
	public Project() {
		super();
	}
	
	public Project(Long projectId, String projectName, Date startDate, Date endDate, int priority) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}

	public Project(String projectName, Date startDate, Date endDate, int priority) {
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}

	public Long getProjectId() {
		return projectId;
	}


	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}





	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}





	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}





	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}





	public void setPriority(int priority) {
		this.priority = priority;
	}	

}
