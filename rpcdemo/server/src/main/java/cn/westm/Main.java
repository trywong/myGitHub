package cn.westm;

import cn.westm.rpc.Server;
import cn.westm.service.HelloService;
import cn.westm.service.impl.HelloServiceImpl;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8181);
        server.regist(HelloService.class, HelloServiceImpl.class);
        server.start();
    }
}
