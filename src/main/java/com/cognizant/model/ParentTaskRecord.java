package com.cognizant.model;

public class ParentTaskRecord {
	
	public String taskName="";
	public TaskRecord task;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public TaskRecord getTask() {
		return task;
	}
	public void setTask(TaskRecord task) {
		this.task = task;
	}
	
	
	
}
