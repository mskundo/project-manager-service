package com.cognizant.model;

import java.util.Date;

import com.cognizant.entity.Task;
import com.cognizant.entity.User;

public class ProjectRecord {
	
	public String projectName="";
	public Date startDate=null;
	public Date endDate=null;
	public int priority=0;
	public User user;
	public Task task;

	public ProjectRecord(String projectName, Date startDate, Date endDate, int priority, User user, Task task) {
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.user = user;
		this.task = task;
	}

	public String getProjectName() {
		return projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

}
