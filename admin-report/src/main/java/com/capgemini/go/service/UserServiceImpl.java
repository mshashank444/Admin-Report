package com.capgemini.go.service;

import com.capgemini.go.dao.UserDaoImpl;
import com.capgemini.go.dto.UserDTO;

public class UserServiceImpl implements UserService {
	
	UserDaoImpl dao = new UserDaoImpl();
	
	public String generateId() {
		
		long count = dao.count();
		count++;
		String newId = "user"+count;
		return newId;		
	}
	
	public UserDTO addUser(String password, String role) {
		String id = generateId();
		UserDTO user = new UserDTO();
		user.setUserId(id);
		user.setUserPassword(password);
		user.setUserRole(role);
		return user;
	}

}
