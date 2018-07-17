package com.park.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class HelloController {
    @Resource
    RedisTemplate<String,String>  redisStrTemplate;
    @GetMapping("/hello/{name}")
    public Object sayHello(@PathVariable String name ){
       return  redisStrTemplate.opsForHash().get("people","name");


    }

}
