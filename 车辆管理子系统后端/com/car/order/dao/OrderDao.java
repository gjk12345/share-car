package com.car.order.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.car.entity.Order;
import com.car.util.BaseDao;

@Repository
public class OrderDao extends BaseDao<Order>{
	public Order getById(int id) {//根据id查找
		return (Order)this.getById(id);
	}
	
	public List<Order> findAll(int page,int total){//根据页数查找
		return this.page("from Order",page,total);
	}
	public List<Order> getByCarId(int id,int page,int total){//根据车id查找
		return this.page("from Order where carid==?",page,total, id);
	}
	public List<Order> getByUserId(String id,int page,int total){//根据用户id查找
		return this.page("from Order where userid==?", page,total,id);
	}
	public List<Order> getByTime(String time,int page,int total){//根据开始和结束时间查找
		return this.page("from Order where starttime<? and endtime>?",page,total, time,time);
	}
	public void add(Order o) {
		this.save(o);
	}
}
