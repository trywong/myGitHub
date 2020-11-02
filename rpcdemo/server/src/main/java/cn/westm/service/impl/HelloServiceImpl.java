package cn.westm.service.impl;

import cn.westm.service.HelloService;

public class HelloServiceImpl implements HelloService {
    public String hello(String msg) {
        System.out.println("in:" + msg);
        return "impl:" + msg;
    }

}
