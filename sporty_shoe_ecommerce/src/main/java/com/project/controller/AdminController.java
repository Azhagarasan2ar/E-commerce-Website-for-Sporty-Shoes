package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@GetMapping("/login")
	public String getLoginForm()
	{
		return "adminlogin";
		
	}
	
	@GetMapping("/logout")
	public String loggingout()
	{
		return "redirect:login";
	}
	
	@GetMapping("/index/changePassword")
	public String getChangePassword()
	{
		return "changePassword";
	}
	
	@PostMapping("/index/changePassword")
	public String changPassword(@RequestParam(name="admin_name") String admin,@RequestParam(name="password") String password,@RequestParam(name="change_password") String pwdToChange,Model model)
	{
		if(adminservice.changePassword(admin, password, pwdToChange))
		{
			model.addAttribute("message", "password changed");
			return "changePassword";
		}
		model.addAttribute("message", "admin name or password are wrong");
		return "changePassword";
	}
	
}