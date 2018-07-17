package com.park.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @RequestMapping("/hi")
    private String sayHi() {
        return "Hi SpringBoot";
    }

    @RequestMapping(value = "/{.*}")
    private String sayHello() {
        return "Hello SpringBoot";
    }

}
