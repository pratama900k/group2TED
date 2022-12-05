package com.cucumber.test.crud.repository;
  
import org.springframework.data.jpa.repository.JpaRepository;

import com.cucumber.test.crud.model.Employee;
 

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
