package com.plinepay.redisdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.plinepay.redisdemo.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Object HASH_KEY = "User";

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    @Override
    public boolean saveUser(User user) {
        try {
            template.opsForHash().put(HASH_KEY, user.getId(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> fetchAllUser() {
        List<User> users;
        users = template.opsForHash().values(HASH_KEY);
        return users;
    }
    
}
