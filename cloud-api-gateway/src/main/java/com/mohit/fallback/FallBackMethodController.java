package com.mohit.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallback")
	public String userServiceFallBackMethod(){
		return "User Service is taking longer than Expected. Please try again.";
	}
	
	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallBackMethod(){
		return "Department Service is taking longer than Expected. Please try again.";
	}
}
