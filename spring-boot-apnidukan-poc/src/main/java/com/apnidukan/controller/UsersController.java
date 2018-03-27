package com.apnidukan.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apnidukan.model.Users;
import com.apnidukan.service.UserService;

@Controller

@RequestMapping("/users")
public class UsersController {

	private UserService userService;
	
	
	@Autowired
	public UsersController(UserService userService) {
		
		this.userService = userService;
	}

	@RequestMapping("/list/{id}")
	public Users findOne(@PathVariable Long id) {
		return userService.findOne(id);
	}
	
	@RequestMapping(value = "/add", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	//@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	/*@RequestMapping("/list")
	public List<Users> userList(){
		return userService.usersList();
	}*/
	
	@GetMapping("/list")
	public String userList(Model model){
		model.addAttribute("users",userService.usersList());
		//calls for the view
		return "/users/list";
	}
}
