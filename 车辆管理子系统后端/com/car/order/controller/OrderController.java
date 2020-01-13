package com.car.order.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.entity.Order;
import com.car.order.service.OrderService;
import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

@Controller
public class OrderController {
	@Resource
	private OrderService orderservice;
	
	@RequestMapping(value="/addOrder")
	public String addOrder(@RequestBody JSONObject json) {
		return " ";
	}
	@RequestMapping(value="/delOrder")
	public String delOrder(@RequestBody JSONObject json) {
		return " ";
	}
	@RequestMapping(value="/getOrderByOid")
	public String getOrderByOid(@RequestBody JSONObject json) {
		int id = json.getInt("id");
		Order o=orderservice.getListById(id);
		if(o!=null) {
			JSONObject j=new JSONObject();
			String response=j.fromObject(o).toString();
			return response;
		}
		else
		{
			return "{\"status\":1,\"message\":\" getOrderByOid failed\"}";
		}
		
	}
	@RequestMapping(value="/getOrderByCid")
	public String getOrderByCid(@RequestBody JSONObject json) {
		int cid = json.getInt("id");
		int pagenum = json.getInt("pagenum");
		List<Order> list = orderservice.getLByCId(cid, pagenum);
		if(list!=null) {
			JsonObject s;
			String success=com.alibaba.fastjson.JSON.toJSONString(list);
			return success;
		}
		else {
			return "{\"status\":1,\"message\":\" getOrderByCid failed\"}";
		}
	}
	@RequestMapping(value="/getOrderByUid")
	public String getOrderByUid(@RequestBody JSONObject json) {
		String uid = json.getString("id");
		int pagenum = json.getInt("pagenum");
		List<Order> list = orderservice.getByUId(pagenum, uid);
		if(list!=null) {
			JsonObject s;
			String success=com.alibaba.fastjson.JSON.toJSONString(list);
			return success;
		}
		else {
			return "{\"status\":1,\"message\":\" getOrderByUid failed\"}";
		}
	}
	@RequestMapping(value="/getAllOrder")
	public String getAllOrder(@RequestBody JSONObject json) {
		int pagenum=json.getInt("pagenum");
		List<Order> list=orderservice.getAll(pagenum);
		if(list!=null) {
			JsonObject s;
			String success=com.alibaba.fastjson.JSON.toJSONString(list);
			return success;
		}
		else {
			return "{\"status\":1,\"message\":\" getAllOrder failed\"}";
		}
	}
	@RequestMapping(value="/getOrderByTime")
	public String getOrderByTime(@RequestBody JSONObject json) {
		String time=json.getString("time");
		int pagenum=json.getInt("pagenum");
		List<Order> list=orderservice.getByTime(pagenum, time);
		if(list!=null) {
			JsonObject s;
			String success=com.alibaba.fastjson.JSON.toJSONString(list);
			return success;
		}
		else {
			return "{\"status\":1,\"message\":\" getOrderByTime failed\"}";
		}
	}
}
