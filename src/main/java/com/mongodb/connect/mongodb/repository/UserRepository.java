package com.mongodb.connect.mongodb.repository;

import java.util.List;
import java.util.Optional;

import com.mongodb.connect.mongodb.bean.User;



public interface UserRepository{


  Optional<List<User>> findAll();
  
  User findByUserId(String userId);

  public User saveUser(User user);


  public void updateUser(User user);


  public void deleteUser(String userId);

Optional<User> findOne(String userId);

}