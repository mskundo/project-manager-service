package com.cognizant.service;

import com.cognizant.entity.Project;
import com.cognizant.model.ProjectRecord;
import com.cognizant.model.ProjectTaskRecord;
import com.cognizant.repository.ParentTaskRepository;
import com.cognizant.repository.ProjectRepository;
import com.cognizant.util.ParentTaskMockData;
import com.cognizant.util.ProjectMockData;
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
    public UserService userService;
    
    @Mock
    public ParentTaskRepository parentTaskRepository;

    @Test
    public void saveProjectTest(){

        Mockito.when(projectRepository.save(Mockito.any(Project.class))).thenReturn(new ProjectMockData().getSingleProject());
        ProjectRecord output = projectService.saveProject(new ProjectMockData().getProjectRecord());

        Assert.assertEquals(new ProjectMockData().getProjectRecord().getProjectName(), output.getProjectName());
        Assert.assertEquals(new ProjectMockData().getProjectRecord().getStartDate(), output.getStartDate());
    }

    @Test
    public void deleteProjectTest(){

        Assert.assertEquals("deleted project successfully", projectService.deleteProject((long)1));
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
        
        Mockito.when(parentTaskRepository.findNameById(Mockito.anyLong()))
		.thenReturn(new ParentTaskMockData().getParentTaskListData());

        List<ProjectTaskRecord> output = projectService.findAll();

        Assert.assertEquals(2,output.size());

    }
}
