package com.mohit.contoller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.ValueObjects.ResponseTemplateVO;
import com.mohit.entity.User;
import com.mohit.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	final static Logger log = Logger.getLogger(UserController.class);
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside Save User from User Service");
		return service.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserwithDepartment(@PathVariable("id") Long id) {
		return service.getUserwithDepartment(id);
	}
	
}
