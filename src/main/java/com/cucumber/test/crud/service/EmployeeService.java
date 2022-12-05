package com.cucumber.test.crud.service;

import java.util.List;

import com.cucumber.test.crud.model.Employee;

public interface EmployeeService {
	Employee saveEmployees(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id); 
	Employee updateEmployees(Employee employee,Integer id); 
	void deleteEmployees(Integer id);
}
