package com.cucumber.test.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cucumber.test.crud.model.Employee;
import com.cucumber.test.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService; 
	}
	
	//Build Create Employee Rest API
	@PostMapping
	public ResponseEntity<Employee> saveEmployees( @RequestBody Employee employee ){   
		return new ResponseEntity<Employee>(employeeService.saveEmployees(employee) , HttpStatus.CREATED);
	}
	
	//Build Get All Employee Rest API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//Build Get By Id Employee Rest API
	@GetMapping("/{id}")
	public ResponseEntity<Employee>  getByIdEmployees(@PathVariable("id") int id){
		Employee employee = employeeService.getEmployeeById(id); 
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	//Build Update Employee Rest API
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployees(  @PathVariable("id") Integer id, @RequestBody Employee employee ){  
		return new ResponseEntity<Employee>(employeeService.updateEmployees(employee, id) , HttpStatus.OK);
	}
	
	//Build Delete Employee Rest API
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteOrganization( @PathVariable("id") Integer id ){ 
		employeeService.deleteEmployees(id);
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("message", "Employee Deleted Successfully");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
