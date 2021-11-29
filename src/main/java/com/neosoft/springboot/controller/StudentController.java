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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.Student;
import com.neosoft.springboot.service.StudentService;

@RestController
public class StudentController {
	

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	StudentService stuService;
	
	/*
	 * @GetMapping("/students") public ResponseEntity<Student> getEmployees(){
	 * List<Student> students = stuService.getStudents(); if(students.isEmpty()) {
	 * logger.error("Student List is Empty ::"+new Date().toString()); return new
	 * ResponseEntity<Student>("Student list is empty",HttpStatus.NO_CONTENT); }else
	 * { logger.info("Students List ::"+new Date().toString()); return new
	 * ResponseEntity<Student>("Student list is empty",HttpStatus.NO_CONTENT); } }
	 */
	@PostMapping("/student/")
	public ResponseEntity<Student> addEmpResponse(@RequestBody Student stu){
		stuService.addStudent(stu);
		logger.info("Student added Successfully ::"+new Date().toString());
		return new ResponseEntity<Student>(stu,HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Object> getEmpResponse(@PathVariable long id) {
		Optional<Student> student =  stuService.getStudentById(id);
		if(stuService.getStudentById(id).isPresent()) {
			logger.info("Student Got Id : "+id+ "::"+new Date().toString());
			return new ResponseEntity<Object>(student,HttpStatus.OK);
		}
		else {
			logger.error("Student Not Found Id : "+id+ "::"+new Date().toString());
			return new ResponseEntity<Object>("No Such Id "+id,HttpStatus.NOT_FOUND);
		}
			
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/student/{id}")
	//@DeleteMapping("/student/{id}")
	public ResponseEntity<Object> deleteEmpResponse(@PathVariable int id) {
		Optional<Student> student =  stuService.getStudentById(id);
		if(stuService.getStudentById(id).isPresent()) {
			stuService.deleteStudent(id);
			logger.info("Student Id : "+id+ " Deleted ::"+new Date().toString());
			return new ResponseEntity<Object>(id+" Deleted Successfully",HttpStatus.OK);
		}else {
			logger.error("Student Id Not Found for Deletion: "+id+ " ::"+new Date().toString());
			return new ResponseEntity<Object>("No Such Id "+id,HttpStatus.NOT_FOUND);
		}
			
	}
	
	@PutMapping("/student/{id}")
	public  ResponseEntity<Object> updateUserResponse(@RequestBody Student stu, @PathVariable int id) {
		Optional<Student> student  =  stuService.getStudentById(id);
		if(stuService.getStudentById(id).isPresent()) {
			stuService.updateStudent(stu,id);
			logger.info("Student Id : "+id+ " Updated ::"+new Date().toString());
			return new ResponseEntity<Object>(" Updated Successfully "+student,HttpStatus.OK);
		}else {
			logger.error("Student Id Not Found for Deletion: "+id+ " ::"+new Date().toString());
			return new ResponseEntity<Object>("No Such Id "+id,HttpStatus.NOT_FOUND);
		}
			
	}

}
