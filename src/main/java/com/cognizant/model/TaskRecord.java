package com.cognizant.model;

import java.util.Date;

import com.cognizant.entity.ParentTask;
import com.cognizant.entity.Project;
import com.cognizant.entity.User;

public class TaskRecord {
	
	public String taskName="";
	public Date startDate=null;
	public Date endDate=null;
	public int priority=0;
	public String status="";
	public User user;
	public Project project;
	public ParentTask parent;

	public TaskRecord(String taskName, Date startDate, Date endDate, int priority, String status, User user, Project project, ParentTask parent) {
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.user = user;
		this.project = project;
		this.parent = parent;
	}

	public String getTaskName() {
		return taskName;
	}

	public Project getProject() {
		return project;
	}

}
