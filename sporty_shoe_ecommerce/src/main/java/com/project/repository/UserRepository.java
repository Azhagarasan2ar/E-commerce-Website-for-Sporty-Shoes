package com.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	
	Optional<User> findByuserName(@Param("userName") String userName);

}
