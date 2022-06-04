package com.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer>{
	
	Optional<Admin> findByadminName(@Param("adminName") String adminName);

}
