package com.cognizant.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

//	@Query("from User where user_id:=userId")
//	List<User> getUserData(@Param("userId") Long userId);

}
