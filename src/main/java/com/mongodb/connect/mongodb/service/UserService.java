package com.mongodb.connect.mongodb.service;

import java.util.List;

import com.mongodb.connect.mongodb.bean.User;

public interface UserService {


	  List<User> findAll();


	  User findByUserId(String userId);


	  User saveUser(User user);


	  void updateUser(User user);


	  void deleteUser(String userId);

	}