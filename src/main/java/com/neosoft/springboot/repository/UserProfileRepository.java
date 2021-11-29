package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
