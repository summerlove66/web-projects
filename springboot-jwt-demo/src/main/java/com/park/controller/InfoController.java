package com.park.controller;

import com.park.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InfoController {
    @GetMapping("/protected")
    public Result userInfo() {

        return new Result(1, "授权通过");
    }

    @GetMapping("/badtoken")
    public Result badToken(){
        return  new Result(0,"bad token ");
    }

}
