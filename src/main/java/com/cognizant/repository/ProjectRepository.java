package com.cognizant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

}
