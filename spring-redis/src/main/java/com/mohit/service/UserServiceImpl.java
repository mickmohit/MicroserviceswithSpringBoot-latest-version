package com.mohit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.model.User;
import com.mohit.repo.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);
	}

	@Override
	public List<User> fetchAllUser() {
		// TODO Auto-generated method stub
		return userDao.fetchAlluser();
	}

}
