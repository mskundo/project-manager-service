package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.Project;
import com.cognizant.model.ProjectRecord;
import com.cognizant.model.ProjectTaskRecord;
import com.cognizant.repository.ProjectRepository;

@Transactional
@Service
public class ProjectService {

	private static final Logger logger = Logger.getLogger(ProjectService.class.getName());

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	public UserService userService;

	@Autowired
	public TaskService taskService;

	public List<ProjectTaskRecord> findAll() {
		try {
			logger.info("getting data from project table");
			List<Project> projects = projectRepository.findAll();
			List<ProjectTaskRecord> ptlist = new ArrayList<ProjectTaskRecord>();
			
			for (Project p : projects) {
				ProjectRecord projectRecord = new ProjectRecord();
				projectRecord.setProjectId(p.getProjectId());
				projectRecord.setEndDate(p.getEndDate());
				projectRecord.setPriority(p.getPriority());
				projectRecord.setProjectName(p.getProjectName());
				projectRecord.setStartDate(p.getStartDate());
				List<Object[]> taskEntity = taskService.getProjectRelatedDetails(p.getProjectId());
				for (Object[] task : taskEntity) {
					ProjectTaskRecord pt=new ProjectTaskRecord();
					pt.setNoOfTask((long) task[0]);
					pt.setCompletedTask((long) task[1]);
					pt.setProjectRecord(projectRecord);
					ptlist.add(pt);
				}
			
			}

			return ptlist;
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
			project.setUserId(projectRecord.user.getUserId());
			projectRepository.save(project);
//			userService.updatProjectIdUser(project.getProjectId(), projectRecord.user);
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

	public List<Project> findAllProjects() {
		try {
			logger.info("getting all data from project table");
			return projectRepository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while getting all data from project table", e.getMessage());
			throw e;
		}
	}

}
