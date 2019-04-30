package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.ParentTask;
import com.cognizant.model.ParentTaskRecord;
import com.cognizant.repository.ParentTaskRepository;

@Service
@Transactional
public class ParentTaskService {
	
	@Autowired
	public ParentTaskRepository parentTaskRepository;

	public ParentTask save(ParentTaskRecord parentTaskRecord) {
		ParentTask parenTask=new ParentTask();
		parenTask.setParentTaskName(parentTaskRecord.parentTaskName);
		return parentTaskRepository.save(parenTask);
	}

	public List<ParentTask> getParentTasks() {
		return parentTaskRepository.findAll();
	}

}
