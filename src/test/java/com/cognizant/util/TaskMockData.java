package com.cognizant.util;

import com.cognizant.entity.Task;
import com.cognizant.model.ProjectTaskRecord;
import com.cognizant.model.TaskRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TaskMockData {

	public TaskRecord getTaskRecord() {
		
		TaskRecord task=new TaskRecord();
		task.setTaskName("DummyTask");
		task.setStartDate(java.sql.Date.valueOf(LocalDate.parse("2019-04-02")));
		task.setEndDate(java.sql.Date.valueOf(LocalDate.parse("2019-04-03")));
		task.setPriority(1);
		task.setStatus("New");
		task.setUser(new UserMockData().getSingleUser());
		task.setProject(new ProjectMockData().getSingleProject());
		task.setParent(new ParentTaskMockData().getSingleParentTask());

		return task;
	}

	public Task getSingleTask() {

		return new Task((long) 1, (long) 1, "DummyTask", java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, "New", (long) 1);
	}

//	public Task getSingleTaskWithoutTaskId() {
//
//		return new Task((long) 1, (long) 1, "DummyTask", java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
//				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, "New");
//	}

	public List<Task> getTaskList() {

		List<Task> taskList = new ArrayList<>();

		taskList.add(new Task((long) 1, (long) 1, "DummyTask",
				java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, "New",(long) 1));

		taskList.add(new Task((long) 2, (long) 1, "DummyTask2",
				java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, "New",(long) 1));

		return taskList;
	}

	public List<TaskRecord> getTaskBySearchList() {

		List<TaskRecord> taskList = new ArrayList<>();
		TaskRecord t=new TaskRecord();
		t.setParentName("DummyTask");
		t.setStartDate(java.sql.Date.valueOf(LocalDate.parse("2019-04-02")));
		t.setEndDate(java.sql.Date.valueOf(LocalDate.parse("2019-04-03")));
		t.setPriority(1);
		t.setStatus("New");
		t.setParent(new ParentTaskMockData().getSingleParentTask());
		t.setProject(new ProjectMockData().getSingleProject());
		t.setUser(new UserMockData().getSingleUser());
		taskList.add(t);

		return taskList;
	}

	public List<Object[]> getProjectRelatedDetailsList() {
		List<Object[]> list=new ArrayList<Object[]>();
		ProjectTaskRecord p=new ProjectTaskRecord();
		p.setCompletedTask((long)1);
		p.setNoOfTask((long)1);
		list.addAll((Collection<? extends Object[]>) p);
		return list;
	}

//	public List<Task> getProjectRelatedDetailsList() {
//		List<Task> taskList = new ArrayList<>();
//
//		taskList.add(new Task((long) 1, (long) 1, (long) 1, "DummyTask",
//				java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
//				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, "New"));
//
//		taskList.add(new Task((long) 2, (long) 1, (long) 1, "DummyTask2",
//				java.sql.Date.valueOf(LocalDate.parse("2019-04-02")),
//				java.sql.Date.valueOf(LocalDate.parse("2019-04-03")), 1, "New"));
//
//		return taskList;
//	}

}
