package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}


