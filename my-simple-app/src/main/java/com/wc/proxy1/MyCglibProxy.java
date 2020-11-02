package com.wc.proxy1;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author shovel
 * @date 2018/12/15 19:34
 * @since 1.0.0
 */
public class MyCglibProxy implements MethodInterceptor {
    private MyClassWithoutInterface target;

    public MyCglibProxy(MyClassWithoutInterface target) {
        this.target = target;
    }

    public MyClassWithoutInterface getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (MyClassWithoutInterface) enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("add".equals(method.getName())) {
            System.out.println("前置校验");
            Object obj = method.invoke(target, args);//methodProxy.invokeSuper(proxy, args);
            System.out.println("后置校验");
            return obj;
        }
        return method.invoke(target, args);//methodProxy.invokeSuper(proxy, args);
    }

    public static void main(String[] args) {
        MyCglibProxy proxy = new MyCglibProxy(new MyClassWithoutInterface());
        MyClassWithoutInterface myClass = proxy.getProxy();
        int add = myClass.add(5, 6);
        int reduce = myClass.reduce(7, 8);
        System.out.println(add);
        System.out.println(reduce);
    }
}
