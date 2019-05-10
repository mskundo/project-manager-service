package com.cognizant.model;

import com.cognizant.entity.Project;

public class ProjectTaskRecord {
	
	public ProjectRecord projectRecord;
	public long completedTask=0L;
	public long noOfTask=0L;
	public ProjectRecord getProjectRecord() {
		return projectRecord;
	}
	public void setProjectRecord(ProjectRecord projectRecord) {
		this.projectRecord = projectRecord;
	}
	public long getCompletedTask() {
		return completedTask;
	}
	public void setCompletedTask(long completedTask) {
		this.completedTask = completedTask;
	}
	public long getNoOfTask() {
		return noOfTask;
	}
	public void setNoOfTask(long noOfTask) {
		this.noOfTask = noOfTask;
	}
	
	

}
