package com.glearning.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employeeManagement.entity.Role;
import com.glearning.employeeManagement.entity.User;
import com.glearning.employeeManagement.service.UserRoleService;

@RestController
public class UserRoleController {
  @Autowired
  private UserRoleService userRoleService;
  
  @PostMapping("/api/role/create")
	public void createRole(@RequestBody Role role){
	  userRoleService.saveRole(role);
	}
  
  @PostMapping("/api/user/create")
	public void createUser(@RequestBody User user){
	  userRoleService.saveUser(user);
	}
}
