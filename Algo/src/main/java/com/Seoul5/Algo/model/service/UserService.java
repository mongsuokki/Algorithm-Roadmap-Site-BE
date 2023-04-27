package com.Seoul5.Algo.model.service;

import java.util.List;

import com.Seoul5.Algo.model.dto.User;

public interface UserService {

	List<User> selectAll();
	
	int insert(User user);
}
