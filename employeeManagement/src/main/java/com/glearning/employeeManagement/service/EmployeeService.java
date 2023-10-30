package com.glearning.employeeManagement.service;

import java.util.List;

import com.glearning.employeeManagement.entity.Employee;

public interface EmployeeService {
   public List<Employee> findAllEmployee();
   public List<Employee> findAllEmployeeSortedByFirstName(String direction);
   public Employee saveEmployee(Employee emp);
   public Employee findEmployeeById(Long id);
   public List<Employee> searchEmployeeByFirstName(String firstName);
   public Employee updateEmployee(Long id,Employee emp);
   public void deleteEmployee(Long id);
}
