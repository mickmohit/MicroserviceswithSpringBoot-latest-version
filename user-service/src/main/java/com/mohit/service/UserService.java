package com.mohit.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mohit.ValueObjects.Department;
import com.mohit.ValueObjects.ResponseTemplateVO;
import com.mohit.entity.User;
import com.mohit.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	final static Logger log = Logger.getLogger(UserService.class);

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	public ResponseTemplateVO getUserwithDepartment(Long id) {
		
		ResponseTemplateVO vo= new ResponseTemplateVO();
		User user= repo.getById(id);
		
		log.info("User details fetched from id passed-"+user);
		
		Department department = 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDeptId(), Department.class);
		
		vo.setDepartment(department);
		vo.setUser(user);
		return vo;
	}
}
