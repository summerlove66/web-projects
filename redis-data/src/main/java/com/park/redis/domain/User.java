package com.park.redis.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;


public class User implements Serializable {
    private String userId;
    private String userName;
    private Double salary;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
