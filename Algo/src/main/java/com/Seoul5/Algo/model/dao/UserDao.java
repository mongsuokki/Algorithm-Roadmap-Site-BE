package com.Seoul5.Algo.model.dao;

import java.util.List;

import com.Seoul5.Algo.model.dto.User;

public interface UserDao {

	List<User> selectAll();

	List<User> searchById(String id);

	int insert(User user);

	int updateUser(User user);

	int solved(String id, int pNum);
}
