package com.cognizant.service;

import com.cognizant.entity.Task;
import com.cognizant.entity.User;
import com.cognizant.model.TaskRecord;
import com.cognizant.repository.TaskRepository;
import com.cognizant.util.TaskMockData;
import com.cognizant.util.UserMockData;
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

	@Test
	public void saveTask() {

		Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(new TaskMockData().getSingleTask());
		Mockito.when(userService.updateTaskIdUser(Mockito.anyLong(), Mockito.any(User.class)))
				.thenReturn(new UserMockData().getSingleUser());

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
		Task output = taskService.updateTask(new TaskMockData().getSingleTaskWithoutTaskId(), (long) 1);

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
				.thenReturn(new TaskMockData().getTaskBySearchList());

		List<Task> output = taskService.getTaskBySearch(Mockito.anyLong());

		Assert.assertEquals(2, output.size());

	}

	@Test
	public void getProjectRelatedDetailsTest() {

		Mockito.when(taskRepository.getProjectRelatedDetails(Mockito.anyLong()))
				.thenReturn(new TaskMockData().getProjectRelatedDetailsList());

		List<Task> output = taskService.getProjectRelatedDetails(Mockito.anyLong());

		Assert.assertEquals(2, output.size());

	}

}
