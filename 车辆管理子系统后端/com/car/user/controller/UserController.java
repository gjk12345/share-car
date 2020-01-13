package com.car.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.entity.User;
import com.car.user.service.UserService;
import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Resource
	private UserService userservice;
	
	@RequestMapping(value="/addUser")
	@ResponseBody
	public String addUser(@RequestBody JSONObject json) {
		return " ";
	}
	@RequestMapping(value="/delUser")
	@ResponseBody
	public String delUser(@RequestBody JSONObject json) {
		return " ";
	}
	@RequestMapping(value="/findUserById")
	@ResponseBody
	public String findUserById(@RequestBody JSONObject json) {
		String id=json.getString("id");
		User r=userservice.getUById(id);
		
		if(r!=null) {
			JSONObject j=new JSONObject();
			String response=j.fromObject(r).toString();
			return response;
		}
		else
		{
			return "{\"status\":1,\"message\":\" findUserById failed\"}";
		}
	}
	@RequestMapping(value="/getAllUser")
	@ResponseBody
	public String getAllUser(@RequestBody JSONObject json) {
		int pagenum=json.getInt("pagenum");
		List<User> list=userservice.getAllU(pagenum);
		if(list!=null) {
			JsonObject s;
			String success=com.alibaba.fastjson.JSON.toJSONString(list);
			return success;
		}
		else {
			return "{\"status\":1,\"message\":\" getAllUser failed\"}";
		}
	}
	@RequestMapping(value="/changeUser")
	@ResponseBody
	public String changeUser(@RequestBody JSONObject json) {
		return " ";
	}
}
