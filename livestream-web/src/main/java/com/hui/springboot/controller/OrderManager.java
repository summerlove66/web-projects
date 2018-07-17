package com.hui.springboot.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hui.springboot.projectmodel.Result;
import com.hui.springboot.service.OrderService;

@RestController
public class OrderManager {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/user/orders")
	public Result getUserAllOrders(HttpSession httpSession) {

		return orderService.getUserAllOrders(httpSession);
	}
}
