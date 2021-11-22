package com.neosoft.springboot.controller;

import java.util.Comparator;

import com.neosoft.springboot.model.User;

public class CompareByName implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return  o1.getName().compareTo(o2.getName());
	}

}
