package com.neosoft.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.neosoft.springboot.controller.CompareByName;
import com.neosoft.springboot.model.User;

@Service
public class UserService {
	
	private List<User> users= new ArrayList<User>(Arrays.asList(
			new User(101, "Jaykumar", "j@ykumar"),
			new User(102, "Dev", "j@ykumar"),
			new User(103, "Yash", "j@ykumar"),
			new User(104, "Deepak", "j@ykumar"),
			new User(105, "Hell", "j@ykumar")
			));
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUser(int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public void deleteUser(int id) {
		users.removeIf(u -> u.getId() == id);
	}
	
	public void updateUser(User user,int id) {
		users.replaceAll(u -> {
		if(u.getId() == id)
			u = user;
		return u;
		});
	}
	
	public List<User> sortByName(){
		List<User> user = (List<User>) users.stream().sorted((o1, o2) -> o1.getName().
				compareTo(o2.getName())).collect(Collectors.toList());
		
//		Comparator<User> sds = Comparator.comparing(User::getName);
		return user;
	}
	
	public List<User> sortById(){
//		List<User> user = (List<User>) users.stream().sorted((o1, o2) -> o1.getName().
//				compareTo(o2.getName())).collect(Collectors.toList());
		
		Comparator<User> comparebyId = Comparator.comparing(User::getId).reversed();
		return users.stream().sorted(comparebyId).collect(Collectors.toList());
	}
	

}
