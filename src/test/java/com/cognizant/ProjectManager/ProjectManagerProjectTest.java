package com.cognizant.ProjectManager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.entity.Project;
import com.cognizant.model.ProjectRecord;
import com.cognizant.repository.ProjectRepository;
import com.cognizant.service.ProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerProjectTest {

	@Mock
	private ProjectRepository projectRepository;

	@InjectMocks
	private ProjectService projectService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {
		List<Project> project = new ArrayList<Project>();
		project.add(new Project(1L, "Telstra", null, null, 1));
		project.add(new Project(2L, "Telstra comm", null, null, 1));
		when(projectRepository.findAll()).thenReturn(project);
		List<Project> result = projectService.findAll();
		assertEquals(2, result.size());
	}

	@Test
	public void testDeleteProject() {
		Project project = new Project(1L, "Telstra", null, null, 1);
		projectService.deleteProject(project.getProjectId());
		verify(projectRepository, times(1)).deleteById(project.getProjectId());
	}

	@Test
	public void testUpdateProject() {
		Project project = new Project(2L, "Telstra comm", null, null, 1);
		when(projectRepository.save(project)).thenReturn(project);
		Project result = projectService.updateProject(project, 1L);
		assertEquals("Telstra comm", result.getProjectName());
		assertEquals(null, result.getStartDate());
		assertEquals(null, result.getEndDate());
		assertEquals(1, result.getPriority());
	}

	@Test
	public void testSaveProject() {
		Project project = new Project();
		ProjectRecord projectRecord = new ProjectRecord();
		projectRecord.projectName = "telstra";
		projectRecord.startDate = null;
		projectRecord.endDate = null;
		projectRecord.priority = 1;
		project.setProjectName(projectRecord.projectName);
		project.setStartDate(projectRecord.startDate);
		project.setEndDate(projectRecord.endDate);
		project.setPriority(projectRecord.priority);
		when(projectRepository.save(project)).thenReturn(project);
	}

}
