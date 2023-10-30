package com.glearning.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.employeeManagement.entity.Role;

public interface RoleJpaRepository extends JpaRepository<Role,Integer>{

}
