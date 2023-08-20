package com.plinepay.redisdemo.service;

import java.util.List;

import com.plinepay.redisdemo.model.User;

public interface UserService {

    boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUserById(Long id);
    
}
