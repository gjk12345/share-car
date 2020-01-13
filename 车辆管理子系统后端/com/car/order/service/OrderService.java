package com.car.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.car.entity.Order;
import com.car.order.dao.OrderDao;

@Service
public class OrderService {
	@Resource
	private OrderDao orderdao;
	
	public Order getListById(int id) {
		Order o=orderdao.getById(id);
		return o;
	}
	public List<Order> getAll(int page){
		int total = 20;
		List<Order> list=orderdao.findAll(page, total);
		return list;
	}
	public List<Order> getLByCId(int id,int page){
		int total = 20;
		List<Order> list=orderdao.getByCarId(id, page, total);
		return list;
	}
	public List<Order> getByUId(int page,String id){
		int total = 20;
		List<Order> list=orderdao.getByUserId(id, page, total);
		return list;
	}
	public List<Order> getByTime(int page,String time){
		int total = 20;
		List<Order> list=orderdao.getByTime(time, page, total);
		return list;
	}
}
