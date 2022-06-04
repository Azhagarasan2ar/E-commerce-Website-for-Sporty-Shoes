package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepo;
	
	public List<User> listUser()
	{
		List<User> userList=new ArrayList<User>();
		userrepo.findAll().forEach(user -> userList.add(user));
		
		return userList;
	}
	
	public User getUserByName(String name)
	{
		Optional<User> optional=userrepo.findByuserName(name);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}
}

