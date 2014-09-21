package com.nhncorp.mgr.bo;

import java.util.Map;

import com.nhncorp.mgr.vo.User;

public interface LoginBO {

	Map<String, Object> login(User user);


}
