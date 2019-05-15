package com.cognizant.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.User;
import com.cognizant.model.UserRecord;
import com.cognizant.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private static final Logger logger = Logger.getLogger(ProjectService.class.getName());

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public ProjectService projectService;

	public User saveUser(UserRecord userRecord) {
		try {
			logger.info("saving data into user table");
			User user = new User();
			user.setFirstName(userRecord.firstName);
			user.setLastName(userRecord.lastName);
			user.setEmpId(userRecord.empId);
			return userRepository.save(user);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while saving data into user table", e.getMessage());
			throw e;
		}
	}

	public List<User> getAll() {
		try {
			logger.info("getting data from user table");
			return userRepository.findAll();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while getting data from user table", e.getMessage());
			throw e;
		}
	}

	public String deleteUser(Long userId) {
		try {
			logger.info("deleting data from user table");
			userRepository.deleteById(userId);
			return "user deleted successfully";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while deleting data from user table", e.getMessage());
			throw e;
		}
	}

	public User updateUser(User user, Long userId) {
		try {
			logger.info("updating data to user table");
			user.setUserId(userId);
			return userRepository.save(user);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while updating data into user table", e.getMessage());
			throw e;
		}
	}

	public List<User> sortByName() {
		try {
			logger.info("sorting user data by first name");
			return userRepository.findAll(Sort.by("firstName").ascending());
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while sorting user data by first name", e.getMessage());
			throw e;
		}
	}

	public List<User> sortByLastName() {
		try {
			logger.info("sorting user data by first name");
			return userRepository.findAll(Sort.by("lastName").ascending());
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while sorting user data by last name", e.getMessage());
			throw e;
		}
	}

	public List<User> sortByEmpId() {
		try {
			logger.info("sorting user data by first name");
			return userRepository.findAll(Sort.by("empId").ascending());
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occurred while sorting user data by employee id", e.getMessage());
			throw e;
		}
	}
}
