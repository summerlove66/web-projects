package com.hui.springboot.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hui.springboot.mapper.OrderMapper;
import com.hui.springboot.model.User;
import com.hui.springboot.model.UserOrder;
import com.hui.springboot.projectmodel.Result;
import com.hui.springboot.utils.ResultUtil;

@Service
public class OrderService {
	@Autowired
	OrderMapper orderMapper;

	public Result getUserAllOrders(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute(UserService.loginedMark);
		
		if (user == null) {
			return ResultUtil.noPermission;
		}
		else {
			System.out.println("USER ====" +user.getUserId());
			List<UserOrder> orders = orderMapper.getOrderByuserId(user.getUserId());
			System.out.println("ORDERS -------" +orders);
			return new Result(1, "success", orders);
		}

	}
}
