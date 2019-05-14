package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.ParentTask;
import com.cognizant.entity.Task;
import com.cognizant.model.ProjectTaskRecord;
import com.cognizant.model.TaskRecord;
import com.cognizant.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	private static final Logger logger = Logger.getLogger(TaskService.class.getName());

	@Autowired
	public TaskRepository taskRepository;

	@Autowired
	public UserService userService;
	
	@Autowired
	public ParentTaskService parentTaskService;

	public TaskRecord saveTask(TaskRecord taskRecord) {
		try {
			logger.info("saving data to task table");
			Task task = new Task();
			task.setTaskName(taskRecord.taskName);
			task.setStartDate(taskRecord.startDate);
			task.setEndDate(taskRecord.endDate);
			task.setPriority(taskRecord.priority);
			task.setStatus(taskRecord.status);
			task.setProjectId(taskRecord.project.getProjectId());
			task.setParentId(taskRecord.parent.getParentId());
			task.setUserId(taskRecord.user.getUserId());
			taskRepository.save(task);
			return taskRecord;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while saving all data into task table", e.getMessage());
			throw e;
		}
	}

	public List<TaskRecord> getTask() {
		try {
			logger.info("getting data from task table");
			List<Task> tasks=taskRepository.findAll();
			List<TaskRecord> tlist=new ArrayList<TaskRecord>();
			
			for(Task t:tasks){
				TaskRecord taskRecord= new TaskRecord();
				taskRecord.setTaskId(t.getTaskId());
				taskRecord.setTaskName(t.getTaskName());
				taskRecord.setStartDate(t.getStartDate());
				taskRecord.setEndDate(t.getEndDate());
				taskRecord.setPriority(t.getPriority());
				taskRecord.setStatus(t.getStatus());
				Optional<ParentTask> parentTask=parentTaskService.getparentTaskData(t.getParentId());
			}
			return tlist;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while getting all data from task table", e.getMessage());
			throw e;
		}
		
	}

	public String deleteTask(Long taskId) {
		try {
			logger.info("deleting data from task table");
			taskRepository.suspendById(taskId);
			return "Task deleted successfully";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while deleting data from task table", e.getMessage());
			throw e;
		}
	}

	public Task updateTask(Task task, Long taskId) {
		try {
			logger.info("updating data in task table");
			task.setTaskId(taskId);
			return taskRepository.save(task);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while updating data into task table", e.getMessage());
			throw e;
		}
	}

	public List<Task> getTaskBySearch(Long projectId) {
		try {
			logger.info("searching task accoring to project id in task table");
			return taskRepository.getTaskBySearch(projectId);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while searching task accoring to project id in task table",
					e.getMessage());
			throw e;
		}
	}
	
	public List<Object[]> getProjectRelatedDetails(Long projectId){
		return taskRepository.getProjectRelatedDetails(projectId);
		
	}
}
