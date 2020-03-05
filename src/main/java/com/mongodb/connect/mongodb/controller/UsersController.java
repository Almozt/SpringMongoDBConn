package com.mongodb.connect.mongodb.controller;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.connect.mongodb.bean.User;
import com.mongodb.connect.mongodb.exception.UserNotFoundException;
import com.mongodb.connect.mongodb.service.UserService;

import java.util.List;

import javax.validation.Valid;


@RestController

@RequestMapping("users")

public class UsersController {


    private static final Log log = LogFactory.getLog(UsersController.class);


    private final UserService usersService;

    private User user;


    @Autowired

    public UsersController(UserService usersService) {

        this.usersService = usersService;

    }


    @GetMapping(value="/{userId}")
    public ResponseEntity<User> userById(@PathVariable String userId)  throws  UserNotFoundException{

        log.info("Get userById");

        try{

        	user = usersService.findByUserId(userId);

        }catch(UserNotFoundException e){

        	user = null;

        }

        return ResponseEntity.ok(user);


    }


    @GetMapping
     public ResponseEntity<List<User>> userById(){

        log.info("Get allUsers");

        return ResponseEntity.ok(usersService.findAll());

    }

    
    @DeleteMapping(value="/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){

    	log.info("Delete user " + userId);

        usersService.deleteUser(userId);

        return ResponseEntity.noContent().build();

    }


    @PostMapping
    public  ResponseEntity<User> saveUser(@RequestBody @Valid User user){

    	log.info("Save new user");

         return ResponseEntity.ok(usersService.saveUser(user));

    }

}