package com.car.charge.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.car.entity.Car;
import com.car.util.BaseDao;


@Repository
public class CarDaolmpl extends BaseDao<Car>{
	public Car getById(int id) {//根据id查找
		return (Car)this.getById(id);
	}
	
	public List<Car> findAll(int page,int total){//根据页数查找
		return this.page("from Car",page,total);
	}
	public void add(Car c) {
		this.save(c);
	}
}
