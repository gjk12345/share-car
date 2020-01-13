package com.car.charge.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.charge.service.CarService;
import com.car.entity.Car;
import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

@Controller
public class CarController {
	@Resource
	private CarService carservice;
	
	@RequestMapping(value="/addCar")
	@ResponseBody
	public String addCar(@RequestBody JSONObject json) {
		return " ";
	}
	@RequestMapping(value="/deleteCar")
	@ResponseBody
	public String deleteCar(@RequestBody JSONObject json) {
		return "";
	}
	@RequestMapping(value="/getCarById")
	@ResponseBody
	public String getCar(@RequestBody JSONObject json) {
		int id=json.getInt("id");
		Car c=carservice.getCarById(id);
		JSONObject j=new JSONObject();
		if(c!=null) {
			String response=j.fromObject(c).toString();
			return response;
		}
		else
		{
			return "{\"status\":1,\"message\":\" getCarById failed\"}";
		}
	}
	@RequestMapping(value="/getAllCar")
	@ResponseBody
	public String getAllCar(@RequestBody JSONObject json) {
		int pagenum=json.getInt("pagenum");
		List<Car> list=carservice.getAllCar(pagenum);
		if(list!=null) {
			JsonObject s;
			String success=com.alibaba.fastjson.JSON.toJSONString(list);
			return success;
		}
		else {
			return "{\"status\":1,\"message\":\" getAllCar failed\"}";
		}
	}
	@RequestMapping(value="/changeCarStatus")
	@ResponseBody
	public String changeCarStatus(@RequestBody JSONObject json) {
		return "";
	}
	@RequestMapping(value="/changeCarPower")
	@ResponseBody
	public String changeCarPower(@RequestBody JSONObject json) {
		return "";
	}
	@RequestMapping(value="/changeCarOdo")
	@ResponseBody
	public String changeCarOdo(@RequestBody JSONObject json) {
		return "";
	}
}
