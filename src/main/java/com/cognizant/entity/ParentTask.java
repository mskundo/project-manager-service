package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parent_task")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ParentTask {

	@Id
	@GeneratedValue
	@Column(name = "parent_id")
	private Long parentId;

	@Column(name = "parent_task")
	private String parentTaskName;

	@Column(name = "project_id")
	private Long projectId;

	public ParentTask(Long parentId, String parentTaskName, Long projectId) {
		super();
		this.parentId = parentId;
		this.parentTaskName = parentTaskName;
		this.projectId = projectId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public ParentTask() {

	}
}
