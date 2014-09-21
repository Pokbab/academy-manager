package com.nhncorp.mgr.bo;

import java.util.List;

import com.nhncorp.mgr.vo.User;

public interface UserBO {

	List<User> readUserList();

	User readUser(String id);

	void addUser(User user);

	void editUser(User user);

	void removeUser(String code);

}
