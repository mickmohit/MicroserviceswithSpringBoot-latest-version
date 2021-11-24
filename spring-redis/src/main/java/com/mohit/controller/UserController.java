package com.mohit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.model.User;
import com.mohit.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		boolean result = userService.saveUser(user);
		if(result) {
			return ResponseEntity.ok("User Created Successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> fetchUsers(){
		List<User> users = userService.fetchAllUser();
		return ResponseEntity.ok(users);
	}
}
