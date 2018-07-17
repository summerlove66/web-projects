package com.park.redis.controller;

import com.park.redis.dao.UserRepository;
import com.park.redis.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: redis-data
 * @description:
 * @author: Hui
 * @create: 2018-07-05 01:28
 **/

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    public UserController (UserRepository userRepository) {
       this.userRepository = userRepository;
    }

    @GetMapping("/add/{userId}/{userName}")
    public User addUser(@PathVariable String userId , @PathVariable String userName){
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setSalary(  2000d);
        userRepository.save(user);
        return user;
    }
    @GetMapping("/delete/{userId}")
    public void deleteUser(@PathVariable String  userId){
        userRepository.deleteUser(userId);
    }

    @GetMapping("/all")
    public Map<Integer,User> getAllUser(){
        return  userRepository.findAll();
    }

}
