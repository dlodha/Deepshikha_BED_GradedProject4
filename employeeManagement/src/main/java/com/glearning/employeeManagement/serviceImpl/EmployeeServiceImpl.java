package com.glearning.employeeManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.glearning.employeeManagement.entity.Employee;
import com.glearning.employeeManagement.repository.EmployeeRepository;
import com.glearning.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
    @Autowired
	private EmployeeRepository employeeRepository;
    
	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public Employee findEmployeeById(Long id) {
		// TODO Auto-generated method stub
		
		return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee doesn't exist"));
	}

	@Override
	public Employee updateEmployee(Long id, Employee emp) {
		// TODO Auto-generated method stub
		Employee existingEmp = findEmployeeById(id);
		existingEmp.setFirstName(emp.getFirstName());
		existingEmp.setLastName(emp.getLastName());
		existingEmp.setEmail(emp.getEmail());
		return employeeRepository.save(existingEmp);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchEmployeeByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepository.searchEmployeeByFirstName(firstName);
	}

	@Override
	public List<Employee> findAllEmployeeSortedByFirstName(String strDirection) {
		// TODO Auto-generated method stub
		Sort.Direction direction = strDirection.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
