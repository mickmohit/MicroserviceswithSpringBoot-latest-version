package com.mohit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
