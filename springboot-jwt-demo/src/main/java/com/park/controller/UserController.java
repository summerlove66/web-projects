package com.park.controller;

import com.park.model.Result;
import com.park.model.User;
import com.park.utils.JWTUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (user.getPassword().equals("ppp") && user.getUserName().equals("uuu")) {
            String idx = System.currentTimeMillis() + "";
            return new Result(1, JWTUtils.createJWT(idx, "TESTER", "learn jwt", 1000 * 60));
        }
        return new Result(0, "用户名或密码出错");
    }


}
