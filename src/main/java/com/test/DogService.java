package com.test;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class DogService {

	@WebMethod
	public JSONObject getDogById(Map map){
		JSONObject dog = new JSONObject();
		dog.put("name", "coding dog");
		dog.put("id", map.get("id"));
		return dog;
	}
}
