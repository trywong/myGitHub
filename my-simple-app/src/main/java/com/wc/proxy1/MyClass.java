package com.wc.proxy1;

/**
 * @author shovel
 * @date 2018/12/15 18:09
 * @since 1.0.0
 */
public class MyClass implements MyInterface {
    @Override
    public void hello(String name) {
        System.out.println("hello, " + name);
    }

    @Override
    public void byebye() {
        System.out.println("GoodBye!!");
    }
}
