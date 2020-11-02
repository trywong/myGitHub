package com.wc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    ClassA target;

    public JDKProxy(ClassA target) {
        this.target = target;
    }

    public ExInterface createProxy() {
        return (ExInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("secondMethod".equals(method.getName())) {
            System.out.println("权限校验……");
            // 执行目标方法
            Object result = method.invoke(target, args);
            System.out.println("日志收集……");
            return result;
        }
        else if ("superMethod".equals(method.getName())) {
            System.out.println("superMethod权限校验……");
            // 执行目标方法
            Object result = method.invoke(target, args);
            System.out.println("superMethod日志收集……");
            return result;
        }

        // 不需要增强，直接执行原方法
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();

        // 创建JDK代理对象
        JDKProxy jdkProxy = new JDKProxy(classA);

        // 创建代理对象
        ExInterface proxy = jdkProxy.createProxy();

        // 执行代理对象方法
        proxy.firstMethod();
        
        int result = proxy.secondMethod(5, 11);
        System.out.println("result:" + result);
        
        proxy.superMethod();
    }
}
