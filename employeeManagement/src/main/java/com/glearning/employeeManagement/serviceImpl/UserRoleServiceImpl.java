package com.glearning.employeeManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.glearning.employeeManagement.entity.Role;
import com.glearning.employeeManagement.entity.User;
import com.glearning.employeeManagement.repository.RoleJpaRepository;
import com.glearning.employeeManagement.repository.UserJpaRepository;
import com.glearning.employeeManagement.service.UserRoleService;


@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	 private UserJpaRepository userJpaRepository;
	 
	 @Autowired
	 private RoleJpaRepository roleJpaRepository;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleJpaRepository.save(role);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		//return userJpaRepository.save(user);
		User newUser = new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(this.passwordEncoder.encode(user.getPassword()));

		user.getRoles().forEach(role->newUser.addRole(role));
		return userJpaRepository.save(newUser);
		
	}
	 
}
