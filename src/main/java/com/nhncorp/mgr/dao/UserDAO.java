package com.nhncorp.mgr.dao;

import java.util.List;

import com.nhncorp.mgr.vo.User;

public interface UserDAO {

	List<User> selectUserList();

	User selectUserById(String id);

	void insertUser(User user);

	void updateUser(User user);

	void deleteUser(String id);

}
