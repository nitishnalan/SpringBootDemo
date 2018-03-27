package com.apnidukan.service;

import java.util.List;

import com.apnidukan.model.Users;

public interface UserService {
	
	List<Users> usersList();
	
	Users findOne(Long id);
	
	Users addUser(Users user);
	
	String deleteUser(Long id);
}
