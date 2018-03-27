package com.apnidukan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

	@RequestMapping("/login")
	
	public String onSignUp(){
		return "I am signed in as Nitish Nalan!";
	}
}
