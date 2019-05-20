package com.cognizant.service;

import com.cognizant.entity.Project;
import com.cognizant.model.ProjectRecord;
import com.cognizant.model.ProjectTaskRecord;
import com.cognizant.repository.ProjectRepository;
import com.cognizant.repository.TaskRepository;
import com.cognizant.util.ProjectMockData;
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
public class ProjectServiceTest {

    @InjectMocks
    public ProjectService projectService;

    @Mock
    public ProjectRepository projectRepository;
    
    @Mock
    public TaskRepository taskRepository;

    @Mock
    public UserService userService;
    
    @Mock
    public TaskService taskService;

    @Test
    public void saveProjectTest(){

        Mockito.when(projectRepository.save(Mockito.any(Project.class))).thenReturn(new ProjectMockData().getSingleProject());
        ProjectRecord output = projectService.saveProject(new ProjectMockData().getProjectRecord());

        Assert.assertEquals(new ProjectMockData().getProjectRecord().getProjectName(), output.getProjectName());
        Assert.assertEquals(new ProjectMockData().getProjectRecord().getStartDate(), output.getStartDate());
    }

    @Test
    public void deleteProjectTest(){
    	String output = projectService.deleteProject((long)1);
    	
    	
    	 taskRepository.suspendById(Mockito.anyLong());

        Assert.assertEquals("deleted project successfully", output);
    }

    @Test
    public void updateProjectTest(){

        Mockito.when(projectRepository.save(Mockito.any(Project.class))).thenReturn(new ProjectMockData().getSingleProject());
        Project output = projectService.updateProject(new ProjectMockData().getSingleProjectWithoutProjectId(), (long)1);

        Assert.assertEquals(new ProjectMockData().getSingleProject().getProjectId(), output.getProjectId());
    }

    @Test
    public void findAllProjectsTest(){

        Mockito.when(projectRepository.findAll()).thenReturn(new ProjectMockData().getProjectList());

        List<Project> output = projectService.findAllProjects();

        Assert.assertEquals(2,output.size());

    }
    
    @Test
    public void findAllTest(){

        Mockito.when(projectRepository.findAll()).thenReturn(new ProjectMockData().getProjectList());
        
        Mockito.when(taskService.getNoOfTasks(Mockito.anyLong()))
		.thenReturn(new TaskMockData().getNoOfTasks());
        
        Mockito.when(taskService.getCompletedTasks(Mockito.anyLong()))
		.thenReturn(new TaskMockData().getCompletedTasks());

        List<ProjectTaskRecord> output = projectService.findAll();

        Assert.assertEquals(0,output.size());

    }
}
