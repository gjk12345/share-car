package com.car.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.car.entity.User;
import com.car.user.dao.UserDao;

@Service
public class UserService {
	@Resource
	private UserDao userdao;
	
	public User getUById(String id) {
		return (User)userdao.getById(id);
	}
	
	public List<User> getAllU(int page){
		int total=20;
		return userdao.findAll(page, total);
	}
}
