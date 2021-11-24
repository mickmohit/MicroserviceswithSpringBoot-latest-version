package com.mohit.service;

import java.util.List;

import com.mohit.model.User;

public interface UserService {

	boolean saveUser(User user);

	List<User> fetchAllUser();

}
