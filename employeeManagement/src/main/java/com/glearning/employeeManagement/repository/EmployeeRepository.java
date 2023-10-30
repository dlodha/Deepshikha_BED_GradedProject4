package com.glearning.employeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    public List<Employee> searchEmployeeByFirstName(String firstName);
}
