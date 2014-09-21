package com.nhncorp.mgr.bo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nhncorp.mgr.dao.UserDAO;
import com.nhncorp.mgr.vo.User;

@Service("userBO")
public class UserBOImpl implements UserBO{

	@Resource(name = "userDAO")
    private UserDAO userDAO;
	
	@Override
	public List<User> readUserList(){
		
		return userDAO.selectUserList();
	}

	@Override
	public User readUser(String id){
		
		return userDAO.selectUserById(id);
	}
	
	@Override
	public void addUser(User user){
		
		userDAO.insertUser(user);
	}
	
	@Override
	public void editUser(User user){
		
		userDAO.updateUser(user);
	}
	
	@Override
	public void removeUser(String code){
		
		userDAO.deleteUser(code);
	}

}
