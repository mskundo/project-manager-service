package com.cognizant.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Project;
import com.cognizant.model.ProjectRecord;
import com.cognizant.repository.ProjectRepository;

@Transactional
@Service
public class ProjectService {

	private static final Logger logger = Logger.getLogger(ProjectService.class.getName());

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	public UserService userService;

	public List<Project> findAll() {
		try {
			logger.info("getting data from project table");
			return projectRepository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while getting all data into project table", e.getMessage());
			throw e;
		}
	}

	public ProjectRecord saveProject(ProjectRecord projectRecord) {
		try {
			logger.info("saving data to project table");
			Project project = new Project();
			project.setProjectName(projectRecord.projectName);
			project.setStartDate(projectRecord.startDate);
			project.setEndDate(projectRecord.endDate);
			project.setPriority(projectRecord.priority);
			projectRepository.save(project);
			userService.updatProjectIdUser(project.getProjectId(), projectRecord.user);
			return projectRecord;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while saving all data into project table", e.getMessage());
			throw e;
		}
	}

	public String deleteProject(Long projectId) {
		try {
			logger.info("deleting data from project table");
			projectRepository.deleteById(projectId);
			return "deleted project successfully";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while deletig data from project table", e.getMessage());
			throw e;
		}
	}

	public Project updateProject(Project project, Long projectId) {
		try {
			logger.info("updating data in project table");
			project.setProjectId(projectId);
			return projectRepository.save(project);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while updating data in project table", e.getMessage());
			throw e;
		}
	}

}
