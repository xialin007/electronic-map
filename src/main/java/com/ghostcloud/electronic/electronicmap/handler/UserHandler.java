package com.ghostcloud.electronic.electronicmap.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ghostcloud.electronic.electronicmap.domain.User;
import com.ghostcloud.electronic.electronicmap.jpa.UserDao;

@Component
public class UserHandler implements IHandler{

	@Autowired
	private UserDao userDao;
	
	public Object handle(Map<String, String> paramMaps) {
		List<User> users = userDao.findAll();
		return users;
	}
	
}
