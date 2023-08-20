package com.plinepay.redisdemo.repository;

import java.util.List;

import com.plinepay.redisdemo.model.User;

public interface UserDao {

    boolean saveUser(User user);

    List<User> fetchAllUser();
    
}
