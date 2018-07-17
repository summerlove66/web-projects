package com.park.redis.dao;

import com.park.redis.domain.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private RedisTemplate<String,User> redisTemplate;
    private HashOperations hashOperations;
    private String userKey="USER";

    public UserRepositoryImpl (RedisTemplate<String ,User> redisTemplate){

        System.out.println("REDISTEMPLATE : " +redisTemplate);
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();

    }

    @Override
    public void save(User user) {
        hashOperations.put(userKey ,user.getUserId() ,user);
    }

    @Override
    public Map<Integer, User> findAll() {
       return hashOperations.entries(userKey);
    }

    @Override
    public void deleteUser(String userId) {
        hashOperations.delete(userKey,userId);
    }


}
