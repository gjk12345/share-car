package com.car.charge.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.charge.dao.CarDaolmpl;
import com.car.entity.Car;

@Service
@Transactional(readOnly=false)
public class CarService {
	@Resource
	private CarDaolmpl cardao;
	public Car getCarById(int id) {
		Car c=cardao.getById(id);
		return c;
	}
	public List<Car> getAllCar(int page){
		int total = 20;
		List<Car> list=cardao.findAll(page, total);
		return list;
	}
}
