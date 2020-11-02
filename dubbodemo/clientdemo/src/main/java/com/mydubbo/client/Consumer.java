package com.mydubbo.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mydubbo.api.DemoService;
import com.mydubbo.api.dto.User;

public class Consumer {
 
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-customer.xml" });
		context.start();
 
		DemoService demoService = (DemoService) context.getBean("demoService");
		String hello = demoService.sayHello("wangchuan07");
		System.out.println(hello);
 
		List<User> list = demoService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		System.in.read();
	}
 
}