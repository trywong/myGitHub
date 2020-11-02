package com.wc.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shovel
 * @date 2018/12/15 19:26
 * @since 1.0.0
 */
public class MyJDKProxy implements InvocationHandler {
    private MyClass target;

    public MyJDKProxy(MyClass target) {
        this.target = target;
    }

    public MyInterface getProxy() {
        return (MyInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("hello".equals(method.getName())) {
            System.out.println("前置校验");
            Object obj = method.invoke(target, args);
            System.out.println("后置校验");

            return obj;
        }
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        MyJDKProxy proxy = new MyJDKProxy(new MyClass());
        MyInterface myClassProxy = proxy.getProxy();
        myClassProxy.hello("zhangsan");
        myClassProxy.byebye();
    }
}
