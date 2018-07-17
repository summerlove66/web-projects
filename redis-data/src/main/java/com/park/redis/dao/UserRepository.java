package com.park.redis.dao;

import com.park.redis.domain.User;

import java.util.Map;

/**
 * @program: redis-data
 * @description:
 * @author: Hui
 * @create: 2018-07-05 01:12
 **/
public interface UserRepository {
    void save(User user);
    Map<Integer, User> findAll();
    void deleteUser(String userId);
}
