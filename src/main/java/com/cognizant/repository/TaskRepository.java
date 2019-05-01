package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query("UPDATE Task SET STATUS='complete' WHERE task_id= :taskId")
	void suspendById(@Param("taskId") Long taskId);

	@Query("from Task where project_id= :projectId")
	List<Task> getTaskBySearch(@Param("projectId") Long projectId);
	
	@Query("select count(task_id), count(case status when 'completed' then 1 else 0 end) from Task where project_id= :projectId")
	List<Task> getProjectRelatedDetails(Long projectId);

}
