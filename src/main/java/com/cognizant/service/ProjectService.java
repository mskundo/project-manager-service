package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Project;
import com.cognizant.model.ProjectRecord;
import com.cognizant.repository.ProjectRepository;

@Transactional
@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	public UserService userService;

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	public ProjectRecord saveProject(ProjectRecord projectRecord) {
		Project project = new Project();
		project.setProjectName(projectRecord.projectName);
		project.setStartDate(projectRecord.startDate);
		project.setEndDate(projectRecord.endDate);
		project.setPriority(projectRecord.priority);
		projectRepository.save(project);
		userService.updatProjectIdUser(project.getProjectId(),projectRecord.user);
		return projectRecord;
	}

	public void deleteProject(Long projectId) {
		projectRepository.deleteById(projectId);
		
	}

	public Project updateProject(Project project, Long projectId) {
		project.setProjectId(projectId);
		return projectRepository.save(project);
	}

}
