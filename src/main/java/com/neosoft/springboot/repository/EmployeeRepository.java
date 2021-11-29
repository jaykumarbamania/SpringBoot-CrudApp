package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}


