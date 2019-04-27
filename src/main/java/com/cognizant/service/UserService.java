package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.User;
import com.cognizant.model.UserRecord;
import com.cognizant.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public ProjectService projectService;


	public User saveUser(UserRecord userRecord) {
		User user=new User();
		user.setUserId(userRecord.userId);
		user.setFirstName(userRecord.firstName);
		user.setLastName(userRecord.lastName);
		user.setEmpId(userRecord.employeeId);
		return userRepository.save(user);
	}
	
	public User updatProjectIdUser(Long projectId, User user){
		user.setProjectId(projectId);
		return userRepository.save(user);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public User updateUser(User user, Long userId) {
		user.setUserId(userId);
		return userRepository.save(user);
	}
}
