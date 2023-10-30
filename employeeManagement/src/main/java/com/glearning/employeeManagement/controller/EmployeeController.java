package com.glearning.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employeeManagement.entity.Employee;
import com.glearning.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee employee){
		employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/list")
	public List<Employee> listEmployees(){
		return employeeService.findAllEmployee();
	}
	@GetMapping("/view/{id}")
	public Employee viewEmployeeById(@PathVariable Long id) {
		return employeeService.findEmployeeById(id);
	}
	@GetMapping("/search/{firstName}")
	public List<Employee> searchEmployeeByFirstName(@PathVariable String firstName) {
		return employeeService.searchEmployeeByFirstName(firstName);
	}
	@GetMapping("/sort")
	public List<Employee> listSortedEmployeeByFirstName(@RequestParam(name="order", required=false) String direction) {
		return employeeService.findAllEmployeeSortedByFirstName(direction);
	}
	@PostMapping("/edit/{id}")
	public Employee updateEmployeeById(@PathVariable long id,@RequestBody Employee employee){
		return employeeService.updateEmployee(id, employee);
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable long id){
		employeeService.deleteEmployee(id);
		return "Deleted employee id - " + id;
	}
	
}
