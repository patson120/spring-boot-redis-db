package com.plinepay.redisdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plinepay.redisdemo.model.User;
import com.plinepay.redisdemo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        boolean result = userService.saveUser(user);
        if (result){
            return new ResponseEntity<>("User saved successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUser(){
        List<User> users ;
        users = userService.fetchAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") Long id){
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        boolean result = userService.deleteUserById(id);
        if (!result){
            return new ResponseEntity<>("Unable to find user", HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
    }

}
