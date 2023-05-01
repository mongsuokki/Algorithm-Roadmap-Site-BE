package com.Seoul5.Algo.model.dao;

import java.util.List;

import com.Seoul5.Algo.model.dto.User;

public interface UserDao {

	List<User> selectAll();
	
	int insert(User user);
}
