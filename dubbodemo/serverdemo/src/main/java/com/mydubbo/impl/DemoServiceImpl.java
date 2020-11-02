package com.mydubbo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mydubbo.api.DemoService;
import com.mydubbo.api.dto.User;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
 
	public String sayHello(String name) {
		return "Hello " + name;
	}
 
	public List getUsers() {
		List list = new ArrayList();
		User u1 = new User();
		u1.setName("wangchuan");
		u1.setAge(20);
		u1.setSex("f");
 
		User u2 = new User();
		u2.setName("shovel");
		u2.setAge(21);
		u2.setSex("m");
 
		
		list.add(u1);
		list.add(u2);
		
		return list;
	}
}