package com.cognizant.model;

import java.util.Date;

import com.cognizant.entity.ParentTask;
import com.cognizant.entity.Project;
import com.cognizant.entity.User;

public class TaskRecord {
	
	public long taskId;
	public String taskName;
	public Date startDate;
	public Date endDate;
	public int priority;
	public String status;
	public User user;
	public Project project;
	public ParentTask parent;
	public String ParentName;
	
	
	
	public String getParentName() {
		return ParentName;
	}
	public void setParentName(String parentName) {
		ParentName = parentName;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public ParentTask getParent() {
		return parent;
	}
	public void setParent(ParentTask parent) {
		this.parent = parent;
	}
		

}
