package com.mohit.repo;

import java.util.List;

import com.mohit.model.User;

public interface UserDao {

	boolean saveUser(User user);

	List<User> fetchAlluser();

}
