package com.cognizant.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="task")

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Task {

	@Id
    @GeneratedValue
    @Column(name="task_id")
	private Long taskId;
	
	@Column(name="parent_id")
	private Long parentId;
	
	@Column(name="project_id")
	private Long projectId;
	
	@Column(name="task_name")
	private String taskName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private Date startDate;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
    @Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
	
	@Column(name="priority")
	private int priority;
	
	@Column(name="status")
	private String status;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}



	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
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



	public void setStatus(String status) {
		this.status = status;
	}

	public Task(Long taskId, Long parentId, Long projectId, String taskName, Date startDate, Date endDate, int priority,
			String status) {
		super();
		this.taskId = taskId;
		this.parentId = parentId;
		this.projectId = projectId;
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
	}

	public Task(Long parentId, Long projectId, String taskName, Date startDate, Date endDate, int priority, String status) {
		this.parentId = parentId;
		this.projectId = projectId;
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
	}

	public Task() {
		
	}
}
