package com.test.dubbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.test.ServiceManager;

public class DemoServiceImpl implements IDemoService {

	public String sayHello(String name) {
		return "Hello " + name;
	}

	public List getUsers() {
		List list = new ArrayList();
		User u1 = new User();
		u1.setName("jack");
		u1.setAge(20);
		u1.setSex("男");

		User u2 = new User();
		u2.setName("tom");
		u2.setAge(21);
		u2.setSex("女");

		User u3 = new User();
		u3.setName("rose");
		u3.setAge(19);
		u3.setSex("女");

		list.add(u1);
		list.add(u2);
		list.add(u3);
		return list;
	}

	@Override
	public Object call(String method , Map obj) {
		Object result = ServiceManager.call(method, obj);
		return result;
	}
}
