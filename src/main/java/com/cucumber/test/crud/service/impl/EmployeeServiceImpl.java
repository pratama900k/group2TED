package com.cucumber.test.crud.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.cucumber.test.crud.model.Employee;
import com.cucumber.test.crud.repository.EmployeeRepository;
import com.cucumber.test.crud.service.EmployeeService;
import com.cucumber.test.crud.exception.ResourceNotFoundException;
 

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployees(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "EmployeeId", id));
	}

	@Override
	public Employee updateEmployees(Employee employee, Integer id) {
		// TODO Auto-generated method stub
		Employee ExistingEmployees = employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "EmployeeId", id));
		if(employee.getName() != null) { ExistingEmployees.setName(employee.getName()); }
		if(employee.getPhone() != null) { ExistingEmployees.setPhone(employee.getPhone()); }
		if(employee.getJob()  != null) { ExistingEmployees.setJob(employee.getJob()); } 
		employeeRepository.save(ExistingEmployees);
		return ExistingEmployees;
	}

	@Override
	public void deleteEmployees(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "EmployeeId", id));
		employeeRepository.deleteById(id);
	}

}
