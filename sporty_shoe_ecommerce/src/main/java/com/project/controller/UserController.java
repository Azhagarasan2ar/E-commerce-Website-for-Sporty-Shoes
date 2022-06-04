package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.User;
import com.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	
	@GetMapping("/index/usersList")
	public String listUser(Model model)
	{
		List<User> userList=userservice.listUser();
		model.addAttribute("users", userList);
		return "usersList";
	}
	
	@GetMapping("/index/userDetails")
	public String getUserByName(@RequestParam(name="user_name") String userName , Model model)
	{
		User user=userservice.getUserByName(userName);
		if(user==null)
		{
			return "redirect:usersList";
		}
		
		model.addAttribute("user", user);
		return "userDetails";
	}
}
