package com.apnidukan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnidukan.model.Users;
import com.apnidukan.repository.UsersRepository;
import com.apnidukan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UsersRepository userRepository;
		
	@Autowired
	public UserServiceImpl(UsersRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<Users> usersList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Users findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		return "{'message' : 'User deleted successfully'}";
	}

}
