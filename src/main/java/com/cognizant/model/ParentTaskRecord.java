package com.cognizant.model;

import com.cognizant.entity.Task;

public class ParentTaskRecord {
	
	public String parentTaskName="";
	public Task task;

    public ParentTaskRecord(String parentTaskName, Task task) {
        this.parentTaskName = parentTaskName;
        this.task = task;
    }
}
