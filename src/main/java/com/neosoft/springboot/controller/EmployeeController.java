package com.neosoft.springboot.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
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
	public Optional<Employee> updateUser(@RequestBody Employee emp, @PathVariable int id) {
		employeeService.updateEmployee(emp, id);
		return employeeService.getEmployee(id);
	}
	
	@GetMapping("/employees/sortById")
	public List<Employee> sortEmpById() {
		return employeeService.sortById();
	}
	
	@GetMapping("/employees/sortByName")
	public List<Employee> sortEmpByName() {
		return employeeService.sortByName();
	}
	
//	Response Entity
	
	@PostMapping("/employee/response")
	public ResponseEntity<Employee> addEmpResponse(@RequestBody Employee emp){
		employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/response/{id}")
	public ResponseEntity<Object> getEmpResponse(@PathVariable long id) {
		Optional<Employee> employee =  employeeService.getEmployee(id);
		if(employeeService.getEmployee(id).isPresent()) 
			return new ResponseEntity<Object>(employee,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Such Id "+id,HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/employee/response/{id}")
	public ResponseEntity<Object> deleteEmpResponse(@PathVariable int id) {
		Optional<Employee> employee =  employeeService.getEmployee(id);
		if(employeeService.getEmployee(id).isPresent()) {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<Object>(id+" Deleted Successfully",HttpStatus.OK);
		}else
			return new ResponseEntity<Object>("No Such Id "+id,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/employees/response/{id}")
	public  ResponseEntity<Object> updateUserResponse(@RequestBody Employee emp, @PathVariable int id) {
		Optional<Employee> employee =  employeeService.getEmployee(id);
		if(employeeService.getEmployee(id).isPresent()) {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<Object>(" Updated Successfully "+employee,HttpStatus.OK);
		}else
			return new ResponseEntity<Object>("No Such Id "+id,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader(){
		return ResponseEntity.ok()
							.header("Custom HEader", "Neosoft")
							.body("Custom Header Set");
	}
	
	@GetMapping("/logger")
	public String getLogger() {
		logger.info("INFO logger method ::"+new Date().toString());
		logger.warn("Warn logger method ::  "+new Date().toString());
		logger.error("Error "+new Date().toString());
		
		return "Logger Text";
	}
}
