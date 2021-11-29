package com.neosoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.User;
import com.neosoft.springboot.service.UserService;

@RestController
public class UserController {
	
//	@GetMapping("/users")
//	public List<User> getUsers(){
//		return Arrays.asList(
//				new User(101, "Jaykumar", "j@ykumar"),
//				new User(102, "Dev", "j@ykumar"),
//				new User(103, "Yash", "j@ykumar"),
//				new User(104, "Deepak", "j@ykumar"),
//				new User(105, "Hell", "j@ykumar")
//				);
//	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/users")
	public void  addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	//Delete 
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		userService.updateUser(user, id);
	}
	
	@GetMapping("/users/sortByName")
	public List<User> getUsersSortedByName() {
		return userService.sortByName();
	}
	
	@GetMapping("/users/sortById")
	public List<User> getUsersSortedById() {
		return userService.sortById();
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
}
