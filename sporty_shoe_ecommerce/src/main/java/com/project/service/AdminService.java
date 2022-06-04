package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Admin;
import com.project.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminrepo;
	
	public boolean toCheck(String name,String password)
	{
		Admin adminobj=new Admin();
		Optional<Admin> optional=adminrepo.findByadminName(name);
		
		if(optional.isPresent())
		{
			adminobj= optional.get();
			String admin=adminobj.getAdminName();
			String adminpwd=adminobj.getAdminPassword();
			if(name.equals(admin) && password.equals(adminpwd))
			{
				return true;
			}
			return false;
		}
		
		return false;
	}
	
	public boolean changePassword(String admin,String password,String pwdToChange)
	{
		Admin adminobj=new Admin();
		Optional<Admin> optional=adminrepo.findByadminName(admin);
		
		if(optional.isPresent())
		{
			adminobj= optional.get();
			String adminInDB=adminobj.getAdminName();
			String pwdInDB=adminobj.getAdminPassword();
			if(adminInDB.equals(admin) && pwdInDB.equals(password))
			{
				adminobj.setAdminPassword(pwdToChange);
				adminrepo.save(adminobj);
				return true;
			}
			return false;
		}
		
		return false;
	}
	

}
