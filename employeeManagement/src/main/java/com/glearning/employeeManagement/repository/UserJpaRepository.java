package com.glearning.employeeManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.employeeManagement.entity.User;

public interface UserJpaRepository extends JpaRepository<User,Integer>{
   public Optional<User> findByUserName(String name);
}
