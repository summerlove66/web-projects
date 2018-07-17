package com.hui.springboot.mapper;

import java.util.List;

import com.hui.springboot.model.UserOrder;

public interface OrderMapper {
	List<UserOrder> getAllOrders();
	List<UserOrder> getOrderByuserId( int userId);
	void insertOrder(UserOrder order);
}
