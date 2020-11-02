package com.wc.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author shovel
 * @date 2018/12/5 17:30
 * @since 1.0.0
 */
public class ProxyTest {

    public void proxyTest() {
        IUser user = (IUser)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{IUser.class}, new UserHandler(new RealUser()));
        user.coding("Java");
        user.rest();
    }

    public static void main(String[] args) {
        ProxyTest te = new ProxyTest();
        te.proxyTest();
    }
}
