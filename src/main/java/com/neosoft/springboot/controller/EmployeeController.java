package com.neosoft.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.Employee;
import com.neosoft.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable long id) {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/employee")
	public String  addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
		return "Saved Successfully";
	}
	
	//Delete 
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "Deleted Successfully";
	}

	@PutMapping("/employee/{id}")
	public Employee updateUser(@RequestBody Employee emp, @PathVariable int id) {
		Employee updtEmp = employeeService.updateEmployee(emp, id);
		return updtEmp;
	}
	
	@GetMapping("/employees/sortById")
	public List<Employee> sortEmpById() {
		return employeeService.sortById();
	}
	
	@GetMapping("/employees/sortByName")
	public List<Employee> sortEmpByName() {
		return employeeService.sortByName();
	}
	

}
