package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CatService {

	@WebMethod
	public List<String> getCatList(Map map){
		List<String> cats = new ArrayList<String>();
		cats.add("tomcat");
		return cats;
	}
}
