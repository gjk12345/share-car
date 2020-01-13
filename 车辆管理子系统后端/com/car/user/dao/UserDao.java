package com.car.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.car.entity.User;
import com.car.util.BaseDao;

@Repository
public class UserDao extends BaseDao<User>{
	public User getById(String id) {//根据id查找
		return (User)this.getById(id);
	}
	
	public List<User> findAll(int page,int total){//根据页数查找
		return this.page("from User",page,total);
	}
}
