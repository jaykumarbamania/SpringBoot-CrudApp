package com.neosoft.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.model.Student;
import com.neosoft.springboot.repository.StudentRepository;

@Service
@CacheConfig(cacheNames = "students")
public class StudentService {
	
	@Autowired
	private StudentRepository stuRep;
	
	@Cacheable
	public List<Student> getStudents(){
		slowService();
		return stuRep.findAll();
	}
	
	public Optional<Student> getStudentById(long id){
		return stuRep.findById(id);
	}
	
	public void addStudent(Student stu) {
		stuRep.save(stu);
	}
	
	public void deleteStudent(long id) {
		stuRep.deleteById(id);
	}
	
	public void updateStudent(Student emp,long id) {

		Student existingStudnt = stuRep.findById(id).orElse(null);
		existingStudnt.setStname(emp.getStname());
		existingStudnt.setStmarks(emp.getStmarks());
		existingStudnt.setSubject(emp.getSubject());
		stuRep.save(existingStudnt);
	}
	

	
	private void slowService() {
		try {
			Thread.sleep(3000L);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
