package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
