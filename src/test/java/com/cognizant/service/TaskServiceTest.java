package com.cognizant.service;

import com.cognizant.entity.Task;
import com.cognizant.model.TaskRecord;
import com.cognizant.repository.TaskRepository;
import com.cognizant.util.ParentTaskMockData;
import com.cognizant.util.TaskMockData;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {

	@InjectMocks
	public TaskService taskService;

	@Mock
	public TaskRepository taskRepository;

	@Mock
	public UserService userService;
	
	@Mock
	public ParentTaskService parentTaskService;

	@Test
	public void saveTask() {

		Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(new TaskMockData().getSingleTask());

		TaskRecord output = taskService.saveTask(new TaskMockData().getTaskRecord());

		Assert.assertEquals(new TaskMockData().getTaskRecord().getTaskName(), output.getTaskName());
		Assert.assertEquals(new TaskMockData().getTaskRecord().getProject().getProjectId(),
				output.getProject().getProjectId());
	}

	@Test
	public void deleteTaskTest() {

		Assert.assertEquals("Task deleted successfully", taskService.deleteTask((long) 1));
	}

	@Test
	public void updateTaskTest() {

		Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(new TaskMockData().getSingleTask());
		Task output = taskService.updateTask(new TaskMockData().getSingleTask(), (long) 1);

		Assert.assertEquals(new TaskMockData().getSingleTask().getTaskId(), output.getTaskId());
		
	}
	

	@Test
	public void getTaskTest() {

		Mockito.when(taskRepository.findAll()).thenReturn(new TaskMockData().getTaskList());

		List<Task> output = taskService.getTask();

		Assert.assertEquals(2, output.size());

	}

	@Test
	public void getTaskBySearchTest() {

		Mockito.when(taskRepository.getTaskBySearch(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getTaskList());
		
		Mockito.when(parentTaskService.getparentTaskData(Mockito.anyLong()))
		.thenReturn(new ParentTaskMockData().getParentTaskListData());

		List<TaskRecord> output = taskService.getTaskBySearch(Mockito.anyLong());

		Assert.assertEquals(2, output.size());

	}
	
	@Test
	public void getNoOfTasksTest() {

		Mockito.when(taskRepository.getTaskIdCount(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getNoOfTasks());

		Long output = taskService.getNoOfTasks(Mockito.anyLong());

		Assert.assertEquals(Long.valueOf(1), output);

	}
	
	@Test
	public void getCompletedTasks() {

		Mockito.when(taskRepository.getStatusCompletedCount(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getStatusCompletedCount());

		Long output = taskService.getCompletedTasks(Mockito.anyLong());

		Assert.assertEquals(Long.valueOf(1), output);

	}

}
