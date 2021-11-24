package com.mohit.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.mohit.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	
	private static final String KEY = "USER";
	
	@Override
	public boolean saveUser(User user) {
		try {
			redisTemplate.opsForHash().put(KEY, user.getId(), user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> fetchAlluser() {
		// TODO Auto-generated method stub
		List<Object> users = redisTemplate.opsForHash().values(KEY);
		List<User> user = new ArrayList<User>();
		user = users.stream().map(i-> (User)i).collect(Collectors.toList());
		return user;
	}

}
