package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.ParentTask;

public interface ParentTaskRepository extends JpaRepository<ParentTask, Long>{

}
