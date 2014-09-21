package com.nhncorp.mgr.bo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nhncorp.mgr.dao.UserDAO;
import com.nhncorp.mgr.vo.User;

@Service("loginBO")
public class LoginBOImpl implements LoginBO{

	@Resource(name = "userDAO")
    private UserDAO userDAO;
	
	@Override
	public Map<String, Object> login(User user){
		
		String id = user.getId();
		String pw = user.getPassword();
		
		Map<String, Object> result = new HashMap<String, Object>();
		if (id == null || pw == null || id.trim().length() == 0 || pw.trim().length() == 0) {
			result.put("STATUS", "ERROR");
			result.put("MESSAGE", "아이디와 비밀번호를 입력하세요");
			
			return result;
		}
		/* 아이디가 일치하는 회원정보 리턴 */
		User searchedUser = userDAO.selectUserById(id);
		/* 아이디가 일치하는 회원정보가 없음 */
		if (searchedUser == null) {
			result.put("STATUS", "ERROR");
			result.put("MESSAGE", "아이디가 일치하는 회원이 없습니다.");
			
			return result;
		}
		if (!searchedUser.getPassword().equals(pw)) {
			result.put("STATUS", "ERROR");
			result.put("MESSAGE", "비밀번호가 일치하지 않습니다.");
			
			return result;
		}
		result.put("STATUS", "OK");
		result.put("USER", searchedUser);
		
		return result;
	}
	
}
