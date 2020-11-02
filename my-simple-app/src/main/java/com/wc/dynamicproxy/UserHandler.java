package com.wc.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shovel
 * @date 2018/12/5 17:27
 * @since 1.0.0
 */
public class UserHandler implements InvocationHandler {
    private IUser user;

    public UserHandler(IUser user) {
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在方法执行前，xxxx");
        Object obj = method.invoke(this.user, args);
        System.out.println("在方法执行后，xxxx");
        return obj;
    }
}
