package com.cognizant.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
