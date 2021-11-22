package com.neosoft.springboot.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.model.Employee;
import com.neosoft.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	//Inject our Employee Repository
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> getEmployee(long id){
		return employeeRepo.findById(id);
	}
	
	public void addEmployee(Employee emp) {
		employeeRepo.save(emp);
	}
	
	public void deleteEmployee(long id) {
		employeeRepo.deleteById(id);
	}
	
	public Employee updateEmployee(Employee emp,long id) {
//		employeeRepo.findById(id).orElseThrow(() -> new Exception("Problem"));
		Employee existingEmp = employeeRepo.findById(id).orElse(null);
		existingEmp.setEmail(emp.getEmail());
		existingEmp.setFirstName(emp.getFirstName());
		existingEmp.setLastName(emp.getLastName());
		return employeeRepo.save(existingEmp);
	}
	
	public List<Employee> sortById() {
		Comparator<Employee> compareById = Comparator.comparing(Employee::getId).reversed();
		return getEmployees().stream().sorted(compareById).collect(Collectors.toList());
	}
	
	public List<Employee> sortByName() {
		Comparator<Employee> compareByName = Comparator.comparing(Employee::getFirstName);
		return getEmployees().stream().sorted(compareByName).collect(Collectors.toList());
	}
}
