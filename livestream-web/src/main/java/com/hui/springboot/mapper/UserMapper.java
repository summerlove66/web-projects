package com.hui.springboot.mapper;

import java.util.List;

import com.hui.springboot.model.User;

public interface UserMapper {
	
	List<User> getAllUsers();	
	User getUserByEmail(String email);
	void insertUser(User user);
	User getUserById(int idx);
	User getUserByUserName(String userName);
	User getUserByUserNameAndEmail(User user);
	void updateUser(User user);
}
