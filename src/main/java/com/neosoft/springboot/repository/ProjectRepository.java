package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
