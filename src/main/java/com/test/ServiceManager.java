package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class ServiceManager implements BeanPostProcessor{

	private static Map<String , ServiceDelegate> services = new HashMap<String , ServiceDelegate>();
	
	@Override
	public Object postProcessAfterInitialization(Object obj, String arg1)
			throws BeansException {
		for(Method m : obj.getClass().getMethods()){
			WebMethod ano = m.getAnnotation(WebMethod.class);
			if(ano==null){
				continue;
			}
			ServiceDelegate delegate = new ServiceDelegate();
			delegate.method = m;
			delegate.target = obj;
			services.put(m.getName(), delegate);
		}
		return obj;
	}

	@Override
	public Object postProcessBeforeInitialization(Object obj, String arg1)
			throws BeansException {
		return obj;
	}

	public static Object call(String method , Map param){
		if(!services.containsKey(method)){
			return null;
		}
		ServiceDelegate sd = services.get(method);
		try {
			return sd.method.invoke(sd.target, param);
		} catch (Exception e) {
			JSONObject msg = new JSONObject();
			msg.put("result", "调用失败");
			return msg;
		}
	}
}
