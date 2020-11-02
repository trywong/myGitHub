package com.wc.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor {
    ClassA target;

    public CGLibProxy(ClassA target) {
        this.target = target;
    }

    public ClassA createProxy() {
        // 创建增强类实例，用于生产代理对象
        Enhancer enhancer = new Enhancer();
        // 设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数，即一个方法拦截
        enhancer.setCallback(this);
        return (ClassA) enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("secondMethod".equals(method.getName())) {
            System.out.println("权限校验……");
            // 执行目标方法
            Object result = methodProxy.invokeSuper(proxy, args);
            System.out.println("日志收集……");
            return result;
        }
        // 如果不需要增强直接执行原方法
        return methodProxy.invokeSuper(proxy, args);
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        CGLibProxy cglibProxy = new CGLibProxy(classA);
        ClassA proxy = cglibProxy.createProxy();
        proxy.firstMethod();
        proxy.secondMethod(5, 67);
        proxy.superMethod();
    }
}
